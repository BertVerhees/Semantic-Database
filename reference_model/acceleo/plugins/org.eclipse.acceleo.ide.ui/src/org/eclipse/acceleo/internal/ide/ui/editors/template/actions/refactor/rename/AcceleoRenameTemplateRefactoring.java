/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.acceleo.internal.ide.ui.editors.template.actions.refactor.rename;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.acceleo.common.IAcceleoConstants;
import org.eclipse.acceleo.internal.ide.ui.AcceleoUIMessages;
import org.eclipse.acceleo.internal.ide.ui.editors.template.actions.references.ReferenceEntry;
import org.eclipse.acceleo.internal.parser.cst.utils.Region;
import org.eclipse.acceleo.internal.parser.cst.utils.Sequence;
import org.eclipse.acceleo.parser.cst.VisibilityKind;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.ChangeDescriptor;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.Refactoring;
import org.eclipse.ltk.core.refactoring.RefactoringChangeDescriptor;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.TextFileChange;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.search.ui.text.Match;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;

/**
 * This class is the central class in the Rename Template refactoring process.
 * 
 * @author <a href="mailto:stephane.begaudeau@obeo.fr">Stephane Begaudeau</a>
 */
public class AcceleoRenameTemplateRefactoring extends Refactoring {

	/**
	 * Template.
	 */
	private static final String TEMPLATE = "template"; //$NON-NLS-1$

	/**
	 * New name.
	 */
	private static final String NEWNAME = "newName"; //$NON-NLS-1$

	/**
	 * Update references.
	 */
	private static final String REFERENCES = "references"; //$NON-NLS-1$

	/**
	 * The current template.
	 */
	protected AcceleoPositionedTemplate fTemplate;

	/**
	 * The name of the new template.
	 */
	protected String fNewTemplateName;

	/**
	 * Whether or not we have to updates all the references (default = true).
	 */
	protected boolean fUpdateReferences = true;

	/**
	 * The title of the refactoring.
	 */
	private final String title = AcceleoUIMessages
			.getString("AcceleoEditorRenameTemplateRefactoring.RenameTemplateTitle"); //$NON-NLS-1$

	/**
	 * The files that will be impacted by the changes and the changes.
	 */
	private Map<IFile, TextFileChange> fChanges;

	/**
	 * The file name.
	 */
	private String fileName;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ltk.core.refactoring.Refactoring#checkFinalConditions(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public RefactoringStatus checkFinalConditions(final IProgressMonitor monitor) throws CoreException,
			OperationCanceledException {
		final RefactoringStatus status = new RefactoringStatus();
		try {
			monitor.beginTask(AcceleoUIMessages
					.getString("AcceleoEditorRenameRefactoring.CheckingPreconditions"), 1); //$NON-NLS-1$

			if (this.fTemplate == null) {
				status.merge(RefactoringStatus.createErrorStatus(AcceleoUIMessages
						.getString("AcceleoEditorRenameTemplateRefactoring.NoTemplateSpecified"))); //$NON-NLS-1$
			}

			this.fTemplate.computeOccurrencesOfTemplate();

			fChanges = new LinkedHashMap<IFile, TextFileChange>();
			if (this.fUpdateReferences) {
				this.putChangesNotInTheCurrentFile();
			}

			this.putChangesOfTheCurrentFile();

		} finally {
			monitor.done();
		}
		return status;
	}

	/**
	 * Find the change that are <b>not</b> in the current file and put them in the map.
	 */
	private void putChangesNotInTheCurrentFile() {
		for (Match match : this.fTemplate.getTemplateMatches()) {
			if (!(match.getElement() instanceof ReferenceEntry)) {
				continue;
			}
			final ReferenceEntry entry = (ReferenceEntry)match.getElement();
			if (!entry.getTemplateFile().getName().equals(fileName)) {
				final IFile file = entry.getTemplateFile();

				TextFileChange tfc = null;
				MultiTextEdit edit = null;

				if (this.fChanges.containsKey(file)
						&& this.fChanges.get(file).getEdit() instanceof MultiTextEdit) {
					tfc = this.fChanges.get(file);
					edit = (MultiTextEdit)this.fChanges.get(file).getEdit();
				} else {
					tfc = new TextFileChange(this.title, file);
					edit = new MultiTextEdit();
					tfc.setEdit(edit);
					tfc.setTextType(IAcceleoConstants.MTL_FILE_EXTENSION);
				}

				final String str = ((ReferenceEntry)match.getElement()).getMessage();

				// Initialization of the offset.
				int offset = str.lastIndexOf(this.fTemplate.getTemplateName());

				// computation of a potential new offset.
				StringBuffer buf = new StringBuffer(str);
				int offsetTmp = this.computeOffset(buf);
				if (offset != 0 && offsetTmp != 0) {
					offset = offsetTmp;
				}

				edit.addChild(new ReplaceEdit(match.getOffset() + offset, this.fTemplate.getTemplateName()
						.length(), this.fNewTemplateName));

				this.fChanges.put(file, tfc);
			}
		}
	}

	/**
	 * Find the change that are in the current file and put them in the map.
	 */
	private void putChangesOfTheCurrentFile() {
		for (Match match : this.fTemplate.getTemplateMatches()) {
			if (!(match.getElement() instanceof ReferenceEntry)) {
				continue;
			}
			final ReferenceEntry entry = (ReferenceEntry)match.getElement();
			if (entry.getTemplateFile().getName().equals(fileName)) {
				final IFile file = entry.getTemplateFile();

				TextFileChange tfc = null;
				MultiTextEdit edit = null;

				if (this.fChanges.containsKey(file)
						&& this.fChanges.get(file).getEdit() instanceof MultiTextEdit) {
					tfc = this.fChanges.get(file);
					edit = (MultiTextEdit)this.fChanges.get(file).getEdit();
				} else {
					tfc = new TextFileChange(this.title, file);
					edit = new MultiTextEdit();
					tfc.setEdit(edit);
					tfc.setTextType(IAcceleoConstants.MTL_FILE_EXTENSION);
				}

				final String str = ((ReferenceEntry)match.getElement()).getMessage();

				// Initialization of the offset.
				int offset = str.lastIndexOf(this.fTemplate.getTemplateName());

				// computation of a potential new offset.
				StringBuffer buf = new StringBuffer(str);
				int offsetTmp = this.computeOffset(buf);
				if (offset != 0 && offsetTmp != 0) {
					offset = offsetTmp;
				}

				edit.addChild(new ReplaceEdit(match.getOffset() + offset, this.fTemplate.getTemplateName()
						.length(), this.fNewTemplateName));
				this.fChanges.put(file, tfc);
			}
		}
	}

	/**
	 * Computes the offset of the name of the template from the string buffer.
	 * 
	 * @param buffer
	 *            The string buffer.
	 * @return The offset.
	 */
	private int computeOffset(final StringBuffer buffer) {
		int offset = 0;
		Sequence sequence = null;
		Region region = null;

		switch (this.fTemplate.getTemplate().getVisibility().getValue()) {
			case VisibilityKind.PRIVATE_VALUE:
				sequence = new Sequence(IAcceleoConstants.TEMPLATE,
						IAcceleoConstants.VISIBILITY_KIND_PRIVATE, this.fTemplate.getTemplateName());
				region = sequence.search(buffer);

				if (region.e() > -1) {
					offset = region.e() - this.fTemplate.getTemplateName().length();
				}

				break;
			case VisibilityKind.PROTECTED_VALUE:
				sequence = new Sequence(IAcceleoConstants.TEMPLATE,
						IAcceleoConstants.VISIBILITY_KIND_PROTECTED, this.fTemplate.getTemplateName());
				region = sequence.search(buffer);

				if (region.e() > -1) {
					offset = region.e() - this.fTemplate.getTemplateName().length();
				}

				break;
			case VisibilityKind.PUBLIC_VALUE:
				sequence = new Sequence(IAcceleoConstants.TEMPLATE, IAcceleoConstants.VISIBILITY_KIND_PUBLIC,
						this.fTemplate.getTemplateName());
				region = sequence.search(buffer);

				if (region.e() > -1) {
					offset = region.e() - this.fTemplate.getTemplateName().length();
				}

				break;
			default:
				// do nothing
				break;
		}

		return offset;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ltk.core.refactoring.Refactoring#checkInitialConditions(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public RefactoringStatus checkInitialConditions(final IProgressMonitor monitor) throws CoreException,
			OperationCanceledException {
		final RefactoringStatus status = new RefactoringStatus();

		if (AcceleoPositionedTemplate.getInput().length == 0) {
			status.merge(RefactoringStatus.createErrorStatus(AcceleoUIMessages
					.getString("AcceleoEditorRenameTemplateRefactoring.NoTemplateInFile"))); //$NON-NLS-1$
		}

		return status;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ltk.core.refactoring.Refactoring#createChange(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public Change createChange(final IProgressMonitor monitor) throws CoreException,
			OperationCanceledException {
		try {
			monitor.beginTask(
					AcceleoUIMessages.getString("AcceleoEditorRenameRefactoring.CreatingChanges"), 1); //$NON-NLS-1$
			final Collection<TextFileChange> changes = fChanges.values();
			final CompositeChange change = new CompositeChange(getName(), changes.toArray(new Change[changes
					.size()])) {

				@Override
				public ChangeDescriptor getDescriptor() {
					Map<String, String> arguments = new HashMap<String, String>();
					final String project = AcceleoUIMessages
							.getString("AcceleoEditorRenameTemplateRefactoring.RefactoringProjectName"); //$NON-NLS-1$
					final String description = AcceleoUIMessages
							.getString("AcceleoEditorRenameTemplateRefactoring.RenamingTemplate") //$NON-NLS-1$
							+ " " //$NON-NLS-1$
							+ fTemplate.getTemplateName();
					final String comment = AcceleoUIMessages.getString(
							"AcceleoEditorRenameTemplateRefactoring.RenamingTemplateWithNewName", //$NON-NLS-1$
							fTemplate.getTemplateName(), fNewTemplateName);
					arguments.put(TEMPLATE, fTemplate.getTemplateName());
					arguments.put(NEWNAME, fNewTemplateName);
					arguments.put(REFERENCES, Boolean.valueOf(fUpdateReferences).toString());
					return new RefactoringChangeDescriptor(new AcceleoRenameTemplateDescriptor(project,
							description, comment, arguments));
				}
			};
			return change;
		} finally {
			monitor.done();
		}
	}

	/**
	 * Sets the file name.
	 * 
	 * @param name
	 *            The file name.
	 */
	public void setFileName(final String name) {
		this.fileName = name;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ltk.core.refactoring.Refactoring#getName()
	 */
	@Override
	public String getName() {
		return this.title;
	}

	/**
	 * Sets the current template.
	 * 
	 * @param currentTemplate
	 *            The current template.
	 */
	public void setTemplate(final AcceleoPositionedTemplate currentTemplate) {
		this.fTemplate = currentTemplate;
	}

	/**
	 * Returns the template.
	 * 
	 * @return The template.
	 */
	public AcceleoPositionedTemplate getTemplate() {
		return this.fTemplate;
	}

	/**
	 * Indicates whether or not we should update all the occurrences of the template name.
	 * 
	 * @param selection
	 *            true if we should update the selection.
	 */
	public void setUpdateReferences(final boolean selection) {
		this.fUpdateReferences = selection;
	}

	/**
	 * Sets the new name of the template.
	 * 
	 * @param text
	 *            The new name of template.
	 * @return The refactoring status.
	 */
	public RefactoringStatus setNewTemplateName(final String text) {
		this.fNewTemplateName = text;
		final RefactoringStatus status = checkTemplateName(this.fNewTemplateName);
		status.merge(checkOverLoading());
		return status;
	}

	/**
	 * Check that the new name does not create any conflict with an existing template. We will check if the
	 * new name is different from an existing template name and if it is not the case, if two templates have
	 * the same name, they should have different parameters.<br />
	 * <code>[template public aaaaa(a : EClass)]</code> renamed in
	 * <code>[template public bbbb(a : EClass)]</code><br />
	 * does not create problem with a template like <code>[template public bbbb(a : EOperation)]</code><br />
	 * but it would create a problem with an existing template named <code>[template public bbbb(thing :
	 * EClass)]</code>.
	 * 
	 * @return The refactoring status.
	 */
	private RefactoringStatus checkOverLoading() {
		RefactoringStatus status = new RefactoringStatus();

		final AcceleoPositionedTemplate[] array = AcceleoPositionedTemplate.getInput();
		for (AcceleoPositionedTemplate acceleoPositionedTemplate : array) {
			if (this.fNewTemplateName.equals(acceleoPositionedTemplate.getTemplateName())) {

				List<Variable> listOfParametersOfTheCurrentTemplate = this.fTemplate.getTemplate()
						.getParameter();
				List<Variable> listOfParametersOfTheTemplateWithTheSameName = acceleoPositionedTemplate
						.getTemplate().getParameter();

				if (listOfParametersOfTheCurrentTemplate.size() == listOfParametersOfTheTemplateWithTheSameName
						.size()) {
					boolean overloadingError = true;

					for (int j = 0; j < listOfParametersOfTheCurrentTemplate.size(); j++) {
						if (!listOfParametersOfTheCurrentTemplate.get(j).getEType().equals(
								listOfParametersOfTheTemplateWithTheSameName.get(j).getEType())) {
							overloadingError = false;
							break;
						}
					}

					if (overloadingError) {
						status.merge(RefactoringStatus
								.createErrorStatus(AcceleoUIMessages
										.getString("AcceleoEditorRenameTemplateRefactoring.TemplateOverloadingError"))); //$NON-NLS-1$
					}
				}
			}
		}

		return status;
	}

	/**
	 * Checks the name of the template.
	 * 
	 * @param name
	 *            The name of the template.
	 * @return The refactoring status.
	 */
	private RefactoringStatus checkTemplateName(final String name) {
		RefactoringStatus status = new RefactoringStatus();
		for (int i = 0; i < name.length(); i++) {
			if (!Character.isJavaIdentifierPart(name.charAt(i))) {
				status.merge(RefactoringStatus.createErrorStatus(AcceleoUIMessages
						.getString("AcceleoEditorRenameTemplateRefactoring.InvalidTemplateName"))); //$NON-NLS-1$
			}
		}
		return status;
	}

	/**
	 * Initialize.
	 * 
	 * @param arguments
	 *            The argument of the initialization.
	 * @return The refactoring status.
	 */
	public RefactoringStatus initialize(final Map<String, String> arguments) {
		final RefactoringStatus status = new RefactoringStatus();
		String value = arguments.get(TEMPLATE);
		if (value != null) {
			// I'm not sure I need to do something here, so let's do nothing instead :)
		}
		value = arguments.get(NEWNAME);
		if (value != null) {
			this.setNewTemplateName(value);
		}
		value = arguments.get(REFERENCES);
		if (value != null) {
			setUpdateReferences(Boolean.valueOf(value).booleanValue());
		}
		return status;
	}
}

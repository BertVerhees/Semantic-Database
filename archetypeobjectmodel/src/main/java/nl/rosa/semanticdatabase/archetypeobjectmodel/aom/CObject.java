package nl.rosa.semanticdatabase.archetypeobjectmodel.aom;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.terminology.ArchetypeTerm;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.utils.AOMUtils;
import nl.rosa.semanticdatabase.base.LanguageConfiguration;
import nl.rosa.semanticdatabase.base.MultiplicityInterval;
import nl.rosa.semanticdatabase.referencemodel.model.internal.paths.PathSegment;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

/**
 * Constraint on an object.
 *
 * Slightly deviates from the openEHR Archetype Model by including the getAttributes() and getAttribute() methods here
 * This enables one to type: archetype.getDefinition().getAttribute("context").getChild("id13").getAttribute("value")
 * without casting.
 */
@Getter
@Setter
public abstract class CObject extends ArchetypeConstraint {

    private String rmTypeName;
    private MultiplicityInterval occurrences;
    private String nodeId;
    private Boolean deprecated;

    private SiblingOrder siblingOrder;

    public List<PathSegment> getPathSegments() {
        CAttribute parent = getParent();
        if(parent == null) {
            return new ArrayList<>();
        }
        List<PathSegment> segments = parent.getPathSegments();
        if(!segments.isEmpty()) {
            segments.get(segments.size()-1).setNodeId(getNodeId());
        }
        return segments;
    }

    /**
     * Get the archetype term, in the defined meaning and description language
     */
    public ArchetypeTerm getTerm() {
        if(nodeId == null) {
            return null;
        }
        Archetype archetype = getArchetype();
        if(archetype == null) {
            return null;
        }
        ArchetypeTerm result = archetype.getTerm(this, LanguageConfiguration.getMeaningAndDescriptionLanguage());
        if(result == null) {
            //no translation in the given language. Fall back to the default.
            result = archetype.getTerm(this, LanguageConfiguration.getDefaultMeaningAndDescriptionLanguage());
        }
        if(result == null && archetype.getOriginalLanguage() != null && archetype.getOriginalLanguage().getCodeString() != null) {
            result = archetype.getTerm(this, archetype.getOriginalLanguage().getCodeString());
        }
        return result;
    }

    private void setTerm(ArchetypeTerm term) {
        //hack to get Jackson to work for now
    }

    /**
     * Get the meaning of this CObject in the defined meaning and description language.
     * See ArchieLanguageConfiguation
     */
    public String getMeaning() {
        ArchetypeTerm termDefinition = getTerm();
        if(termDefinition!=null && termDefinition.getText()!=null) {
            return termDefinition.getText();
        }
        return null;
    }

    /**
     * Get the meaning of this CObject in the defined meaning and description language.
     * See ArchieLanguageConfiguation
     */
    public String getDescription() {
        ArchetypeTerm termDefinition = getTerm();
        if(termDefinition!=null && termDefinition.getDescription()!=null) {
            return termDefinition.getDescription();
        }
        return null;
    }

    private String getLogicalPathMeaning() {
        if(nodeId == null) {
            return null;
        }
        String meaning = null;
        Archetype archetype = getArchetype();
        if(archetype == null) {
            return null;
        }
        ArchetypeTerm termDefinition = archetype.getTerm(this, LanguageConfiguration.getLogicalPathLanguage());
        if(termDefinition!=null && termDefinition.getText()!=null) {
            meaning = termDefinition.getText();
        }
        return meaning;
    }


    public String getLogicalPath() {
        //TODO: this can cause name clashes. Solve them!
        //TODO: the text can contain []-characters. Replace them?
        //TODO: lowercase and replace spaces with underscores?
        if(getParent() == null) {
            return "/";
        }

        String nodeName = getLogicalPathMeaning();
        if(nodeName == null) {
            nodeName = nodeId;
        }
        String path = getParent().getLogicalPath();
        //TODO: this is a bit slow because we have to walk the tree to the archetype every single time
        if(nodeName != null) {
            path += "[" + nodeName + "]";
        }
        if(path.startsWith("//")) {
            return path.substring(1);
        }
        return path;
    }

    public boolean isAllowed() {
        if(occurrences == null) {
            return true;
        }
        return occurrences.isUpperUnbounded() || occurrences.getUpper() > 0;
    }

    @Override
    public CAttribute getParent() {
        return (CAttribute) super.getParent();
    }

    public boolean isRequired() {
        if(occurrences == null) {
            return false;
        }
        return occurrences.getLower() > 0;
    }

    /**
     * Level of specialisation of this archetype node, based on its node_id. The value 0 corresponds to non-specialised,
     * 1 to first-level specialisation and so on. The level is the same as the number of ‘.’ characters in the node_id
     * code. If node_id is not set, the return value is -1, signifying that the specialisation level should be determined
     * from the nearest parent C_OBJECT node having a node_id.
     *
     * @return
     */
    public Integer specialisationDepth() {
        return AOMUtils.getSpecializationDepthFromCode(nodeId);
    }

    public boolean isProhibited() {
        return occurrences != null && occurrences.isProhibited();
    }

    /**
     * True if constraints represented by this node, ignoring any sub-parts, are narrower or the same as other. Typically used during validation of special-ised archetype nodes.
     * @param other
     * @param rmTypesConformant
     * @return
     */
    public boolean cConformsTo(CObject other, BiFunction<String, String, Boolean> rmTypesConformant) {
        return nodeIdConformsTo(other) &&
                occurrencesConformsTo(other)
                && typeNameConformsTo(other, rmTypesConformant);

    }

    public boolean typeNameConformsTo(CObject other, BiFunction<String, String, Boolean> rmTypesConformant) {
        if(other.getRmTypeName() == null || getRmTypeName() == null) {
            return true;//these are not nullable, but we're not throwing exceptions here
        }
        if(other.getRmTypeName().equalsIgnoreCase(getRmTypeName())) {
            return true;
        }
        return rmTypesConformant.apply(getRmTypeName(), other.getRmTypeName());
    }

    /**
     * True if this node id conforms to other.node_id, which includes the ids being identical; other is assumed to be in a flat archetype.
     * @param other
     * @return
     */
    public boolean nodeIdConformsTo(CObject other) {
        return AOMUtils.codesConformant(this.getNodeId(), other.getNodeId());
    }

    public boolean occurrencesConformsTo(CObject other) {
        if(occurrences != null && other.occurrences != null) {
            return other.occurrences.contains(occurrences);
        } else {
            return true;
        }
    }


    /**
     * Calculate the effective occurrences of this CObject. If occurrences has not been set explicitly, get it from the
     * reference model using the supplied function
     *
     * @param referenceModelPropMultiplicity a function to retrieve the reference model multiplicity from the rm model, given the type name and the attribute path
     * @return
     */
    public MultiplicityInterval effectiveOccurrences(BiFunction<String, String, MultiplicityInterval> referenceModelPropMultiplicity) {
        if(getOccurrences() != null) {
            return getOccurrences();
        }
        return getDefaultRMOccurrences(referenceModelPropMultiplicity);
    }

    /**
     * Calculate the occurrences from the RM, ignoring any occurrences in this CObject. Note that is only useful
     * when editing this archetype, not in general use.
     * @param referenceModelPropMultiplicity
     * @return
     */
    public MultiplicityInterval getDefaultRMOccurrences(BiFunction<String, String, MultiplicityInterval> referenceModelPropMultiplicity) {
        CAttribute parent = getParent();
        if(parent != null) {
            if(parent.getCardinality() != null && parent.getCardinality().getInterval() != null) { //technically a cardinality without interval is an error, but let's handle it correctly
                if(parent.getCardinality().getInterval().isUpperUnbounded()) {
                    return MultiplicityInterval.createOpen();
                } else {
                    return MultiplicityInterval.createBounded(0, parent.getCardinality().getInterval().getUpper());
                }
            } else if(parent.getParent() != null) {
                MultiplicityInterval multiplicity = referenceModelPropMultiplicity.apply(parent.getParent().getRmTypeName(), parent.getDifferentialPath() == null ? parent.getRmAttributeName() : parent.getDifferentialPath());
                if(multiplicity == null) {
                    return null;
                } else if (multiplicity.isUpperUnbounded()) {
                    return MultiplicityInterval.createOpen();
                } else {
                    return MultiplicityInterval.createBounded(0, multiplicity.getUpper());
                }
            } else {
                return MultiplicityInterval.createOpen();
            }
        } else {
            return MultiplicityInterval.createOpen();
        }
    }

}

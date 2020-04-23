package nl.rosa.semanticdatabase.archetypeobjectmodel.aom.primitives;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.LanguageConfiguration;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.Archetype;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.CObject;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.CPrimitiveObject;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.terminology.ArchetypeTerm;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.terminology.ArchetypeTerminology;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.terminology.TerminologyCodeWithArchetypeTerm;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.terminology.ValueSet;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.utils.AOMUtils;
import nl.rosa.semanticdatabase.base.terminology.TerminologyCode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

@Getter
@Setter
public class CTerminologyCode extends CPrimitiveObject<String, TerminologyCode> {

    private TerminologyCode assumedValue;
    private List<String> constraint = new ArrayList<>();

    @Override
    public void addConstraint(String constraint) {
        this.constraint.add(constraint);
    }

    @Override
    public boolean isValidValue(TerminologyCode value) {
        if(getConstraint().isEmpty()) {
            return true;
        }
        for(String constraint:getConstraint()) {
            if(constraint.startsWith("at")) {
                if(value.getCodeString() != null && value.getCodeString().equals(constraint)) {
                    return true;
                }
            } else if (constraint.startsWith("ac")) {
                if(value.getTerminologyId() != null && value.getTerminologyId().equals(constraint)) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * Get the ArchetypeTerms in the selected meaning and description language for all the possible options if this is a
     * locally defined terminology.
     * See the ArchieLanguageConfiguration for the language settings.
     *
     * @return
     */
    public List<TerminologyCodeWithArchetypeTerm> getTerms() {
        List<TerminologyCodeWithArchetypeTerm> result = new ArrayList<>();
        Archetype archetype = getArchetype();
        if(archetype == null) {
            //ideally this would not happen, but no reference to archetype exists in leaf constraints in rules so far
            //so for now fix it so it doesn't throw a NullPointerException
            return result;
        }
        ArchetypeTerminology terminology = archetype.getTerminology(this);
        String language = LanguageConfiguration.getMeaningAndDescriptionLanguage();
        String defaultLanguage = LanguageConfiguration.getDefaultMeaningAndDescriptionLanguage();
        for(String constraint:getConstraint()) {
            if(constraint.startsWith("at")) {
                ArchetypeTerm termDefinition = terminology.getTermDefinition(language, constraint);
                if(termDefinition == null) {
                    termDefinition = terminology.getTermDefinition(defaultLanguage, constraint);
                }
                if(termDefinition != null) {
                    result.add(new TerminologyCodeWithArchetypeTerm(constraint, termDefinition));
                }
            } else if (constraint.startsWith("ac")) {
                ValueSet acValueSet = terminology.getValueSets().get(constraint);
                if(acValueSet != null) {
                    for(String atCode:acValueSet.getMembers()) {
                        ArchetypeTerm termDefinition = terminology.getTermDefinition(language, atCode);
                        if(termDefinition == null) {
                            termDefinition = terminology.getTermDefinition(defaultLanguage, atCode);
                        }
                        if(termDefinition != null) {
                            result.add(new TerminologyCodeWithArchetypeTerm(atCode, termDefinition));
                        }
                    }
                }
            }
        }
        return result;
    }

    private void setTerms(List<TerminologyCodeWithArchetypeTerm> terms) {
        //hack for jackson to work
    }

    @JsonIgnore
    public List<String> getValueSetExpanded() {
        List<String> result = new ArrayList<>();
        Archetype archetype = getArchetype();
        if(archetype == null) {
            //ideally this would not happen, but no reference to archetype exists in leaf constraints in rules so far
            //so for now fix it so it doesn't throw a NullPointerException
            return result;
        }
        ArchetypeTerminology terminology = archetype.getTerminology(this);
        for(String constraint:getConstraint()) {
            if(constraint.startsWith("at")) {
                result.add(constraint);
            } else if (constraint.startsWith("ac")) {
                ValueSet acValueSet = terminology.getValueSets().get(constraint);
                if(acValueSet != null) {
                    result.addAll(acValueSet.getMembers());
                }
            }
        }
        return result;
    }

    @Override
    public boolean cConformsTo(CObject other, BiFunction<String, String, Boolean> rmTypesConformant) {
        if(!super.cConformsTo(other, rmTypesConformant)) {
            return false;
        }
        //now guaranteed to be the same class
        CTerminologyCode otherCode = (CTerminologyCode) other;
        List<String> valueSet = getValueSetExpanded();
        List<String> otherValueSet = otherCode.getValueSetExpanded();
        if(constraint.size() != 1 || otherCode.constraint.size() != 1) {
            return false;//this is invalid in the RM
        }
        String thisConstraint = constraint.get(0);
        String otherConstraint = otherCode.constraint.get(0);
        if(AOMUtils.isValidValueSetCode(thisConstraint) && AOMUtils.isValidValueSetCode(otherConstraint)) {
            if (otherValueSet.isEmpty()) {
                return true;
            }
            if(!AOMUtils.codesConformant(thisConstraint, otherConstraint)) {
                return false;
            }
            for (String value : valueSet) {
                //TODO: redefine validation to actually work here!
                if (!otherValueSet.contains(value)) {
                    return false;
                }
            }
            return true;
        } else {
            return AOMUtils.codesConformant(thisConstraint, otherConstraint);
        }
    }

}

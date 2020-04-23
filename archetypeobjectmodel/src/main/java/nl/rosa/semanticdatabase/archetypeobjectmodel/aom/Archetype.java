package nl.rosa.semanticdatabase.archetypeobjectmodel.aom;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.terminology.ArchetypeTerm;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.terminology.ArchetypeTerminology;
import nl.rosa.semanticdatabase.archetypeobjectmodel.aom.utils.ArchetypeParsePostProcesser;
import nl.rosa.semanticdatabase.archetypeobjectmodel.query.AOMPathQuery;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Note: this Archetype does not conform to the UML model completely:
 * - it extends AuthoredResource - needed because otherwise we would have multiple inheritance
 * - it contains fields from AuthoredArchetype - needed because it saves complicated casting in java to call these methods otherwise
 */
@Getter
@Setter
public class Archetype extends AuthoredResource {

    private String parentArchetypeId;
    private boolean differential = false;
    private ArchetypeHRID archetypeId;

    private CComplexObject definition;
    private ArchetypeTerminology terminology;
    private RulesSection rules = null;

    private String adlVersion;
    private String buildUid;
    private String rmRelease;
    private Boolean generated = false;

    //TODO: this probably requires a custom XmlAdapter
    private Map<String, String> otherMetaData = new LinkedHashMap<>();

    public void setDefinition(CComplexObject definition) {
        definition.setArchetype(this);
        this.definition = definition;
    }

    public void setTerminology(ArchetypeTerminology terminology) {
        this.terminology = terminology;
        terminology.setOwnerArchetype(this);
    }

    public void addOtherMetadata(String text, String value) {
        if (value != null) {
            otherMetaData.put(text, value);
        }
    }

    /**
     * Translation helper function. To be overriden by Operational Templates
     *
     * @param object   the object to get the term definition for
     * @param language the language to get the term definition for
     * @return the ArchetypeTerm corresponding to the given CObject in the given language
     */
    public ArchetypeTerm getTerm(CObject object, String language) {
        ArchetypeTerminology terminology = getTerminology();
        return terminology == null ? null : terminology.getTermDefinition(language, object.getNodeId());
    }

    /**
     * Get the terminology definition for a certain code used in a certain path in a terminology. Use this instead of
     * the ArchetypeTerminology and things work in Operation Templates out of the box. Overridden in OperationalTemplate
     *
     * @param object   the object to get the term definition for
     * @param code     the object to get the term definition for. Usually an ac- or at-code
     * @param language the language to get the term definition for
     * @return the ArchetypeTerm corresponding to the given CObject in the given language
     */
    public ArchetypeTerm getTerm(CObject object, String code, String language) {
        return getTerminology().getTermDefinition(language, code);
    }


    public ArchetypeTerminology getTerminology(CObject object) {
        return getTerminology();
    }

    public Archetype clone() {

        Archetype result = (Archetype) super.clone();
        //fix some things that are not handled automatically
        ArchetypeParsePostProcesser.fixArchetype(result);
        return result;

    }

    /** TODO: should this only be on complex objects? */
    public <T extends ArchetypeModelObject> T itemAtPath(String path) {
        return new AOMPathQuery(path).find(getDefinition());
    }

    public List<ArchetypeModelObject> itemsAtPath(String path) {
        return new AOMPathQuery(path).findList(getDefinition());
    }

    public boolean hasPath(String path) {
        return !itemsAtPath(path).isEmpty();
    }

    @Override
    public String toString() {
        return"archetype: " + getArchetypeId();
    }

    public boolean isSpecialized() {
        return parentArchetypeId != null;
    }

    @JsonIgnore
    public int specializationDepth() {
        return AOMUtils.getSpecializationDepthFromCode(definition.getNodeId());
    }

    /**
     * Return a set of all the used id, at and ac codes in the definition of this archetype - includes at codes used in
     * ac codes references in C_TERMINOLOGY_CODE objects and ac codes from value sets keys
     * @return
     */
    @JsonIgnore
    public Set<String> getAllUsedCodes() {
        Stack<CObject> workList = new Stack();
        Set<String> result = new LinkedHashSet<>();
        workList.add(definition);
        while(!workList.isEmpty()) {
            CObject cObject = workList.pop();
            if(!Objects.equals(cObject.getNodeId(), AdlCodeDefinitions.PRIMITIVE_NODE_ID)){
                if(cObject.getNodeId() != null) {
                    result.add(cObject.getNodeId());
                }
            }
            if(cObject instanceof CTerminologyCode) {
                CTerminologyCode terminologyCode = (CTerminologyCode) cObject;
                result.addAll(terminologyCode.getValueSetExpanded());
                if(!terminologyCode.getConstraint().isEmpty()) {
                    result.add(terminologyCode.getConstraint().get(0));
                }
            }
            for(CAttribute attribute:cObject.getAttributes()) {
                workList.addAll(attribute.getChildren());
            }
        }
        if(terminology != null && terminology.getValueSets() != null) {
            for (ValueSet set : terminology.getValueSets().values()) {
                result.add(set.getId());
                for (String code : set.getMembers()) {
                    result.add(code);
                }

            }
        }

        return result;
    }

    @JsonIgnore
    public Set<String> getUsedIdCodes() {
        return getAllUsedCodes().stream().filter(code -> AOMUtils.isIdCode(code)).collect(Collectors.toSet());
    }

    @JsonIgnore
    public Set<String> getUsedValueCodes() {
        return getAllUsedCodes().stream().filter(code -> AOMUtils.isValueCode(code)).collect(Collectors.toSet());

    }

    @JsonIgnore
    public Set<String> getUsedValueSetCodes() {
        return getAllUsedCodes().stream().filter(code -> AOMUtils.isValidValueSetCode(code)).collect(Collectors.toSet());
    }


    private String generateNextCode(String prefix, Set<String> usedCodes) {
        int specializationDepth = this.specializationDepth();
        int maximumIdCode = AOMUtils.getMaximumIdCode(specializationDepth, usedCodes);
        return prefix + generateSpecializationDepthCodePrefix(specializationDepth()) + (maximumIdCode+1);
    }

    public String generateNextIdCode() {
        return generateNextCode(AdlCodeDefinitions.ID_CODE_LEADER, getAllUsedCodes());
    }

    public String generateNextValueCode() {
        return generateNextCode(AdlCodeDefinitions.VALUE_CODE_LEADER, getAllUsedCodes());
    }

    public String generateNextValueSetCode() {
        return generateNextCode(AdlCodeDefinitions.VALUE_SET_CODE_LEADER, getAllUsedCodes());

    }

    private String generateSpecializationDepthCodePrefix (int specializationDepth) {
        String prefix = "";
        for(int i = 0; i < specializationDepth; i++) {
            prefix += "0" + AdlCodeDefinitions.SPECIALIZATION_SEPARATOR;
        }
        return prefix;
    }

    public String generateNextSpecializedIdCode(String nodeId) {
        int specializationDepth = specializationDepth();
        int nodeIdSpecializationDepth = AOMUtils.getSpecializationDepthFromCode(nodeId);
        if(nodeIdSpecializationDepth >= specializationDepth) {
            throw new IllegalArgumentException("cannot specialize a node id at the same or higher specialization depth as the archetype");
        }

        int maximumIdCode = AOMUtils.getMaximumIdCode(specializationDepth, nodeId, getAllUsedCodes());
        return nodeId + AdlCodeDefinitions.SPECIALIZATION_SEPARATOR + generateSpecializationDepthCodePrefix(specializationDepth-nodeIdSpecializationDepth-1) + (maximumIdCode+1);

    }
}

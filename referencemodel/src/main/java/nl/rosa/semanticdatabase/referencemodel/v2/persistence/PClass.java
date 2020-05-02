package nl.rosa.semanticdatabase.referencemodel.v2.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PClass extends PBase {

    private String documentation;//from P_BMM_MODEL_ELEMENT
    private String name;
    private List<String> ancestors;
    private Map<String, PType> ancestorDefs;
    private Map<String, PProperty> properties;
    private Boolean isAbstract;
    private Boolean isOverride;
    private Map<String, PGenericParameter> genericParameterDefs;

    private transient String sourceSchemaId;

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAncestors() {
        if(ancestors == null) {
            ancestors = new ArrayList<>();
        }
        return ancestors;
    }

    /**
     * Get a list of ancestors type names. Combines the ancestors and ancestor_defs attributes, so can always
     * be used instead of those two separately. Warning: generates type names including generic parameters,
     * you may have to strip those for certain types of operations
     * @return
     */
    @JsonIgnore
    public List<String> getAncestorTypeNames() {
        if(ancestorDefs != null && !ancestorDefs.isEmpty()) {
            return ancestorDefs.values().stream().map(type -> type.asTypeString()).collect(Collectors.toList());
        } else if (ancestors != null) {
            return ancestors;
        } else {
            return new ArrayList<>();
        }
    }

    public void setAncestors(List<String> ancestors) {
        this.ancestors = ancestors;
    }

    public Map<String, PProperty> getProperties() {
        if(properties == null) {
            properties = new LinkedHashMap<>();
        }
        return properties;
    }

    public void setProperties(Map<String, PProperty> properties) {
        this.properties = properties;
    }

    @JsonProperty(value = "is_abstract")
    public Boolean isAbstract() {
        return isAbstract;
    }

    public void setAbstract(Boolean anAbstract) {
        isAbstract = anAbstract;
    }

    @JsonProperty(value = "is_override")
    public Boolean isOverride() {
        return isOverride;
    }

    public void setOverride(Boolean override) {
        isOverride = override;
    }

    public Map<String, PGenericParameter> getGenericParameterDefs() {
        if(genericParameterDefs == null) {
            genericParameterDefs = new LinkedHashMap<>();
        }
        return genericParameterDefs;
    }

    public void setGenericParameterDefs(Map<String, PGenericParameter> genericParameterDefs) {
        this.genericParameterDefs = genericParameterDefs;
    }

    /**
     * True if this class is a generic class.
     *
     * @return
     */
    @JsonIgnore
    public boolean isGeneric() {
        return this.getGenericParameterDefs() != null && this.getGenericParameterDefs().size() > 0;
    }

    @JsonIgnore
    public String getSourceSchemaId() {
        return sourceSchemaId;
    }

    public void setSourceSchemaId(String sourceSchemaId) {
        this.sourceSchemaId = sourceSchemaId;
    }

    public Map<String, PType> getAncestorDefs() {
        return ancestorDefs;
    }

    public void setAncestorDefs(Map<String, PType> ancestorDefs) {
        this.ancestorDefs = ancestorDefs;
    }

}

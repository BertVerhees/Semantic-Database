package nl.rosa.semanticdatabase.referencemodel.v2.persistence;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class PRMGenericType extends PRMBaseType {
    private String rootType;
    private Map<String, PRMType> genericParameterDefs;
    private List<String> genericParameters;


    public String getRootType() {
        return rootType;
    }

    public void setRootType(String rootType) {
        this.rootType = rootType;
    }

    public Map<String, PRMType> getGenericParameterDefs() {
        if(genericParameterDefs == null) {
            genericParameterDefs = new LinkedHashMap<>();
        }
        return genericParameterDefs;
    }

    public void setGenericParameterDefs(Map<String, PRMType> genericParameterDefs) {
        this.genericParameterDefs = genericParameterDefs;
    }

    public List<String> getGenericParameters() {
        if(genericParameters == null) {
            genericParameters = new ArrayList<>();
        }
        return genericParameters;
    }

    public void setGenericParameters(List<String> genericParameters) {
        this.genericParameters = genericParameters;
    }

    /**
     * Returns the generic parameters of the root_type in this type specifier. The order must match the order of the
     * owning class’s formal generic parameter declarations
     *
     * @return
     */
    @JsonIgnore
    public List<PRMType> getGenericParamaterRefs() {
        List<PRMType> genericParameterReferences = new ArrayList<>();
        if(genericParameterDefs != null && genericParameterDefs.size() > 0) {
            genericParameterReferences.addAll(genericParameterDefs.values());
        } else {
            genericParameters.forEach(param -> {
                if(param.length() == 1) {
                    // This is ugly because it basically checks parameter length to see if it's a generic parameter
                    // However it's the only way in the current P_BMM version to do so.
                    PRMOpenType openType = new PRMOpenType(param);
                    genericParameterReferences.add(openType);
                } else {
                    PRMSimpleType simpleType = new PRMSimpleType(param);
                    genericParameterReferences.add(simpleType);
                }
            });
        }
        return genericParameterReferences;
    }

    /**
     * Formal name of the type for display.
     *
     * @return
     */
    @Override
    public String asTypeString() {
        StringBuilder builder = new StringBuilder();
        builder.append(rootType).append("<");
        List<PRMType> parameterReferences = getGenericParamaterRefs();
        for(int i = 0; i < parameterReferences.size(); i++) {
            builder.append(parameterReferences.get(i).asTypeString());
            if(i < parameterReferences.size() - 1) {
                builder.append(",");
            }
        };
        builder.append(">");
        return builder.toString();
    }

    @Override
    public List<String> flattenedTypeList() {
        List<String> retVal = new ArrayList<>();
        getGenericParamaterRefs().forEach( item -> {
            retVal.addAll(item.flattenedTypeList());
        });
        return retVal;
    }
}

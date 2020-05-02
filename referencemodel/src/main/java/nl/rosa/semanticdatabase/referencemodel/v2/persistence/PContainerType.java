package nl.rosa.semanticdatabase.referencemodel.v2.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class PContainerType extends PType {

    private String containerType;
    private PBaseType typeDef;
    private String type;

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public PBaseType getTypeDef() {
        return typeDef;
    }

    public void setTypeDef(PBaseType typeDef) {
        this.typeDef = typeDef;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * Formal name of the type for display.
     *
     * @return
     */
    @Override
    public String asTypeString() {
        return containerType + "<" + getTypeRef().asTypeString() + ">";
    }

    @Override
    public List<String> flattenedTypeList() {
        List<String> retVal = new ArrayList<>();
        retVal.add(containerType);
        if(getTypeRef() != null) {
            retVal.addAll(getTypeRef().flattenedTypeList());
        }
        return retVal;
    }

    /**
     * Get the type reference to the contained type
     * @return
     */
    @JsonIgnore
    public PBaseType getTypeRef() {
        if(typeDef == null && type != null) {
            if(type.length() == 1) {
                // This is ugly because it basically checks parameter length to see if it's a generic parameter
                // However it's the only way in the current P_BMM version
                return new POpenType(type);
            } else {
                return new PSimpleType(type);
            }
        }
        return typeDef;
    }


}

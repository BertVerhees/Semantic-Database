package nl.rosa.semanticdatabase.referencemodel.v2.persistence;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class PRMSinglePropertyOpen extends PRMProperty<PRMOpenType> {

    private String type;

    /**
     * The P_BMM spec has quite oddly defined typing: there's a simple string form, and two structural forms. For most
     * typing, the simple string is enough. When this is not enough, there's an object variant called type_def.
     * So far, nothing strange going on. however, now there's a third variant:
     *
     * There's type_ref, which should be a computed (non-serialized) version. However, for terminology code constraints
     * it has to be a serialized version of type_ref. To distinguish between the computed typeRef (so, in our case, a method that returns without side-effects)
     * and the serialized type ref, a serialized type ref has been added. It maps to the json property type_ref.
     */
    private PRMOpenType serializedTypeRef;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    @Override
    public PRMOpenType getTypeRef() {
        if(serializedTypeRef != null) {
            return serializedTypeRef;
        } else if(getTypeDef() == null) {
            return new PRMOpenType(type);
        }
        return getTypeDef();
    }

    @JsonProperty("type_ref")
    public PRMOpenType getSerializedTypeRef() {
        return serializedTypeRef;
    }

    public void setSerializedTypeRef(PRMOpenType serializedTypeRef) {
        this.serializedTypeRef = serializedTypeRef;
    }
}

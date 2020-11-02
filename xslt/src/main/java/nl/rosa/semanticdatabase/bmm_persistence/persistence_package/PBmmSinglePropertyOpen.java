package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persistent form of a BMM_SINGLE_PROPERTY_OPEN.
 * 
*/
public interface PBmmSinglePropertyOpen extends PBmmProperty {

/* * ATTRIBUTE * */

/**
 * 
 * Type definition of this property computed from type for later use in bmm_property.
 * 
*/
    PBmmOpenType getTypeRef();
    void setTypeRef(PBmmOpenType value);

/**
 * 
 * Type definition of this property, if a simple String type reference.
 * Really we should use type_def to be regular in the schema, but that makes the schema more wordy and less clear.
 * So we use this persisted String value, and compute the type_def on the fly.
 * Persisted attribute.
 * 
*/
    String getType();
    void setType(String value);

/**
 * 
 * BMM_PROPERTY created by create_bmm_property_definition.
 * 
*/
    BmmUnitaryProperty getBmmProperty();
    void setBmmProperty(BmmUnitaryProperty value);

/* * FUNCTION * */

/**
 * 
 * Generate type_ref from type and save.
 * 
*/
    PBmmOpenType  type_def();

}

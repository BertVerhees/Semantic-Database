package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persistent form of BMM_GENERIC_PROPERTY.
 * 
*/
public interface PBmmGenericProperty extends PBmmProperty {

/* * ATTRIBUTE * */

/**
 * 
 * Type definition of this property, if not a simple String type reference.
 * Persistent attribute.
 * 
*/
    PBmmGenericType getTypeDef();
    void setTypeDef(PBmmGenericType value);

/**
 * 
 * BMM_PROPERTY created by create_bmm_property_definition.
 * 
*/
    BmmUnitaryProperty getBmmProperty();
    void setBmmProperty(BmmUnitaryProperty value);

/* * FUNCTION * */

}

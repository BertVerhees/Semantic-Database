package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persistent form of BMM_GENERIC_PROPERTY.
 * 
*/
public interface PBmmGenericProperty extends PBmmProperty {

/**
 * 
 * Type definition of this property, if not a simple String type reference.
 * Persistent attribute.
 * 
*/
PBmmGenericType getTypeDef()
setTypeDef(var PBmmGenericType)

/**
 * 
 * BMM_PROPERTY created by create_bmm_property_definition.
 * 
*/
BmmUnitaryProperty getBmmProperty()
setBmmProperty(var BmmUnitaryProperty)

}

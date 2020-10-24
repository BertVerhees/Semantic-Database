package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * 
 * 
*/
public interface PBmmIndexedContainerProperty extends PBmmContainerProperty {

/**
 * 
 * Type definition of this property, if not a simple String type reference.
 * Persistent attribute.
 * 
*/
PBmmIndexedContainerType getTypeDef()
setTypeDef(var PBmmIndexedContainerType)

/**
 * 
 * BMM_PROPERTY created by create_bmm_property.
 * 
*/
BmmIndexedContainerProperty getBmmProperty()
setBmmProperty(var BmmIndexedContainerProperty)

}

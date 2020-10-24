package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persistent form of BMM_CONTAINER_PROPERTY.
 * 
*/
public interface PBmmContainerProperty extends PBmmProperty {

/**
 * 
 * Cardinality of this property in its class.
 * Persistent attribute.
 * 
*/
Interval<integer> getCardinality()
setCardinality(var Interval<integer>)

/**
 * 
 * Type definition of this property, if not a simple String type reference.
 * Persistent attribute.
 * 
*/
PBmmContainerType getTypeDef()
setTypeDef(var PBmmContainerType)

/**
 * 
 * BMM_PROPERTY created by create_bmm_property.
 * 
*/
BmmContainerProperty getBmmProperty()
setBmmProperty(var BmmContainerProperty)

}

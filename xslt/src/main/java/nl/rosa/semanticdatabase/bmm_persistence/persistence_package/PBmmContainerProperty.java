package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persistent form of BMM_CONTAINER_PROPERTY.
 * 
*/
public interface PBmmContainerProperty extends PBmmProperty {

/* * ATTRIBUTE * */

/**
 * 
 * Cardinality of this property in its class.
 * Persistent attribute.
 * 
*/
Interval<integer> getCardinality();
void setCardinality(var Interval<integer>);

/**
 * 
 * Type definition of this property, if not a simple String type reference.
 * Persistent attribute.
 * 
*/
PBmmContainerType getTypeDef();
void setTypeDef(var PBmmContainerType);

/**
 * 
 * BMM_PROPERTY created by create_bmm_property.
 * 
*/
BmmContainerProperty getBmmProperty();
void setBmmProperty(var BmmContainerProperty);

/* * FUNCTION * */

/**
 * 
 * Create bmm_property_definition.
 * create_bmm_property ( a_bmm_schema: BMM_MODEL[1], a_class_def: BMM_CLASS[1] )
 * 
*/

}

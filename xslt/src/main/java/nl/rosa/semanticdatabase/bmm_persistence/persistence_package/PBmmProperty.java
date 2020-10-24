package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persistent form of BMM_PROPERTY.
 * 
*/
public interface PBmmProperty extends PBmmModelElement {

/**
 * 
 * Name of this property within its class.
 * Persisted attribute.
 * 
*/
String getName()
setName(var String)

/**
 * 
 * True if this property is mandatory in its class.
 * Persisted attribute.
 * 
*/
Boolean getIsMandatory()
setIsMandatory(var Boolean)

/**
 * 
 * True if this property is computed rather than stored in objects of this class.
 * Persisted Attribute.
 * 
*/
Boolean getIsComputed()
setIsComputed(var Boolean)

/**
 * 
 * True if this property is info model 'infrastructure' rather than 'data'.
 * Persisted attribute.
 * 
*/
Boolean getIsImInfrastructure()
setIsImInfrastructure(var Boolean)

/**
 * 
 * True if this property is info model 'runtime' settable property.
 * Persisted attribute.
 * 
*/
Boolean getIsImRuntime()
setIsImRuntime(var Boolean)

/**
 * 
 * Type definition of this property, if not a simple String type reference.
 * Persisted attribute.
 * 
*/
PBmmType getTypeDef()
setTypeDef(var PBmmType)

/**
 * 
 * BMM_PROPERTY created by create_bmm_property_definition.
 * 
*/
BmmProperty getBmmProperty()
setBmmProperty(var BmmProperty)

}

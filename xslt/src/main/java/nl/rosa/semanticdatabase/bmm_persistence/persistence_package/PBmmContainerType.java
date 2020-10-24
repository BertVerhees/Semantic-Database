package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persistent form of BMM_CONTAINER_TYPE.
 * 
*/
public interface PBmmContainerType extends PBmmType {

/**
 * 
 * The type of the container.
 * This converts to the root_type in BMM_GENERIC_TYPE.
 * Persisted attribute.
 * 
*/
String getContainerType()
setContainerType(var String)

/**
 * 
 * Type definition of type, if not a simple String type reference.
 * Persisted attribute.
 * 
*/
PBmmBaseType getTypeDef()
setTypeDef(var PBmmBaseType)

/**
 * 
 * The target type; this converts to the first parameter in generic_parameters in BMM_GENERIC_TYPE.
 * Persisted attribute.
 * 
*/
String getType()
setType(var String)

/**
 * 
 * Result of create_bmm_type() call.
 * 
*/
BmmContainerType getBmmType()
setBmmType(var BmmContainerType)

}

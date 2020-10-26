package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persistent form of BMM_CONTAINER_TYPE.
 * 
*/
public interface PBmmContainerType extends PBmmType {

/* * ATTRIBUTE * */

/**
 * 
 * The type of the container.
 * This converts to the root_type in BMM_GENERIC_TYPE.
 * Persisted attribute.
 * 
*/
String getContainerType();
void setContainerType(value String);

/**
 * 
 * Type definition of type, if not a simple String type reference.
 * Persisted attribute.
 * 
*/
PBmmBaseType getTypeDef();
void setTypeDef(value PBmmBaseType);

/**
 * 
 * The target type; this converts to the first parameter in generic_parameters in BMM_GENERIC_TYPE.
 * Persisted attribute.
 * 
*/
String getType();
void setType(value String);

/**
 * 
 * Result of create_bmm_type() call.
 * 
*/
BmmContainerType getBmmType();
void setBmmType(value BmmContainerType);

/* * FUNCTION * */

/**
 * 
 * The target type; this converts to the first parameter in generic_parameters in BMM_GENERIC_TYPE.
 * Persisted attribute.
 * type_ref (): P_BMM_BASE_TYPE
 * 
*/
PBmmBaseType typeRef ();

}

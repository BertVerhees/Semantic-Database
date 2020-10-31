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
    PBmmContainerType getContainerType();
    void setContainerType(PBmmContainerType value);

/**
 * 
 * Type definition of type, if not a simple String type reference.
 * Persisted attribute.
 * 
*/
    PBmmContainerType getTypeDef();
    void setTypeDef(PBmmContainerType value);

/**
 * 
 * The target type; this converts to the first parameter in generic_parameters in BMM_GENERIC_TYPE.
 * Persisted attribute.
 * 
*/
    PBmmContainerType getType();
    void setType(PBmmContainerType value);

/**
 * 
 * Result of create_bmm_type() call.
 * 
*/
    PBmmContainerType getBmmType();
    void setBmmType(PBmmContainerType value);

/* * FUNCTION * */

/**
 * 
 * The target type; this converts to the first parameter in generic_parameters in BMM_GENERIC_TYPE.
 * Persisted attribute.
 * 
*/
    PBmmContainerType  type_ref();

}

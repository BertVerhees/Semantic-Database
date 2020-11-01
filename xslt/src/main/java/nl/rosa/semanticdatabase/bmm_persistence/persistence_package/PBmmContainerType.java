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
     getContainerType();
    void setContainerType( value);

/**
 * 
 * Type definition of type, if not a simple String type reference.
 * Persisted attribute.
 * 
*/
     getTypeDef();
    void setTypeDef( value);

/**
 * 
 * The target type; this converts to the first parameter in generic_parameters in BMM_GENERIC_TYPE.
 * Persisted attribute.
 * 
*/
     getType();
    void setType( value);

/**
 * 
 * Result of create_bmm_type() call.
 * 
*/
    BmmContainerType getBmmType();
    void setBmmType(BmmContainerType value);

/* * FUNCTION * */

/**
 * 
 * The target type; this converts to the first parameter in generic_parameters in BMM_GENERIC_TYPE.
 * Persisted attribute.
 * 
*/
      type_ref();

}

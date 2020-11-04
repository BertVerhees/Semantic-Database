package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * 
 * 
*/
public class PBmmIndexedContainerTypeImpl implements PBmmContainerType{

    //***** PBmmIndexedContainerType *****

/* * FIELDS * */

/**
 * 
 * 
 * 
*/
    private String index_type;

        />
    
/**
 * 
 * Result of create_bmm_type() call.
 * 
*/
    private BmmIndexedContainerType bmm_type;

        />
    
    //***** PBmmContainerType *****

/* * FIELDS * */

/**
 * 
 * The type of the container.
 * This converts to the root_type in BMM_GENERIC_TYPE.
 * Persisted attribute.
 * 
*/
    private String container_type;

        />
    
/**
 * 
 * Type definition of type, if not a simple String type reference.
 * Persisted attribute.
 * 
*/
    private PBmmBaseType type_def;

        />
    
/**
 * 
 * The target type; this converts to the first parameter in generic_parameters in BMM_GENERIC_TYPE.
 * Persisted attribute.
 * 
*/
    private String type;

        />
    
/**
 * 
 * Result of create_bmm_type() call.
 * 
*/
    private BmmContainerType bmm_type;

        />
    
    //***** PBmmType *****

/* * FIELDS * */

/**
 * 
 * Result of create_bmm_type() call.
 * 
*/
    private BmmType bmm_type;

        />
    
/* * ATTRIBUTE * */

/* * POJO * */

/* * FUNCTION * */

}

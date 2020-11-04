package nl.rosa.semanticdatabase.bmm.model_access_package;

/**
 * 
 * Access to BMM models that have been loaded and validated from one or more schema sets.
 * 
*/
public class BmmModelAccessImpl implements {

    //***** BmmModelAccess *****

/* * FIELDS * */

/**
 * 
 * List of directories where all the schemas loaded here are found.
 * 
*/
    private List<String> schema_directories;

        />
    
/**
 * 
 * All schemas found and loaded from schema_directory.
 * Keyed by schema_id.
 * 
*/
    private Map<String,BmmSchemaDescriptor> all_schemas;

        />
    
/**
 * 
 * Top-level (root) models in use, keyed by model_id.
 * 
*/
    private Map<String,BmmModel> bmm_models;

        />
    
/**
 * 
 * Validated models, keyed by model_id() and any shorter forms of id, with some or no versioning information.
 * For example, the keys "openEHR_EHR_1.0.4", "openEHR_EHR_1.0", "openEHR_EHR_1", and "openEHR_EHR" will all match the "openEHR_EHR_1.0.4" model, assuming it is the most recent version available.
 * 
*/
    private Map<String,BmmModel> matching_bmm_models;

        />
    
/**
 * 
 * Reload BMM schemas.
 * 
*/
    private  ;

        />
    
/* * ATTRIBUTE * */

/* * POJO * */

/* * FUNCTION * */

}

package nl.rosa.semanticdatabase.bmm.model_access_package;

/**
 * 
 * Access to BMM models that have been loaded and validated from one or more schema sets.
 * 
*/
public interface BmmModelAccess {

/* * ATTRIBUTE * */

/**
 * 
 * List of directories where all the schemas loaded here are found.
 * 
*/
    List<String> getSchemaDirectories();
    void setSchemaDirectories(List<String> value);

/**
 * 
 * All schemas found and loaded from schema_directory.
 * Keyed by schema_id.
 * 
*/
    Map<String,BmmSchemaDescriptor> getAllSchemas();
    void setAllSchemas(Map<String,BmmSchemaDescriptor> value);

/**
 * 
 * Top-level (root) models in use, keyed by model_id.
 * 
*/
    Map<String,BmmModel> getBmmModels();
    void setBmmModels(Map<String,BmmModel> value);

/**
 * 
 * Validated models, keyed by model_id() and any shorter forms of id, with some or no versioning information.
 * For example, the keys "openEHR_EHR_1.0.4", "openEHR_EHR_1.0", "openEHR_EHR_1", and "openEHR_EHR" will all match the "openEHR_EHR_1.0.4" model, assuming it is the most recent version available.
 * 
*/
    Map<String,BmmModel> getMatchingBmmModels();
    void setMatchingBmmModels(Map<String,BmmModel> value);

/**
 * 
 * Reload BMM schemas.
 * 
*/
     get();
    void set( value);

/* * FUNCTION * */

/**
 * 
 * Initialise with a specific schema load list, usually a sub-set of schemas that will be found in a specified directories a_schema_dirs.
 * 
*/
    void  initialise_with_load_list();

/**
 * 
 * Load all schemas found in a specified directories a_schema_dirs.
 * 
*/
    void  initialise_all();

/**
 * 
 * Return model containing the model key which is a model_id or any shorter form e.g.
 * model id minus the version.
 * If a shorter key is used, the BMM_MODEL with the most recent version will be selected.
 * Uses matching_bmm_models table to find matches if partial version information is supplied in key.
 * 
*/
    BmmModel  bmm_model();

/**
 * 
 * True if a model for a model_key is available.
 * A model key is a model_id or any shorter form e.g.
 * model id minus the version.
 * If a shorter key is used, the Result s True if a BMM_MODEL with any version exists.
 * 
*/
    Boolean  has_bmm_model();

}

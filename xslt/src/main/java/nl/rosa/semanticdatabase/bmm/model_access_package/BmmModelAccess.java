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
    List<string> getSchemaDirectories();
    void setSchemaDirectories(value List<string>);

/**
 * 
 * All schemas found and loaded from schema_directory.
 * Keyed by schema_id.
 * 
*/
    Hash<string,bmmSchemaDescriptor> getAllSchemas();
    void setAllSchemas(value Hash<string,bmmSchemaDescriptor>);

/**
 * 
 * Top-level (root) models in use, keyed by model_id.
 * 
*/
    Hash<string,bmmModel> getBmmModels();
    void setBmmModels(value Hash<string,bmmModel>);

/**
 * 
 * Validated models, keyed by model_id() and any shorter forms of id, with some or no versioning information.
 * For example, the keys "openEHR_EHR_1.0.4", "openEHR_EHR_1.0", "openEHR_EHR_1", and "openEHR_EHR" will all match the "openEHR_EHR_1.0.4" model, assuming it is the most recent version available.
 * 
*/
    Hash<string,bmmModel> getMatchingBmmModels();
    void setMatchingBmmModels(value Hash<string,bmmModel>);

/**
 * 
 * Reload BMM schemas.
 * 
*/
    void getReloadSchemas();
    void setReloadSchemas(value void);

/* * FUNCTION * */

/**
 * 
 * Initialise with a specific schema load list, usually a sub-set of schemas that will be found in a specified directories a_schema_dirs.
 * initialise_with_load_list ( a_schema_dirs: List<String>[1], a_schema_load_list: List<String>[0..1] )
 * 
*/
    void initialiseWithLoadList ( aSchemaDirs: list<string>[1], aSchemaLoadList: list<string>[0..1] );

/**
 * 
 * Load all schemas found in a specified directories a_schema_dirs.
 * initialise_all ( a_schema_dirs: List<String>[1] )
 * 
*/
    void initialiseAll ( aSchemaDirs: list<string>[1] );

/**
 * 
 * Return model containing the model key which is a model_id or any shorter form e.g.
 * model id minus the version.
 * If a shorter key is used, the BMM_MODEL with the most recent version will be selected.
 * Uses matching_bmm_models table to find matches if partial version information is supplied in key.
 * bmm_model ( a_model_key: String[1] ): BMM_MODEL
 * 
*/
    BmmModel bmmModel ( aModelKey: string[1]);

/**
 * 
 * True if a model for a model_key is available.
 * A model key is a model_id or any shorter form e.g.
 * model id minus the version.
 * If a shorter key is used, the Result s True if a BMM_MODEL with any version exists.
 * has_bmm_model ( a_model_key: String[1] ): Boolean
 * 
*/
    Boolean hasBmmModel ( aModelKey: string[1]);

}

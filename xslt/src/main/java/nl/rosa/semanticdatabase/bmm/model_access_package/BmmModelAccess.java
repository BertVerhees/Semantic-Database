package nl.rosa.semanticdatabase.bmm.model_access_package;

/**
 * 
 * Access to BMM models that have been loaded and validated from one or more schema sets.
 * 
*/
public interface BmmModelAccess {

/**
 * 
 * List of directories where all the schemas loaded here are found.
 * 
*/
List<string> getSchemaDirectories()
setSchemaDirectories(var List<string>)

/**
 * 
 * All schemas found and loaded from schema_directory.
 * Keyed by schema_id.
 * 
*/
Hash<string,bmmSchemaDescriptor> getAllSchemas()
setAllSchemas(var Hash<string,bmmSchemaDescriptor>)

/**
 * 
 * Top-level (root) models in use, keyed by model_id.
 * 
*/
Hash<string,bmmModel> getBmmModels()
setBmmModels(var Hash<string,bmmModel>)

/**
 * 
 * Validated models, keyed by model_id() and any shorter forms of id, with some or no versioning information.
 * For example, the keys "openEHR_EHR_1.0.4", "openEHR_EHR_1.0", "openEHR_EHR_1", and "openEHR_EHR" will all match the "openEHR_EHR_1.0.4" model, assuming it is the most recent version available.
 * 
*/
Hash<string,bmmModel> getMatchingBmmModels()
setMatchingBmmModels(var Hash<string,bmmModel>)

/**
 * 
 * Reload BMM schemas.
 * 
*/
getReloadSchemas()
setReloadSchemas(var )

}

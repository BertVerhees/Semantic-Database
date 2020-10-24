package nl.rosa.semanticdatabase.bmm.model_access_package;

/**
 * 
 * Descriptor for a BMM schema.
 * Contains a meta-data table of attributes obtained from a mini-ODIN parse of the schema file.
 * 
*/
public interface BmmSchemaDescriptor {

/**
 * 
 * Persistent form of model.
 * 
*/
BmmSchema getBmmSchema()
setBmmSchema(var BmmSchema)

/**
 * 
 * Computable form of model.
 * 
*/
BmmModel getBmmModel()
setBmmModel(var BmmModel)

/**
 * 
 * Schema id, formed by {BMM_DEFINITIONS}.create_schema_id( meta_data.item({BMM_DEFINITIONS}.Metadata_model_publisher), meta_data.item({BMM_DEFINITIONS}.Metadata_schema_name), meta_data.item({BMM_DEFINITIONS}.Metadata_model_release) e.g.
 * openehr_rm_1.0.3, openehr_test_1.0.1, iso_13606_1_2008_2.1.2.
 * 
*/
String getSchemaId()
setSchemaId(var String)

/**
 * 
 * Table of {key, value} of schema meta-data, keys are string values defined by {BMM_DEFINITIONS}.Metadata_* constants.
 * 
*/
Hash<string, string> getMetaData()
setMetaData(var Hash<string, string>)

/**
 * 
 * Identifiers of schemas included by this schema.
 * 
*/
List<string> getIncludes()
setIncludes(var List<string>)

/**
 * 
 * Load schema into in-memory form, i.e.
 * a P_BMM_SCHEMA instance, if structurally valid.
 * If successful, p_schema will be set.
 * 
*/
getLoad()
setLoad(var )

/**
 * 
 * Validate loaded schema and report errors.
 * 
*/
getValidateMerged()
setValidateMerged(var )

/**
 * 
 * Create schema, i.e.
 * the BMM_MODEL from one P_BMM_SCHEMA schema.
 * 
*/
getCreateModel()
setCreateModel(var )

}

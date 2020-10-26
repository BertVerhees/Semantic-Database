package nl.rosa.semanticdatabase.bmm.model_access_package;

/**
 * 
 * Descriptor for a BMM schema.
 * Contains a meta-data table of attributes obtained from a mini-ODIN parse of the schema file.
 * 
*/
public interface BmmSchemaDescriptor {

/* * ATTRIBUTE * */

/**
 * 
 * Persistent form of model.
 * 
*/
BmmSchema getBmmSchema();
void setBmmSchema(var BmmSchema);

/**
 * 
 * Computable form of model.
 * 
*/
BmmModel getBmmModel();
void setBmmModel(var BmmModel);

/**
 * 
 * Schema id, formed by {BMM_DEFINITIONS}.create_schema_id( meta_data.item({BMM_DEFINITIONS}.Metadata_model_publisher), meta_data.item({BMM_DEFINITIONS}.Metadata_schema_name), meta_data.item({BMM_DEFINITIONS}.Metadata_model_release) e.g.
 * openehr_rm_1.0.3, openehr_test_1.0.1, iso_13606_1_2008_2.1.2.
 * 
*/
String getSchemaId();
void setSchemaId(var String);

/**
 * 
 * Table of {key, value} of schema meta-data, keys are string values defined by {BMM_DEFINITIONS}.Metadata_* constants.
 * 
*/
Hash<string, string> getMetaData();
void setMetaData(var Hash<string, string>);

/**
 * 
 * Identifiers of schemas included by this schema.
 * 
*/
List<string> getIncludes();
void setIncludes(var List<string>);

/* * FUNCTION * */

/**
 * 
 * True if this is a top-level schema, i.e.
 * not included by some other schema.
 * is_top_level (): Boolean
 * 
*/

/**
 * 
 * True if the BMM version found in the schema (or assumed, if none) is compatible with that in this software.
 * is_bmm_compatible (): Boolean
 * 
*/

/**
 * 
 * Load schema into in-memory form, i.e.
 * a P_BMM_SCHEMA instance, if structurally valid.
 * If successful, p_schema will be set.
 * load
 * 
*/

/**
 * 
 * Validate loaded schema and report errors.
 * validate_merged
 * 
*/

/**
 * 
 * Validate includes list for this schema, to see if each mentioned schema exists in all_schemas list.
 * validate_includes ( all_schemas_list: List<String>[0..1] )
 * 
*/

/**
 * 
 * Create schema, i.e.
 * the BMM_MODEL from one P_BMM_SCHEMA schema.
 * create_model
 * 
*/

}

package nl.rosa.semanticdatabase.bmm.model_access_package;

/**
 * 
 * Descriptor for a BMM schema.
 * Contains a meta-data table of attributes obtained from a mini-ODIN parse of the schema file.
 * 
*/
public class BmmSchemaDescriptorImpl implements {

    //***** BmmSchemaDescriptor *****

/* * FIELDS * */

/**
 * 
 * Persistent form of model.
 * 
*/
    private BmmSchema bmm_schema;

        />
    
/**
 * 
 * Computable form of model.
 * 
*/
    private BmmModel bmm_model;

        />
    
/**
 * 
 * Schema id, formed by {BMM_DEFINITIONS}.create_schema_id( meta_data.item({BMM_DEFINITIONS}.Metadata_model_publisher), meta_data.item({BMM_DEFINITIONS}.Metadata_schema_name), meta_data.item({BMM_DEFINITIONS}.Metadata_model_release) e.g.
 * openehr_rm_1.0.3, openehr_test_1.0.1, iso_13606_1_2008_2.1.2.
 * 
*/
    private String schema_id;

        />
    
/**
 * 
 * Table of {key, value} of schema meta-data, keys are string values defined by {BMM_DEFINITIONS}.Metadata_* constants.
 * 
*/
    private Map<String, String> meta_data;

        />
    
/**
 * 
 * Identifiers of schemas included by this schema.
 * 
*/
    private List<String> includes;

        />
    
/**
 * 
 * Load schema into in-memory form, i.e.
 * a P_BMM_SCHEMA instance, if structurally valid.
 * If successful, p_schema will be set.
 * 
*/
    private  ;

        />
    
/**
 * 
 * Validate loaded schema and report errors.
 * 
*/
    private  ;

        />
    
/**
 * 
 * Create schema, i.e.
 * the BMM_MODEL from one P_BMM_SCHEMA schema.
 * 
*/
    private  ;

        />
    
/* * ATTRIBUTE * */

/* * POJO * */

/* * FUNCTION * */

}

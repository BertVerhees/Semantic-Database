package nl.rosa.semanticdatabase.bmm.model_access_package;

/**
 * 
 * Abstract parent of any persistable form of a BMM model, e.g.
 * P_BMM_SCHEMA.
 * 
*/
public interface BmmSchema extends BmmModelMetadata {

/* * ATTRIBUTE * */

/**
 * 
 * Version of BMM model, enabling schema evolution reasoning.
 * Persisted attribute.
 * 
*/
    String getBmmVersion();
    void setBmmVersion(String value);

/**
 * 
 * Inclusion list of any form of BMM model, in the form of a hash of individual include specifications, each of which at least specifies the id of another schema, and may specify a namespace via which types from the included schemas are known in this schema.
 * Persisted attribute.
 * 
*/
    Map<String,BmmIncludeSpec> getIncludes();
    void setIncludes(Map<String,BmmIncludeSpec> value);

/**
 * 
 * Generated by create_bmm_model from persisted elements.
 * 
*/
    BmmModel getBmmModel();
    void setBmmModel(BmmModel value);

/**
 * 
 * Current processing state.
 * 
*/
    BmmSchemaState getState();
    void setState(BmmSchemaState value);

/**
 * 
 * Name of this model, if this schema is a model root point.
 * Not set for sub-schemas that are not considered models on their own.
 * 
*/
    String getModelName();
    void setModelName(String value);

/**
 * 
 * Name of model expressed in schema; a 'schema' usually contains all of the packages of one 'model' of a publisher.
 * A publisher with more than one model can have multiple schemas.
 * 
*/
    String getSchemaName();
    void setSchemaName(String value);

/**
 * 
 * Revision of schema.
 * 
*/
    String getSchemaRevision();
    void setSchemaRevision(String value);

/**
 * 
 * Schema development lifecycle state.
 * 
*/
    String getSchemaLifecycleState();
    void setSchemaLifecycleState(String value);

/**
 * 
 * Primary author of schema.
 * 
*/
    String getSchemaAuthor();
    void setSchemaAuthor(String value);

/**
 * 
 * Description of schema.
 * 
*/
    String getSchemaDescription();
    void setSchemaDescription(String value);

/**
 * 
 * Contributing authors of schema.
 * 
*/
    List<String> getSchemaContributors();
    void setSchemaContributors(List<String> value);

/**
 * 
 * Main validation prior to generation of bmm_model.
 * 
*/
     get();
    void set( value);

/* * FUNCTION * */

/**
 * 
 * Merge in class and package definitions from other, except where the current schema already has a definition for the given type or package.
 * 
*/
    includes_to_process.has (included_schema.schema_id)  merge();

/**
 * 
 * True when validation may be commenced.
 * 
*/
    state = State_includes_processed  read_to_validate();

/**
 * 
 * Identifier of this schema, used for stating inclusions and identifying files.
 * Formed as: {BMM_DEFINITIONS}.create_schema_id ( rm_publisher, schema_name, rm_release) E.g.
 * "openehr_rm_ehr_1.0.4".
 * 
*/
    String  schema_id();

}

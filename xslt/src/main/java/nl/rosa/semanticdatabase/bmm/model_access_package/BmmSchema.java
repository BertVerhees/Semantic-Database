package nl.rosa.semanticdatabase.bmm.model_access_package;

/**
 * 
 * Abstract parent of any persistable form of a BMM model, e.g.
 * P_BMM_SCHEMA.
 * 
*/
public interface BmmSchema extends BmmModelMetadata {

/**
 * 
 * Version of BMM model, enabling schema evolution reasoning.
 * Persisted attribute.
 * 
*/
String getBmmVersion()
setBmmVersion(var String)

/**
 * 
 * Inclusion list of any form of BMM model, in the form of a hash of individual include specifications, each of which at least specifies the id of another schema, and may specify a namespace via which types from the included schemas are known in this schema.
 * Persisted attribute.
 * 
*/
Hash<string,bmmIncludeSpec> getIncludes()
setIncludes(var Hash<string,bmmIncludeSpec>)

/**
 * 
 * Generated by create_bmm_model from persisted elements.
 * 
*/
BmmModel getBmmModel()
setBmmModel(var BmmModel)

/**
 * 
 * Current processing state.
 * 
*/
BmmSchemaState getState()
setState(var BmmSchemaState)

/**
 * 
 * Name of this model, if this schema is a model root point.
 * Not set for sub-schemas that are not considered models on their own.
 * 
*/
String getModelName()
setModelName(var String)

/**
 * 
 * Name of model expressed in schema; a 'schema' usually contains all of the packages of one 'model' of a publisher.
 * A publisher with more than one model can have multiple schemas.
 * 
*/
String getSchemaName()
setSchemaName(var String)

/**
 * 
 * Revision of schema.
 * 
*/
String getSchemaRevision()
setSchemaRevision(var String)

/**
 * 
 * Schema development lifecycle state.
 * 
*/
String getSchemaLifecycleState()
setSchemaLifecycleState(var String)

/**
 * 
 * Primary author of schema.
 * 
*/
String getSchemaAuthor()
setSchemaAuthor(var String)

/**
 * 
 * Description of schema.
 * 
*/
String getSchemaDescription()
setSchemaDescription(var String)

/**
 * 
 * Contributing authors of schema.
 * 
*/
List<string> getSchemaContributors()
setSchemaContributors(var List<string>)

/**
 * 
 * Do some basic validation post initial creation check that package structure is regular: only top-level packages can have qualified names no top-level package name can be a direct parent or child of another (child package must be declared under the parent) check that all classes are mentioned in the package structure check that all models refer to valid packages
 * 
*/
State = stateCreated postState getValidateCreated preState()
setValidateCreated preState(var State = stateCreated postState)

/**
 * 
 * Finalisation work: convert packages to canonical form, i.e.
 * full hierarchy with no packages with names like aa.bb.cc set up include processing list
 * 
*/
State = stateValidatedCreated postState getLoadFinalise preState()
setLoadFinalise preState(var State = stateValidatedCreated postState)

/**
 * 
 * Main validation prior to generation of bmm_model.
 * 
*/
getValidate()
setValidate(var )

/**
 * 
 * Populate bmm_model from schema.
 * 
*/
State = pBmmPackageState.stateIncludesProcessed getCreateBmmModel preState()
setCreateBmmModel preState(var State = pBmmPackageState.stateIncludesProcessed)

}

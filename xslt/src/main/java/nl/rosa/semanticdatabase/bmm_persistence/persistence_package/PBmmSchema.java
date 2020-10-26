package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persisted form of BMM_SCHEMA.
 * 
*/
public interface PBmmSchema extends PBmmPackageContainer,BmmSchema {

/* * ATTRIBUTE * */

/**
 * 
 * Primitive type definitions.
 * Persisted attribute.
 * 
*/
List<pBmmClass> getPrimitiveTypes();
void setPrimitiveTypes(value List<pBmmClass>);

/**
 * 
 * Class definitions.
 * Persisted attribute.
 * 
*/
List<pBmmClass> getClassDefinitions();
void setClassDefinitions(value List<pBmmClass>);

/**
 * 
 * Implementation of validate_created()
 * 
*/
State = stateCreated postState getValidateCreated preState();
void setValidateCreated preState(value State = stateCreated postState);

/**
 * 
 * Implementation of load_finalise()
 * 
*/
State = stateValidatedCreated postState getLoadFinalise preState();
void setLoadFinalise preState(value State = stateValidatedCreated postState);

/**
 * 
 * Implementation of create_bmm_model()
 * 
*/
State = pBmmPackageState.stateIncludesProcessed getCreateBmmModel preState();
void setCreateBmmModel preState(value State = pBmmPackageState.stateIncludesProcessed);

/* * FUNCTION * */

/**
 * 
 * Implementation of merge()
 * merge ( other: P_BMM_SCHEMA[1] ) Pre_state: state = State_includes_pending Pre_other_valid: includes_to_process.has (included_schema.schema_id)
 * 
*/
void merge ( other: pBmmSchema[1] ) preState: state = stateIncludesPending preOtherValid: includesToProcess.has (includedSchema.schemaId);

/**
 * 
 * Implementation of validate()
 * validate
 * 
*/
void validate();

/**
 * 
 * Package structure in which all top-level qualified package names like xx.yy.zz have been expanded out to a hierarchy of BMM_PACKAGE objects.
 * canonical_packages (): P_BMM_PACKAGE
 * 
*/
PBmmPackage canonicalPackages ();

}

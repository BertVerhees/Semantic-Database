package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persisted form of BMM_SCHEMA.
 * 
*/
public interface PBmmSchema extends PBmmPackageContainer,BmmSchema {

/**
 * 
 * Primitive type definitions.
 * Persisted attribute.
 * 
*/
List<pBmmClass> getPrimitiveTypes()
setPrimitiveTypes(var List<pBmmClass>)

/**
 * 
 * Class definitions.
 * Persisted attribute.
 * 
*/
List<pBmmClass> getClassDefinitions()
setClassDefinitions(var List<pBmmClass>)

/**
 * 
 * Implementation of validate_created()
 * 
*/
State = stateCreated postState getValidateCreated preState()
setValidateCreated preState(var State = stateCreated postState)

/**
 * 
 * Implementation of load_finalise()
 * 
*/
State = stateValidatedCreated postState getLoadFinalise preState()
setLoadFinalise preState(var State = stateValidatedCreated postState)

/**
 * 
 * Implementation of validate()
 * 
*/
getValidate()
setValidate(var )

/**
 * 
 * Implementation of create_bmm_model()
 * 
*/
State = pBmmPackageState.stateIncludesProcessed getCreateBmmModel preState()
setCreateBmmModel preState(var State = pBmmPackageState.stateIncludesProcessed)

}

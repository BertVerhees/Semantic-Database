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
    List<PBmmClass> getPrimitiveTypes();
    void setPrimitiveTypes(List<PBmmClass> value);

/**
 * 
 * Class definitions.
 * Persisted attribute.
 * 
*/
    List<PBmmClass> getClassDefinitions();
    void setClassDefinitions(List<PBmmClass> value);

/**
 * 
 * Implementation of validate()
 * 
*/
     get();
    void set( value);

/* * FUNCTION * */

/**
 * 
 * Implementation of merge()
 * 
*/
    includes_to_process.has (included_schema.schema_id)  merge();

/**
 * 
 * Package structure in which all top-level qualified package names like xx.yy.zz have been expanded out to a hierarchy of BMM_PACKAGE objects.
 * 
*/
    PBmmPackage  canonical_packages();

/* * CONSTANTS * */

/**
 * 
 * Implementation of validate_created()
 * 
*/
    state validateCreated preState = State_created Post_state: passed implies state = State_validated_created;

/**
 * 
 * Implementation of load_finalise()
 * 
*/
    state loadFinalise preState = State_validated_created Post_state: state = State_includes_processed or state = State_includes_pending;

/**
 * 
 * Implementation of create_bmm_model()
 * 
*/
    state createBmmModel preState = P_BMM_PACKAGE_STATE.State_includes_processed;

}

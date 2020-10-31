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
    PBmmSchema getPrimitiveTypes();
    void setPrimitiveTypes(PBmmSchema value);

/**
 * 
 * Class definitions.
 * Persisted attribute.
 * 
*/
    PBmmSchema getClassDefinitions();
    void setClassDefinitions(PBmmSchema value);

/**
 * 
 * Implementation of validate()
 * 
*/
    PBmmSchema get();
    void set(PBmmSchema value);

/* * FUNCTION * */

/**
 * 
 * Implementation of merge()
 * 
*/
    PBmmSchema  merge();

/**
 * 
 * Package structure in which all top-level qualified package names like xx.yy.zz have been expanded out to a hierarchy of BMM_PACKAGE objects.
 * 
*/
    PBmmSchema  canonical_packages();

}

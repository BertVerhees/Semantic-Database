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
     getPrimitiveTypes();
    void setPrimitiveTypes( value);

/**
 * 
 * Class definitions.
 * Persisted attribute.
 * 
*/
     getClassDefinitions();
    void setClassDefinitions( value);

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
      merge();

/**
 * 
 * Package structure in which all top-level qualified package names like xx.yy.zz have been expanded out to a hierarchy of BMM_PACKAGE objects.
 * 
*/
    PBmmPackage  canonical_packages();

}

package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persisted form of a package as a tree structure whose nodes can contain more packages and/or classes.
 * 
*/
public interface PBmmPackage extends PBmmPackageContainer,PBmmModelElement {

/* * ATTRIBUTE * */

/**
 * 
 * Name of the package from schema; this name may be qualified if it is a top-level package within the schema, or unqualified.
 * Persistent attribute.
 * 
*/
    PBmmPackage getName();
    void setName(PBmmPackage value);

/**
 * 
 * List of classes in this package.
 * Persistent attribute.
 * 
*/
    PBmmPackage getClasses();
    void setClasses(PBmmPackage value);

/**
 * 
 * BMM_PACKAGE created by create_bmm_package_definition.
 * 
*/
    PBmmPackage getBmmPackageDefinition();
    void setBmmPackageDefinition(PBmmPackage value);

/**
 * 
 * Generate a BMM_PACKAGE_DEFINITION object and write it to bmm_package_definition.
 * 
*/
    PBmmPackage get();
    void set(PBmmPackage value);

/* * FUNCTION * */

/**
 * 
 * Merge packages and classes from other (from an included P_BMM_SCHEMA) into this package.
 * 
*/
    PBmmPackage  merge();

}

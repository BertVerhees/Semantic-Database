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
String getName();
void setName(value String);

/**
 * 
 * List of classes in this package.
 * Persistent attribute.
 * 
*/
List<string> getClasses();
void setClasses(value List<string>);

/**
 * 
 * BMM_PACKAGE created by create_bmm_package_definition.
 * 
*/
BmmPackage getBmmPackageDefinition();
void setBmmPackageDefinition(value BmmPackage);

/* * FUNCTION * */

/**
 * 
 * Merge packages and classes from other (from an included P_BMM_SCHEMA) into this package.
 * merge ( other: P_BMM_PACKAGE[1] )
 * 
*/
void merge ( other: pBmmPackage[1] );

/**
 * 
 * Generate a BMM_PACKAGE_DEFINITION object and write it to bmm_package_definition.
 * create_bmm_package_definition
 * 
*/
void createBmmPackageDefinition();

}

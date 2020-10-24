package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persisted form of a package as a tree structure whose nodes can contain more packages and/or classes.
 * 
*/
public interface PBmmPackage extends PBmmPackageContainer,PBmmModelElement {

/**
 * 
 * Name of the package from schema; this name may be qualified if it is a top-level package within the schema, or unqualified.
 * Persistent attribute.
 * 
*/
String getName()
setName(var String)

/**
 * 
 * List of classes in this package.
 * Persistent attribute.
 * 
*/
List<string> getClasses()
setClasses(var List<string>)

/**
 * 
 * BMM_PACKAGE created by create_bmm_package_definition.
 * 
*/
BmmPackage getBmmPackageDefinition()
setBmmPackageDefinition(var BmmPackage)

/**
 * 
 * Generate a BMM_PACKAGE_DEFINITION object and write it to bmm_package_definition.
 * 
*/
getCreateBmmPackageDefinition()
setCreateBmmPackageDefinition(var )

}

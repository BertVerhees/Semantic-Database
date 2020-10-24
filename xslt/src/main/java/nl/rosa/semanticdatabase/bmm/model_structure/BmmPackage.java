package nl.rosa.semanticdatabase.bmm.model_structure;

/**
 * 
 * Abstraction of a package as a tree structure whose nodes can contain other packages and classes.
 * The name may be qualified if it is a top-level package.
 * 
*/
public interface BmmPackage extends BmmPackageContainer {

/**
 * 
 * Classes listed as being in this package.
 * 
*/
List<bmmClass> getClasses()
setClasses(var List<bmmClass>)

}

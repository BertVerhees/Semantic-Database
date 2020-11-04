package nl.rosa.semanticdatabase.bmm.model_structure;

/**
 * 
 * Abstraction of a package as a tree structure whose nodes can contain other packages and classes.
 * The name may be qualified if it is a top-level package.
 * 
*/
public interface BmmPackage extends BmmPackageContainer {

/* * ATTRIBUTE * */

/**
 * 
 * Classes listed as being in this package.
 * 
*/
    List<BmmClass> getClasses();
    void setClasses(List<BmmClass> value);

/* * FUNCTION * */

/**
 * 
 * Obtain the set of top-level classes in this package, either from this package itself or by recursing into the structure until classes are obtained from child packages.
 * Recurse into each child only far enough to find the first level of classes.
 * 
*/
    List<BmmClass>  root_classes();

/**
 * 
 * Full path of this package back to root package.
 * 
*/
    String  path();

/* * CONSTANTS * */

}

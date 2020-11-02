package nl.rosa.semanticdatabase.bmm.model_structure;

/**
 * 
 * A BMM model component that contains packages and classes.
 * 
*/
public interface BmmPackageContainer extends BmmDeclaration {

/* * ATTRIBUTE * */

/**
 * 
 * Child packages; keys all in upper case for guaranteed matching.
 * 
*/
    Map<String,BmmPackage> getPackages();
    void setPackages(Map<String,BmmPackage> value);

/**
 * 
 * Model element within which a referenceable element is known.
 * 
*/
    BmmPackageContainer getScope();
    void setScope(BmmPackageContainer value);

/* * FUNCTION * */

/**
 * 
 * Package at the path a_path.
 * 
*/
    BmmPackage  package_at_path();

/**
 * 
 * Recursively execute action, which is a procedure taking a BMM_PACKAGE argument, on all members of packages.
 * 
*/
    void  do_recursive_packages();

/**
 * 
 * True if there is a package at the path a_path; paths are delimited with delimiter {BMM_DEFINITIONS}_Package_name_delimiter_.
 * 
*/
    Boolean  has_package_path();

}

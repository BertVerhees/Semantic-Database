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
    Hash<string,bmmPackage> getPackages();
    void setPackages(value Hash<string,bmmPackage>);

/**
 * 
 * Model element within which a referenceable element is known.
 * 
*/
    BmmPackageContainer getScope();
    void setScope(value BmmPackageContainer);

/* * FUNCTION * */

/**
 * 
 * Package at the path a_path.
 * package_at_path ( a_path: String[1] ): BMM_PACKAGE
 * 
*/
    BmmPackage packageAtPath ( aPath: string[1]);

/**
 * 
 * Recursively execute action, which is a procedure taking a BMM_PACKAGE argument, on all members of packages.
 * do_recursive_packages ( action: EL_PROCEDURE_AGENT[1] )
 * 
*/
    void doRecursivePackages ( action: elProcedureAgent[1] );

/**
 * 
 * True if there is a package at the path a_path; paths are delimited with delimiter {BMM_DEFINITIONS}_Package_name_delimiter_.
 * has_package_path ( a_path: String[1] ): Boolean
 * 
*/
    Boolean hasPackagePath ( aPath: string[1]);

}

package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persisted form of a package as a tree structure whose nodes can contain more packages and/or classes.
 * 
*/
public class PBmmPackageImpl implements PBmmPackageContainer,PBmmModelElement{

    //***** PBmmPackage *****

/* * FIELDS * */

/**
 * 
 * Name of the package from schema; this name may be qualified if it is a top-level package within the schema, or unqualified.
 * Persistent attribute.
 * 
*/
    private String name;

        />
    
/**
 * 
 * List of classes in this package.
 * Persistent attribute.
 * 
*/
    private List<String> classes;

        />
    
/**
 * 
 * BMM_PACKAGE created by create_bmm_package_definition.
 * 
*/
    private BmmPackage bmm_package_definition;

        />
    
/**
 * 
 * Generate a BMM_PACKAGE_DEFINITION object and write it to bmm_package_definition.
 * 
*/
    private  ;

        />
    
    //***** PBmmPackageContainer *****

/* * FIELDS * */

/**
 * 
 * Package structure as a hierarchy of packages each potentially containing names of classes in that package in the original model.
 * 
*/
    private Map<String, P_BMM_PACKAGE> packages;

        />
    
    //***** PBmmModelElement *****

/* * FIELDS * */

/**
 * 
 * Optional documentation of this element.
 * 
*/
    private String documentation;

        />
    
/* * ATTRIBUTE * */

/* * POJO * */

/* * FUNCTION * */

}

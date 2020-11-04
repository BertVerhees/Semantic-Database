package nl.rosa.semanticdatabase.bmm.model_structure;

/**
 * 
 * Abstraction of a package as a tree structure whose nodes can contain other packages and classes.
 * The name may be qualified if it is a top-level package.
 * 
*/
public class BmmPackageImpl implements BmmPackageContainer{

    //***** BmmPackage *****

/* * FIELDS * */

/**
 * 
 * Classes listed as being in this package.
 * 
*/
    private List<BmmClass> classes;

        />
    
    //***** BmmPackageContainer *****

/* * FIELDS * */

/**
 * 
 * Child packages; keys all in upper case for guaranteed matching.
 * 
*/
    private Map<String,BmmPackage> packages;

        />
    
/**
 * 
 * Model element within which a referenceable element is known.
 * 
*/
    private BmmPackageContainer scope;

        />
    
    //***** BmmDeclaration *****

/* * FIELDS * */

/**
 * 
 * Name of this model element.
 * 
*/
    private String name;

        />
    
/**
 * 
 * Optional documentation of this element, as a keyed list.
 * It is strongly recommended to use the following key /type combinations for the relevant purposes: "purpose": String "keywords": List<String> "use": String "misuse": String "references": String Other keys and value types may be freely added.
 * 
*/
    private Map<String, Any> documentation;

        />
    
/**
 * 
 * Model element within which an element is declared.
 * 
*/
    private BmmDeclaration scope;

        />
    
/**
 * 
 * Optional meta-data of this element, as a keyed list.
 * May be used to extend the meta-model.
 * 
*/
    private Map<String, Any> extensions;

        />
    
/* * ATTRIBUTE * */

/* * POJO * */

/* * FUNCTION * */

}

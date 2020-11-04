package nl.rosa.semanticdatabase.base_types.identification_package;

/**
 * 
 * Purpose Reference to a LOCATABLE instance inside the top-level content structure inside a VERSION<T>; the path attribute is applied to the object that VERSION.data points to.
 * 
*/
public class LocatableRefImpl implements ObjectRef{

    //***** LocatableRef *****

/* * FIELDS * */

/**
 * 
 * The path to an instance in question, as an absolute path with respect to the object found at VERSION.data.
 * An empty path means that the object referred to by id being specified.
 * 
*/
    private String path;

        />
    
/**
 * 
 * Globally unique id of an object, regardless of where it is stored.
 * 
*/
    private UidBasedId id;

        />
    
    //***** ObjectRef *****

/* * FIELDS * */

/**
 * 
 * Namespace to which this identifier belongs in the local system context (and possibly in any other openEHR compliant environment) e.g.
 * terminology , demographic .
 * These names are not yet standardised.
 * Legal values for namespace are: "local" "unknown" a string matching the standard regex [a-zA-Z][a-zA-Z0-9_.:\/&?=+-]*.
 * Note that the first two are just special values of the regex, and will be matched by it.
 * 
*/
    private String namespace;

        />
    
/**
 * 
 * Name of the class (concrete or abstract) of object to which this identifier type refers, e.g.
 * PARTY, PERSON, GUIDELINE etc.
 * These class names are from the relevant reference model.
 * The type name ANY can be used to indicate that any type is accepted (e.g.
 * if the type is unknown).
 * 
*/
    private String type;

        />
    
/**
 * 
 * Globally unique id of an object, regardless of where it is stored.
 * 
*/
    private ObjectId id;

        />
    
/* * ATTRIBUTE * */

/* * POJO * */

/* * FUNCTION * */

}

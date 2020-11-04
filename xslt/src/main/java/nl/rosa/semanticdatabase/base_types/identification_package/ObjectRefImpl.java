package nl.rosa.semanticdatabase.base_types.identification_package;

/**
 * 
 * Class describing a reference to another object, which may exist locally or be maintained outside the current namespace, e.g.
 * in another service.
 * Services are usually external, e.g.
 * available in a LAN (including on the same host) or the internet via Corba, SOAP, or some other distributed protocol.
 * However, in small systems they may be part of the same executable as the data containing the Id.
 * 
*/
public class ObjectRefImpl implements {

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

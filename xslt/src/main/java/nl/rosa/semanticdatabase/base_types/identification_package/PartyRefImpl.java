package nl.rosa.semanticdatabase.base_types.identification_package;

/**
 * 
 * Identifier for parties in a demographic or identity service.
 * There are typically a number of subtypes of the PARTY class, including PERSON, ORGANISATION, etc.
 * Abstract supertypes are allowed if the referenced object is of a type not known by the current implementation of this class (in other words, if the demographic model is changed by the addition of a new PARTY or ACTOR subtypes, valid PARTY_REFs can still be constructed to them).
 * 
*/
public class PartyRefImpl implements ObjectRef{

    //***** PartyRef *****

/* * FIELDS * */

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

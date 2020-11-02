package nl.rosa.semanticdatabase.base_types.identification_package;

/**
 * 
 * Purpose Reference to a LOCATABLE instance inside the top-level content structure inside a VERSION<T>; the path attribute is applied to the object that VERSION.data points to.
 * 
*/
public interface LocatableRef extends ObjectRef {

/* * ATTRIBUTE * */

/**
 * 
 * The path to an instance in question, as an absolute path with respect to the object found at VERSION.data.
 * An empty path means that the object referred to by id being specified.
 * 
*/
    String getPath();
    void setPath(String value);

/**
 * 
 * Globally unique id of an object, regardless of where it is stored.
 * 
*/
    UidBasedId getId();
    void setId(UidBasedId value);

/* * FUNCTION * */

/**
 * 
 * A URI form of the reference, created by concatenating the following: scheme, e.g.
 * ehr:, derived from namespace id.value / + path, where path is non-empty
 * 
*/
    String  as_uri();

}

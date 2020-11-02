package nl.rosa.semanticdatabase.base_types.identification_package;

/**
 * 
 * Abstract model of UID-based identifiers consisting of a root part and an optional extension; lexical form: root '::' extension.
 * 
*/
public interface UidBasedId extends ObjectId {

/* * ATTRIBUTE * */

/* * FUNCTION * */

/**
 * 
 * The identifier of the conceptual namespace in which the object exists, within the identification scheme.
 * Returns the part to the left of the first '::' separator, if any, or else the whole string.
 * 
*/
    Uid  root();

/**
 * 
 * Optional local identifier of the object within the context of the root identifier.
 * Returns the part to the right of the first '::' separator if any, or else any empty String.
 * 
*/
    String  extension();

/**
 * 
 * True if not extension.is_empty().
 * 
*/
    Boolean  has_extension();

}

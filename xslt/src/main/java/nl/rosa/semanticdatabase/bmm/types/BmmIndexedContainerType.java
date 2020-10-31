package nl.rosa.semanticdatabase.bmm.types;

/**
 * 
 * Meta-type of linear container type that indexes the contained items in the manner of a standard Hash table, map or dictionary.
 * 
*/
public interface BmmIndexedContainerType extends BmmContainerType {

/* * ATTRIBUTE * */

/**
 * 
 * Type of the element index, typically String or Integer, but may be a numeric type or indeed any type from which a hash value can be derived.
 * 
*/
    BmmIndexedContainerType getIndexType();
    void setIndexType(BmmIndexedContainerType value);

/* * FUNCTION * */

/**
 * 
 * Return full type name, e.g.
 * HashMap<String, ELEMENT>.
 * 
*/
    BmmIndexedContainerType  type_name();

}

package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * Defines an array of optionally named items each of any type.
 * 
*/
public interface ElTuple extends ElInstanceRef {

/* * ATTRIBUTE * */

/**
 * 
 * Items in the tuple, potentially with names.
 * Typical use is to represent an argument list to routine call.
 * 
*/
List<elTupleItem> getItems();
void setItems(var List<elTupleItem>);

/**
 * 
 * Static type inferred from literal value.
 * 
*/
BmmTupleType getType();
void setType(var BmmTupleType);

/* * FUNCTION * */

/**
 * 
 * Return type.
 * eval_type (): BMM_TYPE
 * 
*/

}

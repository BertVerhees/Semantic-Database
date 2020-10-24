package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * Defines an array of optionally named items each of any type.
 * 
*/
public interface ElTuple extends ElInstanceRef {

/**
 * 
 * Items in the tuple, potentially with names.
 * Typical use is to represent an argument list to routine call.
 * 
*/
List<elTupleItem> getItems()
setItems(var List<elTupleItem>)

/**
 * 
 * Static type inferred from literal value.
 * 
*/
BmmTupleType getType()
setType(var BmmTupleType)

}

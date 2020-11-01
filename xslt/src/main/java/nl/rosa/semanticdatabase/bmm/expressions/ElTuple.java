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
     getItems();
    void setItems( value);

/**
 * 
 * Static type inferred from literal value.
 * 
*/
    BmmTupleType getType();
    void setType(BmmTupleType value);

/* * FUNCTION * */

/**
 * 
 * Return type.
 * 
*/
      eval_type();

}

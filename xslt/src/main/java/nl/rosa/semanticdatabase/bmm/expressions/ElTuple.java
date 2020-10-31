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
    ElTuple getItems();
    void setItems(ElTuple value);

/**
 * 
 * Static type inferred from literal value.
 * 
*/
    ElTuple getType();
    void setType(ElTuple value);

/* * FUNCTION * */

/**
 * 
 * Return type.
 * 
*/
    ElTuple  eval_type();

}

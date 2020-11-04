package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * Special meta-type used to represent a reference that may appear in any routine, pre- or post-condition, or invariant, and resolves to the current object within which feature references are scoped; corresponds to 'self', 'this' or 'Current' in various programming languages.
 * 
*/
public interface ElSelfRef extends ElInstanceRef {

/* * ATTRIBUTE * */

/**
 * 
 * Type of the current scoping instance, inferred from expression context.
 * 
*/
    BmmType getType();
    void setType(BmmType value);

/* * FUNCTION * */

/**
 * 
 * Return type.
 * 
*/
    BmmType  eval_type();

/* * CONSTANTS * */

}

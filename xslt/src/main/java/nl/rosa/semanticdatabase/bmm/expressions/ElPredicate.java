package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * Parent type of predicate of any object reference.
 * 
*/
public interface ElPredicate extends ElTerminal {

/* * ATTRIBUTE * */

/**
 * 
 * The target instance of this predicate.
 * 
*/
ElInstanceRef getOperand();
void setOperand(var ElInstanceRef);

/* * FUNCTION * */

/**
 * 
 * Return {BMM_MODEL}.boolean_type_definition().
 * eval_type (): BMM_SIMPLE_TYPE
 * 
*/

}

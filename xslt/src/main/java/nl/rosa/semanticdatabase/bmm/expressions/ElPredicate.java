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
    void setOperand(ElInstanceRef value);

/* * FUNCTION * */

/**
 * 
 * Return {BMM_MODEL}.boolean_type_definition().
 * 
*/
    BmmSimpleType  eval_type();

}

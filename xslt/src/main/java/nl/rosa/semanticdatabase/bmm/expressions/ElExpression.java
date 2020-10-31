package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * Abstract parent of all typed expression meta-types.
 * 
*/
public interface ElExpression {

/* * ATTRIBUTE * */

/* * FUNCTION * */

/**
 * 
 * Meta-type of expression entity used in type-checking and evaluation.
 * Effected in descendants.
 * 
*/
    ElExpression  eval_type();

/**
 * 
 * True if eval_type is notionally Boolean (i.e.
 * a BMM_SIMPLE_TYPE with type_name() = Boolean).
 * 
*/
    ElExpression  is_boolean();

}

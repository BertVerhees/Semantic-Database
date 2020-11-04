package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * Conditional structure used in condition chain expressions.
 * Evaluated by evaluating its condition, which is a Boolean-returning expression, and if this returns True, the result is the evaluation result of expression.
 * 
*/
public class ElConditionalExpressionImpl implements ElDecisionBranch{

    //***** ElConditionalExpression *****

/* * FIELDS * */

/**
 * 
 * Gate expression that acts as the condition under which the target expression is returned.
 * 
*/
    private ElSimple condition;

        />
    
    //***** ElDecisionBranch *****

/* * FIELDS * */

/**
 * 
 * Result expression of conditional, if its condition evaluates to True.
 * 
*/
    private ElExpression result;

        />
    
/* * ATTRIBUTE * */

/* * POJO * */

/* * FUNCTION * */

}

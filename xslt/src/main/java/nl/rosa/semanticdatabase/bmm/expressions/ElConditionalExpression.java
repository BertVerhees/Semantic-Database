package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * Conditional structure used in condition chain expressions.
 * Evaluated by evaluating its condition, which is a Boolean-returning expression, and if this returns True, the result is the evaluation result of expression.
 * 
*/
public interface ElConditionalExpression extends ElDecisionBranch {

/* * ATTRIBUTE * */

/**
 * 
 * Gate expression that acts as the condition under which the target expression is returned.
 * 
*/
ElSimple getCondition();
void setCondition(var ElSimple);

/* * FUNCTION * */

}

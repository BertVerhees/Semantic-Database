package nl.rosa.semanticdatabase.bmm.statements;

/**
 * 
 * Conditional, or 'gated' statement, consisting of a Boolean-returning condition and the target statement.
 * 
*/
public interface BmmConditionalAction {

/* * ATTRIBUTE * */

/**
 * 
 * The gate condition for the target statement.
 * 
*/
ElBooleanExpression getCondition();
void setCondition(var ElBooleanExpression);

/**
 * 
 * Target statement.
 * 
*/
BmmStatementItem getStatement();
void setStatement(var BmmStatementItem);

/* * FUNCTION * */

}

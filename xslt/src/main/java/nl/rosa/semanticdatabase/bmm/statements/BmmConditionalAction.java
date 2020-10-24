package nl.rosa.semanticdatabase.bmm.statements;

/**
 * 
 * Conditional, or 'gated' statement, consisting of a Boolean-returning condition and the target statement.
 * 
*/
public interface BmmConditionalAction {

/**
 * 
 * The gate condition for the target statement.
 * 
*/
ElBooleanExpression getCondition()
setCondition(var ElBooleanExpression)

/**
 * 
 * Target statement.
 * 
*/
BmmStatementItem getStatement()
setStatement(var BmmStatementItem)

}

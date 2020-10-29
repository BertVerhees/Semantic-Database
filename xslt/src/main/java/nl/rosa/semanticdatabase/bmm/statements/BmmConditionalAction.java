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
    BmmConditionalAction getCondition();
    void setCondition(value BmmConditionalAction);

/**
 * 
 * Target statement.
 * 
*/
    BmmConditionalAction getStatement();
    void setStatement(value BmmConditionalAction);

/* * FUNCTION * */

}

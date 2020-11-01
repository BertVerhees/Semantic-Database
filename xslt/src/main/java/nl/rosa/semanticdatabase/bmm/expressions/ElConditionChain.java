package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * Compound expression consisting of a chain of condition-gated expressions, and an ungated else member that as a whole, represents an if/then/elseif/else chains.
 * Evaluated by iterating through items and for each one, evaluating its condition, which if True, causes the evaluation result of the chain to be that item’s result evaluation result.
 * If no member of items has a True-returning condition, the evaluation result is the result of evaluating the else expression.
 * 
*/
public interface ElConditionChain extends ElDecisionTable {

/* * ATTRIBUTE * */

/**
 * 
 * Members of the chain, equivalent to branches in an if/then/else chain and cases in a case statement.
 * 
*/
     getItems();
    void setItems( value);

/* * FUNCTION * */

}

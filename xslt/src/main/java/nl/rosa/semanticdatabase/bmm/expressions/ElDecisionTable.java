package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * Complex expression structure representing a logical decision table.
 * 
*/
public interface ElDecisionTable extends ElExpression {

/* * ATTRIBUTE * */

/**
 * 
 * Result expression of the chain if no member of items succeeds in evaluation.
 * 
*/
     getElse();
    void setElse( value);

/**
 * 
 * Members of the chain, equivalent to branches in an if/then/else chain and cases in a case statement.
 * 
*/
     getItems();
    void setItems( value);

/* * FUNCTION * */

}

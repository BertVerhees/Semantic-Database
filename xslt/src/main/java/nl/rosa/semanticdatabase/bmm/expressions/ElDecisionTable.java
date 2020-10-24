package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * Complex expression structure representing a logical decision table.
 * 
*/
public interface ElDecisionTable extends ElExpression {

/**
 * 
 * Result expression of the chain if no member of items succeeds in evaluation.
 * 
*/
ElExpression getElse()
setElse(var ElExpression)

/**
 * 
 * Members of the chain, equivalent to branches in an if/then/else chain and cases in a case statement.
 * 
*/
List<elDecisionBranch> getItems()
setItems(var List<elDecisionBranch>)

}

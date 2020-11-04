package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * Complex expression structure representing a logical decision table.
 * 
*/
public class ElDecisionTableImpl implements ElExpression{

    //***** ElDecisionTable *****

/* * FIELDS * */

/**
 * 
 * Result expression of the chain if no member of items succeeds in evaluation.
 * 
*/
    private ElExpression else;

        />
    
/**
 * 
 * Members of the chain, equivalent to branches in an if/then/else chain and cases in a case statement.
 * 
*/
    private List<ElDecisionBranch> items;

        />
    
    //***** ElExpression *****

/* * FIELDS * */

/* * ATTRIBUTE * */

/* * POJO * */

/* * FUNCTION * */

}

package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * Compound expression consisting of a list of value-range / expression pairs, and an else member that as a whole, represents a case statement flavour of decision table.
 * Evaluated by iterating through items and for each one, comparing input to the item value_range.
 * If the input is in the range, the evaluation result of the table is that item’s result evaluation result.
 * If no member of items has a True-returning condition, the evaluation result is the result of evaluating the else expression.
 * 
*/
public class ElCaseTableImpl implements ElDecisionTable{

    //***** ElCaseTable *****

/* * FIELDS * */

/**
 * 
 * Input value that is compared against each items[i].value_range to determine the overall result.
 * 
*/
    private ElSimple input;

        />
    
/**
 * 
 * Members of the chain, equivalent to branches in an if/then/else chain and cases in a case statement.
 * 
*/
    private List<ElCase> items;

        />
    
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

package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * 
 * 
*/
public interface ElDecisionBranch {

/* * ATTRIBUTE * */

/**
 * 
 * Result expression of conditional, if its condition evaluates to True.
 * 
*/
    ElExpression getResult();
    void setResult(value ElExpression);

/* * FUNCTION * */

}

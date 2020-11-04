package nl.rosa.semanticdatabase.bmm.statements;

/**
 * 
 * Statement type representing an assignment from a value-generating source to a writable entity, i.e.
 * a variable reference or property.
 * 
*/
public interface BmmAssignment extends BmmStatement {

/* * ATTRIBUTE * */

/**
 * 
 * The target variable on the notional left-hand side of this assignment.
 * 
*/
    EL_INSTANTIABLE_REF getTarget();
    void setTarget(EL_INSTANTIABLE_REF value);

/**
 * 
 * Source right hand side) of the assignment.
 * 
*/
    ElExpression getSource();
    void setSource(ElExpression value);

/* * FUNCTION * */

/* * CONSTANTS * */

}

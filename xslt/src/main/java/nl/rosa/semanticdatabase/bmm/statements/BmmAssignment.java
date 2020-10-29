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
    BmmAssignment getTarget();
    void setTarget(value BmmAssignment);

/**
 * 
 * Source right hand side) of the assignment.
 * 
*/
    BmmAssignment getSource();
    void setSource(value BmmAssignment);

/* * FUNCTION * */

}

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
     getTarget();
    void setTarget( value);

/**
 * 
 * Source right hand side) of the assignment.
 * 
*/
     getSource();
    void setSource( value);

/* * FUNCTION * */

}

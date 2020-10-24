package nl.rosa.semanticdatabase.bmm.statements;

/**
 * 
 * Statement type representing an assignment from a value-generating source to a writable entity, i.e.
 * a variable reference or property.
 * 
*/
public interface BmmAssignment extends BmmStatement {

/**
 * 
 * The target variable on the notional left-hand side of this assignment.
 * 
*/
ElInstantiableRef getTarget()
setTarget(var ElInstantiableRef)

/**
 * 
 * Source right hand side) of the assignment.
 * 
*/
ElExpression getSource()
setSource(var ElExpression)

}

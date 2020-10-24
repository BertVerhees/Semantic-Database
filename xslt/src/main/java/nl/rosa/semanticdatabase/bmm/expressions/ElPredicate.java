package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * Parent type of predicate of any object reference.
 * 
*/
public interface ElPredicate extends ElTerminal {

/**
 * 
 * The target instance of this predicate.
 * 
*/
ElInstanceRef getOperand()
setOperand(var ElInstanceRef)

}

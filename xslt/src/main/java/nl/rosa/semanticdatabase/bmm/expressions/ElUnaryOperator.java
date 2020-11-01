package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * Unary operator expression node.
 * 
*/
public interface ElUnaryOperator extends ElOperator {

/* * ATTRIBUTE * */

/**
 * 
 * Operand node.
 * 
*/
     getOperand();
    void setOperand( value);

/* * FUNCTION * */

}

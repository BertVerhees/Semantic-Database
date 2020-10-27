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
    ElSimple getOperand();
    void setOperand(value ElSimple);

/* * FUNCTION * */

}

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
    ElUnaryOperator getOperand();
    void setOperand(ElUnaryOperator value);

/* * FUNCTION * */

}

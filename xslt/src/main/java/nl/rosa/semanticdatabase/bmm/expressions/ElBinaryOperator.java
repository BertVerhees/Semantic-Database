package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * Binary operator expression node.
 * 
*/
public interface ElBinaryOperator extends ElOperator {

/* * ATTRIBUTE * */

/**
 * 
 * Left operand node.
 * 
*/
    ElBinaryOperator getLeftOperand();
    void setLeftOperand(value ElBinaryOperator);

/**
 * 
 * Right operand node.
 * 
*/
    ElBinaryOperator getRightOperand();
    void setRightOperand(value ElBinaryOperator);

/* * FUNCTION * */

}

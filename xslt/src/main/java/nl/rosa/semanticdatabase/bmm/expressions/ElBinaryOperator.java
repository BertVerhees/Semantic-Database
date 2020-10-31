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
    void setLeftOperand(ElBinaryOperator value);

/**
 * 
 * Right operand node.
 * 
*/
    ElBinaryOperator getRightOperand();
    void setRightOperand(ElBinaryOperator value);

/* * FUNCTION * */

}

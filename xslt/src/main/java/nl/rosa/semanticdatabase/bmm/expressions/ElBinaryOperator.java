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
     getLeftOperand();
    void setLeftOperand( value);

/**
 * 
 * Right operand node.
 * 
*/
     getRightOperand();
    void setRightOperand( value);

/* * FUNCTION * */

}

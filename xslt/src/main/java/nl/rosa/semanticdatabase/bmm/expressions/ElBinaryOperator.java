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
ElSimple getLeftOperand();
void setLeftOperand(value ElSimple);

/**
 * 
 * Right operand node.
 * 
*/
ElTerminal getRightOperand();
void setRightOperand(value ElTerminal);

/* * FUNCTION * */

}

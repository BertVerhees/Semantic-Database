package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * Binary operator expression node.
 * 
*/
public interface ElBinaryOperator extends ElOperator {

/**
 * 
 * Left operand node.
 * 
*/
ElSimple getLeftOperand()
setLeftOperand(var ElSimple)

/**
 * 
 * Right operand node.
 * 
*/
ElTerminal getRightOperand()
setRightOperand(var ElTerminal)

}

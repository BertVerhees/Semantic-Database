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
    void setLeftOperand(ElSimple value);

/**
 * 
 * Right operand node.
 * 
*/
    ElTerminal getRightOperand();
    void setRightOperand(ElTerminal value);

/* * FUNCTION * */

/* * CONSTANTS * */

}

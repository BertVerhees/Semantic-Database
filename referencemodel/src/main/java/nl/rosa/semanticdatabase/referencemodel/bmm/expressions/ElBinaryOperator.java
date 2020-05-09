package nl.rosa.semanticdatabase.referencemodel.bmm.expressions;


/**
 * Class ElBinaryOperator
 * Binary operator expression node
 */
public class ElBinaryOperator extends ElOperator {

  //
  // Fields
  //

  /**
   * Left operand node.
   */
  private expressions.ElExpression leftOperand;
  /**
   * Right operand node.
   */
  private expressions.ElTerminal rightOperand;
  
  //
  // Constructors
  //
  public ElBinaryOperator () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of leftOperand
   * Left operand node.
   * @param newVar the new value of leftOperand
   */
  public void setLeftOperand (expressions.ElExpression newVar) {
    leftOperand = newVar;
  }

  /**
   * Get the value of leftOperand
   * Left operand node.
   * @return the value of leftOperand
   */
  public expressions.ElExpression getLeftOperand () {
    return leftOperand;
  }

  /**
   * Set the value of rightOperand
   * Right operand node.
   * @param newVar the new value of rightOperand
   */
  public void setRightOperand (expressions.ElTerminal newVar) {
    rightOperand = newVar;
  }

  /**
   * Get the value of rightOperand
   * Right operand node.
   * @return the value of rightOperand
   */
  public expressions.ElTerminal getRightOperand () {
    return rightOperand;
  }

  //
  // Other methods
  //

}

package nl.rosa.semanticdatabase.referencemodel.bmm.expressions;


/**
 * Class ElUnaryOperator
 * Unary operator expression node.
 */
public class ElUnaryOperator extends ElOperator {

  //
  // Fields
  //

  /**
   * Operand node.
   */
  private expressions.ElExpression operand;
  
  //
  // Constructors
  //
  public ElUnaryOperator () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of operand
   * Operand node.
   * @param newVar the new value of operand
   */
  public void setOperand (expressions.ElExpression newVar) {
    operand = newVar;
  }

  /**
   * Get the value of operand
   * Operand node.
   * @return the value of operand
   */
  public expressions.ElExpression getOperand () {
    return operand;
  }

  //
  // Other methods
  //

}

package expressions;


/**
 * Class ElConstraintExpression
 * Special kind of expression representing a constraint on values. Used with the
 * 'matches' operator. Does not follow the ordinary model of binary operator, since
 * the constraint is not itself a value-returning expression.
 */
public class ElConstraintExpression extends ElExpression {

  //
  // Fields
  //

  /**
   * Left operand of constraint expression.
   */
  private expressions.ElExpression leftOperand;
  /**
   * Right hand side of the constraint expression. Redefined in sub-nl.rosa.semanticdatabase.bmm.model.types.
   */
  private Object constraint;
  
  //
  // Constructors
  //
  public ElConstraintExpression () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of leftOperand
   * Left operand of constraint expression.
   * @param newVar the new value of leftOperand
   */
  public void setLeftOperand (expressions.ElExpression newVar) {
    leftOperand = newVar;
  }

  /**
   * Get the value of leftOperand
   * Left operand of constraint expression.
   * @return the value of leftOperand
   */
  public expressions.ElExpression getLeftOperand () {
    return leftOperand;
  }

  /**
   * Set the value of constraint
   * Right hand side of the constraint expression. Redefined in sub-nl.rosa.semanticdatabase.bmm.model.types.
   * @param newVar the new value of constraint
   */
  public void setConstraint (Object newVar) {
    constraint = newVar;
  }

  /**
   * Get the value of constraint
   * Right hand side of the constraint expression. Redefined in sub-nl.rosa.semanticdatabase.bmm.model.types.
   * @return the value of constraint
   */
  public Object getConstraint () {
    return constraint;
  }

  //
  // Other methods
  //

}

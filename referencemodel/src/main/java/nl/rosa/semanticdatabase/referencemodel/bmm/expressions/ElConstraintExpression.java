package nl.rosa.semanticdatabase.referencemodel.bmm.expressions;


import lombok.Data;
import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmType;

/**
 * Class ElConstraintExpression
 * Special kind of expression representing a constraint on values. Used with the
 * 'matches' operator. Does not follow the ordinary model of binary operator, since
 * the constraint is not itself a value-returning expression.
 */
@Data
public class ElConstraintExpression implements ElExpression {

  //
  // Fields
  //

  /**
   * Left operand of constraint expression.
   */
  private ElExpression leftOperand;
  /**
   * Right hand side of the constraint expression. Redefined in sub-types.
   */
  private Object constraint;
  
  //
  // Constructors
  //
  public ElConstraintExpression () { };
  
  //
  // Other methods
  //
  @Override
  public BmmType evalType() {
    return null;
  }

  @Override
  public boolean isBoolean() {
    return false;
  }


}

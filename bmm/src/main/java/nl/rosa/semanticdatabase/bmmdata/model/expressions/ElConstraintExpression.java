package nl.rosa.semanticdatabase.bmmdata.model.expressions;


import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;

/**
 * Class ElConstraintExpression
 * Special kind of expression representing a constraint on values. Used with the
 * 'matches' operator. Does not follow the ordinary model of binary operator, since
 * the constraint is not itself a value-returning expression.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ElConstraintExpression extends ElExpression {
  /**
   * Left operand of constraint expression.
   */
  private ElExpression leftOperand;
  /**
   * 1..1
   * constraint: Any
   * Right hand side of the constraint expression. Redefined in sub-types.
   *
   * Invariants
   * Inv_boolean_result: is_boolean()
   */
  private Object constraint;
  
  @Override
  public BmmType evalType() {
    return null;
  }
}

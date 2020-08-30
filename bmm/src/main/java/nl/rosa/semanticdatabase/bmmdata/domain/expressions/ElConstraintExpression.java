package nl.rosa.semanticdatabase.bmmdata.domain.expressions;


import lombok.*;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmType;

import javax.persistence.Entity;

/**
 * Class ElConstraintExpression
 * Special kind of expression representing a constraint on values. Used with the
 * 'matches' operator. Does not follow the ordinary model of binary operator, since
 * the constraint is not itself a value-returning expression.
 */
@Data
@Entity
public class ElConstraintExpression extends ElExpression {
  /**
   * 1..1
   * left_operand: EL_EXPRESSION
   * Left operand of constraint expression.
   */
  @NonNull
  @Getter
  @Setter
  private ElExpression leftOperand;
  /**
   * 1..1
   * constraint: Any
   * Right hand side of the constraint expression. Redefined in sub-types.
   *
   * Invariants
   * Inv_boolean_result: is_boolean()
   */
  @NonNull
  @Getter
  @Setter
  private Object constraint;
  
  @Override
  public BmmType evalType() {
    return null;
  }
}

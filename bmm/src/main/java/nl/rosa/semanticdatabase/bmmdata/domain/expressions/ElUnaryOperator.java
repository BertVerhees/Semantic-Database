package nl.rosa.semanticdatabase.bmmdata.domain.expressions;


import lombok.*;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmType;

import javax.persistence.Entity;

/**
 * Class ElUnaryOperator
 * Unary operator expression node.
 */
public class ElUnaryOperator extends ElOperator {
  /**
   * 1..1
   * operand: EL_EXPRESSION
   * Operand node.
   */
  @NonNull
  @Getter
  @Setter
  private ElExpression operand;
  @Override
  public BmmType evalType() {
    return null;
  }
}

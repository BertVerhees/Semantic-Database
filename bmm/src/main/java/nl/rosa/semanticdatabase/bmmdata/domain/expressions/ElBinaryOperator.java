package nl.rosa.semanticdatabase.bmmdata.domain.expressions;


import lombok.*;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmType;

import javax.persistence.Entity;

/**
 * Class ElBinaryOperator
 * Binary operator expression node
 */
public class ElBinaryOperator extends ElOperator  {
  /**
   * 1..1
   * operand: EL_EXPRESSION
   * Operand node.
   */
  @NonNull
  @Getter
  @Setter
  private ElExpression leftOperand;
  /**
   * 1..1
   * right_operand: EL_TERMINAL
   * Right operand node.
   */
  @NonNull
  @Getter
  @Setter
  private ElTerminal rightOperand;

  @Override
  public BmmType evalType() {
    return null;
  }
}

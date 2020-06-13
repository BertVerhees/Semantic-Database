package nl.rosa.semanticdatabase.bmmdata.domain.expressions;


import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmType;

import javax.persistence.Entity;

/**
 * Class ElBinaryOperator
 * Binary operator expression node
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class ElBinaryOperator extends ElOperator  {
  /**
   * Left operand node.
   */
  private ElExpression leftOperand;
  /**
   * Right operand node.
   */
  private ElTerminal rightOperand;

  @Override
  public BmmType evalType() {
    return null;
  }
}

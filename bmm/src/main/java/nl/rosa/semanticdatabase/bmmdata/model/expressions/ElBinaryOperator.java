package nl.rosa.semanticdatabase.bmmdata.model.expressions;


import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;

/**
 * Class ElBinaryOperator
 * Binary operator expression node
 */
@Data
@EqualsAndHashCode(callSuper = true)
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

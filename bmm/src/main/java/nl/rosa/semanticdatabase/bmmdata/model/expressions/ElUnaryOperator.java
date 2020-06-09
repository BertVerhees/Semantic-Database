package nl.rosa.semanticdatabase.bmmdata.model.expressions;


import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;

/**
 * Class ElUnaryOperator
 * Unary operator expression node.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ElUnaryOperator extends ElOperator {
  /**
   * Operand node.
   */
  private ElExpression operand;
  @Override
  public BmmType evalType() {
    return null;
  }
}

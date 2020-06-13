package nl.rosa.semanticdatabase.bmmdata.domain.expressions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.domain.literal_values.BmmLiteralValue;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmType;

import javax.persistence.Entity;


/**
 * Class ElLiteral
 * Literal value of any type known in the model, including primitive nl.rosa.semanticdatabase.bmm.model.types. Defined
 * via a BMM_LITERAL_VALUE.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class ElLiteral extends ElInstanceRef {
  /**
   * 1..1
   * value: BMM_LITERAL_VALUE
   * The reference item from which the value of this node can be computed.
   */
  private BmmLiteralValue value;

  /**
   * 1..1
   * (effected)
   * eval_type (): BMM_TYPE
   * Return value.type.
   * @return
   */
  @Override
  public BmmType evalType() {
    return null;
  }
}

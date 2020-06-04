package nl.rosa.semanticdatabase.bmmdata.model.expressions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;
import nl.rosa.semanticdatabase.bmmdata.model.literal_values.BmmLiteralValue;

import javax.validation.constraints.NotNull;


/**
 * Class ElLiteral
 * Literal value of any type known in the model, including primitive nl.rosa.semanticdatabase.bmm.model.types. Defined
 * via a BMM_LITERAL_VALUE.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ElLiteral extends BmmBaseEntity implements ElInstanceRef {
/**
 *    ElInstanceRef
 *      ElTerminal
 *        ElExpression
 *  ElAgentCall
 */
  /**
   * ElInstanceRef
   */
  /**
   * ElExpression
   */
  @NotNull
  public BmmType evalType(){
    return null;
  }
  @NotNull
  public Boolean isBoolean(){
    return null;
  }
  /**
   * ElTerminal
   */
  /**
   * ElAgentCall
   */
  @NotNull
  private ElAgent agent;
//======================================================================================
  /**
   * The reference item from which the value of this node can be computed.
   */
  private BmmLiteralValue value;
  /**
   * Set the value of value
   * The reference item from which the value of this node can be computed.
   * @param newVar the new value of value
   */
  public void setValue (BmmLiteralValue newVar) {
    value = newVar;
  }

  /**
   * Get the value of value
   * The reference item from which the value of this node can be computed.
   * @return the value of value
   */
  public BmmLiteralValue getValue () {
    return value;
  }
}

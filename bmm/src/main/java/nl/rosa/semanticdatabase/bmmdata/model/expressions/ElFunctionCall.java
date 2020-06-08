package nl.rosa.semanticdatabase.bmmdata.model.expressions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;


/**
 * Class ElFunctionCall
 * A call made on a closed function agent, returning a result. Equivalent to an
 * 'application' of a function in Lambda calculus.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ElFunctionCall extends ElScopedRef implements ElAgentCall {
  /**
   * ElAgentCall
   */
  @NonNull
  private ElAgent agent;
//======================================================================================

  /**
   * 1..1
   * (effected)
   * eval_type (): BMM_TYPE
   * Return agent.definition.type.
   * @return
   */
  public BmmType evalType(){
    return null;
  }
}

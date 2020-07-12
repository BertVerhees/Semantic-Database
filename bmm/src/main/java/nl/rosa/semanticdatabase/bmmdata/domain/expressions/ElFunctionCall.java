package nl.rosa.semanticdatabase.bmmdata.domain.expressions;

import lombok.*;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmType;

import javax.persistence.Entity;


/**
 * Class ElFunctionCall
 * A call made on a closed function agent, returning a result. Equivalent to an
 * 'application' of a function in Lambda calculus.
 */
public class ElFunctionCall extends ElScopedRef implements ElAgentCall {
  /**
   * ElAgentCall
   */
  @NonNull
  @Getter
  @Setter
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

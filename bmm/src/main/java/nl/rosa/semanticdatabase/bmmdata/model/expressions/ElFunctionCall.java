package nl.rosa.semanticdatabase.bmmdata.model.expressions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;

import javax.validation.constraints.NotNull;


/**
 * Class ElFunctionCall
 * A call made on a closed function agent, returning a result. Equivalent to an
 * 'application' of a function in Lambda calculus.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ElFunctionCall extends BmmBaseEntity implements ElScopedRef, ElAgentCall {
/**
 *  ElScopedRef
 *    ElInstanceRef
 *      ElTerminal
 *        ElExpression
 *  ElAgentCall
 */
/**
 * ElInstanceRef
 */
  /**
   * ElScopedRef
   */
  private ElInstanceRef scope;
  /**
   * ElTerminal
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
   * ElAgentCall
   */
  @NotNull
  private ElAgent agent;
//======================================================================================
}

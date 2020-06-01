package nl.rosa.semanticdatabase.bmmdata.model.expressions;

import lombok.Data;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;

import javax.validation.constraints.NotNull;


/**
 * Class ElFunctionCall
 * A call made on a closed function agent, returning a result. Equivalent to an
 * 'application' of a function in Lambda calculus.
 */
@Data
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


  // ElScopedRef
  /**
   * Reference to an owning object for this terminal element, if it is not the current scope.
   */
  private ElInstanceRef scope;


  /**
   * The function agent being called.
   */
  private ElFunctionAgent agent;
  
  //
  // Constructors
  //
  public ElFunctionCall () { };
  //
  // Other methods
  //

  /**
   * Return agent.definition.type.
   * @return       nl.rosa.semanticdatabase.bmm.model.types.BmmType
   */
  public BmmType evalType()
  {
    //TODO
    return null;
  }

  @Override
  public Boolean isBoolean() {
    //TODO
    return false;
  }


  @Override
  @Deprecated
  public void setAgent(ElAgent newVar) {
    this.agent = (ElFunctionAgent) newVar;
  }
}

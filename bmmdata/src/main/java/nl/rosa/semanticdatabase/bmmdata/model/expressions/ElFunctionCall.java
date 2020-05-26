package nl.rosa.semanticdatabase.bmmdata.model.expressions;

import lombok.Data;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;


/**
 * Class ElFunctionCall
 * A call made on a closed function agent, returning a result. Equivalent to an
 * 'application' of a function in Lambda calculus.
 */
@Data
public class ElFunctionCall implements ElScopedRef, ElAgentCall {

  //
  // Fields
  //

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
  public boolean isBoolean() {
    //TODO
    return false;
  }


  @Override
  @Deprecated
  public void setAgent(ElAgent newVar) {
    this.agent = (ElFunctionAgent) newVar;
  }
}

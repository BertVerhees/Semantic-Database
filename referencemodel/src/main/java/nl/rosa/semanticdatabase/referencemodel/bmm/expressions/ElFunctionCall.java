package nl.rosa.semanticdatabase.referencemodel.bmm.expressions;

import lombok.Data;
import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmType;


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

  // ElAgentCall
  /**
   * The agent being called.
   */
  private ElAgent agent;


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
   * @return       types.BmmType
   */
  public BmmType evalType()
  {
  }


}

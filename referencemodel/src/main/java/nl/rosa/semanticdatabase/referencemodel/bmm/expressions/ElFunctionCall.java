package nl.rosa.semanticdatabase.referencemodel.bmm.expressions;
import types.BmmType;


/**
 * Class ElFunctionCall
 * A call made on a closed function agent, returning a result. Equivalent to an
 * 'application' of a function in Lambda calculus.
 */
public class ElFunctionCall extends ElScopedRef, ElAgentCall {

  //
  // Fields
  //

  /**
   * The function agent being called.
   */
  private expressions.ElFunctionAgent agent;
  
  //
  // Constructors
  //
  public ElFunctionCall () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of agent
   * The function agent being called.
   * @param newVar the new value of agent
   */
  public void setAgent (expressions.ElFunctionAgent newVar) {
    agent = newVar;
  }

  /**
   * Get the value of agent
   * The function agent being called.
   * @return the value of agent
   */
  public expressions.ElFunctionAgent getAgent () {
    return agent;
  }

  //
  // Other methods
  //

  /**
   * Return agent.definition.type.
   * @return       types.BmmType
   */
  public types.BmmType evalType()
  {
  }


}

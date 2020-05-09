package nl.rosa.semanticdatabase.referencemodel.bmm.expressions;


/**
 * Class ElAgentCall
 * A call made to a 'closed' agent, i.e. one with no remaining open arguments
 */
abstract public class ElAgentCall {

  //
  // Fields
  //

  /**
   * The agent being called.
   */
  private expressions.ElAgent agent;
  
  //
  // Constructors
  //
  public ElAgentCall () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of agent
   * The agent being called.
   * @param newVar the new value of agent
   */
  public void setAgent (expressions.ElAgent newVar) {
    agent = newVar;
  }

  /**
   * Get the value of agent
   * The agent being called.
   * @return the value of agent
   */
  public expressions.ElAgent getAgent () {
    return agent;
  }

  //
  // Other methods
  //

}

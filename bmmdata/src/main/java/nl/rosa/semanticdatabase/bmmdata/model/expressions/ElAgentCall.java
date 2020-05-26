package nl.rosa.semanticdatabase.bmmdata.model.expressions;


/**
 * Class ElAgentCall
 * A call made to a 'closed' agent, i.e. one with no remaining open arguments
 */
public interface ElAgentCall {

  /**
   * Set the value of agent
   * The agent being called.
   * @param newVar the new value of agent
   */
  void setAgent (ElAgent newVar);

  /**
   * Get the value of agent
   * The agent being called.
   * @return the value of agent
   */
  ElAgent getAgent ();
}

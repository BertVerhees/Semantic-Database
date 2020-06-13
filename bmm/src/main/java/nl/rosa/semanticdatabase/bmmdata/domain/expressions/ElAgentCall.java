package nl.rosa.semanticdatabase.bmmdata.domain.expressions;


/**
 * Class ElAgentCall
 * A call made to a 'closed' agent, i.e. one with no remaining open arguments
 */
public interface ElAgentCall {
  /**
   * 1..1
   * agent: EL_AGENT
   * The agent being called.
   * @param newVar the new value of agent
   */
  void setAgent (ElAgent newVar);
  ElAgent getAgent ();
}

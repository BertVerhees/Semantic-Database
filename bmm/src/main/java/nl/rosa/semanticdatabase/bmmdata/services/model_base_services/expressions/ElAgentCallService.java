package nl.rosa.semanticdatabase.bmmdata.services.model_base_services.expressions;


/**
 * Base-model structure of interfaces to deliver over inheritance the functions
 * to the service-classes which are implemented in the Service-structures
 * Interface ElAgentCallService
 * A call made to a 'closed' agent, i.e. one with no remaining open arguments
 */
public interface ElAgentCallService {

  /**
   * 1..1
   * agent: EL_AGENT
   * The agent being called.
   * @param newVar the new value of agent
   */
  void setAgent (ElAgentService newVar);
  ElAgentService getAgent ();
}

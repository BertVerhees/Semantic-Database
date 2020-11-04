package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * A call made to a 'closed' agent, i.e.
 * one with no remaining open arguments.
 * 
*/
public interface ElAgentCall {

/* * ATTRIBUTE * */

/**
 * 
 * The agent being called.
 * 
*/
    ElAgent getAgent();
    void setAgent(ElAgent value);

/* * FUNCTION * */

/* * CONSTANTS * */

}

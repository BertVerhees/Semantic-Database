package nl.rosa.semanticdatabase.bmm.statements;

/**
 * 
 * A call made on a closed procedure agent.
 * 
*/
public interface BmmProcedureCall extends ElAgentCall,BmmStatement {

/* * ATTRIBUTE * */

/**
 * 
 * The procedure agent being called.
 * 
*/
    ElProcedureAgent getAgent();
    void setAgent(ElProcedureAgent value);

/* * FUNCTION * */

}

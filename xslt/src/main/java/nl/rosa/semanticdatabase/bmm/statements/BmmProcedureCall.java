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
    BmmProcedureCall getAgent();
    void setAgent(BmmProcedureCall value);

/* * FUNCTION * */

}

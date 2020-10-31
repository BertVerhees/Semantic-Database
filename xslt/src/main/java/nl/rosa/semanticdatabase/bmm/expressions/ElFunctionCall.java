package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * A call made on a closed function agent, returning a result.
 * Equivalent to an 'application' of a function in Lambda calculus.
 * 
*/
public interface ElFunctionCall extends ElScopedRef,ElAgentCall {

/* * ATTRIBUTE * */

/**
 * 
 * The function agent being called.
 * 
*/
    ElFunctionCall getAgent();
    void setAgent(ElFunctionCall value);

/* * FUNCTION * */

/**
 * 
 * Return agent.definition.type.
 * 
*/
    ElFunctionCall  eval_type();

}

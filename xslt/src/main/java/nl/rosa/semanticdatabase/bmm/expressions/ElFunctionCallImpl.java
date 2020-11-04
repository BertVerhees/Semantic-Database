package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * A call made on a closed function agent, returning a result.
 * Equivalent to an 'application' of a function in Lambda calculus.
 * 
*/
public class ElFunctionCallImpl implements ElScopedRef,ElAgentCall{

    //***** ElFunctionCall *****

/* * FIELDS * */

/**
 * 
 * The function agent being called.
 * 
*/
    private ElFunctionAgent agent;

        />
    
    //***** ElScopedRef *****

/* * FIELDS * */

/**
 * 
 * Reference to an owning object for this terminal element, if it is not the current scope.
 * 
*/
    private ElInstanceRef scope;

        />
    
    //***** ElInstanceRef *****

/* * FIELDS * */

    //***** ElTerminal *****

/* * FIELDS * */

    //***** ElSimple *****

/* * FIELDS * */

    //***** ElExpression *****

/* * FIELDS * */

    //***** ElAgentCall *****

/* * FIELDS * */

/**
 * 
 * The agent being called.
 * 
*/
    private ElAgent agent;

        />
    
/* * ATTRIBUTE * */

/* * POJO * */

/* * FUNCTION * */

}

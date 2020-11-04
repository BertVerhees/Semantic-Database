package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * An agent whose signature is of a function, i.e.
 * has a result type.
 * 
*/
public class ElFunctionAgentImpl implements ElAgent{

    //***** ElFunctionAgent *****

/* * FIELDS * */

/**
 * 
 * Reference to definition of a routine for which this is a direct call instance, if one exists.
 * 
*/
    private BmmFunction definition;

        />
    
    //***** ElAgent *****

/* * FIELDS * */

/**
 * 
 * Name of the routine being called.
 * 
*/
    private String name;

        />
    
/**
 * 
 * Closed arguments of a routine call as a tuple of objects.
 * 
*/
    private ElTuple closed_args;

        />
    
/**
 * 
 * Optional list of names of open arguments of the call.
 * If not provided, and the name refers to a routine with more arguments than supplied in closed_args, the missing arguments are inferred from the definition.
 * 
*/
    private List<String> open_args;

        />
    
/**
 * 
 * Reference to definition of a routine for which this is an agent, if one exists.
 * 
*/
    private BmmRoutine definition;

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

/* * ATTRIBUTE * */

/* * POJO * */

/* * FUNCTION * */

}

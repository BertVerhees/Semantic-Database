package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * A delayed routine call, whose arguments may be open, partially closed or closed.
 * Instances may include closed delayed calls like calculate_age (dob="1987-09-13", today="2019-06-03") but also partially open calls such as format_structure (struct=?, style=3), where struct is an open argument.
 * Evaluation type (i.e.
 * type of runtime evaluated form) is BMM_SIGNATURE.
 * 
*/
public class ElAgentImpl implements ElScopedRef{

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

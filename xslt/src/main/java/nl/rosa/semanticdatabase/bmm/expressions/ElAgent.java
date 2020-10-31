package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * A delayed routine call, whose arguments may be open, partially closed or closed.
 * Instances may include closed delayed calls like calculate_age (dob="1987-09-13", today="2019-06-03") but also partially open calls such as format_structure (struct=?, style=3), where struct is an open argument.
 * Evaluation type (i.e.
 * type of runtime evaluated form) is BMM_SIGNATURE.
 * 
*/
public interface ElAgent extends ElScopedRef {

/* * ATTRIBUTE * */

/**
 * 
 * Name of the routine being called.
 * 
*/
    ElAgent getName();
    void setName(ElAgent value);

/**
 * 
 * Closed arguments of a routine call as a tuple of objects.
 * 
*/
    ElAgent getClosedArgs();
    void setClosedArgs(ElAgent value);

/**
 * 
 * Optional list of names of open arguments of the call.
 * If not provided, and the name refers to a routine with more arguments than supplied in closed_args, the missing arguments are inferred from the definition.
 * 
*/
    ElAgent getOpenArgs();
    void setOpenArgs(ElAgent value);

/**
 * 
 * Reference to definition of a routine for which this is an agent, if one exists.
 * 
*/
    ElAgent getDefinition();
    void setDefinition(ElAgent value);

/* * FUNCTION * */

/**
 * 
 * Eval type is the signature corresponding to the (remaining) open arguments and return type, if any.
 * 
*/
    ElAgent  eval_type();

/**
 * 
 * True if there are no open arguments.
 * 
*/
    ElAgent  is_callable();

}

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
    String getName();
    void setName(value String);

/**
 * 
 * Closed arguments of a routine call as a tuple of objects.
 * 
*/
    ElTuple getClosedArgs();
    void setClosedArgs(value ElTuple);

/**
 * 
 * Optional list of names of open arguments of the call.
 * If not provided, and the name refers to a routine with more arguments than supplied in closed_args, the missing arguments are inferred from the definition.
 * 
*/
    List<string> getOpenArgs();
    void setOpenArgs(value List<string>);

/**
 * 
 * Reference to definition of a routine for which this is an agent, if one exists.
 * 
*/
    BmmRoutine getDefinition();
    void setDefinition(value BmmRoutine);

/* * FUNCTION * */

/**
 * 
 * Eval type is the signature corresponding to the (remaining) open arguments and return type, if any.
 * eval_type (): BMM_SIGNATURE Post_result: Result = definition.signature
 * 
*/
    BmmSignature postResult: result = definition.signature evalType ();

/**
 * 
 * True if there are no open arguments.
 * is_callable (): Boolean Post_result_validity: Result = open_arguments = Void
 * 
*/
    Boolean postResultValidity: result = openArguments = void isCallable ();

}

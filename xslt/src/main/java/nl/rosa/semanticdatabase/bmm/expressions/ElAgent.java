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

/**
 * 
 * Name of the routine being called.
 * 
*/
String getName()
setName(var String)

/**
 * 
 * Closed arguments of a routine call as a tuple of objects.
 * 
*/
ElTuple getClosedArgs()
setClosedArgs(var ElTuple)

/**
 * 
 * Optional list of names of open arguments of the call.
 * If not provided, and the name refers to a routine with more arguments than supplied in closed_args, the missing arguments are inferred from the definition.
 * 
*/
List<string> getOpenArgs()
setOpenArgs(var List<string>)

/**
 * 
 * Reference to definition of a routine for which this is an agent, if one exists.
 * 
*/
BmmRoutine getDefinition()
setDefinition(var BmmRoutine)

}

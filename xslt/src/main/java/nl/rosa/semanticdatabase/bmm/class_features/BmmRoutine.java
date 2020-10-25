package nl.rosa.semanticdatabase.bmm.class_features;

/**
 * 
 * A feature defining a routine, scoped to a class.
 * 
*/
public interface BmmRoutine extends BmmClassFeature {

/* * ATTRIBUTE * */

/**
 * 
 * Formal parameters of the routine.
 * 
*/
List<bmmParameter> getParameters();
void setParameters(var List<bmmParameter>);

/**
 * 
 * Local variables of the routine.
 * 
*/
List<bmmLocal> getLocals();
void setLocals(var List<bmmLocal>);

/**
 * 
 * 
 * 
*/
List<bmmAssertion> getPreConditions();
void setPreConditions(var List<bmmAssertion>);

/**
 * 
 * 
 * 
*/
List<bmmAssertion> getPostConditions();
void setPostConditions(var List<bmmAssertion>);

/**
 * 
 * Body of a routine, i.e.
 * executable program.
 * 
*/
BmmRoutineBody getBody();
void setBody(var BmmRoutineBody);

/* * FUNCTION * */

/**
 * 
 * Return number of arguments of this routine.
 * arity (): Integer
 * 
*/

/**
 * 
 * Formal signature of this element, in the form '[arg1_name: T_arg1, …​]:T_value'.
 * signature ()
 * 
*/

}

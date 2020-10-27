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
    void setParameters(value List<bmmParameter>);

/**
 * 
 * Local variables of the routine.
 * 
*/
    List<bmmLocal> getLocals();
    void setLocals(value List<bmmLocal>);

/**
 * 
 * 
 * 
*/
    List<bmmAssertion> getPreConditions();
    void setPreConditions(value List<bmmAssertion>);

/**
 * 
 * 
 * 
*/
    List<bmmAssertion> getPostConditions();
    void setPostConditions(value List<bmmAssertion>);

/**
 * 
 * Body of a routine, i.e.
 * executable program.
 * 
*/
    BmmRoutineBody getBody();
    void setBody(value BmmRoutineBody);

/* * FUNCTION * */

/**
 * 
 * Return number of arguments of this routine.
 * arity (): Integer
 * 
*/
    Integer arity ();

/**
 * 
 * Formal signature of this element, in the form '[arg1_name: T_arg1, …​]:T_value'.
 * signature ()
 * 
*/
    void signature ();

}

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
    List<BmmParameter> getParameters();
    void setParameters(List<BmmParameter> value);

/**
 * 
 * Local variables of the routine.
 * 
*/
    List<BmmLocal> getLocals();
    void setLocals(List<BmmLocal> value);

/**
 * 
 * 
 * 
*/
    List<BmmAssertion> getPreConditions();
    void setPreConditions(List<BmmAssertion> value);

/**
 * 
 * 
 * 
*/
    List<BmmAssertion> getPostConditions();
    void setPostConditions(List<BmmAssertion> value);

/**
 * 
 * Body of a routine, i.e.
 * executable program.
 * 
*/
    BmmRoutineBody getBody();
    void setBody(BmmRoutineBody value);

/* * FUNCTION * */

/**
 * 
 * Return number of arguments of this routine.
 * 
*/
    Integer  arity();

/**
 * 
 * Formal signature of this element, in the form '[arg1_name: T_arg1, …​]:T_value'.
 * 
*/
    void  signature();

/* * CONSTANTS * */

}

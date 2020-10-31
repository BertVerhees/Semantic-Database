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
    BmmRoutine getParameters();
    void setParameters(BmmRoutine value);

/**
 * 
 * Local variables of the routine.
 * 
*/
    BmmRoutine getLocals();
    void setLocals(BmmRoutine value);

/**
 * 
 * 
 * 
*/
    BmmRoutine getPreConditions();
    void setPreConditions(BmmRoutine value);

/**
 * 
 * 
 * 
*/
    BmmRoutine getPostConditions();
    void setPostConditions(BmmRoutine value);

/**
 * 
 * Body of a routine, i.e.
 * executable program.
 * 
*/
    BmmRoutine getBody();
    void setBody(BmmRoutine value);

/* * FUNCTION * */

/**
 * 
 * Return number of arguments of this routine.
 * 
*/
    BmmRoutine  arity();

/**
 * 
 * Formal signature of this element, in the form '[arg1_name: T_arg1, …​]:T_value'.
 * 
*/
    BmmRoutine  signature();

}

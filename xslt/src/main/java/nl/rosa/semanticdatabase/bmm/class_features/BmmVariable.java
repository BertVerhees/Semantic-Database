package nl.rosa.semanticdatabase.bmm.class_features;

/**
 * 
 * A mutable entity whose scope is a routine.
 * 
*/
public interface BmmVariable extends BmmInstantiable,BmmClassEntity {

/* * ATTRIBUTE * */

/**
 * 
 * Routine within which variable is defined.
 * 
*/
    BmmRoutine getScope();
    void setScope(BmmRoutine value);

/* * FUNCTION * */

/**
 * 
 * Formal signature of this element, in the form 'name [arg1_name: T_arg1, …​][:T_value]'.
 * 
*/
    void  signature();

}

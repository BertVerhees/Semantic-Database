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
     getParameters();
    void setParameters( value);

/**
 * 
 * Local variables of the routine.
 * 
*/
     getLocals();
    void setLocals( value);

/**
 * 
 * 
 * 
*/
     getPreConditions();
    void setPreConditions( value);

/**
 * 
 * 
 * 
*/
     getPostConditions();
    void setPostConditions( value);

/**
 * 
 * Body of a routine, i.e.
 * executable program.
 * 
*/
     getBody();
    void setBody( value);

/* * FUNCTION * */

/**
 * 
 * Return number of arguments of this routine.
 * 
*/
      arity();

/**
 * 
 * Formal signature of this element, in the form '[arg1_name: T_arg1, …​]:T_value'.
 * 
*/
      signature();

}

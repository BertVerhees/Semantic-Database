package nl.rosa.semanticdatabase.bmm.class_features;

/**
 * 
 * A mutable entity whose scope is a routine.
 * 
*/
public interface BmmVariable extends BmmInstantiable,BmmClassEntity {

/**
 * 
 * Routine within which variable is defined.
 * 
*/
BmmRoutine getScope()
setScope(var BmmRoutine)

}

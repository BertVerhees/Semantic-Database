package nl.rosa.semanticdatabase.bmmdata.model.class_features;


/**
 * Class BmmVariable
 * A mutable entity whose scope is a routine.
 */
public interface BmmVariable extends BmmInstantiable, BmmClassEntity {


  /**
   * 1..1
   * (redefined)
   * scope: BMM_ROUTINE
   * Routine within which variable is defined.
   */
  void setScope (BmmRoutine newVar);
  BmmRoutine getScope ();

}

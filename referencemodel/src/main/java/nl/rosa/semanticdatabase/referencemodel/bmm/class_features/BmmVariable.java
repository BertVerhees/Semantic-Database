package nl.rosa.semanticdatabase.referencemodel.bmm.class_features;


/**
 * Class BmmVariable
 * A mutable entity whose scope is a routine.
 */
public interface BmmVariable extends BmmInstantiableClass, BmmClassEntity {


  /**
   * Set the value of scope
   * Routine within which variable is defined.
   * @param newVar the new value of scope
   */
  void setScope (BmmRoutine newVar);

  /**
   * Get the value of scope
   * Routine within which variable is defined.
   * @return the value of scope
   */
  BmmRoutine getScope ();


  /**
   * Formal signature of this element, in the form 'name [arg1_name: T_arg1,
   * �?][:T_value]'.
   */
  public void signature();
}

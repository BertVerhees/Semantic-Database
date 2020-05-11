package class_features;


/**
 * Class BmmVariable
 * A mutable entity whose scope is a routine.
 */
abstract public class BmmVariable extends BmmInstantiableClass, BmmClassEntity {

  //
  // Fields
  //

  /**
   * Routine within which variable is defined.
   */
  private class_features.BmmRoutine scope;
  
  //
  // Constructors
  //
  public BmmVariable () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of scope
   * Routine within which variable is defined.
   * @param newVar the new value of scope
   */
  public void setScope (class_features.BmmRoutine newVar) {
    scope = newVar;
  }

  /**
   * Get the value of scope
   * Routine within which variable is defined.
   * @return the value of scope
   */
  public class_features.BmmRoutine getScope () {
    return scope;
  }

  //
  // Other methods
  //

  /**
   * Formal signature of this element, in the form 'name [arg1_name: T_arg1,
   * …?][:T_value]'.
   */
  public void signature()
  {
  }


}

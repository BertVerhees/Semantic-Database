package class_features;


/**
 * Class BmmFunction
 * A formal element with signature of the form: name ({arg:TArg}*):TResult. A
 * function is a computed (rather than data) element, generally assumed to be
 * non-state-changing.
 */
public class BmmFunction extends BmmRoutine, BmmTypedFeature {

  //
  // Fields
  //

  /**
   * Optional details enabling a function to be represented as an operator in a syntactic representation.
   */
  private class_features.BmmOperator operatorDefinition;
  /**
   * Automatically created Result variable, usable in body and post-condition.
   */
  private class_features.BmmResult result;
  
  //
  // Constructors
  //
  public BmmFunction () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of operatorDefinition
   * Optional details enabling a function to be represented as an operator in a
   * syntactic representation.
   * @param newVar the new value of operatorDefinition
   */
  public void setOperatorDefinition (class_features.BmmOperator newVar) {
    operatorDefinition = newVar;
  }

  /**
   * Get the value of operatorDefinition
   * Optional details enabling a function to be represented as an operator in a
   * syntactic representation.
   * @return the value of operatorDefinition
   */
  public class_features.BmmOperator getOperatorDefinition () {
    return operatorDefinition;
  }

  /**
   * Set the value of result
   * Automatically created Result variable, usable in body and post-condition.
   * @param newVar the new value of result
   */
  public void setResult (class_features.BmmResult newVar) {
    result = newVar;
  }

  /**
   * Get the value of result
   * Automatically created Result variable, usable in body and post-condition.
   * @return the value of result
   */
  public class_features.BmmResult getResult () {
    return result;
  }

  //
  // Other methods
  //

}

package nl.rosa.semanticdatabase.referencemodel.bmm.expressions;
import class_features.BmmFunction;


/**
 * Class ElFunctionAgent
 * An agent whose signature is of a function, i.e. has a result type.
 */
public class ElFunctionAgent extends ElAgent {

  //
  // Fields
  //

  private class_features.BmmFunction definition;
  
  //
  // Constructors
  //
  public ElFunctionAgent () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of definition
   * @param newVar the new value of definition
   */
  public void setDefinition (class_features.BmmFunction newVar) {
    definition = newVar;
  }

  /**
   * Get the value of definition
   * @return the value of definition
   */
  public class_features.BmmFunction getDefinition () {
    return definition;
  }

  //
  // Other methods
  //

}

package nl.rosa.semanticdatabase.referencemodel.bmm.expressions;
import class_features.BmmProcedure;


/**
 * Class ElProcedureAgent
 * An agent whose signature is of a procedure, i.e. has no result type.
 */
public class ElProcedureAgent extends ElAgent {

  //
  // Fields
  //

  /**
   * Reference to definition of routine for which this is a call instance.
   */
  private class_features.BmmProcedure definition;
  
  //
  // Constructors
  //
  public ElProcedureAgent () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of definition
   * Reference to definition of routine for which this is a call instance.
   * @param newVar the new value of definition
   */
  public void setDefinition (class_features.BmmProcedure newVar) {
    definition = newVar;
  }

  /**
   * Get the value of definition
   * Reference to definition of routine for which this is a call instance.
   * @return the value of definition
   */
  public class_features.BmmProcedure getDefinition () {
    return definition;
  }

  //
  // Other methods
  //

}

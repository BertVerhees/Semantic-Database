package nl.rosa.semanticdatabase.referencemodel.bmm.expressions;

import lombok.Data;
import nl.rosa.semanticdatabase.referencemodel.bmm.class_features.BmmFunction;
import nl.rosa.semanticdatabase.referencemodel.bmm.class_features.BmmRoutine;

import java.util.List;


/**
 * Class ElFunctionAgent
 * An agent whose signature is of a function, i.e. has a result type.
 */
@Data
public class ElFunctionAgent implements ElAgent {

  //
  // Fields
  //

  // ElAgent
  /**
   * Name of the routine being called.
   */
  private String name;
  /**
   * Closed arguments of a routine call as a tuple of objects.
   */
  private ElTuple closedArgs;
  /**
   * Optional list of names of open arguments of the call. If not provided, and the name refers to a routine with more arguments than supplied in closed_args, the missing arguments are inferred from the definition.
   */
  private List<String> openArgs;
  /**
   * Reference to definition of a routine for which this is an agent, if one exists.
   */
  private BmmFunction definition;
  
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

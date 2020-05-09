package nl.rosa.semanticdatabase.referencemodel.bmm.expressions;
import class_features.BmmRoutine;


/**
 * Class ElAgent
 * A delayed routine call, whose arguments may be open, partially closed or closed.
 * Instances may include closed delayed calls like calculate_age (dob="1987-09-13",
 * today="2019-06-03") but also partially open calls such as format_structure
 * (struct=?, style=3), where struct is an open argument.
 * Evaluation type (i.e. type of runtime evaluated form) is BMM_SIGNATURE.
 */
abstract public class ElAgent extends ElScopedRef {

  //
  // Fields
  //

  /**
   * Name of the routine being called.
   */
  private String name;
  /**
   * Closed arguments of a routine call as a tuple of objects.
   */
  private expressions.ElTuple closedArgs;
  /**
   * Optional list of names of open arguments of the call. If not provided, and the name refers to a routine with more arguments than supplied in closed_args, the missing arguments are inferred from the definition.
   */
  private List<String> openArgs;
  /**
   * Reference to definition of a routine for which this is an agent, if one exists.
   */
  private class_features.BmmRoutine definition;
  
  //
  // Constructors
  //
  public ElAgent () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of name
   * Name of the routine being called.
   * @param newVar the new value of name
   */
  public void setName (String newVar) {
    name = newVar;
  }

  /**
   * Get the value of name
   * Name of the routine being called.
   * @return the value of name
   */
  public String getName () {
    return name;
  }

  /**
   * Set the value of closedArgs
   * Closed arguments of a routine call as a tuple of objects.
   * @param newVar the new value of closedArgs
   */
  public void setClosedArgs (expressions.ElTuple newVar) {
    closedArgs = newVar;
  }

  /**
   * Get the value of closedArgs
   * Closed arguments of a routine call as a tuple of objects.
   * @return the value of closedArgs
   */
  public expressions.ElTuple getClosedArgs () {
    return closedArgs;
  }

  /**
   * Set the value of openArgs
   * Optional list of names of open arguments of the call. If not provided, and the
   * name refers to a routine with more arguments than supplied in closed_args, the
   * missing arguments are inferred from the definition.
   * @param newVar the new value of openArgs
   */
  public void setOpenArgs (List<String> newVar) {
    openArgs = newVar;
  }

  /**
   * Get the value of openArgs
   * Optional list of names of open arguments of the call. If not provided, and the
   * name refers to a routine with more arguments than supplied in closed_args, the
   * missing arguments are inferred from the definition.
   * @return the value of openArgs
   */
  public List<String> getOpenArgs () {
    return openArgs;
  }

  /**
   * Set the value of definition
   * Reference to definition of a routine for which this is an agent, if one exists.
   * @param newVar the new value of definition
   */
  public void setDefinition (class_features.BmmRoutine newVar) {
    definition = newVar;
  }

  /**
   * Get the value of definition
   * Reference to definition of a routine for which this is an agent, if one exists.
   * @return the value of definition
   */
  public class_features.BmmRoutine getDefinition () {
    return definition;
  }

  //
  // Other methods
  //

  /**
   * Eval type is the signature corresponding to the (remaining) open arguments and
   * return type, if any.
   * Post_result: Result = definition.signature
   */
  public void evalType()
  {
  }


  /**
   * True if there are no open arguments.
   * Post_result_validity: Result = open_arguments = Void
   * @return       boolean
   */
  public boolean isCallable()
  {
  }


}

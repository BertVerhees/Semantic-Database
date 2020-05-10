package nl.rosa.semanticdatabase.referencemodel.bmm.expressions;

import nl.rosa.semanticdatabase.referencemodel.bmm.class_features.BmmRoutine;
import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmSignature;

import java.util.List;


/**
 * Class ElAgent
 * A delayed routine call, whose arguments may be open, partially closed or closed.
 * Instances may include closed delayed calls like calculate_age (dob="1987-09-13",
 * today="2019-06-03") but also partially open calls such as format_structure
 * (struct=?, style=3), where struct is an open argument.
 * Evaluation type (i.e. type of runtime evaluated form) is BMM_SIGNATURE.
 */
public interface ElAgent extends ElScopedRef {


  /**
   * Set the value of name
   * Name of the routine being called.
   * @param newVar the new value of name
   */
  void setName (String newVar);

  /**
   * Get the value of name
   * Name of the routine being called.
   * @return the value of name
   */
  String getName ();

  /**
   * Set the value of closedArgs
   * Closed arguments of a routine call as a tuple of objects.
   * @param newVar the new value of closedArgs
   */
  void setClosedArgs (ElTuple newVar);

  /**
   * Get the value of closedArgs
   * Closed arguments of a routine call as a tuple of objects.
   * @return the value of closedArgs
   */
  ElTuple getClosedArgs ();

  /**
   * Set the value of openArgs
   * Optional list of names of open arguments of the call. If not provided, and the
   * name refers to a routine with more arguments than supplied in closed_args, the
   * missing arguments are inferred from the definition.
   * @param newVar the new value of openArgs
   */
  void setOpenArgs (List<String> newVar);

  /**
   * Get the value of openArgs
   * Optional list of names of open arguments of the call. If not provided, and the
   * name refers to a routine with more arguments than supplied in closed_args, the
   * missing arguments are inferred from the definition.
   * @return the value of openArgs
   */
  List<String> getOpenArgs ();

  /**
   * Set the value of definition
   * Reference to definition of a routine for which this is an agent, if one exists.
   * @param newVar the new value of definition
   */
  void setDefinition (BmmRoutine newVar);

  /**
   * Get the value of definition
   * Reference to definition of a routine for which this is an agent, if one exists.
   * @return the value of definition
   */
  BmmRoutine getDefinition ();

  //
  // Other methods
  //

  /**
   * Eval type is the signature corresponding to the (remaining) open arguments and
   * return type, if any.
   * Post_result: Result = definition.signature
   */
  BmmSignature evalType();
  /**
   * True if there are no open arguments.
   * Post_result_validity: Result = open_arguments = Void
   * @return       boolean
   */
  boolean isCallable();
}

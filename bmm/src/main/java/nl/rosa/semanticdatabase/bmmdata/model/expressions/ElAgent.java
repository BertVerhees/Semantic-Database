package nl.rosa.semanticdatabase.bmmdata.model.expressions;

import nl.rosa.semanticdatabase.bmmdata.model.class_features.BmmRoutine;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmSignature;

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
   * 1..1
   * name: String
   * Name of the routine being called.
   */
  void setName (String newVar);
  String getName ();

  /**
   * 0..1
   * closed_args: EL_TUPLE
   * Closed arguments of a routine call as a tuple of objects.
   */
  void setClosedArgs (ElTuple newVar);
  ElTuple getClosedArgs ();

  /**
   * 0..1
   * open_args: List<String>
   * Set the value of openArgs
   * Optional list of names of open arguments of the call. If not provided, and the
   * name refers to a routine with more arguments than supplied in closed_args, the
   * missing arguments are inferred from the definition.
   * @param newVar the new value of openArgs
   */
  void setOpenArgs (List<String> newVar);
  List<String> getOpenArgs ();

  /**
   * 0..1
   * definition: BMM_ROUTINE
   * Reference to definition of a routine for which this is an agent, if one exists.
   * @param newVar the new value of definition
   */
  void setDefinition (BmmRoutine newVar);
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
   * @return       Boolean
   */
  Boolean isCallable();
}

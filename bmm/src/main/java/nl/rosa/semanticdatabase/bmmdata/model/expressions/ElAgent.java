package nl.rosa.semanticdatabase.bmmdata.model.expressions;

import lombok.Data;
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
@Data
public abstract class ElAgent extends ElScopedRef {
  /**
   * 1..1
   * name: String
   * Name of the routine being called.
   */
  private String name;

  /**
   * 0..1
   * closed_args: EL_TUPLE
   * Closed arguments of a routine call as a tuple of objects.
   */
  private ElTuple closedArgs;

  /**
   * 0..1
   * open_args: List<String>
   * Set the value of openArgs
   * Optional list of names of open arguments of the call. If not provided, and the
   * name refers to a routine with more arguments than supplied in closed_args, the
   * missing arguments are inferred from the definition.
   * @param newVar the new value of openArgs
   */
  private List<String> openArgs;

  /**
   * 0..1
   * definition: BMM_ROUTINE
   * Reference to definition of a routine for which this is an agent, if one exists.
   * @param newVar the new value of definition
   */
  private BmmRoutine definition;
  // Functions
  /**
   * Eval type is the signature corresponding to the (remaining) open arguments and
   * return type, if any.
   * Post_result: Result = definition.signature
   */
  public BmmSignature evalType(){
    return null;
  }
  /**
   * True if there are no open arguments.
   * Post_result_validity: Result = open_arguments = Void
   * @return       Boolean
   */
  public Boolean isCallable(){
    return null;
  }
}

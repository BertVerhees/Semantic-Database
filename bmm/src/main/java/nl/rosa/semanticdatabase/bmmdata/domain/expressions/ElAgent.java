package nl.rosa.semanticdatabase.bmmdata.domain.expressions;

import lombok.*;
import nl.rosa.semanticdatabase.bmmdata.domain.class_features.BmmRoutine;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmSignature;

import java.util.*;


/**
 * Class ElAgent
 * A delayed routine call, whose arguments may be open, partially closed or closed.
 * Instances may include closed delayed calls like calculate_age (dob="1987-09-13",
 * today="2019-06-03") but also partially open calls such as format_structure
 * (struct=?, style=3), where struct is an open argument.
 * Evaluation type (i.e. type of runtime evaluated form) is BMM_SIGNATURE.
 */
public abstract class ElAgent extends ElScopedRef {
  /**
   * 1..1
   * name: String
   * Name of the routine being called.
   */
  @NonNull
  @Getter
  @Setter
  private String name;

  /**
   * 0..1
   * closed_args: EL_TUPLE
   * Closed arguments of a routine call as a tuple of objects.
   */
  @Getter
  @Setter
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
  private Set<String> openArgs;
  public void addOpenArg(@NonNull String value){
    if(openArgs==null){
      openArgs = new HashSet<>();
    }
    openArgs.add(value);
  }
  public void addOpenArgs(Set<String> openArgs){
    openArgs.forEach(openArg -> addOpenArg(openArg));

  }
  public void removeOpenArg(String openArg){
    if(openArgs!=null) {
      openArgs.remove(openArg);
    }
  }
  public void removeOpenArgs(Collection<String> openArgs){
    openArgs.forEach(this::removeOpenArg);
  }
  public void removeOpenArgs(Set<String> openArgs) {
    this.openArgs.removeAll(openArgs);
  }
  void setOpenArgs(Set<String> openArgs) {
    this.openArgs = openArgs;
  }
  Set<String> getOpenArgs() {
    return openArgs;
  }
  public Set<String> openArgs() {
    return Collections.unmodifiableSet(openArgs);
  }


  /**
   * 0..1
   * definition: BMM_ROUTINE
   * Reference to definition of a routine for which this is an agent, if one exists.
   * @param newVar the new value of definition
   */
  @Getter
  @Setter
  private BmmRoutine definition;
  // Functions
  /**
   * 1..1
   * (effected)
   * eval_type (): BMM_SIGNATURE
   * Post_result: Result = definition.signature
   * Eval type is the signature corresponding to the (remaining) open arguments and
   * return type, if any.
   */
  @NonNull
  public BmmSignature evalType(){
    return null;
  }
  /**
   * True if there are no open arguments.
   * Post_result_validity: Result = open_arguments = Void
   * @return       Boolean
   */
  @NonNull
  public Boolean isCallable(){
    return null;
  }
}

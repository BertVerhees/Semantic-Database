package nl.rosa.semanticdatabase.bmmdata.model.expressions;

import lombok.Data;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.class_features.BmmFunction;
import nl.rosa.semanticdatabase.bmmdata.model.class_features.BmmRoutine;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmSignature;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;

import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * Class ElFunctionAgent
 * An agent whose signature is of a function, i.e. has a result type.
 */
@Data
public class ElFunctionAgent extends BmmBaseEntity implements ElAgent {
/**
 * ElAgent
 *  ElScopedRef
 *    ElInstanceRef
 *      ElTerminal
 *        ElExpression
 */
  /**
   * ElAgent
   */
  @NotNull
  private String name;
  private ElTuple closedArgs;
  private List<String> openArgs;
  private BmmRoutine definition;
  // Functions
  @NotNull
  public BmmSignature evalType(){
    return null;
  }
  @NotNull
  public Boolean isCallable(){
    return null;
  }
  /**
   * ElScopedRef
   */
  private ElInstanceRef scope;
/**
 * ElInstanceRef
 */
  /**
   * ElExpression
   */
  @NotNull
  public BmmType evalType(){
    return null;
  }
  @NotNull
  public Boolean isBoolean(){
    return null;
  }
  /**
   * ElScopedRef
   */
  private ElInstanceRef scope;
  /**
   * ElTerminal
   */
  /**
   * ElExpression
   */
  @NotNull
  public BmmType evalType(){
    return null;
  }
  @NotNull
  public Boolean isBoolean(){
    return null;
  }
//========================================================================



  // ElScopedRef
  /**
   * Reference to an owning object for this terminal element, if it is not the current scope.
   */
  private ElInstanceRef scope;


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

  @Override
  @Deprecated
  public void setDefinition(BmmRoutine newVar) {
    this.definition = (BmmFunction) newVar;
  }

  @Override
  public BmmSignature evalType() {
    //TODO
    return null;
  }

  @Override
  public Boolean isBoolean() {
    //TODO
    return false;
  }

  @Override
  public Boolean isCallable() {
    //TODO
    return false;
  }
}

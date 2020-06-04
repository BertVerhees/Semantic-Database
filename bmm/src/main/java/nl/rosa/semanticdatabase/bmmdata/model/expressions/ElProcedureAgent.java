package nl.rosa.semanticdatabase.bmmdata.model.expressions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.class_features.BmmProcedure;
import nl.rosa.semanticdatabase.bmmdata.model.class_features.BmmRoutine;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmSignature;

import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * Class ElProcedureAgent
 * An agent whose signature is of a procedure, i.e. has no result type.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ElProcedureAgent extends BmmBaseEntity implements ElAgent {
/**
 * ElAgent
 *  ElScopedRef
 *    ElInstanceRef
 *      ElTerminal
 *        ElExpression
 */
  /**
   * ElInstanceRef
   */
  /**
   * ElExpression
   */
  @NotNull
  public BmmSignature evalType(){
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
//======================================================================================

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
   * Reference to definition of routine for which this is a call instance.
   */
  private BmmProcedure definition;
  
  @Override
  @Deprecated
  public void setDefinition(BmmRoutine newVar) {
    this.definition = (BmmProcedure) newVar;
  }

  @Override
  public Boolean isCallable() {
    //TODO
    return false;
  }
}

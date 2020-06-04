package nl.rosa.semanticdatabase.bmmdata.model.expressions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.class_features.BmmFunction;
import nl.rosa.semanticdatabase.bmmdata.model.class_features.BmmRoutine;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmSignature;

import javax.validation.constraints.NotNull;
import java.util.List;


/**
 * Class ElFunctionAgent
 * An agent whose signature is of a function, i.e. has a result type.
 */
@Data
@EqualsAndHashCode(callSuper = true)
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
  public Boolean isBoolean(){
    return null;
  }
  /**
   * ElTerminal
   */
  /**
   * ElExpression
   */
  @NotNull
  //========================================================================
@Override
  @Deprecated
  public void setDefinition(BmmRoutine newVar) {
    this.definition = (BmmFunction) newVar;
  }

  public ElFunctionAgent() {
    super();
  }
}



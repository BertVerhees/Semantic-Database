package nl.rosa.semanticdatabase.bmmdata.model.class_features;


import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmClass;
import nl.rosa.semanticdatabase.bmmdata.model.expressions.ElAssertion;
import nl.rosa.semanticdatabase.bmmdata.model.routine_implementation.BmmStatementItem;
import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmDeclaration;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmSignature;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * Class BmmProcedure
 * A formal element with signature of the form: name ({arg:TArg}*). A procedure is
 * a computed (rather than data) element, generally assumed to be state-changing.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BmmProcedure extends BmmBaseEntity implements BmmRoutine {
  /**
   * BmmRoutine
   *  BmmClassScoped
   *    BmmClassEntity
   *      BmmDeclaration
   */
  /**
   * BmmRoutine
   */
  private List<BmmParameter> parameters;
  private List<BmmLocal> locals;
  private List<ElAssertion> preConditions;
  private List<ElAssertion> postConditions;
  private BmmStatementItem body;
  // functions
  public Integer arity(){
    return null;
  }
  /**
   * BmmClassScoped
   */
  private Object visibility;
  @NotNull private BmmClass scope;
  /**
   * BmmClassEntity
   */
  private Boolean isSynthesisedGeneric;
  // function
  @NotNull
  public BmmSignature signature(){
    return null;
  }
  /**
   * BmmDeclaration
   */
  @NotNull
  private String name;
  private Map<String, Object> documentation;
  private Map<String, Object> extensions;
  // Functions;
  @Override
  public Boolean isRootScope(){
    return scope.equals(this);
  }
  //=============================================

  @Override
  @Deprecated
  public void setScope(BmmDeclaration newVar) {
    this.scope = (BmmClass) newVar;
  }

  @Override
  public void setScope(BmmClass newVar) {
    this.scope = newVar;
  }

}

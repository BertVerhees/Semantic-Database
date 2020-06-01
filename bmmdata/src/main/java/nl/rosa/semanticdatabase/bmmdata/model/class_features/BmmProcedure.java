package nl.rosa.semanticdatabase.bmmdata.model.class_features;


import lombok.Data;
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
public class BmmProcedure extends BmmBaseEntity implements BmmRoutine {
  /**
   * BmmRoutine
   *  BmmClassScoped
   *    BmmClassEntity
   *      BmmDeclaration
   */

  /**
   * BmmDeclaration
   */
  @NotNull
  private String name;
  private Map<String, Object> documentation;
  private Map<String, Object> extensions;

  @Override
  public Boolean isRootScope(){
    return scope.equals(this);
  }
  /**
   * BmmClassEntity
   */
  private Boolean isSynthesisedGeneric;
  /**
   * BmmClassScoped
   */
  private Object visibility;
  @NotNull private BmmClass scope;
  /**
   * BmmRoutine
   */
  private List<BmmParameter> parameters;
  private List<BmmLocal> locals;
  private List<ElAssertion> preConditions;
  private List<ElAssertion> postCondtions;
  private BmmStatementItem body;


  //
  // Constructors
  //
  public BmmProcedure () { };

  /**
   * Return number of arguments of this routine.
   * @return
   */
  @Override
  public Integer arity() {
    //TODO
    return null;
  }

  /**
   * Formal signature of this element, in the form
   *
   * '[arg1_name: T_arg1, …​]:T_value'.
   * @return
   */
  @Override
  public BmmSignature signature() {
    //TODO
    return null;
  }

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

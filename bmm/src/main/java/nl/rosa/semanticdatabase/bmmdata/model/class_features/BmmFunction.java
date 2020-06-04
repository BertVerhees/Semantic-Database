package nl.rosa.semanticdatabase.bmmdata.model.class_features;


import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmClass;
import nl.rosa.semanticdatabase.bmmdata.model.expressions.ElAssertion;
import nl.rosa.semanticdatabase.bmmdata.model.routine_implementation.BmmStatementItem;
import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmDeclaration;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmEffectiveType;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmSignature;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmUnitaryType;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * Class BmmFunction
 * A formal element with signature of the form: name ({arg:TArg}*):TResult. A
 * function is a computed (rather than data) element, generally assumed to be
 * non-state-changing.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BmmFunction extends BmmBaseEntity implements BmmRoutine, BmmTypedFeature {

  /**
   * BmmRoutine
   *  BmmClassScoped
   *    BmmClassEntity
   *      BmmDeclaration
   * BmmTypedFeature
   *   BmmTyped
   *     BmmType
   */
  /**
   * BmmType
   */
  // Functions
  @NotNull
  public String typeName(){
    return null;
  }
  @NotNull
  public List<String> flattenedTypeList(){
    return null;
  }
  @NotNull
  public String typeSignature(){
    return null;
  }
  @NotNull
  public BmmUnitaryType unitaryType(){
    return null;
  }
  @NotNull
  public BmmEffectiveType effectiveType(){
    return null;
  }
  // Functions
  @NotNull
  public Boolean isAbstract(){
    return null;
  }
  @NotNull
  public Boolean isPrimitive(){
    return null;
  }
  /**
   * BmmTyped
   */
  @NotNull
  private BmmType type;
  // functions
  @NotNull
  public Boolean isBoolean(){
    return null;
  }
  /**
   * BmmTypedFeature
   */
  private Boolean isNullable;
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
  private BmmClass scope;
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
  public Boolean isRootScope(){
    return scope.equals(this);
  }
  //=============================================
  /**
   * Optional details enabling a function to be represented as an operator in a syntactic representation.
   */
  private BmmOperator operatorDefinition;
  /**
   * Automatically created Result variable, usable in body and post-condition.
   */
  private BmmResult result;

  @Override
  public void setScope(BmmClass newVar) {
    this.scope = newVar;
  }

  @Override
  @Deprecated
  public void setScope(BmmDeclaration newVar) {
    this.scope = (BmmClass) newVar;
  }


}

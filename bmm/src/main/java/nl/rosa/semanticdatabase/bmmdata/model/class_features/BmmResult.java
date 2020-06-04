package nl.rosa.semanticdatabase.bmmdata.model.class_features;


import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmDeclaration;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmEffectiveType;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmSignature;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmUnitaryType;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * Class BmmResult
 * Automatically declared variable representing result instance of a Function call.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BmmResult extends BmmBaseEntity implements BmmVariable {
  /**
   * BmmVariable
   *  BmmInstantiable
   *    BmmTypedFeature
   *      BmmTyped
   *        BmmType
   *  BmmClassEntity
   *    BmmDeclaration
   */
  /**
   * BmmVariable
   */
  private BmmRoutine scope;
  @Override
  public void setScope(BmmRoutine newVar) {
    scope = newVar;
  }
  /**
   * BmmDeclaration
   */
  @NotNull
  private String name;
  private Map<String, Object> documentation;
  private Map<String, Object> extensions;

  @Override
  @Deprecated
  public void setScope(BmmDeclaration newVar) {
    this.scope = (BmmRoutine) newVar;
  }

  // Functions;
  public Boolean isRootScope(){
    return null;
  }
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
  @Override
  public Boolean isAbstract() {
    //TODO
    return false;
  }

  @Override
  public Boolean isPrimitive() {
    //TODO
    return false;
  }
  /**
   * BmmTypedFeature
   */
  private Boolean isNullable;
  /**
   * BmmInstantiable
   */
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
//================================================================

}

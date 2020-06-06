package nl.rosa.semanticdatabase.bmmdata.model.class_features;


import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmDeclaration;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmEffectiveType;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmSignature;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmUnitaryType;

import lombok.NonNull;
import java.util.List;
import java.util.Map;

/**
 * Class BmmLocal
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BmmLocal extends BmmBaseEntity implements BmmVariable {
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
  /**
   * BmmDeclaration
   */
  @NonNull
  private String name;
  private Map<String, Object> documentation;
  private Map<String, Object> extensions;
  @NonNull
  public Boolean isRootScope(){
    return scope.equals(this);
  }

  /**
   * BmmClassEntity
   */
  private Boolean isSynthesisedGeneric;
  // function
  @NonNull
  public BmmSignature signature(){
    return null;
  }
  /**
   * BmmType
   */
  // Functions
  @NonNull
  public String typeName(){
    return null;
  }
  @NonNull
  public List<String> flattenedTypeList(){
    return null;
  }
  @NonNull
  public String typeSignature(){
    return null;
  }
  @NonNull
  public BmmUnitaryType unitaryType(){
    return null;
  }
  @NonNull
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
  @NonNull
  private BmmType type;
  // functions
  @NonNull
  public Boolean isBoolean(){
    return null;
  }
//================================================================
  @Override
  @Deprecated
  public void setScope(BmmDeclaration newVar) {
    this.scope = (BmmRoutine) newVar;
  }


  @Override
  public void setScope(BmmRoutine newVar) {
    this.scope = newVar;
  }
}

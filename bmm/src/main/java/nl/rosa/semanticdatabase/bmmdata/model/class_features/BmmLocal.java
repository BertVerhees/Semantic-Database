package nl.rosa.semanticdatabase.bmmdata.model.class_features;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmDeclaration;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;

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
  // BmmVariable
  private BmmRoutine scope;
  // BmmDeclaration
  @NonNull
  private String name;
  private Map<String, Object> documentation;
  private Map<String, Object> extensions;
  // BmmClassEntity
  private Boolean isSynthesisedGeneric;
  // BmmType
  // BmmTypedFeature
  private Boolean isNullable;
  // BmmInstantiable
  // BmmTyped
  @NonNull
  private BmmType type;
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

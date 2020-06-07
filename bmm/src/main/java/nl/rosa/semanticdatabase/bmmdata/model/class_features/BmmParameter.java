package nl.rosa.semanticdatabase.bmmdata.model.class_features;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmDeclaration;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;

import java.util.Map;

/**
 * Class BmmParameter
 * A routine parameter variable.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BmmParameter extends BmmBaseEntity implements BmmVariable {
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
  /**
   * Optional read/write direction of the parameter. If none-supplied, the parameter is treated as in, i.e. readable.
   */
  private BmmParameterDirection direction;

  @Override
  public void setScope(BmmRoutine newVar) {
    this.scope = newVar;
  }
  @Override
  @Deprecated
  public void setScope(BmmDeclaration newVar) {
    this.scope = (BmmRoutine) newVar;
  }

}

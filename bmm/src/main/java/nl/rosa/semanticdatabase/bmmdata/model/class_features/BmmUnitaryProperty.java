package nl.rosa.semanticdatabase.bmmdata.model.class_features;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmClass;
import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmDeclaration;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmUnitaryType;

import java.util.Map;


/**
 * Class BmmUnitaryProperty
 * Meta-type of for properties of unitary type.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BmmUnitaryProperty extends BmmBaseEntity implements BmmProperty {
  /**
   * BmmProperty
   *  BmmInstantiable
   *    BmmTypedFeature
   *      BmmTyped
   *        BmmType
   *  BmmClassScoped
   *    BmmClassEntity
   *      BmmDeclaration
   */
  // BmmClassScoped
  private Object visibility;
  @NonNull
  private BmmClass scope;
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
  // BmmProperty
  private Boolean isImRuntime;
  private Boolean isImInfrastructure;
  private Boolean isComposition;
  // BmmInstantiable
  // BmmTyped
//================================================================
  /**
   * Declared or inferred static type of the entity.
   */
  @NonNull
  private BmmUnitaryType type;

  @Override
  public void setType(BmmType newVar) {
    this.type = (BmmUnitaryType) newVar;
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

package nl.rosa.semanticdatabase.bmmdata.model.class_features;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmClass;
import nl.rosa.semanticdatabase.bmmdata.model.literal_values.BmmLiteralValue;
import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmDeclaration;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;

import java.util.Map;


/**
 * Class BmmConstant
 * An immutable, static value-returning element scoped to a class.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BmmConstant extends BmmBaseEntity implements BmmClassScoped, BmmInstantiable {
  /**
   * BmmClassScoped
   *  BmmClassEntity
   *    BmmDeclaration
   * BmmInstantiable
   *  BmmTypedFeature
   *    BmmTyped
   *      BmmType
   */
  // BmmProperty
  private Boolean isImRuntime;
  private Boolean isImInfrastructure;
  private Boolean isComposition;
  // BmmClassScoped
  private Object visibility;
  private BmmClass scope;
  // BmmDeclaration
  @NonNull
  private String name;
  private Map<String, Object> documentation;
  @NonNull
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
   * The value of the constant.
   */
  private BmmLiteralValue value;
  
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

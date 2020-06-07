package nl.rosa.semanticdatabase.bmmdata.model.class_features;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import nl.rosa.semanticdatabase.base.MultiplicityInterval;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmClass;
import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmDeclaration;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;

import java.util.Map;


/**
 * Class BmmContainerProperty
 * Meta-type of for properties of linear container type, such as List<T> etc.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BmmContainerProperty extends BmmBaseEntity implements BmmProperty {
  /**
   * BmmProperty
   *  BmmClassScoped
   *    BmmClassEntity
   *      BmmDeclaration
   *  BmmInstantiable
   *    BmmTypedFeature
   *      BmmTyped
   *        BmmType
   */
  // BmmProperty
  private Boolean isImRuntime;
  private Boolean isImInfrastructure;
  private Boolean isComposition;
  // BmmClassScoped
  private Object visibility;
  // BmmVariable
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
  // BmmInstantiable
  // BmmTyped
  @NonNull
  private BmmType type;
//================================================================
  /**
   * Cardinality of this container.
   */
  private MultiplicityInterval cardinality;

  @Override
  public void setScope(BmmClass newVar) {
    this.scope =  newVar;
  }

  @Override
  @Deprecated
  public void setScope(BmmDeclaration newVar) {
    this.scope = (BmmClass) newVar;
  }
}

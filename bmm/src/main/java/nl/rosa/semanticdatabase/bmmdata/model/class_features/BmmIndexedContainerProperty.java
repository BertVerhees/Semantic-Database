package nl.rosa.semanticdatabase.bmmdata.model.class_features;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmClass;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmIndexedContainerType;

import java.util.Map;


/**
 * Class BmmIndexedContainerProperty
 * Meta-type of for properties of linear container type, such as Hash<Index_type,
 * T> etc.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BmmIndexedContainerProperty extends BmmContainerProperty {
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
  private BmmClass scope;
  // BmmVariable
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
//================================================================
  /**
   * Declared or inferred static type of the entity.
   */
  @NonNull
  private BmmIndexedContainerType type;
}

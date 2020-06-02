package nl.rosa.semanticdatabase.bmmdata.model.class_features;

import lombok.Data;
import nl.rosa.semanticdatabase.base.MultiplicityInterval;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmClass;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmEffectiveType;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmIndexedContainerType;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmSignature;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmUnitaryType;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;


/**
 * Class BmmIndexedContainerProperty
 * Meta-type of for properties of linear container type, such as Hash<Index_type,
 * T> etc.
 */
@Data
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
  /**
   * BmmProperty
   */
  private Boolean isImRuntime;
  private Boolean isImInfrastructure;
  private Boolean isComposition;
  // functions
  @NotNull
  public MultiplicityInterval existence(){
    return null;
  }
  @NotNull
  public String displayName(){
    return null;
  }
  /**
   * BmmClassScoped
   */
  private Object visibility;
  private BmmClass scope;
  /**
   * BmmVariable
   */
  /**
   * BmmDeclaration
   */
  @NotNull
  private String name;
  private Map<String, Object> documentation;
  private Map<String, Object> extensions;
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
  // functions
  @NotNull
  public Boolean isBoolean(){
    return null;
  }
//================================================================

  /**
   * Declared or inferred static type of the entity.
   */
  @NotNull
  private BmmIndexedContainerType type;
}

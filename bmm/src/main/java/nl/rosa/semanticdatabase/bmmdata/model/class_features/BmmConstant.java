package nl.rosa.semanticdatabase.bmmdata.model.class_features;

import lombok.Data;
import nl.rosa.semanticdatabase.base.MultiplicityInterval;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmClass;
import nl.rosa.semanticdatabase.bmmdata.model.literal_values.BmmLiteralValue;
import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmDeclaration;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmEffectiveType;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmSignature;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmUnitaryType;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;


/**
 * Class BmmConstant
 * An immutable, static value-returning element scoped to a class.
 */
@Data
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
  /**
   * BmmEntity
   */
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
   * BmmDeclaration
   */
  @NotNull
  private String name;
  private Map<String, Object> documentation;
  @NotNull
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
  @NotNull
  private BmmType type;
  // functions
  @NotNull
  public Boolean isBoolean(){
    return null;
  }
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

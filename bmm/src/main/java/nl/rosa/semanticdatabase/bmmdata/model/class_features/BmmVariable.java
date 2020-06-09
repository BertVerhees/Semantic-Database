package nl.rosa.semanticdatabase.bmmdata.model.class_features;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmEffectiveType;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmUnitaryType;

import java.util.List;

/**
 * Class BmmVariable
 * A mutable entity whose scope is a routine.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BmmVariable extends BmmClassEntity implements BmmInstantiable {
  /**
   * BmmInstantiable
   *  BmmTypedFeature
   *   BmmTyped
   *     BmmType
   */
  /**
   * BmmType
   */
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
  @NonNull
  public Boolean isAbstract(){
    return null;
  }
  @NonNull
  public Boolean isPrimitive(){
    return null;
  }
  //==================================================================================
  /**
   * 1..1
   * (redefined)
   * scope: BMM_ROUTINE
   * Routine within which variable is defined.
   */
  private BmmRoutine scope;
}

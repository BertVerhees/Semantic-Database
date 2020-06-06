package nl.rosa.semanticdatabase.bmmdata.model.types;


import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmClass;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmValueSpec;

import lombok.NonNull;
import java.util.List;

/**
 * Class BmmIndexedContainerType
 * Meta-type of linear container type that indexes the contained items in the
 * manner of a standard Hash table, map or dictionary.
 * 
 * (effected) type_name (): String
 * Return full type name, e.g. HashMap<String, ELEMENT>.
 * 
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BmmIndexedContainerType extends BmmContainerType {
  /**
   *      BmmType
   *        BmmEntity
   */
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
  /**
   * BmmEntity
   */
  // Functions
  @NonNull
  public Boolean isAbstract(){
    return null;
  }
  @NonNull
  public Boolean isPrimitive(){
    return null;
  }
  private BmmValueSpec valueConstraint;
  @NonNull
  private BmmClass baseClass;
//==================================================================================
  /**
   * Type of the element index, typically String or Integer, but may be a numeric type or indeed any type from which a hash value can be derived.
   */
  private BmmSimpleType indexType;
}

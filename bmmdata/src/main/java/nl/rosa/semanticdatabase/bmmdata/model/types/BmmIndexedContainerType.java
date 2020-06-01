package nl.rosa.semanticdatabase.bmmdata.model.types;


import lombok.Data;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmClass;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmValueSpec;

import javax.validation.constraints.NotNull;
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
public class BmmIndexedContainerType extends BmmContainerType {
  /**
   *      BmmType
   *        BmmEntity
   */
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
  private BmmValueSpec valueConstraint;
  @NotNull
  private BmmClass baseClass;
//==================================================================================
  /**
   * Type of the element index, typically String or Integer, but may be a numeric type or indeed any type from which a hash value can be derived.
   */
  private BmmSimpleType indexType;
  
  //
  // Constructors
  //
  public BmmIndexedContainerType () { };
  

  // BmmEntity
  @Override
  public Boolean isAbstract() {
    //TODO
    return false;
  }

  @Override
  public Boolean isPrimitive() {
    //TODO
    return false;
  }
}

package nl.rosa.semanticdatabase.bmmdata.model.types;

import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmClass;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmSimpleClass;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmValueSpec;

import lombok.NonNull;
import java.util.List;


/**
 * Class BmmSimpleType
 * Type reference to a single type i.e. not generic or container type.
 * 
 * (effected) type_name (): String
 * Result is base_class.name.
 * (effected) is_abstract (): Boolean
 * Result is base_class.is_abstract.
 * (effected) flattened_type_list (): List<String>
 * Result is base_class.name .
 * 
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BmmSimpleType extends BmmBaseEntity implements BmmModelType {
  /**
   * BmmModelType
   *  BmmEffectiveType
   *    BmmUnitaryType
   *      BmmType
   *        BmmEntity
   */

  /**
   * BmmEffectiveType
   */
  // Functions;
  @NonNull
  public BmmEffectiveType getEffectiveType(){
    return null;
  }
  @NonNull
  public String typeBaseName(){
    return null;
  }
  /**
   * BmmUnitaryType
   */
  // Functions
  @NonNull
  public BmmUnitaryType unitaryType(){
    return null;
  }
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
  /**
   *  BmmModelType
   */
  private BmmValueSpec valueConstraint;

  //==================================================================================
  /**
   * Defining class of this type.
   */
  @NonNull
  private BmmSimpleClass baseClass;
  
  //
  // Constructors
  //
  public BmmSimpleType () { };

  /**
   * True if this declaration entity is the root of the declaration hierarchy.
   * @return
   */
  public Boolean isRootScope() {
    return false;
  }

  @Override
  @Deprecated
  public void setBaseClass(BmmClass newVar) {

  }
}

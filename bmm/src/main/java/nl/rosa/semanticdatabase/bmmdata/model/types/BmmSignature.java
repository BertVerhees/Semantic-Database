package nl.rosa.semanticdatabase.bmmdata.model.types;


import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmClass;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmValueSpec;

import lombok.NonNull;
import java.util.List;

/**
 * Class BmmSignature
 * Non-entity meta-type that expresses the type structure of any referenceable
 * element of a model. Consists of potential arguments and result, with constraints
 * in descendants determining the exact form.
 * 
 * (effected) type_base_name (): String
 * Post_result: Result.is_equal (base_name())
 * Return base_name.
 * (effected) is_abstract (): Boolean
 * Result = False.
 * (effected) is_primitive (): Boolean
 * Result = True.
 * (effected) type_name (): String
 * Post_result: Result.is_equal (base_name())
 * Return base_name
 * 
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BmmSignature extends BmmBaseEntity implements BmmEffectiveType {
  /**
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
  private BmmValueSpec valueConstraint;
  @NonNull
  private BmmClass baseClass;
//==================================================================================


  private String baseName = "Signature";
  /**
   * Type of arguments in the signature, if any; represented as a type-tuple (list of arbitrary nl.rosa.semanticdatabase.bmm.model.types).
   */
  private BmmTupleType argumentTypes;  /**

   * Result type of signature, if any.
   *    */

  private BmmType resultType;
  
  //
  // Constructors
  //
  public BmmSignature () { };

  /**
   * True if this declaration entity is the root of the declaration hierarchy.
   * @return
   */
  public Boolean isRootScope() {
    return false;
  }

}

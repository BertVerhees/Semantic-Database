package nl.rosa.semanticdatabase.bmmdata.model.types;


import lombok.Data;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmClass;
import nl.rosa.semanticdatabase.bmmdata.model.classes.BmmValueSpec;

import javax.validation.constraints.NotNull;
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
  @NotNull
  public BmmEffectiveType getEffectiveType(){
    return null;
  }
  @NotNull
  public String typeBaseName(){
    return null;
  }
  /**
   * BmmUnitaryType
   */
  // Functions
  @NotNull
  public BmmUnitaryType unitaryType(){
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

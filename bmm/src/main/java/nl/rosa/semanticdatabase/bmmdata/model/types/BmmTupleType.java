package nl.rosa.semanticdatabase.bmmdata.model.types;


import lombok.Data;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

/**
 * Class BmmTupleType
 * Special type representing the type of a tuple, i.e. an array of any number of
 * other nl.rosa.semanticdatabase.bmm.model.types. This includes both container and unitary nl.rosa.semanticdatabase.bmm.model.types, since tuple
 * instances represent concrete objects.
 * Note that both open and closed generic parameters are allowed, as with any
 * generic type, but open generic parameters are only valid within the scope of a
 * generic class.
 * 
 * effected) type_base_name (): String
 * Post_result: Result.is_equal (base_name())
 * Return base_name.
 * (effected) is_primitive (): Boolean
 * Result = True.
 * (effected) is_abstract (): Boolean
 * Result = False.
 * (effected) type_name (): String
 * Post_result: Result.is_equal (base_name())
 * Return base_name.
 * 
 */
@Data
public class BmmTupleType extends BmmBaseEntity implements BmmEffectiveType {
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
//==================================================================================

  private String baseName = "Tuple";
  /**
   * List of nl.rosa.semanticdatabase.bmm.model.types of the items of the tuple, keyed by purpose in the tuple.
   */
  private Map<String,BmmType> itemTypes;
  /**
   * True if this declaration entity is the root of the declaration hierarchy.
   * @return
   */
  public Boolean isRootScope() {
    return false;
  }

}

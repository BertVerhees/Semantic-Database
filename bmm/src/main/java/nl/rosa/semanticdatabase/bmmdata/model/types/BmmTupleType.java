package nl.rosa.semanticdatabase.bmmdata.model.types;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

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
@EqualsAndHashCode(callSuper = true)
public class BmmTupleType extends BmmEffectiveType  {

  private String baseName = "Tuple";
  /**
   * List of nl.rosa.semanticdatabase.bmm.model.types of the items of the tuple, keyed by purpose in the tuple.
   */
  private Map<String,BmmType> itemTypes;

  /**
   * 1..1
   * (effected)
   * type_base_name (): String
   * Post_result: Result.is_equal (base_name())
   * Return base_name.
   * @return
   */
  @Override
  public String typeBaseName() {
    return baseName;
  }

  /**
   * 1..1
   * (effected)
   * type_name (): String
   * Post_result: Result.is_equal (base_name())
   * Return base_name.
   * @return
   */
  @Override
  public @NonNull String typeName() {
    return baseName;
  }

  @Override
  public @NonNull List<String> flattenedTypeList() {
    return null;
  }

  /**
   * 1..1
   * (effected)
   * is_abstract (): Boolean
   * Result = False.
   * @return
   */
  @Override
  public @NonNull Boolean isAbstract() {
    return false;
  }

  /**
   * 1..1
   * (effected)
   * is_primitive (): Boolean
   * Result = True.
   * @return
   */
  @Override
  public @NonNull Boolean isPrimitive() {
    return true;
  }
}

package nl.rosa.semanticdatabase.bmmdata.model.types;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

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
   * 1..1
   * index_type: BMM_SIMPLE_TYPE
   * Type of the element index, typically String or Integer,
   * but may be a numeric type or indeed any type from which a hash value can be derived.
   */
  @NonNull
  private BmmSimpleType indexType;

  /**
   * 1..1
   * (effected)
   * type_name (): String
   * Return full type name, e.g. HashMap<String, ELEMENT>.
   * @return
   */
  @NonNull
  public String typeName(){
    return null;
  }
}

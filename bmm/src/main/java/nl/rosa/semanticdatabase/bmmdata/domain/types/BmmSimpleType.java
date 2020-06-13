package nl.rosa.semanticdatabase.bmmdata.domain.types;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.domain.classes.BmmSimpleClass;

import javax.persistence.Entity;
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
@Entity
public class BmmSimpleType extends BmmModelType  {
  /**
   * 1..1
   * (redefined)
   * base_class: BMM_SIMPLE_CLASS
   * Defining class of this type.
   */
  @NonNull
  private BmmSimpleClass baseClass;

  /**
   * 1..1
   * (effected)
   * type_name (): String
   * Result is base_class.name.
   * @return
   */
  @Override
  @NonNull
  public  String typeName() {
    return null;
  }

  /**
   * 1..1
   * (effected)
   * flattened_type_list (): List<String>
   * Result is base_class.name .
   * @return
   */
  @Override
  @NonNull
  public List<String> flattenedTypeList() {
    return null;
  }

  /**
   * 1..1
   * (effected)
   * is_abstract (): Boolean
   * Result is base_class.is_abstract.
   * @return
   */
  @Override
  @NonNull
  public Boolean isAbstract() {
    return null;
  }

  /**
   * 1..1
   * effective_base_class (): BMM_SIMPLE_CLASS
   * Main design class for this type, from which properties etc can be extracted.
   * @return
   */
  @NonNull
  public BmmSimpleClass effectiveBaseClass(){
    return null;
  }
}

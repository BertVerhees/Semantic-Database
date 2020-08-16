package nl.rosa.semanticdatabase.bmmdata.domain.types;


import lombok.*;

import javax.persistence.Entity;
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
public class BmmSignature extends BmmEffectiveType  {
  @Getter
  private final String baseName = "Signature";
  /**
   * 0..1
   * Type of arguments in the signature, if any; represented as a type-tuple (list of arbitrary nl.rosa.semanticdatabase.bmm.model.types).
   */
  @Getter
  @Setter
  private BmmTupleType argumentTypes;

  /**
   * 0..1
   * Result type of signature, if any.
  */
  @Getter
  @Setter
  private BmmType resultType;

  public Boolean isRootScope() {
    return false;
  }

  /**
   * 1..1
   * (effected)
   * type_base_name (): String
   * Post_result: Result.is_equal (base_name())
   * Return base_name.
   * @return
   */
  @Override
  public @NonNull String typeBaseName() {
    return null;
  }

  /**
   * 1..1
   * (effected)
   * type_name (): String
   * Post_result: Result.is_equal (base_name())
   *
   * Return base_name
   * @return
   */
  @Override
  public String typeName() {
    return null;
  }

  /**
   * 1..1
   * (effected)
   * flattened_type_list (): List<String>
   * Return the logical set (i.e. unique items) consisting of argument_types.flattened_type_list() and result_type.flattened_type_list().
   * @return
   */
  @Override
  public List<String> flattenedTypeList() {
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
  public Boolean isAbstract(){
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

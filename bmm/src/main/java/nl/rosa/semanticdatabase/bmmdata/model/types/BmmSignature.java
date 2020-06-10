package nl.rosa.semanticdatabase.bmmdata.model.types;


import lombok.Data;
import lombok.EqualsAndHashCode;
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
public class BmmSignature extends BmmEffectiveType  {
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

  @Override
  public String typeBaseName() {
    return null;
  }

  @Override
  public @NonNull String typeName() {
    return null;
  }

  @Override
  public @NonNull List<String> flattenedTypeList() {
    return null;
  }

  @Override
  public @NonNull Boolean isAbstract() {
    return null;
  }

  @Override
  public @NonNull Boolean isPrimitive() {
    return null;
  }
}

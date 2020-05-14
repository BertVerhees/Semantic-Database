package nl.rosa.semanticdatabase.bmm.types;


import lombok.Data;

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
public class BmmSignature implements BmmEffectiveType {

  //
  // Fields
  //

  private String baseName = "Signature";
  /**
   * Type of arguments in the signature, if any; represented as a type-tuple (list of arbitrary nl.rosa.semanticdatabase.bmm.types).
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
  public boolean isRootScope() {
    return false;
  }

  /**
   * Formal string form of the type as per UML.
   * @return
   */
  @Override
  public String typeName() {
    //TODO
    return null;
  }

  /**
   * Completely flattened list of type names, flattening out all generic parameters.
   * @return
   */
  @Override
  public List<String> flattenedTypeList() {
    //TODO
    return null;
  }

  /**
   * Signature form of the type name, which for generics includes generic parameter constrainer nl.rosa.semanticdatabase.bmm.types E.g. Interval<T:Ordered>.
   *
   * Defaults to the value of type_name().
   * @return
   */
  @Override
  public String typeSignature() {
    //TODO
    return null;
  }

  /**
   * Type with any container abstracted away.
   * @return
   */
  @Override
  public BmmUnitaryType unitaryType() {
    //TODO
    return null;
  }

  /**
   * Type with any container abstracted away, and any formal parameter replaced by its effective constraint type.
   * @return
   */
  @Override
  public BmmEffectiveType effectiveType() {
    //TODO
    return null;
  }

  @Override
  public String typeBaseName() {
    //TODO
    return null;
  }

  // BmmEntity
  @Override
  public boolean isAbstract() {
    //TODO
    return false;
  }

  @Override
  public boolean isPrimitive() {
    //TODO
    return false;
  }
}

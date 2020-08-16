package nl.rosa.semanticdatabase.bmmdata.domain.types;


import lombok.*;

import javax.persistence.Entity;
import java.util.List;

/**
 * Class BmmParameterType
 * Definition of a generic parameter in a class definition of a generic type.
 * 
 * (effected) is_primitive (): Boolean
 * Result = False - generic parameters are understood by definition to be
 * non-primitive.
 * (effected) is_abstract (): Boolean
 * Result = False - generic parameters are understood by definition to be
 * non-abstract.
 * (effected) type_name (): String
 * Return name.
 * (effected) flattened_type_list (): List<String>
 * Result is either flattened_conforms_to_type.flattened_type_list or the Any type.
 * (effected) effective_type (): BMM_EFFECTIVE_TYPE
 * Generate ultimate conformance type, which is either flattened_conforms_to_type
 * or if not set, Any.
 *
 *    * Invariants
 *    * Inv_generic_name: name.count = 1 and name.is_upper
 * 
 */
public class BmmParameterType extends BmmUnitaryType  {

  /**
   * 1..1
   * name: String
   * Name of the parameter, e.g. 'T' etc. The name is limited to 1 character and upper-case.
   */
  @NonNull
  @Getter
  @Setter
  private String name;
  /**
   * 0..1
   * type_constraint: BMM_EFFECTIVE_TYPE
   * Optional conformance constraint that must be the name of a defined type.
   */
  private BmmEffectiveType typeConstraint;
  /**
   * 0..1
   * inheritance_precursor: BMM_PARAMETER_TYPE
   * If set, is the corresponding generic parameter definition in an ancestor class.
   */
  private BmmParameterType inheritancePrecursor;

  //========= Functions ====================================

  /**
   * 0..1
   * flattened_conforms_to_type (): BMM_EFFECTIVE_TYPE
   * Result is either conforms_to_type or inheritance_precursor.flattened_conforms_to_type.
   * @return
   */
   public @NonNull BmmEffectiveType flattenedConformsToType (){
    return null;
  }

  /**
   * 1..1
   * (redefined)
   * type_signature (): String
   * Signature form of the open type, including constrainer type if there is one, e.g. T:Ordered.
   */
  @Override
  public @NonNull String typeSignature() {
    return null;
  }

  /**
   * 1..1
   * (effected)
   * flattened_type_list (): List<String>
   * Result is either flattened_conforms_to_type.flattened_type_list or the Any type.
   * @return
   */
  @Override
  public @NonNull List<String> flattenedTypeList() {
    return null;
  }

  /**
   * 1..1
   * (effected)
   * effective_type (): BMM_EFFECTIVE_TYPE
   * Generate ultimate conformance type, which is either flattened_conforms_to_type or if not set, Any.
   * @return
   */
  @Override
  public @NonNull BmmEffectiveType effectiveType() {
    return null;
  }

  /**
   * 1..1
   * (effected)
   * is_abstract (): Boolean
   * Result = False - generic parameters are understood by definition to be non-abstract.
   * @return
   */
  @Override
  public @NonNull Boolean isAbstract() {
    return null;
  }

  /**
   * 1..1
   * (effected)
   * is_primitive (): Boolean
   * Result = False - generic parameters are understood by definition to be non-primitive.
   * @return
   */
  @Override
  public @NonNull Boolean isPrimitive() {
    return null;
  }

  /**
   * 1..1
   * (effected)
   * type_name (): String
   * Return name.
   * @return
   */
  @Override
  public @NonNull String typeName() {
    return null;
  }
}

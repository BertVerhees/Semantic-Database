package nl.rosa.semanticdatabase.bmmdata.model.types;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

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
@Data
@EqualsAndHashCode(callSuper = true)
public class BmmParameterType extends BmmUnitaryType  {

  /**
   * Name of the parameter, e.g. 'T' etc. The name is limited to 1 character and upper-case.
   */
  private String name;
  /**
   * Optional conformance constraint that must be the name of a defined type.
   */
  private BmmEffectiveType typeConstraint;
  /**
   * If set, is the corresponding generic parameter definition in an ancestor class.
   */
  private BmmParameterType inheritancePrecursor;
  /**
   * 1..1
   * flattened_conforms_to_type (): BMM_EFFECTIVE_TYPE
   * Result is either conforms_to_type or inheritance_precursor.flattened_conforms_to_type.
   * @return
   */

  // Functions
  @NonNull
  public BmmEffectiveType flattenedConformsToType (){
    return null;
  }
  //================================================================
  /**
   * BmmType
   * @return
   */
  /**
   * 1..1
   * (effected)
   * type_name (): String
   * Return name.
   * @return
   */
  @Override
  @NonNull
  public String typeName() {
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
}

package nl.rosa.semanticdatabase.referencemodel.bmm.types;


import lombok.Data;

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
 */
@Data
public class BmmParameterType implements BmmUnitaryType {

  //
  // Fields
  //

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

  //
  // Constructors
  //
  public BmmParameterType () { };

  @Override
  public String typeName() {
    //TODO
    return null;
  }

  @Override
  public List<String> flattenedTypeList() {
    //TODO
    return null;
  }

  /**
   * Signature form of the open type, including constrainer type if there is one,
   * e.g. T:Ordered.
   * @return       String
   */
  public String typeSignature()
  {
    //TODO
    return null;
  }


  @Override
  public BmmUnitaryType unitaryType() {
    //TODO
    return null;
  }

  @Override
  public BmmEffectiveType effectiveType() {
    //TODO
    return null;
  }

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

package nl.rosa.semanticdatabase.referencemodel.bmm.types;


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
public interface BmmParameterType extends BmmUnitaryType {

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
  private types.BmmEffectiveType typeConstraint;
  /**
   * If set, is the corresponding generic parameter definition in an ancestor class.
   */
  private types.BmmParameterType inheritancePrecursor;
  
  //
  // Constructors
  //
  public BmmParameterType () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of name
   * Name of the parameter, e.g. 'T' etc. The name is limited to 1 character and
   * upper-case.
   * @param newVar the new value of name
   */
  public void setName (String newVar) {
    name = newVar;
  }

  /**
   * Get the value of name
   * Name of the parameter, e.g. 'T' etc. The name is limited to 1 character and
   * upper-case.
   * @return the value of name
   */
  public String getName () {
    return name;
  }

  /**
   * Set the value of typeConstraint
   * Optional conformance constraint that must be the name of a defined type.
   * @param newVar the new value of typeConstraint
   */
  public void setTypeConstraint (types.BmmEffectiveType newVar) {
    typeConstraint = newVar;
  }

  /**
   * Get the value of typeConstraint
   * Optional conformance constraint that must be the name of a defined type.
   * @return the value of typeConstraint
   */
  public types.BmmEffectiveType getTypeConstraint () {
    return typeConstraint;
  }

  /**
   * Set the value of inheritancePrecursor
   * If set, is the corresponding generic parameter definition in an ancestor class.
   * @param newVar the new value of inheritancePrecursor
   */
  public void setInheritancePrecursor (types.BmmParameterType newVar) {
    inheritancePrecursor = newVar;
  }

  /**
   * Get the value of inheritancePrecursor
   * If set, is the corresponding generic parameter definition in an ancestor class.
   * @return the value of inheritancePrecursor
   */
  public types.BmmParameterType getInheritancePrecursor () {
    return inheritancePrecursor;
  }

  //
  // Other methods
  //

  /**
   * Result is either conforms_to_type or
   * inheritance_precursor.flattened_conforms_to_type.
   * @return       types.BmmEffectiveType
   */
  public types.BmmEffectiveType flattenedConformsToType()
  {
  }


  /**
   * Signature form of the open type, including constrainer type if there is one,
   * e.g. T:Ordered.
   * @return       String
   */
  public String typeSignature()
  {
  }


}

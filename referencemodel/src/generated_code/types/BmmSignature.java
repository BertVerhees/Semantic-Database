package types;


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
public class BmmSignature extends BmmEffectiveType {

  //
  // Fields
  //

  private String baseName = "Signature";
  /**
   * Type of arguments in the signature, if any; represented as a type-tuple (list of arbitrary types).
   */
  private types.BmmTupleType argumentTypes;  /**

   * Result type of signature, if any.
   *    */

  private types.BmmType resultType;
  
  //
  // Constructors
  //
  public BmmSignature () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of baseName
   * @param newVar the new value of baseName
   */
  public void setBaseName (String newVar) {
    baseName = newVar;
  }

  /**
   * Get the value of baseName
   * @return the value of baseName
   */
  public String getBaseName () {
    return baseName;
  }

  /**
   * Set the value of argumentTypes
   * Type of arguments in the signature, if any; represented as a type-tuple (list of
   * arbitrary types).
   * @param newVar the new value of argumentTypes
   */
  public void setArgumentTypes (types.BmmTupleType newVar) {
    argumentTypes = newVar;
  }

  /**
   * Get the value of argumentTypes
   * Type of arguments in the signature, if any; represented as a type-tuple (list of
   * arbitrary types).
   * @return the value of argumentTypes
   */
  public types.BmmTupleType getArgumentTypes () {
    return argumentTypes;
  }

  /**
   * Set the value of resultType
   * Result type of signature, if any.
   * 
   * @param newVar the new value of resultType
   */
  public void setResultType (types.BmmType newVar) {
    resultType = newVar;
  }

  /**
   * Get the value of resultType
   * Result type of signature, if any.
   * 
   * @return the value of resultType
   */
  public types.BmmType getResultType () {
    return resultType;
  }

  //
  // Other methods
  //

}

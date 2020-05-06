package types;


/**
 * Class BmmModelType
 * A type that is defined by a class (or classes) in the model.
 * 
 * (effected) type_base_name (): String
 * Result = defining_class.name.
 * (effected) is_primitive (): Boolean
 * Result = defining_class.is_primitive.
 * 
 */
abstract public class BmmModelType extends BmmEffectiveType {

  //
  // Fields
  //

  private BmmValueSpec valueConstraint;
  /**
   * Defining class of this type.
   */
  private BmmClass baseClass;
  
  //
  // Constructors
  //
  public BmmModelType () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of valueConstraint
   * @param newVar the new value of valueConstraint
   */
  public void setValueConstraint (BmmValueSpec newVar) {
    valueConstraint = newVar;
  }

  /**
   * Get the value of valueConstraint
   * @return the value of valueConstraint
   */
  public BmmValueSpec getValueConstraint () {
    return valueConstraint;
  }

  /**
   * Set the value of baseClass
   * Defining class of this type.
   * @param newVar the new value of baseClass
   */
  public void setBaseClass (BmmClass newVar) {
    baseClass = newVar;
  }

  /**
   * Get the value of baseClass
   * Defining class of this type.
   * @return the value of baseClass
   */
  public BmmClass getBaseClass () {
    return baseClass;
  }

  //
  // Other methods
  //

}

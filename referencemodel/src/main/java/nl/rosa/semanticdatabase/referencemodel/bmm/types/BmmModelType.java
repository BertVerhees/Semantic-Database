package nl.rosa.semanticdatabase.referencemodel.bmm.types;

import nl.rosa.semanticdatabase.referencemodel.bmm.classes.BmmValueSpec;
import nl.rosa.semanticdatabase.referencemodel.bmm.classes.BmmClass;


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
public interface BmmModelType extends BmmEffectiveType {

  //
  // Fields
  //

  private classes.BmmValueSpec valueConstraint;
  /**
   * Defining class of this type.
   */
  private classes.BmmClass baseClass;
  
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
  public void setValueConstraint (classes.BmmValueSpec newVar) {
    valueConstraint = newVar;
  }

  /**
   * Get the value of valueConstraint
   * @return the value of valueConstraint
   */
  public classes.BmmValueSpec getValueConstraint () {
    return valueConstraint;
  }

  /**
   * Set the value of baseClass
   * Defining class of this type.
   * @param newVar the new value of baseClass
   */
  public void setBaseClass (classes.BmmClass newVar) {
    baseClass = newVar;
  }

  /**
   * Get the value of baseClass
   * Defining class of this type.
   * @return the value of baseClass
   */
  public classes.BmmClass getBaseClass () {
    return baseClass;
  }

  //
  // Other methods
  //

}

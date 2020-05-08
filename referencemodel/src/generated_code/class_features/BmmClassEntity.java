package class_features;
import model_structure.BmmDeclaration;


/**
 * Class BmmClassEntity
 * Any entity declared within a class.
 */
abstract public class BmmClassEntity extends BmmDeclaration {

  //
  // Fields
  //
  /**

   * True if this feature was synthesised due to generic substitution in an inherited type, or further constraining of a formal generic parameter.
   * {default = false}   */

  private boolean isSynthesisedGeneric;
  
  //
  // Constructors
  //
  public BmmClassEntity () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of isSynthesisedGeneric
   * True if this feature was synthesised due to generic substitution in an inherited
   * type, or further constraining of a formal generic parameter.
   * {default = false}
   * @param newVar the new value of isSynthesisedGeneric
   */
  public void setIsSynthesisedGeneric (boolean newVar) {
    isSynthesisedGeneric = newVar;
  }

  /**
   * Get the value of isSynthesisedGeneric
   * True if this feature was synthesised due to generic substitution in an inherited
   * type, or further constraining of a formal generic parameter.
   * {default = false}
   * @return the value of isSynthesisedGeneric
   */
  public boolean getIsSynthesisedGeneric () {
    return isSynthesisedGeneric;
  }

  //
  // Other methods
  //

  /**
   * Formal signature of this element, in the form:
   * name [arg1_name: T_arg1, …?][:T_value]
   * Specific implementations in descendants.
   */
  public void signature()
  {
  }


}

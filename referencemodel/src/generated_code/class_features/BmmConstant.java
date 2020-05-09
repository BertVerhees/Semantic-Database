package class_features;
import literal_values.BmmLiteralValue;


/**
 * Class BmmConstant
 * An immutable, static value-returning element scoped to a class.
 */
public class BmmConstant extends BmmClassScoped, BmmInstantiableClass {

  //
  // Fields
  //

  /**
   * The value of the constant.
   */
  private literal_values.BmmLiteralValue value;
  
  //
  // Constructors
  //
  public BmmConstant () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of value
   * The value of the constant.
   * @param newVar the new value of value
   */
  public void setValue (literal_values.BmmLiteralValue newVar) {
    value = newVar;
  }

  /**
   * Get the value of value
   * The value of the constant.
   * @return the value of value
   */
  public literal_values.BmmLiteralValue getValue () {
    return value;
  }

  //
  // Other methods
  //

}

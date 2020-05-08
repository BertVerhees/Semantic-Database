package class_features;


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
  private BmmLiteralValue value;
  
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
  public void setValue (BmmLiteralValue newVar) {
    value = newVar;
  }

  /**
   * Get the value of value
   * The value of the constant.
   * @return the value of value
   */
  public BmmLiteralValue getValue () {
    return value;
  }

  //
  // Other methods
  //

}

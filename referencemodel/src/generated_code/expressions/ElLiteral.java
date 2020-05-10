package expressions;
import literal_values.BmmLiteralValue;
import types.BmmType;


/**
 * Class ElLiteral
 * Literal value of any type known in the model, including primitive types. Defined
 * via a BMM_LITERAL_VALUE.
 */
public class ElLiteral extends ElInstanceRef {

  //
  // Fields
  //

  /**
   * The reference item from which the value of this node can be computed.
   */
  private literal_values.BmmLiteralValue value;
  
  //
  // Constructors
  //
  public ElLiteral () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of value
   * The reference item from which the value of this node can be computed.
   * @param newVar the new value of value
   */
  public void setValue (literal_values.BmmLiteralValue newVar) {
    value = newVar;
  }

  /**
   * Get the value of value
   * The reference item from which the value of this node can be computed.
   * @return the value of value
   */
  public literal_values.BmmLiteralValue getValue () {
    return value;
  }

  //
  // Other methods
  //

  /**
   * Return value.type.
   * @return       types.BmmType
   */
  public types.BmmType evalType()
  {
  }


}

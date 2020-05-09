package nl.rosa.semanticdatabase.referencemodel.bmm.literal_values;


/**
 * Class BmmBooleanValue
 * Meta-type for a literal Boolean value, for which type is fixed to the BMM_TYPE
 * representing Boolean and value is of type Boolean.
 */
public class BmmBooleanValue extends BmmLiteralValue {

  //
  // Fields
  //

  /**
   * Native Boolean value.
   */
  private boolean value;
  
  //
  // Constructors
  //
  public BmmBooleanValue () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of value
   * Native Boolean value.
   * @param newVar the new value of value
   */
  public void setValue (boolean newVar) {
    value = newVar;
  }

  /**
   * Get the value of value
   * Native Boolean value.
   * @return the value of value
   */
  public boolean getValue () {
    return value;
  }

  //
  // Other methods
  //

}

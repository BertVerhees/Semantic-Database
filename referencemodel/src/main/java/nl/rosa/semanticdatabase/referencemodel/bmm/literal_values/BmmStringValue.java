package nl.rosa.semanticdatabase.referencemodel.bmm.literal_values;


/**
 * Class BmmStringValue
 * Meta-type for a literal String value, for which type is fixed to the BMM_TYPE
 * representing String and value is of type String.
 */
public class BmmStringValue extends BmmLiteralValue {

  //
  // Fields
  //

  /**
   * Native String value.
   */
  private String value;
  
  //
  // Constructors
  //
  public BmmStringValue () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of value
   * Native String value.
   * @param newVar the new value of value
   */
  public void setValue (String newVar) {
    value = newVar;
  }

  /**
   * Get the value of value
   * Native String value.
   * @return the value of value
   */
  public String getValue () {
    return value;
  }

  //
  // Other methods
  //

}

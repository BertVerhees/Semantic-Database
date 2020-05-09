package nl.rosa.semanticdatabase.referencemodel.bmm.literal_values;


/**
 * Class BmmIntegerValue
 * Meta-type for a literal Integer value, for which type is fixed to the BMM_TYPE
 * representing Integer and value is of type Integer.
 */
public class BmmIntegerValue extends BmmLiteralValue {

  //
  // Fields
  //

  /**
   * Native Integer value.
   */
  private Integer value;
  
  //
  // Constructors
  //
  public BmmIntegerValue () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of value
   * Native Integer value.
   * @param newVar the new value of value
   */
  public void setValue (Integer newVar) {
    value = newVar;
  }

  /**
   * Get the value of value
   * Native Integer value.
   * @return the value of value
   */
  public Integer getValue () {
    return value;
  }

  //
  // Other methods
  //

}

package nl.rosa.semanticdatabase.referencemodel.bmm.classes;
import literal_values.BmmLiteralValue;


/**
 * Class BmmEnumeration
 */
public class BmmEnumeration extends BmmSimpleClass {

  //
  // Fields
  //

  /**
   * The list of names of the enumeration. If no values are supplied, the integer values 0, 1, 2, �? are assumed.
   */
  private List<String> itemNames;
  /**
   * Optional list of specific values. Must be 1:1 with item_names list.
   */
  private literal_values.BmmLiteralValue itemValues;
  
  //
  // Constructors
  //
  public BmmEnumeration () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of itemNames
   * The list of names of the enumeration. If no values are supplied, the integer
   * values 0, 1, 2, �? are assumed.
   * @param newVar the new value of itemNames
   */
  public void setItemNames (List<String> newVar) {
    itemNames = newVar;
  }

  /**
   * Get the value of itemNames
   * The list of names of the enumeration. If no values are supplied, the integer
   * values 0, 1, 2, �? are assumed.
   * @return the value of itemNames
   */
  public List<String> getItemNames () {
    return itemNames;
  }

  /**
   * Set the value of itemValues
   * Optional list of specific values. Must be 1:1 with item_names list.
   * @param newVar the new value of itemValues
   */
  public void setItemValues (literal_values.BmmLiteralValue newVar) {
    itemValues = newVar;
  }

  /**
   * Get the value of itemValues
   * Optional list of specific values. Must be 1:1 with item_names list.
   * @return the value of itemValues
   */
  public literal_values.BmmLiteralValue getItemValues () {
    return itemValues;
  }

  //
  // Other methods
  //

  /**
   * @return       Hash<String,String>
   */
  public Hash<String,String> nameMap()
  {
  }


}

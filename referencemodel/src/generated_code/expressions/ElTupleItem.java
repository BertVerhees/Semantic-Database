package expressions;


/**
 * Class ElTupleItem
 * A single tuple item, with an optional name.
 */
public class ElTupleItem {

  //
  // Fields
  //

  /**
   * Reference to value entity. If Void, this indicates that the item in this position is Void, e.g. within a routine call parameter list.
   */
  private expressions.ElExpression item;  /**

   * 
   * 
   * Optional name of tuple item.
   *    */

  private String name;
  
  //
  // Constructors
  //
  public ElTupleItem () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of item
   * Reference to value entity. If Void, this indicates that the item in this
   * position is Void, e.g. within a routine call parameter list.
   * @param newVar the new value of item
   */
  public void setItem (expressions.ElExpression newVar) {
    item = newVar;
  }

  /**
   * Get the value of item
   * Reference to value entity. If Void, this indicates that the item in this
   * position is Void, e.g. within a routine call parameter list.
   * @return the value of item
   */
  public expressions.ElExpression getItem () {
    return item;
  }

  /**
   * Set the value of name
   * 
   * 
   * Optional name of tuple item.
   * 
   * @param newVar the new value of name
   */
  public void setName (String newVar) {
    name = newVar;
  }

  /**
   * Get the value of name
   * 
   * 
   * Optional name of tuple item.
   * 
   * @return the value of name
   */
  public String getName () {
    return name;
  }

  //
  // Other methods
  //

}

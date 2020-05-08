package expressions;
import types.BmmType;
import types.BmmTupleType;


/**
 * Class ElTuple
 * Defines an array of optionally named items each of any type.
 */
public class ElTuple extends ElInstanceRef {

  //
  // Fields
  //

  /**
   * Items in the tuple, potentially with names. Typical use is to represent an argument list to routine call.
   */
  private expressions.ElTupleItem items;
  /**
   * Static type inferred from literal value.
   */
  private types.BmmTupleType type;
  
  //
  // Constructors
  //
  public ElTuple () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of items
   * Items in the tuple, potentially with names. Typical use is to represent an
   * argument list to routine call.
   * @param newVar the new value of items
   */
  public void setItems (expressions.ElTupleItem newVar) {
    items = newVar;
  }

  /**
   * Get the value of items
   * Items in the tuple, potentially with names. Typical use is to represent an
   * argument list to routine call.
   * @return the value of items
   */
  public expressions.ElTupleItem getItems () {
    return items;
  }

  /**
   * Set the value of type
   * Static type inferred from literal value.
   * @param newVar the new value of type
   */
  public void setType (types.BmmTupleType newVar) {
    type = newVar;
  }

  /**
   * Get the value of type
   * Static type inferred from literal value.
   * @return the value of type
   */
  public types.BmmTupleType getType () {
    return type;
  }

  //
  // Other methods
  //

  /**
   * Return type.
   * @return       types.BmmType
   */
  public types.BmmType evalType()
  {
  }


}

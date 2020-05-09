package functional_elements;


/**
 * Class BmmStatementBlock
 * A statement 'block' corresponding to the programming language concept of the
 * same name. May be used to establish scope in specific languages.
 */
public class BmmStatementBlock extends BmmStatementItem {

  //
  // Fields
  //

  /**
   * Child blocks of the current block.
   */
  private functional_elements.BmmStatementItem items;
  
  //
  // Constructors
  //
  public BmmStatementBlock () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of items
   * Child blocks of the current block.
   * @param newVar the new value of items
   */
  public void setItems (functional_elements.BmmStatementItem newVar) {
    items = newVar;
  }

  /**
   * Get the value of items
   * Child blocks of the current block.
   * @return the value of items
   */
  public functional_elements.BmmStatementItem getItems () {
    return items;
  }

  //
  // Other methods
  //

}

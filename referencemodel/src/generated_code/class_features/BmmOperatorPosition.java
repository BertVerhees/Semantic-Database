package class_features;


/**
 * Class BmmOperatorPosition
 * Enumeration of possible position of operator in a syntactic representation for
 * operators associated with 1- and 2- degree functions.
 */
public class BmmOperatorPosition {

  //
  // Fields
  //

  /**
   * Prefix operator position: operator comes before operand
   */
  private void prefix;
  /**
   * Infix operator position: operator comes between left and right operands.
   */
  private void infix;
  
  //
  // Constructors
  //
  public BmmOperatorPosition () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of prefix
   * Prefix operator position: operator comes before operand
   * @param newVar the new value of prefix
   */
  public void setPrefix (void newVar) {
    prefix = newVar;
  }

  /**
   * Get the value of prefix
   * Prefix operator position: operator comes before operand
   * @return the value of prefix
   */
  public void getPrefix () {
    return prefix;
  }

  /**
   * Set the value of infix
   * Infix operator position: operator comes between left and right operands.
   * @param newVar the new value of infix
   */
  public void setInfix (void newVar) {
    infix = newVar;
  }

  /**
   * Get the value of infix
   * Infix operator position: operator comes between left and right operands.
   * @return the value of infix
   */
  public void getInfix () {
    return infix;
  }

  //
  // Other methods
  //

}

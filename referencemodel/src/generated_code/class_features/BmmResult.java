package class_features;


/**
 * Class BmmResult
 * Automatically declared variable representing result instance of a Function call.
 */
public class BmmResult extends BmmVariable {

  //
  // Fields
  //
  /**

   * Name of this model element.
   * {default = "Result"}   */

  private String name;
  
  //
  // Constructors
  //
  public BmmResult () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of name
   * Name of this model element.
   * {default = "Result"}
   * @param newVar the new value of name
   */
  public void setName (String newVar) {
    name = newVar;
  }

  /**
   * Get the value of name
   * Name of this model element.
   * {default = "Result"}
   * @return the value of name
   */
  public String getName () {
    return name;
  }

  //
  // Other methods
  //

}

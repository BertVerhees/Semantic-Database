package class_features;


/**
 * Class BmmParameter
 * A routine parameter variable.
 */
public class BmmParameter extends BmmVariable {

  //
  // Fields
  //

  /**
   * Optional read/write direction of the parameter. If none-supplied, the parameter is treated as in, i.e. readable.
   */
  private class_features.BmmParameterDirection direction;
  
  //
  // Constructors
  //
  public BmmParameter () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of direction
   * Optional read/write direction of the parameter. If none-supplied, the parameter
   * is treated as in, i.e. readable.
   * @param newVar the new value of direction
   */
  public void setDirection (class_features.BmmParameterDirection newVar) {
    direction = newVar;
  }

  /**
   * Get the value of direction
   * Optional read/write direction of the parameter. If none-supplied, the parameter
   * is treated as in, i.e. readable.
   * @return the value of direction
   */
  public class_features.BmmParameterDirection getDirection () {
    return direction;
  }

  //
  // Other methods
  //

}

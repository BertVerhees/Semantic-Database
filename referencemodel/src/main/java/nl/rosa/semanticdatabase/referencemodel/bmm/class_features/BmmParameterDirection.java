package nl.rosa.semanticdatabase.referencemodel.bmm.class_features;


/**
 * Class BmmParameterDirection
 */
public class BmmParameterDirection {

  //
  // Fields
  //

  /**
   * Parameter is an input parameter, and treated as readonly by the receiving routine.
   */
  private void in;
  /**
   * Parameter is an output parameter, and treated as a reference to an entity writeable by the receiving routine.
   */
  private void out;  /**

   * 
   * Parameter is an input and output parameter, and treated as a reference to an entity readable and writeable by the receiving routine.
   *    */

  private void in_out;
  
  //
  // Constructors
  //
  public BmmParameterDirection () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of in
   * Parameter is an input parameter, and treated as readonly by the receiving
   * routine.
   * @param newVar the new value of in
   */
  public void setIn (void newVar) {
    in = newVar;
  }

  /**
   * Get the value of in
   * Parameter is an input parameter, and treated as readonly by the receiving
   * routine.
   * @return the value of in
   */
  public void getIn () {
    return in;
  }

  /**
   * Set the value of out
   * Parameter is an output parameter, and treated as a reference to an entity
   * writeable by the receiving routine.
   * @param newVar the new value of out
   */
  public void setOut (void newVar) {
    out = newVar;
  }

  /**
   * Get the value of out
   * Parameter is an output parameter, and treated as a reference to an entity
   * writeable by the receiving routine.
   * @return the value of out
   */
  public void getOut () {
    return out;
  }

  /**
   * Set the value of in_out
   * 
   * Parameter is an input and output parameter, and treated as a reference to an
   * entity readable and writeable by the receiving routine.
   * 
   * @param newVar the new value of in_out
   */
  public void setIn_out (void newVar) {
    in_out = newVar;
  }

  /**
   * Get the value of in_out
   * 
   * Parameter is an input and output parameter, and treated as a reference to an
   * entity readable and writeable by the receiving routine.
   * 
   * @return the value of in_out
   */
  public void getIn_out () {
    return in_out;
  }

  //
  // Other methods
  //

}

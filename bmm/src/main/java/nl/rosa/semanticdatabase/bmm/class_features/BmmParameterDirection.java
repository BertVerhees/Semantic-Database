package nl.rosa.semanticdatabase.bmm.class_features;


import lombok.Data;

/**
 * Class BmmParameterDirection
 */
@Data
public class BmmParameterDirection {

  //
  // Fields
  //

  /**
   * Parameter is an input parameter, and treated as readonly by the receiving routine.
   */
  private Object in;
  /**
   * Parameter is an output parameter, and treated as a reference to an entity writeable by the receiving routine.
   */
  private Object out;  /**

   * 
   * Parameter is an input and output parameter, and treated as a reference to an entity readable and writeable by the receiving routine.
   *    */

  private Object in_out;
  
  //
  // Constructors
  //
  public BmmParameterDirection () { };
  
}

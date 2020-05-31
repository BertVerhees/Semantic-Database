package nl.rosa.semanticdatabase.bmmdata.model.class_features;


import lombok.Data;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;

/**
 * Class BmmParameterDirection
 */
@Data
public class BmmParameterDirection extends BmmBaseEntity {

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

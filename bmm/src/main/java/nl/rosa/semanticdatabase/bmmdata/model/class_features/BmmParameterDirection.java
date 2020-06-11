package nl.rosa.semanticdatabase.bmmdata.model.class_features;


/**
 * Enumeration of parameter read/write direction values.
 */
public enum BmmParameterDirection {

  /**
   * Parameter is an input parameter, and treated as readonly by the receiving routine.
   */
  in,
  /**
   * Parameter is an output parameter, and treated as a reference to an entity writeable by the receiving routine.
   */
  out,
  /**
   * Parameter is an input and output parameter, and treated as a reference to an entity readable and writeable by the receiving routine.
   */

  in_out
}

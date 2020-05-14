package nl.rosa.semanticdatabase.bmm.class_features;


import lombok.Data;

/**
 * Class BmmOperatorPosition
 * Enumeration of possible position of operator in a syntactic representation for
 * operators associated with 1- and 2- degree functions.
 */
@Data
public class BmmOperatorPosition {

  //
  // Fields
  //

  /**
   * Prefix operator position: operator comes before operand
   */
  private Object prefix;
  /**
   * Infix operator position: operator comes between left and right operands.
   */
  private Object infix;
  
  //
  // Constructors
  //
  public BmmOperatorPosition () { };
  
}

package nl.rosa.semanticdatabase.bmmdata.domain.class_features;


/**
 * Class BmmOperatorPosition
 * Enumeration of possible position of operator in a syntactic representation for
 * operators associated with 1- and 2- degree functions.
 */
public enum BmmOperatorPosition {

  /**
   * Prefix operator position: operator comes before operand
   */
  prefix,
  /**
   * Infix operator position: operator comes between left and right operands.
   */
  infix
}

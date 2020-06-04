package nl.rosa.semanticdatabase.bmmdata.model.class_features;


import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;

/**
 * Class BmmOperatorPosition
 * Enumeration of possible position of operator in a syntactic representation for
 * operators associated with 1- and 2- degree functions.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BmmOperatorPosition extends BmmBaseEntity {

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

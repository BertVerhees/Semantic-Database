package nl.rosa.semanticdatabase.referencemodel.bmm.expressions;

import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmSimpleType;


/**
 * Class ElPredicate
 * Parent type of predicate of any object reference.
 */
public interface ElPredicate extends ElTerminal {
  //
  // Accessor methods
  //

  /**
   * Set the value of operand
   * The target instance of this predicate.
   * @param newVar the new value of operand
   */
  public void setOperand (ElInstanceRef newVar);

  /**
   * Get the value of operand
   * The target instance of this predicate.
   * @return the value of operand
   */
  public ElInstanceRef getOperand ();
  //
  // Other methods
  //

  /**
   * Return {BMM_MODEL}.boolean_type_definition().
   * @return       types.BmmSimpleType
   */
  public BmmSimpleType evalType();
}

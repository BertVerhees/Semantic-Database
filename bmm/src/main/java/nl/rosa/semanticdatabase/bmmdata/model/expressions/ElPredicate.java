package nl.rosa.semanticdatabase.bmmdata.model.expressions;

import nl.rosa.semanticdatabase.bmmdata.model.types.BmmSimpleType;


/**
 * Class ElPredicate
 * Parent type of predicate of any object reference.
 */
public interface ElPredicate extends ElTerminal {

  /**
   * 1..1
   * operand: EL_INSTANCE_REF
   * The target instance of this predicate.
   * @param newVar the new value of operand
   */
  public void setOperand (ElInstanceRef newVar);
  public ElInstanceRef getOperand ();
  //
  // Other methods
  //

  /**
   * 1..1
   * (effected)
   * eval_type (): BMM_SIMPLE_TYPE
   * Return {BMM_MODEL}.Boolean_type_definition().
   * @return       nl.rosa.semanticdatabase.bmm.model.types.BmmSimpleType
   */
  public BmmSimpleType evalType();
}

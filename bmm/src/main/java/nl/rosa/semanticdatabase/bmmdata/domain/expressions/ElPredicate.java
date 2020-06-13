package nl.rosa.semanticdatabase.bmmdata.domain.expressions;

import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmSimpleType;

/**
 * Class ElPredicate
 * Parent type of predicate of any object reference.
 */
public abstract class ElPredicate extends ElTerminal {
  /**
   * 1..1
   * operand: EL_INSTANCE_REF
   * The target instance of this predicate.
   * @param newVar the new value of operand
   */
  private ElInstanceRef operand;
  // Functions
  /**
   * 1..1
   * (effected)
   * eval_type (): BMM_SIMPLE_TYPE
   * Return {BMM_MODEL}.boolean_type_definition().
   *
   * Invariants
   * Inv_boolean_result: is_boolean()
   */
  public BmmSimpleType evalType(){
    return null;
  }
}

package nl.rosa.semanticdatabase.bmmdata.model.expressions;

import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;

/**
 * Class ElExpression
 * Abstract parent of all typed expression tree items.
 */
public interface ElExpression {

  /**
   * Meta-type of expression entity used in type-checking and evaluation.
   *
   * Effected in descendants.
   * @return BmmType
   */
  BmmType evalType();

  /**
   * True if eval_type is notionally Boolean (i.e. a BMM_SIMPLE_TYPE with type_name()
   * = Boolean)
   * @return       Boolean
   * Post_result: Result = eval_type().equal( {BMM_MODEL}.Boolean_type_definition())
   */
  Boolean isBoolean();
}

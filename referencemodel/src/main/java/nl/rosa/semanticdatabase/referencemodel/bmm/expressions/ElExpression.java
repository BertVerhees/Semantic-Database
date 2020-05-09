package nl.rosa.semanticdatabase.referencemodel.bmm.expressions;

import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmType;


/**
 * Class ElExpression
 * Abstract parent of all typed expression tree items.
 */
public interface ElExpression {

  BmmType evalType();

  /**
   * True if eval_type is notionally Boolean (i.e. a BMM_SIMPLE_TYPE with type_name()
   * = Boolean)
   * @return       boolean
   * Post_result: Result = eval_type().equal( {BMM_MODEL}.boolean_type_definition())
   */
  boolean isBoolean();
}

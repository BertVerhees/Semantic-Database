package nl.rosa.semanticdatabase.bmmdata.services.model_base_services.expressions;

import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;

/**
 * Base-model structure of interfaces to deliver over inheritance the functions
 * to the service-classes which are implemented in the Service-structures
 * Interface ElExpressionService
 * Abstract parent of all typed expression tree items.
 */
public interface ElExpressionService {

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

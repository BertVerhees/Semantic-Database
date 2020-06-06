package nl.rosa.semanticdatabase.bmmdata.services.model_base_services.expressions;


import nl.rosa.semanticdatabase.bmmdata.model.class_features.BmmOperator;
import nl.rosa.semanticdatabase.bmmdata.model.expressions.ElFunctionCall;

/**
 * Base-model structure of interfaces to deliver over inheritance the functions
 * to the service-classes which are implemented in the Service-structures
 * Interface ElOperatorService
 * Abstract parent of operator nl.rosa.semanticdatabase.bmm.model.types.
 */
public interface ElOperatorService extends ElExpressionService {
  /**
   * Operator definition derived from definition.operator_definition().
   * @return       class_features.BmmOperator
   */
  BmmOperator operatorDefinition();

  /**
   * Function call equivalent to this operator.
   * @return       expressions.ElFunctionCall
   */
  ElFunctionCall equivalentCall();
}

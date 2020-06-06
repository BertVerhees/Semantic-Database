package nl.rosa.semanticdatabase.bmmdata.services.model_base_services.expressions;


import nl.rosa.semanticdatabase.bmmdata.model.types.BmmSimpleType;

/**
 * Base-model structure of interfaces to deliver over inheritance the functions
 * to the service-classes which are implemented in the Service-structures
 * Interface ElPredicateService
 * Parent type of predicate of any object reference.
 */
public interface ElPredicateService extends ElTerminalService {
  /**
   * 1..1
   * (effected)
   * eval_type (): BMM_SIMPLE_TYPE
   * Return {BMM_MODEL}.Boolean_type_definition().
   * @return       nl.rosa.semanticdatabase.bmm.model.types.BmmSimpleType
   */
  BmmSimpleType evalType();
}

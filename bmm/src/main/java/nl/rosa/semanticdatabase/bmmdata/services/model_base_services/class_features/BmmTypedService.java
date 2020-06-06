package nl.rosa.semanticdatabase.bmmdata.services.model_base_services.class_features;

import nl.rosa.semanticdatabase.bmmdata.services.model_base_services.types.BmmTypeService;


/**
 * Base-model structure of interfaces to deliver over inheritance the functions
 *  * to the service-classes which are implemented in the Service-structures
 *  * Interface BmmTyped
 * Any entity that has a declared or inferred static type, and that can therefore
 * be generate a value.
 */
public interface BmmTypedService extends BmmTypeService {
  /**
   * 1..1
   * is_boolean (): Boolean
   * Post_result: Result = type().equal( {BMM_MODEL}.boolean_type_definition())
   * True if type is notionally Boolean (i.e. a BMM_SIMPLE_TYPE with type_name() = 'Boolean').
   */
  public Boolean isBoolean();


}

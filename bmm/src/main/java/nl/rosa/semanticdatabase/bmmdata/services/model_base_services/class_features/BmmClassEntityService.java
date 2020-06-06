package nl.rosa.semanticdatabase.bmmdata.services.model_base_services.class_features;

import nl.rosa.semanticdatabase.bmmdata.model.types.BmmSignature;
import nl.rosa.semanticdatabase.bmmdata.services.model_base_services.model_structure.BmmDeclarationService;


/**
 * Base-model structure of interfaces to deliver over inheritance the functions
 * to the service-classes which are implemented in the Service-structures
 * Interface BmmClassEntityService
 * Any entity declared within a class.
 */
public interface BmmClassEntityService extends BmmDeclarationService {
  /**
   * 1..1
   * (abstract)
   * signature (): BMM_SIGNATURE
   * Formal signature of this element, in the form:
   * name [arg1_name: T_arg1, �?][:T_value]
   * Specific implementations in descendants.
   */
  BmmSignature signature();
}

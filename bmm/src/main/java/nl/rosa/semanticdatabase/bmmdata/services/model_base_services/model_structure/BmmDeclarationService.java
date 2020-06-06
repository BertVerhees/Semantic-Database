package nl.rosa.semanticdatabase.bmmdata.services.model_base_services.model_structure;


/**
 * Base-model structure of interfaces to deliver over inheritance the functions
 *  * to the service-classes which are implemented in the Service-structures
 *  * Interface BmmDeclaration
 */
public interface BmmDeclarationService {
  /**
   * 1..1
   * is_root_scope (): Boolean
   * Post_result: Result = (scope = self)
   * True if this declaration entity is the root of the declaration hierarchy.
   */
  Boolean isRootScope();
}

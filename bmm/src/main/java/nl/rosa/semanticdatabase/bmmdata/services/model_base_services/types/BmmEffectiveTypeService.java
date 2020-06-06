package nl.rosa.semanticdatabase.bmmdata.services.model_base_services.types;


/**
 * Base-model structure of interfaces to deliver over inheritance the functions
 * to the service-classes which are implemented in the Service-structures
 * Interface BmmEffectiveTypeService
 * Meta-type for a A concrete, unitary type that can be used as an actual parameter
 * type in a generic type declaration.
 */
public interface BmmEffectiveTypeService extends BmmUnitaryTypeService {

  /**
   * 1..1
   * (effected)
   * effective_type (): BMM_EFFECTIVE_TYPE
   * Result = self.
   */
  BmmEffectiveTypeService getEffectiveType();
  /**
   * 1..1
   * (abstract)
   * type_base_name (): String
   * Name of base generator type, i.e. excluding any generic parts if present.
   */
  String typeBaseName();
}

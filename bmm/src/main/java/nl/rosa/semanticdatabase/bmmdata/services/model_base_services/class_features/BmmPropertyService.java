package nl.rosa.semanticdatabase.bmmdata.services.model_base_services.class_features;


import nl.rosa.semanticdatabase.base.MultiplicityInterval;

/**
 * Base-model structure of interfaces to deliver over inheritance the functions
 * to the service-classes which are implemented in the Service-structures
 * Interface BmmPropertyService
 * Meta-type of a property definition within a class definition of an object model.
 * The is_composition attribute indicates whether the property has sub-part or an
 * association semantics with respect to the owning class.
 */
public interface BmmPropertyService extends BmmInstantiableService, BmmClassScopedService {
  /**
   * 1..1
   * Interval form of 0..1, 1..1 etc, derived from is_nullable.
   */
  MultiplicityInterval existence();

  /**
   * 1..1
   * Name of this property to display in UI.
   */
  String displayName();
}

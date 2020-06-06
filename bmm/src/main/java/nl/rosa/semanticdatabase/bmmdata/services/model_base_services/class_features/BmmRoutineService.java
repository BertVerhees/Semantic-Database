package nl.rosa.semanticdatabase.bmmdata.services.model_base_services.class_features;

/**
 * Base-model structure of interfaces to deliver over inheritance the functions
 * to the service-classes which are implemented in the Service-structures
 * Interface BmmRoutineService
 * A feature defining a routine, scoped to a class.
 */
public interface BmmRoutineService extends BmmClassScopedService {
  /**
   * Return number of arguments of this routine.
   * @return       Integer
   */
  Integer arity();
}

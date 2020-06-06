package nl.rosa.semanticdatabase.bmmdata.services.model_base_services.types;

/**
 * Base-model structure of interfaces to deliver over inheritance the functions
 * to the service-classes which are implemented in the Service-structures
 * Interface BmmModelTypeService
 * A type that is defined by a class (or classes) in the model.
 * 
 * (effected) type_base_name (): String
 * Result = defining_class.name.
 * (effected) is_primitive (): Boolean
 * Result = defining_class.is_primitive.
 * 
 */
public interface BmmModelTypeService extends BmmEffectiveTypeService {
}

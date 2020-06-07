package nl.rosa.semanticdatabase.bmmdata.services.model_base_services.types;


/**
 * Base-model structure of interfaces to deliver over inheritance the functions
 * to the service-classes which are implemented in the Service-structures
 * Interface BmmUnitaryTypeService
 * Parent of meta-nl.rosa.semanticdatabase.bmm.model.types that may be used as the type of any instantiated object
 * that is not a container object.
 */
public interface BmmUnitaryTypeService extends BmmTypeService {
        /**
         * 1..1
         * (effected)
         * Result = self.
         * @return
         */
        BmmUnitaryTypeService unitaryType();
}

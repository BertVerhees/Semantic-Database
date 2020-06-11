package nl.rosa.semanticdatabase.bmmdata.services.model_base_services.classes;

import nl.rosa.semanticdatabase.bmmdata.model.class_features.BmmClassScoped;
import nl.rosa.semanticdatabase.bmmdata.model.class_features.BmmProperty;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmModelType;
import nl.rosa.semanticdatabase.bmmdata.services.model_base_services.model_structure.BmmModuleService;

import java.util.List;


/**
 * Base-model structure of interfaces to deliver over inheritance the functions
 * to the service-classes which are implemented in the Service-structures
 * Interface BmmClassService
 * Meta-type corresponding a class definition in an object model. Inheritance is
 * specified by the ancestors attribute, which contains a list of nl.rosa.semanticdatabase.bmm.model.types rather than
 * classes. Inheritance is thus understood in BMM as a stated relationship between
 * classes. The equivalent relationship between nl.rosa.semanticdatabase.bmm.model.types is conformance.
 * 
 * NOTE
 * unlike UML, the name is just the root name, even if the class is generic. Use
 * type_name() to obtain the qualified type name.
 * 
 * 
 * (effected) is_primitive (): Boolean
 * True if this class is designated a primitive type within the overall type system
 * of the schema. Set from schema.
 * (effected) is_abstract (): Boolean
 * True if this class is abstract in its model. Value provided from an underlying
 * data property set at creation or construction time.
 * 
 */
public interface BmmClassService extends BmmModuleService {

}

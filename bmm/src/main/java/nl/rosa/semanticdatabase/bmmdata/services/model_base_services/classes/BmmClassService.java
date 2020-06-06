package nl.rosa.semanticdatabase.bmmdata.services.model_base_services.classes;

import nl.rosa.semanticdatabase.bmmdata.services.model_base_services.class_features.BmmClassScopedService;
import nl.rosa.semanticdatabase.bmmdata.services.model_base_services.class_features.BmmPropertyService;
import nl.rosa.semanticdatabase.bmmdata.services.model_base_services.model_structure.BmmModuleService;
import nl.rosa.semanticdatabase.bmmdata.services.model_base_services.types.BmmModelTypeService;

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
  /**
   * 1..1
   * is_abstract (): Boolean
   * If true, indicates an abstract class in a BMM model, or a type based on an abstract class,
   * i.e. a type that cannot be directly instantiated.
   */
  Boolean isAbstract();

  /**
   * 1..1
   * is_primitive (): Boolean
   * If True, indicates that the entity in a BMM model is considered to relate to a primitive type set,
   * i.e. be a primitive type, or be a definer of one.
   */
  Boolean isPrimitive();
  /**
   * 1..1
   * (abstract)
   * type (): BMM_MODEL_TYPE
   * Generate a type object that represents the type for which this class is the definer.
   */
  BmmModelTypeService type();
  /**
   * List of all inheritance parent class names, recursively.
   * @return       List<String>
   */
  List<String> allAncestors();

  /**
   * Compute all descendants by following immediate_descendants.
   * @return       List<String>
   */
  List<String> allDescendants();

  /**
   * List of names of immediate supplier classes, including concrete generic
   * parameters, concrete descendants of abstract statically defined nl.rosa.semanticdatabase.bmm.model.types, and
   * inherited suppliers. (Where generics are unconstrained, no class name is added,
   * since logically it would be Any and this can always be assumed anyway). This
   * list includes primitive nl.rosa.semanticdatabase.bmm.model.types.
   * @return       List<String>
   */
  List<String> suppliers();

  /**
   * Same as suppliers minus primitive nl.rosa.semanticdatabase.bmm.model.types, as defined in input schema.
   * @return       List<String>
   */
  List<String> suppliersNonPrimitive();

  /**
   * ist of names of all classes in full supplier closure, including concrete generic
   * parameters; (where generics are unconstrained, no class name is added, since
   * logically it would be Any and this can always be assumed anyway). This list
   * includes primitive nl.rosa.semanticdatabase.bmm.model.types.
   * @return       List<String>
   */
  List<String> supplierClosure();

  /**
   * Fully qualified package name, of form: package.package
   * @return       String
   */
  String packagePath();

  /**
   * Fully qualified class name, of form: package.package.CLASS with package path in
   * lower-case and class in original case.
   * @return       String
   */
  String classPath();

  /**
   * List of all feature definitions introduced in this class.
   */
  List<BmmClassScopedService> features();

  /**
   * Consolidated list of all feature definitions from this class and all inheritance
   * ancestors.
   */
  List<BmmClassScopedService> flatFeatures();

  /**
   * List of all properties due to current and ancestor classes, keyed by property
   * name.
   * @return       class_features.BmmProperty
   */
  List<BmmPropertyService> flatProperties();
}

package nl.rosa.semanticdatabase.bmmdata.model.classes;

import nl.rosa.semanticdatabase.bmmdata.model.class_features.*;
import nl.rosa.semanticdatabase.bmmdata.model.expressions.ElAssertion;
import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmModule;
import nl.rosa.semanticdatabase.bmmdata.model.model_structure.BmmPackage;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmModelType;

import java.util.List;
import java.util.Map;


/**
 * Class BmmClass
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
public interface BmmClass extends BmmModule {

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
   * 0..1
   * ancestors: Hash<String,BMM_MODEL_TYPE>
   * List of immediate inheritance parents.
   */
  void setAncestors (Map<String, BmmModelType> newVar);
  Map<String, BmmModelType> getAncestors ();

  /**
   * 1..1
   * package: BMM_PACKAGE
   * Package this class belongs to.
   */
  void set_package (BmmPackage newVar);
  BmmPackage get_package ();

  /**
   * 0..1
   * properties: Hash<String,BMM_PROPERTY>
   * List of attributes defined in this class.
   */
  void setProperties (Map<String, BmmProperty> newVar);
  Map<String, BmmProperty> getProperties ();

  /**
   * 1..1
   * source_schema_id: String
   * Reference to original source schema defining this class.
   * Useful for UI tools to determine which original schema file to open for a given class for manual editing.
   */
  void setSourceSchemaId (String newVar);
  String getSourceSchemaId ();

  /**
   * 0..1
   * immediate_descendants: List<BMM_CLASS>
   * List of computed references to base classes of immediate inheritance
   * descendants, derived when members of ancestors are attached at creation time.
   */
  void setImmediateDescendants (List<BmmClass> newVar);
  List<BmmClass> getImmediateDescendants ();

  /**
   * 1..1
   * is_override: Boolean
   * True if this definition overrides a class of the same name in an included
   * schema.
   */
  void setIsOverride (Boolean newVar);
  Boolean getIsOverride ();

  /**
   * 0..1
   * constants: Hash<String,BMM_CONSTANT>
   * List of constants defined in this class.
   */
  void setConstants (Map<String, BmmConstant> newVar);
  Map<String, BmmConstant> getConstants ();

  /**
   * 0..1
   * functions: Hash<String,BMM_FUNCTION>
   * List of functions defined in this class.
   */
  void setFunctions (Map<String, BmmFunction> newVar);
  Map<String, BmmFunction> getFunctions ();

  /**
   * 0..1
   * procedures: Hash<String,BMM_PROCEDURE>
   * List of procedures defined in this class.
   */
  void setProcedures (Map<String, BmmProcedure> newVar);
  Map<String, BmmProcedure> getProcedures ();

  /**
   * 0..1
   * invariants: List<EL_ASSERTION>
   */
  void setInVariants (List<ElAssertion> newVar);
  List<ElAssertion> getInVariants ();

  /**
   * 0..1
   * creators: Hash<String,BMM_PROCEDURE>
   * Subset of procedures that may be used to initialise a new instance of an object,
   * and whose execution will guarantee that class invariants are satisfied.
   */
  void setCreators (Map<String, BmmProcedure> newVar);
  Map<String, BmmProcedure> getCreators ();

  /**
   * 0..1
   * converters: Hash<String,BMM_PROCEDURE>
   * Subset of creators that create a new instance from a single argument of another type.
   */
  void setConvertors (Map<String, BmmProcedure> newVar);
  Map<String, BmmProcedure> getConvertors ();
//---------------------------------------------------------------------------------------------
  /**
   * 1..1
   * (abstract)
   * type (): BMM_MODEL_TYPE
   * Generate a type object that represents the type for which this class is the definer.
   */
  BmmModelType type();
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
  List<BmmClassScoped> features();


  /**
   * Consolidated list of all feature definitions from this class and all inheritance
   * ancestors.
   */
  List<BmmClassScoped> flatFeatures();

  /**
   * List of all properties due to current and ancestor classes, keyed by property
   * name.
   * @return       class_features.BmmProperty
   */
  List<BmmProperty> flatProperties();
}

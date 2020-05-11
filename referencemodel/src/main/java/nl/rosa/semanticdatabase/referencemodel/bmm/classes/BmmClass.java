package nl.rosa.semanticdatabase.referencemodel.bmm.classes;

import nl.rosa.semanticdatabase.referencemodel.bmm.class_features.*;
import nl.rosa.semanticdatabase.referencemodel.bmm.entities.BmmEntity;
import nl.rosa.semanticdatabase.referencemodel.bmm.expressions.ElAssertion;
import nl.rosa.semanticdatabase.referencemodel.bmm.model_structure.BmmModule;
import nl.rosa.semanticdatabase.referencemodel.bmm.model_structure.BmmPackage;
import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmModelType;

import java.util.List;
import java.util.Map;


/**
 * Class BmmClass
 * Meta-type corresponding a class definition in an object model. Inheritance is
 * specified by the ancestors attribute, which contains a list of types rather than
 * classes. Inheritance is thus understood in BMM as a stated relationship between
 * classes. The equivalent relationship between types is conformance.
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
public interface BmmClass extends BmmModule, BmmEntity {


  /**
   * Set the value of ancestors
   * List of immediate inheritance parents.
   * @param newVar the new value of ancestors
   */
  void setAncestors (Map<String, BmmModelType> newVar);

  /**
   * Get the value of ancestors
   * List of immediate inheritance parents.
   * @return the value of ancestors
   */
  Map<String, BmmModelType> getAncestors ();

  /**
   * Set the value of package
   * Package this class belongs to.
   * @param newVar the new value of package
   */
  void set_package (BmmPackage newVar);

  /**
   * Get the value of package
   * Package this class belongs to.
   * @return the value of package
   */
  BmmPackage get_package ();

  /**
   * Set the value of properties
   * List of attributes defined in this class.
   * @param newVar the new value of properties
   */
  void setProperties (Map<String, BmmProperty> newVar);

  /**
   * Get the value of properties
   * List of attributes defined in this class.
   * @return the value of properties
   */
  Map<String, BmmProperty> getProperties ();

  /**
   * Set the value of sourceSchemaId
   * Reference to original source schema defining this class. Useful for UI tools to
   * determine which original schema file to open for a given class for manual
   * editing.
   * @param newVar the new value of sourceSchemaId
   */
  void setSourceSchemaId (String newVar);

  /**
   * Get the value of sourceSchemaId
   * Reference to original source schema defining this class. Useful for UI tools to
   * determine which original schema file to open for a given class for manual
   * editing.
   * @return the value of sourceSchemaId
   */
  String getSourceSchemaId ();

  /**
   * Set the value of immediateDescendants
   * List of computed references to base classes of immediate inheritance
   * descendants, derived when members of ancestors are attached at creation time.
   * @param newVar the new value of immediateDescendants
   */
  void setImmediateDescendants (List<BmmClass> newVar);

  /**
   * Get the value of immediateDescendants
   * List of computed references to base classes of immediate inheritance
   * descendants, derived when members of ancestors are attached at creation time.
   * @return the value of immediateDescendants
   */
  List<BmmClass> getImmediateDescendants ();

  /**
   * Set the value of isOverride
   * True if this definition overrides a class of the same name in an included
   * schema.
   * @param newVar the new value of isOverride
   */
  void setOverride (boolean newVar);

  /**
   * Get the value of isOverride
   * True if this definition overrides a class of the same name in an included
   * schema.
   * @return the value of isOverride
   */
  boolean isOverride ();

  /**
   * Set the value of constants
   * List of constants defined in this class.
   * @param newVar the new value of constants
   */
  void setConstants (Map<String, BmmConstant> newVar);

  /**
   * Get the value of constants
   * List of constants defined in this class.
   * @return the value of constants
   */
  Map<String, BmmConstant> getConstants ();

  /**
   * Set the value of functions
   * List of functions defined in this class.
   * @param newVar the new value of functions
   */
  void setFunctions (Map<String, BmmFunction> newVar);

  /**
   * Get the value of functions
   * List of functions defined in this class.
   * @return the value of functions
   */
  Map<String, BmmFunction> getFunctions ();

  /**
   * Set the value of procedures
   * @param newVar the new value of procedures
   */
  void setProcedures (Map<String, BmmProcedure> newVar);

  /**
   * Get the value of procedures
   * @return the value of procedures
   */
  Map<String, BmmProcedure> getProcedures ();

  /**
   * Set the value of inVariants
   * @param newVar the new value of inVariants
   */
  void setInVariants (List<ElAssertion> newVar);

  /**
   * Get the value of inVariants
   * @return the value of inVariants
   */
  List<ElAssertion> getInVariants ();

  /**
   * Set the value of creators
   * Subset of procedures that may be used to initialise a new instance of an object,
   * and whose execution will guarantee that class invariants are satisfied.
   * @param newVar the new value of creators
   */
  void setCreators (Map<String, BmmProcedure> newVar);

  /**
   * Get the value of creators
   * Subset of procedures that may be used to initialise a new instance of an object,
   * and whose execution will guarantee that class invariants are satisfied.
   * @return the value of creators
   */
  Map<String, BmmProcedure> getCreators ();

  /**
   * Set the value of convertors
   * @param newVar the new value of convertors
   */
  void setConvertors (Map<String, BmmProcedure> newVar);

  /**
   * Get the value of convertors
   * @return the value of convertors
   */
  Map<String, BmmProcedure> getConvertors ();

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
   * parameters, concrete descendants of abstract statically defined types, and
   * inherited suppliers. (Where generics are unconstrained, no class name is added,
   * since logically it would be Any and this can always be assumed anyway). This
   * list includes primitive types.
   * @return       List<String>
   */
  List<String> suppliers();


  /**
   * Same as suppliers minus primitive types, as defined in input schema.
   * @return       List<String>
   */
  List<String> suppliersNonPrimitive();


  /**
   * ist of names of all classes in full supplier closure, including concrete generic
   * parameters; (where generics are unconstrained, no class name is added, since
   * logically it would be Any and this can always be assumed anyway). This list
   * includes primitive types.
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

package classes;
import entities.BmmEntity;
import types.BmmModelType;
import model_structure.BmmPackage;
import expressions.ElAssertion;


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
abstract public class BmmClass extends BmmEntity, BmmModule {

  //
  // Fields
  //

  /**
   * List of immediate inheritance parents.
   */
  private types.BmmModelType ancestors;
  /**
   * Package this class belongs to.
   */
  private model_structure.BmmPackage package;
  /**
   * List of attributes defined in this class.
   */
  private BmmProperty properties;
  /**
   * Reference to original source schema defining this class. Useful for UI tools to determine which original schema file to open for a given class for manual editing.
   */
  private String sourceSchemaId;
  /**
   * List of computed references to base classes of immediate inheritance descendants, derived when members of ancestors are attached at creation time.
   */
  private BmmClass immediateDescendants;
  /**
   * True if this definition overrides a class of the same name in an included schema.
   */
  private boolean isOverride;
  /**
   * List of constants defined in this class.
   */
  private BmmConstant constants;
  /**
   * List of functions defined in this class.
   */
  private BmmFunction functions;
  private BmmProcedure procedures;
  private expressions.ElAssertion inVariants;
  /**
   * Subset of procedures that may be used to initialise a new instance of an object, and whose execution will guarantee that class invariants are satisfied.
   */
  private BmmProcedure creators;
  private BmmProcedure convertors;
  
  //
  // Constructors
  //
  public BmmClass () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of ancestors
   * List of immediate inheritance parents.
   * @param newVar the new value of ancestors
   */
  public void setAncestors (types.BmmModelType newVar) {
    ancestors = newVar;
  }

  /**
   * Get the value of ancestors
   * List of immediate inheritance parents.
   * @return the value of ancestors
   */
  public types.BmmModelType getAncestors () {
    return ancestors;
  }

  /**
   * Set the value of package
   * Package this class belongs to.
   * @param newVar the new value of package
   */
  public void setPackage (model_structure.BmmPackage newVar) {
    package = newVar;
  }

  /**
   * Get the value of package
   * Package this class belongs to.
   * @return the value of package
   */
  public model_structure.BmmPackage getPackage () {
    return package;
  }

  /**
   * Set the value of properties
   * List of attributes defined in this class.
   * @param newVar the new value of properties
   */
  public void setProperties (BmmProperty newVar) {
    properties = newVar;
  }

  /**
   * Get the value of properties
   * List of attributes defined in this class.
   * @return the value of properties
   */
  public BmmProperty getProperties () {
    return properties;
  }

  /**
   * Set the value of sourceSchemaId
   * Reference to original source schema defining this class. Useful for UI tools to
   * determine which original schema file to open for a given class for manual
   * editing.
   * @param newVar the new value of sourceSchemaId
   */
  public void setSourceSchemaId (String newVar) {
    sourceSchemaId = newVar;
  }

  /**
   * Get the value of sourceSchemaId
   * Reference to original source schema defining this class. Useful for UI tools to
   * determine which original schema file to open for a given class for manual
   * editing.
   * @return the value of sourceSchemaId
   */
  public String getSourceSchemaId () {
    return sourceSchemaId;
  }

  /**
   * Set the value of immediateDescendants
   * List of computed references to base classes of immediate inheritance
   * descendants, derived when members of ancestors are attached at creation time.
   * @param newVar the new value of immediateDescendants
   */
  public void setImmediateDescendants (BmmClass newVar) {
    immediateDescendants = newVar;
  }

  /**
   * Get the value of immediateDescendants
   * List of computed references to base classes of immediate inheritance
   * descendants, derived when members of ancestors are attached at creation time.
   * @return the value of immediateDescendants
   */
  public BmmClass getImmediateDescendants () {
    return immediateDescendants;
  }

  /**
   * Set the value of isOverride
   * True if this definition overrides a class of the same name in an included
   * schema.
   * @param newVar the new value of isOverride
   */
  public void setIsOverride (boolean newVar) {
    isOverride = newVar;
  }

  /**
   * Get the value of isOverride
   * True if this definition overrides a class of the same name in an included
   * schema.
   * @return the value of isOverride
   */
  public boolean getIsOverride () {
    return isOverride;
  }

  /**
   * Set the value of constants
   * List of constants defined in this class.
   * @param newVar the new value of constants
   */
  public void setConstants (BmmConstant newVar) {
    constants = newVar;
  }

  /**
   * Get the value of constants
   * List of constants defined in this class.
   * @return the value of constants
   */
  public BmmConstant getConstants () {
    return constants;
  }

  /**
   * Set the value of functions
   * List of functions defined in this class.
   * @param newVar the new value of functions
   */
  public void setFunctions (BmmFunction newVar) {
    functions = newVar;
  }

  /**
   * Get the value of functions
   * List of functions defined in this class.
   * @return the value of functions
   */
  public BmmFunction getFunctions () {
    return functions;
  }

  /**
   * Set the value of procedures
   * @param newVar the new value of procedures
   */
  public void setProcedures (BmmProcedure newVar) {
    procedures = newVar;
  }

  /**
   * Get the value of procedures
   * @return the value of procedures
   */
  public BmmProcedure getProcedures () {
    return procedures;
  }

  /**
   * Set the value of inVariants
   * @param newVar the new value of inVariants
   */
  public void setInVariants (expressions.ElAssertion newVar) {
    inVariants = newVar;
  }

  /**
   * Get the value of inVariants
   * @return the value of inVariants
   */
  public expressions.ElAssertion getInVariants () {
    return inVariants;
  }

  /**
   * Set the value of creators
   * Subset of procedures that may be used to initialise a new instance of an object,
   * and whose execution will guarantee that class invariants are satisfied.
   * @param newVar the new value of creators
   */
  public void setCreators (BmmProcedure newVar) {
    creators = newVar;
  }

  /**
   * Get the value of creators
   * Subset of procedures that may be used to initialise a new instance of an object,
   * and whose execution will guarantee that class invariants are satisfied.
   * @return the value of creators
   */
  public BmmProcedure getCreators () {
    return creators;
  }

  /**
   * Set the value of convertors
   * @param newVar the new value of convertors
   */
  public void setConvertors (BmmProcedure newVar) {
    convertors = newVar;
  }

  /**
   * Get the value of convertors
   * @return the value of convertors
   */
  public BmmProcedure getConvertors () {
    return convertors;
  }

  //
  // Other methods
  //

  /**
   * Generate a type object that represents the type for which this class is the
   * definer.
   * @return       types.BmmModelType
   */
  abstract public types.BmmModelType type();


  /**
   * List of all inheritance parent class names, recursively.
   * @return       List<String>
   */
  abstract public List<String> allAncestors();


  /**
   * Compute all descendants by following immediate_descendants.
   * @return       List<String>
   */
  public List<String> allDescendants()
  {
  }


  /**
   * List of names of immediate supplier classes, including concrete generic
   * parameters, concrete descendants of abstract statically defined types, and
   * inherited suppliers. (Where generics are unconstrained, no class name is added,
   * since logically it would be Any and this can always be assumed anyway). This
   * list includes primitive types.
   * @return       List<String>
   */
  public List<String> suppliers()
  {
  }


  /**
   * Same as suppliers minus primitive types, as defined in input schema.
   * @return       List<String>
   */
  public List<String> suppliersNonPrimitive()
  {
  }


  /**
   * ist of names of all classes in full supplier closure, including concrete generic
   * parameters; (where generics are unconstrained, no class name is added, since
   * logically it would be Any and this can always be assumed anyway). This list
   * includes primitive types.
   * @return       List<String>
   */
  public List<String> supplierClosure()
  {
  }


  /**
   * Fully qualified package name, of form: package.package
   * @return       String
   */
  public String packagePath()
  {
  }


  /**
   * Fully qualified class name, of form: package.package.CLASS with package path in
   * lower-case and class in original case.
   * @return       String
   */
  public String classPath()
  {
  }


  /**
   * List of all feature definitions introduced in this class.
   * @return       BmmClassScoped
   */
  public BmmClassScoped features()
  {
  }


  /**
   * Consolidated list of all feature definitions from this class and all inheritance
   * ancestors.
   * @return       BmmClassScoped
   */
  public BmmClassScoped flatFeatures()
  {
  }


  /**
   * List of all properties due to current and ancestor classes, keyed by property
   * name.
   * @return       BmmProperty
   */
  public BmmProperty flatProperties()
  {
  }


}

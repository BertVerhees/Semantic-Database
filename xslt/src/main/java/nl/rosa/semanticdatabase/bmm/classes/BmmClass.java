package nl.rosa.semanticdatabase.bmm.classes;

/**
 * 
 * Meta-type corresponding a class definition in an object model.
 * Inheritance is specified by the ancestors attribute, which contains a list of types rather than classes.
 * Inheritance is thus understood in BMM as a stated relationship between classes.
 * The equivalent relationship between types is conformance.
 * Note unlike UML, the name is just the root name, even if the class is generic.
 * Use type_name() to obtain the qualified type name.
 * 
*/
public interface BmmClass extends BmmModule {

/* * ATTRIBUTE * */

/**
 * 
 * List of immediate inheritance parents.
 * 
*/
    Hash<string,bmmModelType> getAncestors();
    void setAncestors(value Hash<string,bmmModelType>);

/**
 * 
 * Package this class belongs to.
 * 
*/
    BmmPackage getPackage();
    void setPackage(value BmmPackage);

/**
 * 
 * List of attributes defined in this class.
 * 
*/
    Hash<string,bmmProperty> getProperties();
    void setProperties(value Hash<string,bmmProperty>);

/**
 * 
 * Reference to original source schema defining this class.
 * Useful for UI tools to determine which original schema file to open for a given class for manual editing.
 * 
*/
    String getSourceSchemaId();
    void setSourceSchemaId(value String);

/**
 * 
 * List of computed references to base classes of immediate inheritance descendants, derived when members of ancestors are attached at creation time.
 * 
*/
    List<bmmClass> getImmediateDescendants();
    void setImmediateDescendants(value List<bmmClass>);

/**
 * 
 * True if this definition overrides a class of the same name in an included schema.
 * 
*/
    Boolean getIsOverride();
    void setIsOverride(value Boolean);

/**
 * 
 * List of constants defined in this class.
 * 
*/
    Hash<string,bmmConstant> getConstants();
    void setConstants(value Hash<string,bmmConstant>);

/**
 * 
 * List of functions defined in this class.
 * 
*/
    Hash<string,bmmFunction> getFunctions();
    void setFunctions(value Hash<string,bmmFunction>);

/**
 * 
 * List of procedures defined in this class.
 * 
*/
    Hash<string,bmmProcedure> getProcedures();
    void setProcedures(value Hash<string,bmmProcedure>);

/**
 * 
 * True if this class represents a type considered to be primitive in the type system, i.e.
 * any typically built-in or standard library type such as String, Date, Hash<K,V> etc.
 * 
*/
    Boolean {default = false} getIsPrimitive();
    void setIsPrimitive(value Boolean {default = false});

/**
 * 
 * True if this class is marked as abstract, i.e.
 * direct instances cannot be created from its direct type.
 * 
*/
    Boolean {default = false} getIsAbstract();
    void setIsAbstract(value Boolean {default = false});

/**
 * 
 * 
 * 
*/
    List<bmmAssertion> getInvariants();
    void setInvariants(value List<bmmAssertion>);

/**
 * 
 * Subset of procedures that may be used to initialise a new instance of an object, and whose execution will guarantee that class invariants are satisfied.
 * 
*/
    Hash<string,bmmProcedure> getCreators();
    void setCreators(value Hash<string,bmmProcedure>);

/**
 * 
 * Subset of creators that create a new instance from a single argument of another type.
 * 
*/
    Hash<string,bmmProcedure> getConverters();
    void setConverters(value Hash<string,bmmProcedure>);

/**
 * 
 * List of feature groups in this class.
 * 
*/
    List<bmmFeatureGroup> getFeatureGroups();
    void setFeatureGroups(value List<bmmFeatureGroup>);

/* * FUNCTION * */

/**
 * 
 * Generate a type object that represents the type for which this class is the definer.
 * type (): BMM_MODEL_TYPE
 * 
*/
    BmmModelType type ();

/**
 * 
 * List of all inheritance parent class names, recursively.
 * all_ancestors (): List<String>
 * 
*/
    List<string> allAncestors ();

/**
 * 
 * Compute all descendants by following immediate_descendants.
 * all_descendants (): List<String>
 * 
*/
    List<string> allDescendants ();

/**
 * 
 * List of names of immediate supplier classes, including concrete generic parameters, concrete descendants of abstract statically defined types, and inherited suppliers.
 * (Where generics are unconstrained, no class name is added, since logically it would be Any and this can always be assumed anyway).
 * This list includes primitive types.
 * suppliers (): List<String>
 * 
*/
    List<string> suppliers ();

/**
 * 
 * Same as suppliers minus primitive types, as defined in input schema.
 * suppliers_non_primitive (): List<String>
 * 
*/
    List<string> suppliersNonPrimitive ();

/**
 * 
 * List of names of all classes in full supplier closure, including concrete generic parameters; (where generics are unconstrained, no class name is added, since logically it would be Any and this can always be assumed anyway).
 * This list includes primitive types.
 * supplier_closure (): List<String>
 * 
*/
    List<string> supplierClosure ();

/**
 * 
 * Fully qualified package name, of form: package.package.
 * package_path (): String
 * 
*/
    String packagePath ();

/**
 * 
 * Fully qualified class name, of form: package.package.CLASS with package path in lower-case and class in original case.
 * class_path (): String
 * 
*/
    String classPath ();

/**
 * 
 * True if this class is designated a primitive type within the overall type system of the schema.
 * Set from schema.
 * is_primitive (): Boolean
 * 
*/
    Boolean isPrimitive ();

/**
 * 
 * True if this class is abstract in its model.
 * Value provided from an underlying data property set at creation or construction time.
 * is_abstract (): Boolean
 * 
*/
    Boolean isAbstract ();

/**
 * 
 * List of all feature definitions introduced in this class.
 * features (): List<BMM_CLASS_FEATURE>
 * 
*/
    List<bmmClassFeature> features ();

/**
 * 
 * Consolidated list of all feature definitions from this class and all inheritance ancestors.
 * flat_features (): List<BMM_CLASS_FEATURE>
 * 
*/
    List<bmmClassFeature> flatFeatures ();

/**
 * 
 * List of all properties due to current and ancestor classes, keyed by property name.
 * flat_properties (): List<BMM_PROPERTY>
 * 
*/
    List<bmmProperty> flatProperties ();

}

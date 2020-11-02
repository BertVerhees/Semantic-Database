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
    Map<String,BmmModelType> getAncestors();
    void setAncestors(Map<String,BmmModelType> value);

/**
 * 
 * Package this class belongs to.
 * 
*/
    BmmPackage getPackage();
    void setPackage(BmmPackage value);

/**
 * 
 * List of attributes defined in this class.
 * 
*/
    Map<String,BmmProperty> getProperties();
    void setProperties(Map<String,BmmProperty> value);

/**
 * 
 * Reference to original source schema defining this class.
 * Useful for UI tools to determine which original schema file to open for a given class for manual editing.
 * 
*/
    String getSourceSchemaId();
    void setSourceSchemaId(String value);

/**
 * 
 * List of computed references to base classes of immediate inheritance descendants, derived when members of ancestors are attached at creation time.
 * 
*/
    List<BmmClass> getImmediateDescendants();
    void setImmediateDescendants(List<BmmClass> value);

/**
 * 
 * True if this definition overrides a class of the same name in an included schema.
 * 
*/
    Boolean getIsOverride();
    void setIsOverride(Boolean value);

/**
 * 
 * List of constants defined in this class.
 * 
*/
    Map<String,BmmConstant> getConstants();
    void setConstants(Map<String,BmmConstant> value);

/**
 * 
 * List of functions defined in this class.
 * 
*/
    Map<String,BmmFunction> getFunctions();
    void setFunctions(Map<String,BmmFunction> value);

/**
 * 
 * List of procedures defined in this class.
 * 
*/
    Map<String,BmmProcedure> getProcedures();
    void setProcedures(Map<String,BmmProcedure> value);

/**
 * 
 * 
 * 
*/
    List<BmmAssertion> getInvariants();
    void setInvariants(List<BmmAssertion> value);

/**
 * 
 * Subset of procedures that may be used to initialise a new instance of an object, and whose execution will guarantee that class invariants are satisfied.
 * 
*/
    Map<String,BmmProcedure> getCreators();
    void setCreators(Map<String,BmmProcedure> value);

/**
 * 
 * Subset of creators that create a new instance from a single argument of another type.
 * 
*/
    Map<String,BmmProcedure> getConverters();
    void setConverters(Map<String,BmmProcedure> value);

/**
 * 
 * List of feature groups in this class.
 * 
*/
    List<BmmFeatureGroup> getFeatureGroups();
    void setFeatureGroups(List<BmmFeatureGroup> value);

/* * FUNCTION * */

/**
 * 
 * Generate a type object that represents the type for which this class is the definer.
 * 
*/
    BmmModelType  type();

/**
 * 
 * List of all inheritance parent class names, recursively.
 * 
*/
    List<String>  all_ancestors();

/**
 * 
 * Compute all descendants by following immediate_descendants.
 * 
*/
    List<String>  all_descendants();

/**
 * 
 * List of names of immediate supplier classes, including concrete generic parameters, concrete descendants of abstract statically defined types, and inherited suppliers.
 * (Where generics are unconstrained, no class name is added, since logically it would be Any and this can always be assumed anyway).
 * This list includes primitive types.
 * 
*/
    List<String>  suppliers();

/**
 * 
 * Same as suppliers minus primitive types, as defined in input schema.
 * 
*/
    List<String>  suppliers_non_primitive();

/**
 * 
 * List of names of all classes in full supplier closure, including concrete generic parameters; (where generics are unconstrained, no class name is added, since logically it would be Any and this can always be assumed anyway).
 * This list includes primitive types.
 * 
*/
    List<String>  supplier_closure();

/**
 * 
 * Fully qualified package name, of form: package.package.
 * 
*/
    String  package_path();

/**
 * 
 * Fully qualified class name, of form: package.package.CLASS with package path in lower-case and class in original case.
 * 
*/
    String  class_path();

/**
 * 
 * True if this class is designated a primitive type within the overall type system of the schema.
 * Set from schema.
 * 
*/
    Boolean  is_primitive();

/**
 * 
 * True if this class is abstract in its model.
 * Value provided from an underlying data property set at creation or construction time.
 * 
*/
    Boolean  is_abstract();

/**
 * 
 * List of all feature definitions introduced in this class.
 * 
*/
    List<BmmClassFeature>  features();

/**
 * 
 * Consolidated list of all feature definitions from this class and all inheritance ancestors.
 * 
*/
    List<BmmClassFeature>  flat_features();

/**
 * 
 * List of all properties due to current and ancestor classes, keyed by property name.
 * 
*/
    List<BmmProperty>  flat_properties();

}

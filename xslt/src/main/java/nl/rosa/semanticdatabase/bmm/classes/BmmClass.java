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
    BmmClass getAncestors();
    void setAncestors(BmmClass value);

/**
 * 
 * Package this class belongs to.
 * 
*/
    BmmClass getPackage();
    void setPackage(BmmClass value);

/**
 * 
 * List of attributes defined in this class.
 * 
*/
    BmmClass getProperties();
    void setProperties(BmmClass value);

/**
 * 
 * Reference to original source schema defining this class.
 * Useful for UI tools to determine which original schema file to open for a given class for manual editing.
 * 
*/
    BmmClass getSourceSchemaId();
    void setSourceSchemaId(BmmClass value);

/**
 * 
 * List of computed references to base classes of immediate inheritance descendants, derived when members of ancestors are attached at creation time.
 * 
*/
    BmmClass getImmediateDescendants();
    void setImmediateDescendants(BmmClass value);

/**
 * 
 * True if this definition overrides a class of the same name in an included schema.
 * 
*/
    BmmClass getIsOverride();
    void setIsOverride(BmmClass value);

/**
 * 
 * List of constants defined in this class.
 * 
*/
    BmmClass getConstants();
    void setConstants(BmmClass value);

/**
 * 
 * List of functions defined in this class.
 * 
*/
    BmmClass getFunctions();
    void setFunctions(BmmClass value);

/**
 * 
 * List of procedures defined in this class.
 * 
*/
    BmmClass getProcedures();
    void setProcedures(BmmClass value);

/**
 * 
 * 
 * 
*/
    BmmClass getInvariants();
    void setInvariants(BmmClass value);

/**
 * 
 * Subset of procedures that may be used to initialise a new instance of an object, and whose execution will guarantee that class invariants are satisfied.
 * 
*/
    BmmClass getCreators();
    void setCreators(BmmClass value);

/**
 * 
 * Subset of creators that create a new instance from a single argument of another type.
 * 
*/
    BmmClass getConverters();
    void setConverters(BmmClass value);

/**
 * 
 * List of feature groups in this class.
 * 
*/
    BmmClass getFeatureGroups();
    void setFeatureGroups(BmmClass value);

/* * FUNCTION * */

/**
 * 
 * Generate a type object that represents the type for which this class is the definer.
 * 
*/
    BmmClass  type();

/**
 * 
 * List of all inheritance parent class names, recursively.
 * 
*/
    BmmClass  all_ancestors();

/**
 * 
 * Compute all descendants by following immediate_descendants.
 * 
*/
    BmmClass  all_descendants();

/**
 * 
 * List of names of immediate supplier classes, including concrete generic parameters, concrete descendants of abstract statically defined types, and inherited suppliers.
 * (Where generics are unconstrained, no class name is added, since logically it would be Any and this can always be assumed anyway).
 * This list includes primitive types.
 * 
*/
    BmmClass  suppliers();

/**
 * 
 * Same as suppliers minus primitive types, as defined in input schema.
 * 
*/
    BmmClass  suppliers_non_primitive();

/**
 * 
 * List of names of all classes in full supplier closure, including concrete generic parameters; (where generics are unconstrained, no class name is added, since logically it would be Any and this can always be assumed anyway).
 * This list includes primitive types.
 * 
*/
    BmmClass  supplier_closure();

/**
 * 
 * Fully qualified package name, of form: package.package.
 * 
*/
    BmmClass  package_path();

/**
 * 
 * Fully qualified class name, of form: package.package.CLASS with package path in lower-case and class in original case.
 * 
*/
    BmmClass  class_path();

/**
 * 
 * True if this class is designated a primitive type within the overall type system of the schema.
 * Set from schema.
 * 
*/
    BmmClass  is_primitive();

/**
 * 
 * True if this class is abstract in its model.
 * Value provided from an underlying data property set at creation or construction time.
 * 
*/
    BmmClass  is_abstract();

/**
 * 
 * List of all feature definitions introduced in this class.
 * 
*/
    BmmClass  features();

/**
 * 
 * Consolidated list of all feature definitions from this class and all inheritance ancestors.
 * 
*/
    BmmClass  flat_features();

/**
 * 
 * List of all properties due to current and ancestor classes, keyed by property name.
 * 
*/
    BmmClass  flat_properties();

}

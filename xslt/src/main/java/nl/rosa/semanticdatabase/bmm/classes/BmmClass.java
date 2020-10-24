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

/**
 * 
 * List of immediate inheritance parents.
 * 
*/
Hash<string,bmmModelType> getAncestors()
setAncestors(var Hash<string,bmmModelType>)

/**
 * 
 * Package this class belongs to.
 * 
*/
BmmPackage getPackage()
setPackage(var BmmPackage)

/**
 * 
 * List of attributes defined in this class.
 * 
*/
Hash<string,bmmProperty> getProperties()
setProperties(var Hash<string,bmmProperty>)

/**
 * 
 * Reference to original source schema defining this class.
 * Useful for UI tools to determine which original schema file to open for a given class for manual editing.
 * 
*/
String getSourceSchemaId()
setSourceSchemaId(var String)

/**
 * 
 * List of computed references to base classes of immediate inheritance descendants, derived when members of ancestors are attached at creation time.
 * 
*/
List<bmmClass> getImmediateDescendants()
setImmediateDescendants(var List<bmmClass>)

/**
 * 
 * True if this definition overrides a class of the same name in an included schema.
 * 
*/
Boolean getIsOverride()
setIsOverride(var Boolean)

/**
 * 
 * List of constants defined in this class.
 * 
*/
Hash<string,bmmConstant> getConstants()
setConstants(var Hash<string,bmmConstant>)

/**
 * 
 * List of functions defined in this class.
 * 
*/
Hash<string,bmmFunction> getFunctions()
setFunctions(var Hash<string,bmmFunction>)

/**
 * 
 * List of procedures defined in this class.
 * 
*/
Hash<string,bmmProcedure> getProcedures()
setProcedures(var Hash<string,bmmProcedure>)

/**
 * 
 * True if this class represents a type considered to be primitive in the type system, i.e.
 * any typically built-in or standard library type such as String, Date, Hash<K,V> etc.
 * 
*/
Boolean {default = false} getIsPrimitive()
setIsPrimitive(var Boolean {default = false})

/**
 * 
 * True if this class is marked as abstract, i.e.
 * direct instances cannot be created from its direct type.
 * 
*/
Boolean {default = false} getIsAbstract()
setIsAbstract(var Boolean {default = false})

/**
 * 
 * 
 * 
*/
List<bmmAssertion> getInvariants()
setInvariants(var List<bmmAssertion>)

/**
 * 
 * Subset of procedures that may be used to initialise a new instance of an object, and whose execution will guarantee that class invariants are satisfied.
 * 
*/
Hash<string,bmmProcedure> getCreators()
setCreators(var Hash<string,bmmProcedure>)

/**
 * 
 * Subset of creators that create a new instance from a single argument of another type.
 * 
*/
Hash<string,bmmProcedure> getConverters()
setConverters(var Hash<string,bmmProcedure>)

/**
 * 
 * List of feature groups in this class.
 * 
*/
List<bmmFeatureGroup> getFeatureGroups()
setFeatureGroups(var List<bmmFeatureGroup>)

}

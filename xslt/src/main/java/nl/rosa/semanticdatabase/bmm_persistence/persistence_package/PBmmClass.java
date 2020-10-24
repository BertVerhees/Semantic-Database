package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Definition of persistent form of BMM_CLASS for serialisation to ODIN, JSON, XML etc.
 * 
*/
public interface PBmmClass extends PBmmModelElement {

/**
 * 
 * Name of the class.
 * Persisted attribute.
 * 
*/
String getName()
setName(var String)

/**
 * 
 * List of immediate inheritance parents.
 * If there are generic ancestors, use ancestor_defs instead.
 * Persisted attribute.
 * 
*/
List<string> getAncestors()
setAncestors(var List<string>)

/**
 * 
 * List of attributes defined in this class.
 * Persistent attribute.
 * 
*/
Hash<string,pBmmProperty> getProperties()
setProperties(var Hash<string,pBmmProperty>)

/**
 * 
 * True if this is an abstract type.
 * Persisted attribute.
 * 
*/
Boolean getIsAbstract()
setIsAbstract(var Boolean)

/**
 * 
 * True if this class definition overrides one found in an included schema.
 * 
*/
Boolean getIsOverride()
setIsOverride(var Boolean)

/**
 * 
 * List of generic parameter definitions.
 * Persisted attribute.
 * 
*/
Hash<string,pBmmGenericParameter> getGenericParameterDefs()
setGenericParameterDefs(var Hash<string,pBmmGenericParameter>)

/**
 * 
 * Reference to original source schema defining this class.
 * Set during BMM_SCHEMA materialise.
 * Useful for GUI tools to enable user to edit the schema file containing a given class (i.e.
 * taking into account that a class may be in any of the schemas in a schema inclusion hierarchy).
 * 
*/
String getSourceSchemaId()
setSourceSchemaId(var String)

/**
 * 
 * BMM_CLASS object built by create_bmm_class_definition and populate_bmm_class_definition.
 * 
*/
BmmClass getBmmClass()
setBmmClass(var BmmClass)

/**
 * 
 * Unique id generated for later comparison during merging, in order to detect if two classes are the same.
 * Assigned in post-load processing.
 * 
*/
Integer getUid()
setUid(var Integer)

/**
 * 
 * List of structured inheritance ancestors, used only in the case of generic inheritance.
 * Persisted attribute.
 * 
*/
List<pBmmGenericType> getAncestorDefs()
setAncestorDefs(var List<pBmmGenericType>)

/**
 * 
 * Create bmm_class_definition.
 * 
*/
getCreateBmmClass()
setCreateBmmClass(var )

}

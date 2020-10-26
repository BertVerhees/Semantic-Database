package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Definition of persistent form of BMM_CLASS for serialisation to ODIN, JSON, XML etc.
 * 
*/
public interface PBmmClass extends PBmmModelElement {

/* * ATTRIBUTE * */

/**
 * 
 * Name of the class.
 * Persisted attribute.
 * 
*/
String getName();
void setName(var String);

/**
 * 
 * List of immediate inheritance parents.
 * If there are generic ancestors, use ancestor_defs instead.
 * Persisted attribute.
 * 
*/
List<string> getAncestors();
void setAncestors(var List<string>);

/**
 * 
 * List of attributes defined in this class.
 * Persistent attribute.
 * 
*/
Hash<string,pBmmProperty> getProperties();
void setProperties(var Hash<string,pBmmProperty>);

/**
 * 
 * True if this is an abstract type.
 * Persisted attribute.
 * 
*/
Boolean getIsAbstract();
void setIsAbstract(var Boolean);

/**
 * 
 * True if this class definition overrides one found in an included schema.
 * 
*/
Boolean getIsOverride();
void setIsOverride(var Boolean);

/**
 * 
 * List of generic parameter definitions.
 * Persisted attribute.
 * 
*/
Hash<string,pBmmGenericParameter> getGenericParameterDefs();
void setGenericParameterDefs(var Hash<string,pBmmGenericParameter>);

/**
 * 
 * Reference to original source schema defining this class.
 * Set during BMM_SCHEMA materialise.
 * Useful for GUI tools to enable user to edit the schema file containing a given class (i.e.
 * taking into account that a class may be in any of the schemas in a schema inclusion hierarchy).
 * 
*/
String getSourceSchemaId();
void setSourceSchemaId(var String);

/**
 * 
 * BMM_CLASS object built by create_bmm_class_definition and populate_bmm_class_definition.
 * 
*/
BmmClass getBmmClass();
void setBmmClass(var BmmClass);

/**
 * 
 * Unique id generated for later comparison during merging, in order to detect if two classes are the same.
 * Assigned in post-load processing.
 * 
*/
Integer getUid();
void setUid(var Integer);

/**
 * 
 * List of structured inheritance ancestors, used only in the case of generic inheritance.
 * Persisted attribute.
 * 
*/
List<pBmmGenericType> getAncestorDefs();
void setAncestorDefs(var List<pBmmGenericType>);

/* * FUNCTION * */

/**
 * 
 * True if this class is a generic class.
 * is_generic (): Boolean Post: Result := generic_parameter_defs /= Void
 * 
*/

/**
 * 
 * Create bmm_class_definition.
 * create_bmm_class
 * 
*/

/**
 * 
 * Add remaining model elements from Current to bmm_class_definition.
 * populate_bmm_class ( a_bmm_schema: BMM_MODEL[1] )
 * 
*/

}

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
    void setName(String value);

/**
 * 
 * List of immediate inheritance parents.
 * If there are generic ancestors, use ancestor_defs instead.
 * Persisted attribute.
 * 
*/
    List<String> getAncestors();
    void setAncestors(List<String> value);

/**
 * 
 * List of attributes defined in this class.
 * Persistent attribute.
 * 
*/
    Map<String,PBmmProperty> getProperties();
    void setProperties(Map<String,PBmmProperty> value);

/**
 * 
 * True if this is an abstract type.
 * Persisted attribute.
 * 
*/
    Boolean getIsAbstract();
    void setIsAbstract(Boolean value);

/**
 * 
 * True if this class definition overrides one found in an included schema.
 * 
*/
    Boolean getIsOverride();
    void setIsOverride(Boolean value);

/**
 * 
 * List of generic parameter definitions.
 * Persisted attribute.
 * 
*/
    Map<String,PBmmGenericParameter> getGenericParameterDefs();
    void setGenericParameterDefs(Map<String,PBmmGenericParameter> value);

/**
 * 
 * Reference to original source schema defining this class.
 * Set during BMM_SCHEMA materialise.
 * Useful for GUI tools to enable user to edit the schema file containing a given class (i.e.
 * taking into account that a class may be in any of the schemas in a schema inclusion hierarchy).
 * 
*/
    String getSourceSchemaId();
    void setSourceSchemaId(String value);

/**
 * 
 * BMM_CLASS object built by create_bmm_class_definition and populate_bmm_class_definition.
 * 
*/
    BmmClass getBmmClass();
    void setBmmClass(BmmClass value);

/**
 * 
 * Unique id generated for later comparison during merging, in order to detect if two classes are the same.
 * Assigned in post-load processing.
 * 
*/
    Integer getUid();
    void setUid(Integer value);

/**
 * 
 * List of structured inheritance ancestors, used only in the case of generic inheritance.
 * Persisted attribute.
 * 
*/
    List<PBmmGenericType> getAncestorDefs();
    void setAncestorDefs(List<PBmmGenericType> value);

/**
 * 
 * Create bmm_class_definition.
 * 
*/
     get();
    void set( value);

/* * FUNCTION * */

/**
 * 
 * True if this class is a generic class.
 * 
*/
    = generic_parameter_defs /= Void  is_generic();

/**
 * 
 * Add remaining model elements from Current to bmm_class_definition.
 * 
*/
    void  populate_bmm_class();

}

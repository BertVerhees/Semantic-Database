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
     getName();
    void setName( value);

/**
 * 
 * List of immediate inheritance parents.
 * If there are generic ancestors, use ancestor_defs instead.
 * Persisted attribute.
 * 
*/
     getAncestors();
    void setAncestors( value);

/**
 * 
 * List of attributes defined in this class.
 * Persistent attribute.
 * 
*/
     getProperties();
    void setProperties( value);

/**
 * 
 * True if this is an abstract type.
 * Persisted attribute.
 * 
*/
     getIsAbstract();
    void setIsAbstract( value);

/**
 * 
 * True if this class definition overrides one found in an included schema.
 * 
*/
     getIsOverride();
    void setIsOverride( value);

/**
 * 
 * List of generic parameter definitions.
 * Persisted attribute.
 * 
*/
     getGenericParameterDefs();
    void setGenericParameterDefs( value);

/**
 * 
 * Reference to original source schema defining this class.
 * Set during BMM_SCHEMA materialise.
 * Useful for GUI tools to enable user to edit the schema file containing a given class (i.e.
 * taking into account that a class may be in any of the schemas in a schema inclusion hierarchy).
 * 
*/
     getSourceSchemaId();
    void setSourceSchemaId( value);

/**
 * 
 * BMM_CLASS object built by create_bmm_class_definition and populate_bmm_class_definition.
 * 
*/
     getBmmClass();
    void setBmmClass( value);

/**
 * 
 * Unique id generated for later comparison during merging, in order to detect if two classes are the same.
 * Assigned in post-load processing.
 * 
*/
     getUid();
    void setUid( value);

/**
 * 
 * List of structured inheritance ancestors, used only in the case of generic inheritance.
 * Persisted attribute.
 * 
*/
     getAncestorDefs();
    void setAncestorDefs( value);

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
      is_generic();

/**
 * 
 * Add remaining model elements from Current to bmm_class_definition.
 * 
*/
      populate_bmm_class();

}

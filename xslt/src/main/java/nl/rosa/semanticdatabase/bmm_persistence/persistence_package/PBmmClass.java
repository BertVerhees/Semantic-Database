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
    PBmmClass getName();
    void setName(PBmmClass value);

/**
 * 
 * List of immediate inheritance parents.
 * If there are generic ancestors, use ancestor_defs instead.
 * Persisted attribute.
 * 
*/
    PBmmClass getAncestors();
    void setAncestors(PBmmClass value);

/**
 * 
 * List of attributes defined in this class.
 * Persistent attribute.
 * 
*/
    PBmmClass getProperties();
    void setProperties(PBmmClass value);

/**
 * 
 * True if this is an abstract type.
 * Persisted attribute.
 * 
*/
    PBmmClass getIsAbstract();
    void setIsAbstract(PBmmClass value);

/**
 * 
 * True if this class definition overrides one found in an included schema.
 * 
*/
    PBmmClass getIsOverride();
    void setIsOverride(PBmmClass value);

/**
 * 
 * List of generic parameter definitions.
 * Persisted attribute.
 * 
*/
    PBmmClass getGenericParameterDefs();
    void setGenericParameterDefs(PBmmClass value);

/**
 * 
 * Reference to original source schema defining this class.
 * Set during BMM_SCHEMA materialise.
 * Useful for GUI tools to enable user to edit the schema file containing a given class (i.e.
 * taking into account that a class may be in any of the schemas in a schema inclusion hierarchy).
 * 
*/
    PBmmClass getSourceSchemaId();
    void setSourceSchemaId(PBmmClass value);

/**
 * 
 * BMM_CLASS object built by create_bmm_class_definition and populate_bmm_class_definition.
 * 
*/
    PBmmClass getBmmClass();
    void setBmmClass(PBmmClass value);

/**
 * 
 * Unique id generated for later comparison during merging, in order to detect if two classes are the same.
 * Assigned in post-load processing.
 * 
*/
    PBmmClass getUid();
    void setUid(PBmmClass value);

/**
 * 
 * List of structured inheritance ancestors, used only in the case of generic inheritance.
 * Persisted attribute.
 * 
*/
    PBmmClass getAncestorDefs();
    void setAncestorDefs(PBmmClass value);

/**
 * 
 * Create bmm_class_definition.
 * 
*/
    PBmmClass get();
    void set(PBmmClass value);

/* * FUNCTION * */

/**
 * 
 * True if this class is a generic class.
 * 
*/
    PBmmClass  is_generic();

/**
 * 
 * Add remaining model elements from Current to bmm_class_definition.
 * 
*/
    PBmmClass  populate_bmm_class();

}

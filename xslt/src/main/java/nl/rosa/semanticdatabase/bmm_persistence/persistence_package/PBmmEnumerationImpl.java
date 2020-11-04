package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persistent form of BMM_ENUMERATION attributes.
 * 
*/
public class PBmmEnumerationImpl implements PBmmClass{

    //***** PBmmEnumeration *****

/* * FIELDS * */

/**
 * 
 * 
 * 
*/
    private List<String> item_names;

        />
    
/**
 * 
 * 
 * 
*/
    private List<Any> item_values;

        />
    
/**
 * 
 * BMM_CLASS object build by create_bmm_class_definition and populate_bmm_class_definition.
 * 
*/
    private BmmEnumeration bmm_class;

        />
    
    //***** PBmmClass *****

/* * FIELDS * */

/**
 * 
 * Name of the class.
 * Persisted attribute.
 * 
*/
    private String name;

        />
    
/**
 * 
 * List of immediate inheritance parents.
 * If there are generic ancestors, use ancestor_defs instead.
 * Persisted attribute.
 * 
*/
    private List<String> ancestors;

        />
    
/**
 * 
 * List of attributes defined in this class.
 * Persistent attribute.
 * 
*/
    private Map<String,PBmmProperty> properties;

        />
    
/**
 * 
 * True if this is an abstract type.
 * Persisted attribute.
 * 
*/
    private Boolean is_abstract;

        />
    
/**
 * 
 * True if this class definition overrides one found in an included schema.
 * 
*/
    private Boolean is_override;

        />
    
/**
 * 
 * List of generic parameter definitions.
 * Persisted attribute.
 * 
*/
    private Map<String,PBmmGenericParameter> generic_parameter_defs;

        />
    
/**
 * 
 * Reference to original source schema defining this class.
 * Set during BMM_SCHEMA materialise.
 * Useful for GUI tools to enable user to edit the schema file containing a given class (i.e.
 * taking into account that a class may be in any of the schemas in a schema inclusion hierarchy).
 * 
*/
    private String source_schema_id;

        />
    
/**
 * 
 * BMM_CLASS object built by create_bmm_class_definition and populate_bmm_class_definition.
 * 
*/
    private BmmClass bmm_class;

        />
    
/**
 * 
 * Unique id generated for later comparison during merging, in order to detect if two classes are the same.
 * Assigned in post-load processing.
 * 
*/
    private Integer uid;

        />
    
/**
 * 
 * List of structured inheritance ancestors, used only in the case of generic inheritance.
 * Persisted attribute.
 * 
*/
    private List<PBmmGenericType> ancestor_defs;

        />
    
/**
 * 
 * Create bmm_class_definition.
 * 
*/
    private  ;

        />
    
    //***** PBmmModelElement *****

/* * FIELDS * */

/**
 * 
 * Optional documentation of this element.
 * 
*/
    private String documentation;

        />
    
/* * ATTRIBUTE * */

/* * POJO * */

/* * FUNCTION * */

}

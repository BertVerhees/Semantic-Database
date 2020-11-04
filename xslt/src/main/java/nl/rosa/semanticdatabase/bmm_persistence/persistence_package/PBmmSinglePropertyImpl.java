package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persistent form of BMM_SINGLE_PROPERTY.
 * 
*/
public class PBmmSinglePropertyImpl implements PBmmProperty{

    //***** PBmmSingleProperty *****

/* * FIELDS * */

/**
 * 
 * If the type is a simple type, then this attribute will hold the type name.
 * If the type is a container or generic, then type_ref will hold the type definition.
 * The resulting type is generated in type_def.
 * 
*/
    private String type;

        />
    
/**
 * 
 * Type definition of this property computed from type for later use in bmm_property.
 * 
*/
    private PBmmSimpleType type_ref;

        />
    
/**
 * 
 * BMM_PROPERTY created by create_bmm_property_definition.
 * 
*/
    private BmmUnitaryProperty bmm_property;

        />
    
    //***** PBmmProperty *****

/* * FIELDS * */

/**
 * 
 * Name of this property within its class.
 * Persisted attribute.
 * 
*/
    private String name;

        />
    
/**
 * 
 * True if this property is mandatory in its class.
 * Persisted attribute.
 * 
*/
    private Boolean is_mandatory;

        />
    
/**
 * 
 * True if this property is computed rather than stored in objects of this class.
 * Persisted Attribute.
 * 
*/
    private Boolean is_computed;

        />
    
/**
 * 
 * True if this property is info model 'infrastructure' rather than 'data'.
 * Persisted attribute.
 * 
*/
    private Boolean is_im_infrastructure;

        />
    
/**
 * 
 * True if this property is info model 'runtime' settable property.
 * Persisted attribute.
 * 
*/
    private Boolean is_im_runtime;

        />
    
/**
 * 
 * Type definition of this property, if not a simple String type reference.
 * Persisted attribute.
 * 
*/
    private PBmmType type_def;

        />
    
/**
 * 
 * BMM_PROPERTY created by create_bmm_property_definition.
 * 
*/
    private BmmProperty bmm_property;

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

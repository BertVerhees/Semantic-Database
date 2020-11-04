package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persistent form of BMM_GENERIC_TYPE.
 * 
*/
public class PBmmGenericTypeImpl implements PBmmBaseType{

    //***** PBmmGenericType *****

/* * FIELDS * */

/**
 * 
 * Root type of this generic type, e.g.
 * Interval in Interval<Integer>.
 * 
*/
    private String root_type;

        />
    
/**
 * 
 * Generic parameters of the root_type in this type specifier if non-simple types.
 * The order must match the order of the owning class’s formal generic parameter declarations.
 * Persistent attribute.
 * 
*/
    private List<PBmmType> generic_parameter_defs;

        />
    
/**
 * 
 * Generic parameters of the root_type in this type specifier, if simple types.
 * The order must match the order of the owning class’s formal generic parameter declarations.
 * Persistent attribute.
 * 
*/
    private List<String> generic_parameters;

        />
    
/**
 * 
 * Result of create_bmm_type() call.
 * 
*/
    private BmmGenericType bmm_type;

        />
    
    //***** PBmmBaseType *****

/* * FIELDS * */

/**
 * 
 * 
 * 
*/
    private String value_constraint;

        />
    
    //***** PBmmType *****

/* * FIELDS * */

/**
 * 
 * Result of create_bmm_type() call.
 * 
*/
    private BmmType bmm_type;

        />
    
/* * ATTRIBUTE * */

/* * POJO * */

/* * FUNCTION * */

}

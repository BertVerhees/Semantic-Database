package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persistent form of BMM_GENERIC_PARAMETER.
 * 
*/
public class PBmmGenericParameterImpl implements PBmmModelElement{

    //***** PBmmGenericParameter *****

/* * FIELDS * */

/**
 * 
 * Name of the parameter, e.g.
 * 'T' etc.
 * Persisted attribute.
 * Name is limited to 1 character, upper case.
 * 
*/
    private String name;

        />
    
/**
 * 
 * Optional conformance constraint - the name of a type to which a concrete substitution of this generic parameter must conform.
 * Persisted attribute.
 * 
*/
    private String conforms_to_type;

        />
    
/**
 * 
 * BMM_GENERIC_PARAMETER created by create_bmm_generic_parameter.
 * 
*/
    private BmmParameterType bmm_generic_parameter;

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

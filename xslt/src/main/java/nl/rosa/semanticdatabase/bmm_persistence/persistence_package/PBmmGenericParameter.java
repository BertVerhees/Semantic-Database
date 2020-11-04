package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persistent form of BMM_GENERIC_PARAMETER.
 * 
*/
public interface PBmmGenericParameter extends PBmmModelElement {

/* * ATTRIBUTE * */

/**
 * 
 * Name of the parameter, e.g.
 * 'T' etc.
 * Persisted attribute.
 * Name is limited to 1 character, upper case.
 * 
*/
    String getName();
    void setName(String value);

/**
 * 
 * Optional conformance constraint - the name of a type to which a concrete substitution of this generic parameter must conform.
 * Persisted attribute.
 * 
*/
    String getConformsToType();
    void setConformsToType(String value);

/**
 * 
 * BMM_GENERIC_PARAMETER created by create_bmm_generic_parameter.
 * 
*/
    BmmParameterType getBmmGenericParameter();
    void setBmmGenericParameter(BmmParameterType value);

/* * FUNCTION * */

/**
 * 
 * Create bmm_generic_parameter.
 * 
*/
    void  create_bmm_generic_parameter();

/* * CONSTANTS * */

}

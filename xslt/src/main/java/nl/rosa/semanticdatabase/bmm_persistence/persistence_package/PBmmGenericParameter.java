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
    PBmmGenericParameter getName();
    void setName(PBmmGenericParameter value);

/**
 * 
 * Optional conformance constraint - the name of a type to which a concrete substitution of this generic parameter must conform.
 * Persisted attribute.
 * 
*/
    PBmmGenericParameter getConformsToType();
    void setConformsToType(PBmmGenericParameter value);

/**
 * 
 * BMM_GENERIC_PARAMETER created by create_bmm_generic_parameter.
 * 
*/
    PBmmGenericParameter getBmmGenericParameter();
    void setBmmGenericParameter(PBmmGenericParameter value);

/* * FUNCTION * */

/**
 * 
 * Create bmm_generic_parameter.
 * 
*/
    PBmmGenericParameter  create_bmm_generic_parameter();

}

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
void setName(var String);

/**
 * 
 * Optional conformance constraint - the name of a type to which a concrete substitution of this generic parameter must conform.
 * Persisted attribute.
 * 
*/
String getConformsToType();
void setConformsToType(var String);

/**
 * 
 * BMM_GENERIC_PARAMETER created by create_bmm_generic_parameter.
 * 
*/
BmmParameterType getBmmGenericParameter();
void setBmmGenericParameter(var BmmParameterType);

/* * FUNCTION * */

/**
 * 
 * Create bmm_generic_parameter.
 * create_bmm_generic_parameter ( a_bmm_schema: BMM_MODEL[1] )
 * 
*/

}

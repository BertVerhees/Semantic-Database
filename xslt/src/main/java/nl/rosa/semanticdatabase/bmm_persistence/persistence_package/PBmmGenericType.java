package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

/**
 * 
 * Persistent form of BMM_GENERIC_TYPE.
 * 
*/
public interface PBmmGenericType extends PBmmBaseType {

/* * ATTRIBUTE * */

/**
 * 
 * Root type of this generic type, e.g.
 * Interval in Interval<Integer>.
 * 
*/
String getRootType();
void setRootType(value String);

/**
 * 
 * Generic parameters of the root_type in this type specifier if non-simple types.
 * The order must match the order of the owning class’s formal generic parameter declarations.
 * Persistent attribute.
 * 
*/
List<pBmmType> getGenericParameterDefs();
void setGenericParameterDefs(value List<pBmmType>);

/**
 * 
 * Generic parameters of the root_type in this type specifier, if simple types.
 * The order must match the order of the owning class’s formal generic parameter declarations.
 * Persistent attribute.
 * 
*/
List<string> getGenericParameters();
void setGenericParameters(value List<string>);

/**
 * 
 * Result of create_bmm_type() call.
 * 
*/
BmmGenericType getBmmType();
void setBmmType(value BmmGenericType);

/* * FUNCTION * */

/**
 * 
 * Generic parameters of the root_type in this type specifier.
 * The order must match the order of the owning class’s formal generic parameter declarations
 * generic_parameter_refs (): List<P_BMM_TYPE>
 * 
*/
List<pBmmType> genericParameterRefs ();

}

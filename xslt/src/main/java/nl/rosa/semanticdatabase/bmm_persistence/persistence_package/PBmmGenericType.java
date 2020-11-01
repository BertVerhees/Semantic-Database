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
     getRootType();
    void setRootType( value);

/**
 * 
 * Generic parameters of the root_type in this type specifier if non-simple types.
 * The order must match the order of the owning class’s formal generic parameter declarations.
 * Persistent attribute.
 * 
*/
     getGenericParameterDefs();
    void setGenericParameterDefs( value);

/**
 * 
 * Generic parameters of the root_type in this type specifier, if simple types.
 * The order must match the order of the owning class’s formal generic parameter declarations.
 * Persistent attribute.
 * 
*/
     getGenericParameters();
    void setGenericParameters( value);

/**
 * 
 * Result of create_bmm_type() call.
 * 
*/
    BmmGenericType getBmmType();
    void setBmmType(BmmGenericType value);

/* * FUNCTION * */

/**
 * 
 * Generic parameters of the root_type in this type specifier.
 * The order must match the order of the owning class’s formal generic parameter declarations
 * 
*/
      generic_parameter_refs();

}

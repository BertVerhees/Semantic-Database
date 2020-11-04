package nl.rosa.semanticdatabase.bmm.types;

/**
 * 
 * Meta-type based on a non-container generic class, e.g.
 * Packet<Header>.
 * 
*/
public interface BmmGenericType extends BmmModelType {

/* * ATTRIBUTE * */

/**
 * 
 * Generic parameters of the root_type in this type specifier.
 * The order must match the order of the owning class’s formal generic parameter declarations, and the types may be defined types or formal parameter types.
 * 
*/
    List<BmmUnitaryType> getGenericParameters();
    void setGenericParameters(List<BmmUnitaryType> value);

/**
 * 
 * Defining generic class of this type.
 * 
*/
    BmmGenericClass getBaseClass();
    void setBaseClass(BmmGenericClass value);

/* * FUNCTION * */

/**
 * 
 * Return the full name of the type including generic parameters, e.g.
 * DV_INTERVAL<T>, TABLE<List<THING>,String>.
 * 
*/
    String  type_name();

/**
 * 
 * Signature form of the type, which for generics includes generic parameter constrainer types E.g.
 * Interval<T:Ordered>.
 * 
*/
    String  type_signature();

/**
 * 
 * True if base_class.is_abstract or if any (non-open) parameter type is abstract.
 * 
*/
    Boolean  is_abstract();

/**
 * 
 * Result is base_class.name followed by names of all generic parameter type names, which may be open or closed.
 * 
*/
    List<String>  flattened_type_list();

/**
 * 
 * Returns True if there is any substituted generic parameter.
 * 
*/
    Boolean  is_partially_closed();

/**
 * 
 * Effective underlying class for this type, abstracting away any container type.
 * 
*/
    BmmGenericClass  effective_base_class();

/**
 * 
 * True if all generic parameters from ancestor generic types have been substituted in this type.
 * 
*/
    Boolean  is_open();

/* * CONSTANTS * */

}

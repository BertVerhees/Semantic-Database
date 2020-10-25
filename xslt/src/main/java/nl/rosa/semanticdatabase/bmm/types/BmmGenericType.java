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
List<bmmUnitaryType> getGenericParameters();
void setGenericParameters(var List<bmmUnitaryType>);

/**
 * 
 * Defining generic class of this type.
 * 
*/
BmmGenericClass getBaseClass();
void setBaseClass(var BmmGenericClass);

/* * FUNCTION * */

/**
 * 
 * Return the full name of the type including generic parameters, e.g.
 * DV_INTERVAL<T>, TABLE<List<THING>,String>.
 * type_name (): String
 * 
*/

/**
 * 
 * Signature form of the type, which for generics includes generic parameter constrainer types E.g.
 * Interval<T:Ordered>.
 * type_signature (): String
 * 
*/

/**
 * 
 * True if base_class.is_abstract or if any (non-open) parameter type is abstract.
 * is_abstract (): Boolean
 * 
*/

/**
 * 
 * Result is base_class.name followed by names of all generic parameter type names, which may be open or closed.
 * flattened_type_list (): List<String>
 * 
*/

/**
 * 
 * Returns True if there is any substituted generic parameter.
 * is_partially_closed (): Boolean
 * 
*/

/**
 * 
 * Effective underlying class for this type, abstracting away any container type.
 * effective_base_class (): BMM_GENERIC_CLASS
 * 
*/

/**
 * 
 * True if all generic parameters from ancestor generic types have been substituted in this type.
 * is_open (): Boolean
 * 
*/

}

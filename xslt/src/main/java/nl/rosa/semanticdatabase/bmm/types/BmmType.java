package nl.rosa.semanticdatabase.bmm.types;

/**
 * 
 * Abstract idea of specifying a type in some context.
 * This is not the same as 'defining' a class.
 * A type specification is essentially a reference of some kind, that defines the type of an attribute, or function result or argument.
 * It may include generic parameters that might or might not be bound.
 * See subtypes.
 * 
*/
public interface BmmType {

/* * ATTRIBUTE * */

/* * FUNCTION * */

/**
 * 
 * Formal string form of the type as per UML.
 * 
*/
    String  type_name();

/**
 * 
 * Signature form of the type name, which for generics includes generic parameter constrainer types E.g.
 * Interval<T:Ordered>.
 * Defaults to the value of type_name().
 * 
*/
    String  type_signature();

/**
 * 
 * If true, indicates an abstract class in a BMM model, or a type based on an abstract class, i.e.
 * a type that cannot be directly instantiated.
 * 
*/
    Boolean  is_abstract();

/**
 * 
 * If True, indicates that the entity in a BMM model is considered to relate to a primitive type set, i.e.
 * be a primitive type, or be a definer of one.
 * 
*/
    Boolean  is_primitive();

/**
 * 
 * Type with any container abstracted away; may be a formal generic type.
 * 
*/
    BmmUnitaryType  unitary_type();

/**
 * 
 * Type with any container abstracted away, and any formal parameter replaced by its effective constraint type.
 * 
*/
    BmmEffectiveType  effective_type();

/**
 * 
 * Completely flattened list of type names, flattening out all generic parameters.
 * 
*/
    List<String>  flattened_type_list();

}

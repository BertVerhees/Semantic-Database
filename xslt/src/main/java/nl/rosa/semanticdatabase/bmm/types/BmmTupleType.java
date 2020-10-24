package nl.rosa.semanticdatabase.bmm.types;

/**
 * 
 * Special type representing the type of a tuple, i.e.
 * an array of any number of other types.
 * This includes both container and unitary types, since tuple instances represent concrete objects.
 * Note that both open and closed generic parameters are allowed, as with any generic type, but open generic parameters are only valid within the scope of a generic class.
 * 
*/
public interface BmmTupleType extends BmmEffectiveType {

/**
 * 
 * Base name (built-in).
 * 
*/
String = "tuple" getBaseName()
setBaseName(var String = "tuple")

/**
 * 
 * List of types of the items of the tuple, keyed by purpose in the tuple.
 * 
*/
Hash<string,bmmType> getItemTypes()
setItemTypes(var Hash<string,bmmType>)

}

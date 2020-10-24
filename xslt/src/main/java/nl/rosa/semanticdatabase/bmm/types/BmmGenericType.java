package nl.rosa.semanticdatabase.bmm.types;

/**
 * 
 * Meta-type based on a non-container generic class, e.g.
 * Packet<Header>.
 * 
*/
public interface BmmGenericType extends BmmModelType {

/**
 * 
 * Generic parameters of the root_type in this type specifier.
 * The order must match the order of the owning class’s formal generic parameter declarations, and the types may be defined types or formal parameter types.
 * 
*/
List<bmmUnitaryType> getGenericParameters()
setGenericParameters(var List<bmmUnitaryType>)

/**
 * 
 * Defining generic class of this type.
 * 
*/
BmmGenericClass getBaseClass()
setBaseClass(var BmmGenericClass)

}

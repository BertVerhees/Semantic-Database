package nl.rosa.semanticdatabase.bmm.classes;

/**
 * 
 * Definition of a generic class in an object model.
 * 
*/
public interface BmmGenericClass extends BmmClass {

/**
 * 
 * List of formal generic parameters, keyed by name.
 * These are defined either directly on this class or by the inclusion of an ancestor class which is generic.
 * 
*/
Hash<string,bmmParameterType> getGenericParameters()
setGenericParameters(var Hash<string,bmmParameterType>)

}

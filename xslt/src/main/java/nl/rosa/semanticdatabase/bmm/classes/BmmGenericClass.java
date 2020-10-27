package nl.rosa.semanticdatabase.bmm.classes;

/**
 * 
 * Definition of a generic class in an object model.
 * 
*/
public interface BmmGenericClass extends BmmClass {

/* * ATTRIBUTE * */

/**
 * 
 * List of formal generic parameters, keyed by name.
 * These are defined either directly on this class or by the inclusion of an ancestor class which is generic.
 * 
*/
    Hash<string,bmmParameterType> getGenericParameters();
    void setGenericParameters(value Hash<string,bmmParameterType>);

/* * FUNCTION * */

/**
 * 
 * Add suppliers from generic parameters.
 * suppliers (): List<String>
 * 
*/
    List<string> suppliers ();

/**
 * 
 * Generate a fully open BMM_GENERIC_TYPE instance that corresponds to this class definition
 * type (): BMM_GENERIC_TYPE
 * 
*/
    BmmGenericType type ();

/**
 * 
 * For a generic class, type to which generic parameter a_name conforms e.g.
 * if this class is Interval <T:Comparable> then the Result will be the single type Comparable.
 * For an unconstrained type T, the Result will be Any.
 * generic_parameter_conformance_type ( a_name: String[1] ): String
 * 
*/
    String genericParameterConformanceType ( aName: string[1]);

}

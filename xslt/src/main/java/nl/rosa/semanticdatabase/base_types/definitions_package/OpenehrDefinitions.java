package nl.rosa.semanticdatabase.base_types.definitions_package;

/**
 * 
 * Inheritance class to provide access to constants defined in other packages.
 * 
*/
public interface OpenehrDefinitions extends BasicDefinitions {

/* * ATTRIBUTE * */

/* * FUNCTION * */

/* * CONSTANTS * */

/**
 * 
 * Predefined terminology identifier to indicate it is local to the knowledge resource in which it occurs, e.g.
 * an archetype
 * 
*/
    String {default localTerminologyId = "local"};

}

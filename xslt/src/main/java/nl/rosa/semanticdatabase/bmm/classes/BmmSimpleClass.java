package nl.rosa.semanticdatabase.bmm.classes;

/**
 * 
 * Definition of a simple class, i.e.
 * a class that has no generic parameters and is 1:1 with the type it generates.
 * 
*/
public interface BmmSimpleClass extends BmmClass {

/* * ATTRIBUTE * */

/* * FUNCTION * */

/**
 * 
 * Generate a type object that represents the type of this class.
 * Can only be an instance of BMM_SIMPLE_TYPE or a descendant.
 * 
*/
    BmmSimpleType  type();

}

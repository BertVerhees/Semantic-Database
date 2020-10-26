package nl.rosa.semanticdatabase.bmm.types;

/**
 * 
 * Parent of meta-types that may be used as the type of any instantiated object that is not a container object.
 * 
*/
public interface BmmUnitaryType extends BmmType {

/* * ATTRIBUTE * */

/* * FUNCTION * */

/**
 * 
 * Result = self.
 * unitary_type (): BMM_UNITARY_TYPE
 * 
*/
BmmUnitaryType unitaryType ();

}

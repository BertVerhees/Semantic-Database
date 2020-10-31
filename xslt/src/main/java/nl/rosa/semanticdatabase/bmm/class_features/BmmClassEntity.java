package nl.rosa.semanticdatabase.bmm.class_features;

/**
 * 
 * Any entity declared within a class.
 * 
*/
public interface BmmClassEntity extends BmmDeclaration {

/* * ATTRIBUTE * */

/* * FUNCTION * */

/**
 * 
 * Formal signature of this element, in the form: name [arg1_name: T_arg1, …​][:T_value] Specific implementations in descendants.
 * 
*/
    BmmClassEntity  signature();

}

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
    BmmSignature  signature();

/* * CONSTANTS * */

/**
 * 
 * True if this feature was synthesised due to generic substitution in an inherited type, or further constraining of a formal generic parameter.
 * 
*/
    Boolean {default isSynthesisedGeneric = false};

}

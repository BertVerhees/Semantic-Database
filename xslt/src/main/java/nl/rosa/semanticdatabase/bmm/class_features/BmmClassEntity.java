package nl.rosa.semanticdatabase.bmm.class_features;

/**
 * 
 * Any entity declared within a class.
 * 
*/
public interface BmmClassEntity extends BmmDeclaration {

/**
 * 
 * True if this feature was synthesised due to generic substitution in an inherited type, or further constraining of a formal generic parameter.
 * 
*/
Boolean {default = false} getIsSynthesisedGeneric()
setIsSynthesisedGeneric(var Boolean {default = false})

}

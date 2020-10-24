package nl.rosa.semanticdatabase.bmm.types;

/**
 * 
 * A type that is defined by a class (or classes) in the model.
 * 
*/
public interface BmmModelType extends BmmEffectiveType {

/**
 * 
 * 
 * 
*/
BmmValueSetSpec getValueConstraint()
setValueConstraint(var BmmValueSetSpec)

/**
 * 
 * Base class of this type.
 * 
*/
BmmClass getBaseClass()
setBaseClass(var BmmClass)

}

package nl.rosa.semanticdatabase.bmm.class_features;

/**
 * 
 * Meta-type of a property definition within a class definition of an object model.
 * The is_composition attribute indicates whether the property has sub-part or an association semantics with respect to the owning class.
 * 
*/
public interface BmmProperty extends BmmInstantiable,BmmClassFeature {

/* * ATTRIBUTE * */

/* * FUNCTION * */

/**
 * 
 * Interval form of 0..1, 1..1 etc, derived from is_nullable.
 * 
*/
    Multiplicity_interval  existence();

/**
 * 
 * Name of this property to display in UI.
 * 
*/
    String  display_name();

}

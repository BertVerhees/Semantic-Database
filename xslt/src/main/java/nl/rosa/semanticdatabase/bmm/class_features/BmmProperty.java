package nl.rosa.semanticdatabase.bmm.class_features;

/**
 * 
 * Meta-type of a property definition within a class definition of an object model.
 * The is_composition attribute indicates whether the property has sub-part or an association semantics with respect to the owning class.
 * 
*/
public interface BmmProperty extends BmmInstantiable,BmmClassFeature {

/* * ATTRIBUTE * */

/**
 * 
 * True if this property is marked with info model im_runtime property.
 * 
*/
Boolean {default = false} getIsImRuntime();
void setIsImRuntime(var Boolean {default = false});

/**
 * 
 * True if this property was marked with info model im_infrastructure flag.
 * 
*/
Boolean {default = false} getIsImInfrastructure();
void setIsImInfrastructure(var Boolean {default = false});

/**
 * 
 * True if this property instance is a compositional sub-part of the owning class instance.
 * Equivalent to 'composition' in UML associations (but missing from UML properties without associations) and also 'cascade-delete' semantics in ER schemas.
 * 
*/
Boolean {default = false} getIsComposition();
void setIsComposition(var Boolean {default = false});

/* * FUNCTION * */

/**
 * 
 * Interval form of 0..1, 1..1 etc, derived from is_nullable.
 * existence (): Multiplicity_interval
 * 
*/

/**
 * 
 * Name of this property to display in UI.
 * display_name (): String
 * 
*/

}

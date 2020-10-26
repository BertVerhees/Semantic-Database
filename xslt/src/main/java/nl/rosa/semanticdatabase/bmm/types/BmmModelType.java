package nl.rosa.semanticdatabase.bmm.types;

/**
 * 
 * A type that is defined by a class (or classes) in the model.
 * 
*/
public interface BmmModelType extends BmmEffectiveType {

/* * ATTRIBUTE * */

/**
 * 
 * 
 * 
*/
BmmValueSetSpec getValueConstraint();
void setValueConstraint(value BmmValueSetSpec);

/**
 * 
 * Base class of this type.
 * 
*/
BmmClass getBaseClass();
void setBaseClass(value BmmClass);

/* * FUNCTION * */

/**
 * 
 * Result = base_class.name.
 * type_base_name (): String
 * 
*/
String typeBaseName ();

/**
 * 
 * Result = base_class.is_primitive.
 * is_primitive (): Boolean
 * 
*/
Boolean isPrimitive ();

}

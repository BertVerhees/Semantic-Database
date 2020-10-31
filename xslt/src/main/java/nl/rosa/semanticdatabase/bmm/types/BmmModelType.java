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
    BmmModelType getValueConstraint();
    void setValueConstraint(BmmModelType value);

/**
 * 
 * Base class of this type.
 * 
*/
    BmmModelType getBaseClass();
    void setBaseClass(BmmModelType value);

/* * FUNCTION * */

/**
 * 
 * Result = base_class.name.
 * 
*/
    BmmModelType  type_base_name();

/**
 * 
 * Result = base_class.is_primitive.
 * 
*/
    BmmModelType  is_primitive();

}

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
    void setValueConstraint(BmmValueSetSpec value);

/**
 * 
 * Base class of this type.
 * 
*/
    BmmClass getBaseClass();
    void setBaseClass(BmmClass value);

/* * FUNCTION * */

/**
 * 
 * Result = base_class.name.
 * 
*/
    String  type_base_name();

/**
 * 
 * Result = base_class.is_primitive.
 * 
*/
    Boolean  is_primitive();

}

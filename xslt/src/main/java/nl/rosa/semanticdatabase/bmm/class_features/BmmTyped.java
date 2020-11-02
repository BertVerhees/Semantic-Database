package nl.rosa.semanticdatabase.bmm.class_features;

/**
 * 
 * Any entity that has a declared or inferred static type, and that can therefore be generate a value.
 * 
*/
public interface BmmTyped {

/* * ATTRIBUTE * */

/**
 * 
 * Declared or inferred static type of the entity.
 * 
*/
    BmmType getType();
    void setType(BmmType value);

/* * FUNCTION * */

/**
 * 
 * True if type is notionally Boolean (i.e.
 * a BMM_SIMPLE_TYPE with type_name() = 'Boolean').
 * 
*/
    Result = type().equal( {BMM_MODEL}.boolean_type_definition())  is_boolean();

}

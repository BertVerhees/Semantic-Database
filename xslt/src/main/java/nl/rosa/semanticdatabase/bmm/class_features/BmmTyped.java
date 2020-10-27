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
    void setType(value BmmType);

/* * FUNCTION * */

/**
 * 
 * True if type is notionally Boolean (i.e.
 * a BMM_SIMPLE_TYPE with type_name() = 'Boolean').
 * is_boolean (): Boolean Post_result: Result = type().equal( {BMM_MODEL}.boolean_type_definition())
 * 
*/
    Boolean postResult: result = type().equal( {bmmModel}.booleanTypeDefinition()) isBoolean ();

}

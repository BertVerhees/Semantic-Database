package nl.rosa.semanticdatabase.bmm.literal_values;

/**
 * 
 * Meta-type for literal instance values declared in a model.
 * Instance values may be inline values of primitive types in the usual fashion or complex objects in syntax form, e.g.
 * JSON.
 * 
*/
public interface BmmLiteralValue extends BmmTyped {

/* * ATTRIBUTE * */

/**
 * 
 * A serial representation of the value.
 * 
*/
    BmmLiteralValue getValueLiteral();
    void setValueLiteral(value BmmLiteralValue);

/**
 * 
 * A native representation of the value, possibly derived by deserialising value_literal.
 * 
*/
    BmmLiteralValue getValue();
    void setValue(value BmmLiteralValue);

/**
 * 
 * Optional specification of formalism of the value_literal attribute for complex values.
 * Value may be any of json | yawl | xml | odin | rdf or another value agreed by the user community.
 * If not set, json is assumed.
 * 
*/
    BmmLiteralValue getSyntax();
    void setSyntax(value BmmLiteralValue);

/* * FUNCTION * */

}

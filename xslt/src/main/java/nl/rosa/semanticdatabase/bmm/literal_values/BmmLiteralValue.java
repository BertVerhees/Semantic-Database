package nl.rosa.semanticdatabase.bmm.literal_values;

/**
 * 
 * Meta-type for literal instance values declared in a model.
 * Instance values may be inline values of primitive types in the usual fashion or complex objects in syntax form, e.g.
 * JSON.
 * 
*/
public interface BmmLiteralValue extends BmmTyped {

/**
 * 
 * A serial representation of the value.
 * 
*/
String getValueLiteral()
setValueLiteral(var String)

/**
 * 
 * A native representation of the value, possibly derived by deserialising value_literal.
 * 
*/
Any getValue()
setValue(var Any)

/**
 * 
 * Optional specification of formalism of the value_literal attribute for complex values.
 * Value may be any of json | yawl | xml | odin | rdf or another value agreed by the user community.
 * If not set, json is assumed.
 * 
*/
String getSyntax()
setSyntax(var String)

}

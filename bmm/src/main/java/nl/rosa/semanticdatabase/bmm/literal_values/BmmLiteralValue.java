package nl.rosa.semanticdatabase.bmm.literal_values;


/**
 * Class BmmLiteralValue
 * Meta-type for literal instance values declared in a model. Instance values may
 * be inline values of primitive nl.rosa.semanticdatabase.bmm.types in the usual fashion or complex objects in
 * syntax form, e.g. JSON.
 */
abstract public class BmmLiteralValue {

  /**
   * Set the value of valueLiteral
   * A serial representation of the value.
   * @param newVar the new value of valueLiteral
   */
  abstract void setValueLiteral(String newVar);

  /**
   * Get the value of valueLiteral
   * A serial representation of the value.
   * @return the value of valueLiteral
   */
  abstract String getValueLiteral();

  /**
   * Set the value of value
   * A native representation of the value, possibly derived by deserialising
   * value_literal.
   * @param newVar the new value of value
   */
  abstract void setValue(Object newVar);

  /**
   * Get the value of value
   * A native representation of the value, possibly derived by deserialising
   * value_literal.
   * @return the value of value
   */
  abstract Object getValue();

  /**
   * Set the value of syntax
   * Optional specification of formalism of the value_literal attribute for complex
   * values. Value may be any of json | yawl | xml | odin | rdf or another value
   * agreed by the user community. If not set, json is assumed.
   * @param newVar the new value of syntax
   */
  abstract void setSyntax(String newVar);

  /**
   * Get the value of syntax
   * Optional specification of formalism of the value_literal attribute for complex
   * values. Value may be any of json | yawl | xml | odin | rdf or another value
   * agreed by the user community. If not set, json is assumed.
   * @return the value of syntax
   */
  abstract String getSyntax();

}

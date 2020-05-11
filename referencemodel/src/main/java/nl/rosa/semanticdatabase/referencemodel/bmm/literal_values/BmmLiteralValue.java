package nl.rosa.semanticdatabase.referencemodel.bmm.literal_values;


/**
 * Class BmmLiteralValue
 * Meta-type for literal instance values declared in a model. Instance values may
 * be inline values of primitive types in the usual fashion or complex objects in
 * syntax form, e.g. JSON.
 */
public interface BmmLiteralValue {

  //
  // Fields
  //

  /**
   * A serial representation of the value.
   */
  private String valueLiteral;
  /**
   * A native representation of the value, possibly derived by deserialising value_literal.
   */
  private Object value;
  /**
   * Optional specification of formalism of the value_literal attribute for complex values. Value may be any of json | yawl | xml | odin | rdf or another value agreed by the user community. If not set, json is assumed.
   */
  private String syntax;
  //
  // Accessor methods
  //

  /**
   * Set the value of valueLiteral
   * A serial representation of the value.
   * @param newVar the new value of valueLiteral
   */
  public void setValueLiteral (String newVar) {
    valueLiteral = newVar;
  }

  /**
   * Get the value of valueLiteral
   * A serial representation of the value.
   * @return the value of valueLiteral
   */
  public String getValueLiteral () {
    return valueLiteral;
  }

  /**
   * Set the value of value
   * A native representation of the value, possibly derived by deserialising
   * value_literal.
   * @param newVar the new value of value
   */
  public void setValue (Object newVar) {
    value = newVar;
  }

  /**
   * Get the value of value
   * A native representation of the value, possibly derived by deserialising
   * value_literal.
   * @return the value of value
   */
  public Object getValue () {
    return value;
  }

  /**
   * Set the value of syntax
   * Optional specification of formalism of the value_literal attribute for complex
   * values. Value may be any of json | yawl | xml | odin | rdf or another value
   * agreed by the user community. If not set, json is assumed.
   * @param newVar the new value of syntax
   */
  public void setSyntax (String newVar) {
    syntax = newVar;
  }

  /**
   * Get the value of syntax
   * Optional specification of formalism of the value_literal attribute for complex
   * values. Value may be any of json | yawl | xml | odin | rdf or another value
   * agreed by the user community. If not set, json is assumed.
   * @return the value of syntax
   */
  public String getSyntax () {
    return syntax;
  }

  //
  // Other methods
  //

}

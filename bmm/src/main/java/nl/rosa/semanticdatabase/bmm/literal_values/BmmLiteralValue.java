package nl.rosa.semanticdatabase.bmm.literal_values;


import lombok.Data;

/**
 * Class BmmLiteralValue
 * Meta-type for literal instance values declared in a model. Instance values may
 * be inline values of primitive nl.rosa.semanticdatabase.bmm.types in the usual fashion or complex objects in
 * syntax form, e.g. JSON.
 */
@Data
abstract public class BmmLiteralValue {

  /**
   * Optional specification of formalism of the value_literal attribute for complex values.
   * Value may be any of json | yawl | xml | odin | rdf or another value agreed by the user community.
   * If not set, json is assumed.
   */
  private String syntax;/**
   /**
   * A serial representation of the value.
   */
  private String valueLiteral;
}

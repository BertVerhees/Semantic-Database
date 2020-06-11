package nl.rosa.semanticdatabase.bmmdata.model.literal_values;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;

/**
 * Class BmmLiteralValue
 * Meta-type for literal instance values declared in a model. Instance values may
 * be inline values of primitive nl.rosa.semanticdatabase.bmm.model.types in the usual fashion or complex objects in
 * syntax form, e.g. JSON.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class BmmLiteralValue extends BmmBaseEntity {

  /**
   * 0..1
   * syntax: String
   * Optional specification of formalism of the value_literal attribute for complex values.
   * Value may be any of json | yawl | xml | odin | rdf or another value agreed by the user community.
   * If not set, json is assumed.
   */
  private String syntax;
  /**
   * 1..1
   * value_literal: String
   * A serial representation of the value.
   */
  @NonNull
  private String valueLiteral;
  /**
   * 0..1
   * value: Any
   * A native representation of the value, possibly derived by deserialising value_literal.
   */
  private Object value;
}

package nl.rosa.semanticdatabase.bmmdata.domain.literal_values;


import lombok.*;
import nl.rosa.semanticdatabase.bmmdata.domain.BmmBase;
import nl.rosa.semanticdatabase.bmmdata.domain.class_features.BmmTyped;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmType;

/**
 * Class BmmLiteralValue
 * Meta-type for literal instance values declared in a model. Instance values may
 * be inline values of primitive nl.rosa.semanticdatabase.bmm.model.types in the usual fashion or complex objects in
 * syntax form, e.g. JSON.
 */
public class BmmLiteralValue extends BmmBase implements BmmTyped {

  /**
   * 1..1
   * type: BMM_TYPE
   * Declared or inferred static type of the entity.
   *
   * !!Implemented because of implemented derived interface from BmmTyped!!
   */
  @NonNull
  @Getter
  @Setter
  private BmmType type;
  /**
   * 1..1
   * is_boolean (): Boolean
   * Post_result: Result = type().equal( {BMM_MODEL}.boolean_type_definition())
   * True if type is notionally Boolean (i.e. a BMM_SIMPLE_TYPE with type_name() = 'Boolean').
   * @return
   */
  @Override
  @NonNull
  public Boolean isBoolean() {
    //TODO
    return null;
  }


  /**
   * 0..1
   * syntax: String
   * Optional specification of formalism of the value_literal attribute for complex values.
   * Value may be any of json | yawl | xml | odin | rdf or another value agreed by the user community.
   * If not set, json is assumed.
   */
  @Getter
  @Setter
  private String syntax;
  /**
   * 1..1
   * value_literal: String
   * A serial representation of the value.
   */
  @NonNull
  @Getter
  @Setter
  private String valueLiteral;

  /**
   * 0..1
   * value: Any
   * A native representation of the value, possibly derived by deserialising value_literal.
   */
  @Getter
  @Setter
  private Object value;
}

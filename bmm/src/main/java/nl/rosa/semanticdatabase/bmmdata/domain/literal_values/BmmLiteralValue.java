package nl.rosa.semanticdatabase.bmmdata.domain.literal_values;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.domain.Bmm;
import nl.rosa.semanticdatabase.bmmdata.domain.class_features.BmmTyped;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmType;

import javax.persistence.DiscriminatorValue;

/**
 * Class BmmLiteralValue
 * Meta-type for literal instance values declared in a model. Instance values may
 * be inline values of primitive nl.rosa.semanticdatabase.bmm.model.types in the usual fashion or complex objects in
 * syntax form, e.g. JSON.
 */
@Getter
@EqualsAndHashCode(callSuper = true)
public class BmmLiteralValue extends Bmm implements BmmTyped {

  /**
   * 1..1
   * type: BMM_TYPE
   * Declared or inferred static type of the entity.
   *
   * !!Implemented because of implemented derived interface from BmmTyped!!
   */
  @NonNull
  private BmmType type;
  public BmmLiteralValue setType(BmmType type) {
    this.type = type;
    return this;
  }

  /**
   * 1..1
   * is_boolean (): Boolean
   * Post_result: Result = type().equal( {BMM_MODEL}.boolean_type_definition())
   * True if type is notionally Boolean (i.e. a BMM_SIMPLE_TYPE with type_name() = 'Boolean').
   * @return
   */
  @Override
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
  private String syntax;
  /**
   * 1..1
   * value_literal: String
   * A serial representation of the value.
   */
  @NonNull
  private String valueLiteral;
  public String getValueLiteral() {
    return value.toString();
  }
  public void setValueLiteral(String valueLiteral) {
    this.valueLiteral = valueLiteral;
  }

  /**
   * 0..1
   * value: Any
   * A native representation of the value, possibly derived by deserialising value_literal.
   */
  private Object value;
  public BmmLiteralValue setValue(Object value) {
    this.value = value;
    return this;
  }
}

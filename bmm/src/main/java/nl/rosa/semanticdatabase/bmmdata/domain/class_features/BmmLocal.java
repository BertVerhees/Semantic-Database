package nl.rosa.semanticdatabase.bmmdata.domain.class_features;


import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * Class BmmLocal
 */
@EqualsAndHashCode(callSuper = true)
@Entity
public class BmmLocal extends BmmVariable  {
  /**
   * 0..1
   * is_nullable: Boolean
   * {default = false}
   * True if this element can be null (Void) at execution time. May be interpreted as optionality in subtypes..
   */
  private Boolean isNullable;
  /**
   * 1..1
   * is_boolean (): Boolean
   * Post_result: Result = type().equal( {BMM_MODEL}.boolean_type_definition())
   * True if type is notionally Boolean (i.e. a BMM_SIMPLE_TYPE with type_name() = 'Boolean').
   * @return
   */
  @Override
  public Boolean isBoolean() {
    return null;
  }
}

package nl.rosa.semanticdatabase.bmmdata.domain.class_features;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Class BmmResult
 * Automatically declared variable representing result instance of a Function call.
 */
public class BmmResult extends BmmVariable {
  /**
   * 0..1
   * is_nullable: Boolean
   * {default = false}
   * True if this element can be null (Void) at execution time. May be interpreted as optionality in subtypes..
   */
  @Getter
  @Setter
  private Boolean isNullable;
  /**
   * 1..1
   * (redefined)
   * name: String
   * {default = "Result"}
   * Name of this model element.
   */
  @NonNull
  @Setter
  @Getter
  private String name = "Result";
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

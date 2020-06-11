package nl.rosa.semanticdatabase.bmmdata.model.class_features;


import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;

/**
 * Class BmmResult
 * Automatically declared variable representing result instance of a Function call.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BmmResult extends BmmVariable {
  /**
   * 0..1
   * is_nullable: Boolean
   * {default = false}
   * True if this element can be null (Void) at execution time. May be interpreted as optionality in subtypes..
   */
  private Boolean isNullable;
  /**
   * 1..1
   * type: BMM_TYPE
   * Declared or inferred static type of the entity.
   */
  private BmmType type;
  /**
   * 1..1
   * (redefined)
   * name: String
   * {default = "Result"}
   * Name of this model element.
   */
  private String name;
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

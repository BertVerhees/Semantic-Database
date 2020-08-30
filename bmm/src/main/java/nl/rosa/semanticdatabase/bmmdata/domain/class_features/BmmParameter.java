package nl.rosa.semanticdatabase.bmmdata.domain.class_features;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * Class BmmParameter
 * A routine parameter variable.
 */
public class BmmParameter extends BmmVariable {
  /**
   * 0..1
   * direction: BMM_PARAMETER_DIRECTION
   * Optional read/write direction of the parameter. If none-supplied, the parameter is treated as in, i.e. readable.
   */
  @Getter
  @Setter
  private BmmParameterDirection direction;
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
    return null;
  }
}

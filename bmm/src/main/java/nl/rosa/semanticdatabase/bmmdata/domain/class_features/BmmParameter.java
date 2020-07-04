package nl.rosa.semanticdatabase.bmmdata.domain.class_features;


import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * Class BmmParameter
 * A routine parameter variable.
 */
@EqualsAndHashCode(callSuper = true)
@Entity
public class BmmParameter extends BmmVariable {
  /**
   * 0..1
   * direction: BMM_PARAMETER_DIRECTION
   * Optional read/write direction of the parameter. If none-supplied, the parameter is treated as in, i.e. readable.
   */
  private BmmParameterDirection direction;
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

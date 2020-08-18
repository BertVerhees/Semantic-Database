package nl.rosa.semanticdatabase.bmmdata.domain.class_features;

import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.domain.Bmm;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmType;


/**
 * Class BmmTyped
 * Any entity that has a declared or inferred static type, and that can therefore
 * be generate a value.
 */
public interface BmmTyped {

  /**
   * 1..1
   * type: BMM_TYPE
   * Declared or inferred static type of the entity.
   */
  BmmType getType();
  void setType(BmmType type);

  /**
   * 1..1
   * is_boolean (): Boolean
   * Post_result: Result = type().equal( {BMM_MODEL}.boolean_type_definition())
   * True if type is notionally Boolean (i.e. a BMM_SIMPLE_TYPE with type_name() = 'Boolean').
   * @return
   */
  Boolean isBoolean();


}

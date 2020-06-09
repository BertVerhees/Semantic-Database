package nl.rosa.semanticdatabase.bmmdata.model.expressions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;


/**
 * Class ElInstantiableRef
 * Terminal item corresponding to a reference to a directly instantiable entity,
 * i.e. a variable, constant, or property.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ElInstantiableRef<T> extends ElScopedRef {
  /**
   * Definition of the constant, property or variable, inferred by inspection of the current scoping instance.
   */
  private T definition;

  // Functions
  /**
   * 1..1
   * (effected)
   * eval_type (): BMM_TYPE
   * Type definition (i.e. BMM meta-type definition object) of the constant, property or variable,
   * inferred by inspection of the current scoping instance. Return definition.type.
   * @return
   */
  public BmmType evalType(){
    return null;
  }
}

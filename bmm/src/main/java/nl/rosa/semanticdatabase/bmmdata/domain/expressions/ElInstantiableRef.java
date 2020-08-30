package nl.rosa.semanticdatabase.bmmdata.domain.expressions;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmType;

/**
 * Class ElInstantiableRef
 * Terminal item corresponding to a reference to a directly instantiable entity,
 * i.e. a variable, constant, or property.
 */
public class ElInstantiableRef<T> extends ElScopedRef {
  /**
   * 0..1
   * definition: T
   * Definition of the constant, property or variable, inferred by inspection of the current scoping instance.
   */
  @Getter
  @Setter
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

package nl.rosa.semanticdatabase.bmmdata.model.expressions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;

import javax.validation.constraints.NotNull;


/**
 * Class ElInstantiableRef
 * Terminal item corresponding to a reference to a directly instantiable entity,
 * i.e. a variable, constant, or property.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ElInstantiableRef<T> extends BmmBaseEntity implements ElScopedRef {
/**
 *  ElScopedRef
 *    ElInstanceRef
 *      ElTerminal
 *        ElExpression
 */
  /**
   * ElInstanceRef
   */
  /**
   * ElExpression
   */
  @NotNull
  public BmmType evalType(){
    return null;
  }
  @NotNull
  public Boolean isBoolean(){
    return null;
  }
  /**
   * ElScopedRef
   */
  private ElInstanceRef scope;
  /**
   * ElTerminal
   */
  /**
   * ElExpression
   */
//======================================================================================
  /**
   * Definition of the constant, property or variable, inferred by inspection of the current scoping instance.
   */
  private T definition;
}

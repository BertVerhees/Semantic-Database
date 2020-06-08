package nl.rosa.semanticdatabase.bmmdata.model.expressions;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;

/**
 * Class ElScopedRef
 * A reference that is scoped by a containing entity and requires a context
 * qualifier if it is not the currently scoping entity.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class ElScopedRef extends BmmBaseEntity implements ElInstanceRef {
  /**
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
  @NonNull
  public Boolean isBoolean(){
    return null;
  }
  /**
   * ElTerminal
   */
  /**
   * ElExpression
   */
//=================================================================

  /**
   * 0..1
   * scope: EL_INSTANCE_REF
   * Reference to an owning object for this terminal element, if it is not the
   * current scope.
   * @param newVar the new value of scope
   */
  private ElInstanceRef scope;
}

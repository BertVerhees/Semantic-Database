package nl.rosa.semanticdatabase.bmmdata.domain.expressions;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Class ElScopedRef
 * A reference that is scoped by a containing entity and requires a context
 * qualifier if it is not the currently scoping entity.
 */
public abstract class ElScopedRef extends ElInstanceRef {
  /**
   * 0..1
   * scope: EL_INSTANCE_REF
   * Reference to an owning object for this terminal element, if it is not the
   * current scope.
   * @param newVar the new value of scope
   */
  @Getter
  @Setter
  private ElInstanceRef scope;
}

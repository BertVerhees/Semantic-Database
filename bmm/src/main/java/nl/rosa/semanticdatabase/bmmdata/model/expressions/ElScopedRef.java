package nl.rosa.semanticdatabase.bmmdata.model.expressions;


/**
 * Class ElScopedRef
 * A reference that is scoped by a containing entity and requires a context
 * qualifier if it is not the currently scoping entity.
 */
public interface ElScopedRef extends ElInstanceRef {
  /**
   * 0..1
   * scope: EL_INSTANCE_REF
   * Reference to an owning object for this terminal element, if it is not the
   * current scope.
   * @param newVar the new value of scope
   */
  void setScope (ElInstanceRef newVar);
  ElInstanceRef getScope ();

}

package nl.rosa.semanticdatabase.bmm.expressions;


/**
 * Class ElScopedRef
 * A reference that is scoped by a containing entity and requires a context
 * qualifier if it is not the currently scoping entity.
 */
public interface ElScopedRef extends ElInstanceRef {


  //
  // Accessor methods
  //

  /**
   * Set the value of scope
   * Reference to an owning object for this terminal element, if it is not the
   * current scope.
   * @param newVar the new value of scope
   */
  void setScope (ElInstanceRef newVar);

  /**
   * Get the value of scope
   * Reference to an owning object for this terminal element, if it is not the
   * current scope.
   * @return the value of scope
   */
  ElInstanceRef getScope ();

}

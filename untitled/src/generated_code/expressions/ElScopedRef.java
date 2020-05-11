package expressions;


/**
 * Class ElScopedRef
 * A reference that is scoped by a containing entity and requires a context
 * qualifier if it is not the currently scoping entity.
 */
abstract public class ElScopedRef extends ElInstanceRef {

  //
  // Fields
  //

  /**
   * Reference to an owning object for this terminal element, if it is not the current scope.
   */
  private expressions.ElInstanceRef scope;
  
  //
  // Constructors
  //
  public ElScopedRef () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of scope
   * Reference to an owning object for this terminal element, if it is not the
   * current scope.
   * @param newVar the new value of scope
   */
  public void setScope (expressions.ElInstanceRef newVar) {
    scope = newVar;
  }

  /**
   * Get the value of scope
   * Reference to an owning object for this terminal element, if it is not the
   * current scope.
   * @return the value of scope
   */
  public expressions.ElInstanceRef getScope () {
    return scope;
  }

  //
  // Other methods
  //

}

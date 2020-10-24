package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * A reference that is scoped by a containing entity and requires a context qualifier if it is not the currently scoping entity.
 * 
*/
public interface ElScopedRef extends ElInstanceRef {

/**
 * 
 * Reference to an owning object for this terminal element, if it is not the current scope.
 * 
*/
ElInstanceRef getScope()
setScope(var ElInstanceRef)

}

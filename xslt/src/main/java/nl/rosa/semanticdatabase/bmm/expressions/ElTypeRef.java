package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * Meta-type for reference to a non-abstract type as an object.
 * Assumed to be accessible at run-time.
 * Typically represented syntactically as TypeName or {TypeName}.
 * May be used as a value, or as the qualifier for a function or constant access.
 * 
*/
public interface ElTypeRef extends ElInstanceRef {

/* * ATTRIBUTE * */

/**
 * 
 * Type, directly from the name of the reference, e.g.
 * {SOME_TYPE}.
 * 
*/
    BmmType getType();
    void setType(BmmType value);

/* * FUNCTION * */

/**
 * 
 * Return type.
 * 
*/
    BmmType  eval_type();

}

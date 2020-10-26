package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * Terminal item corresponding to a reference to a directly instantiable entity, i.e.
 * a variable, constant, or property.
 * 
*/
public interface ElInstantiableRef<t> extends ElScopedRef {

/* * ATTRIBUTE * */

/**
 * 
 * Definition of the constant, property or variable, inferred by inspection of the current scoping instance.
 * 
*/
T getDefinition();
void setDefinition(value T);

/* * FUNCTION * */

/**
 * 
 * Type definition (i.e.
 * BMM meta-type definition object) of the constant, property or variable, inferred by inspection of the current scoping instance.
 * Return definition.type.
 * eval_type (): BMM_TYPE
 * 
*/
BmmType evalType ();

}

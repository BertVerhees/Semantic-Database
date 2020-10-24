package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * Terminal item corresponding to a reference to a directly instantiable entity, i.e.
 * a variable, constant, or property.
 * 
*/
public interface ElInstantiableRef<t> extends ElScopedRef {

/**
 * 
 * Definition of the constant, property or variable, inferred by inspection of the current scoping instance.
 * 
*/
T getDefinition()
setDefinition(var T)

}

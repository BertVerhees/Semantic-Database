package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * Terminal item corresponding to a reference to a directly instantiable entity, i.e.
 * a variable, constant, or property.
 * 
*/
public class ElInstantiableRef<t>Impl implements ElScopedRef{

    //***** ElInstantiableRef<t> *****

/* * FIELDS * */

/**
 * 
 * Definition of the constant, property or variable, inferred by inspection of the current scoping instance.
 * 
*/
    private T definition;

        />
    
    //***** ElScopedRef *****

/* * FIELDS * */

/**
 * 
 * Reference to an owning object for this terminal element, if it is not the current scope.
 * 
*/
    private ElInstanceRef scope;

        />
    
    //***** ElInstanceRef *****

/* * FIELDS * */

    //***** ElTerminal *****

/* * FIELDS * */

    //***** ElSimple *****

/* * FIELDS * */

    //***** ElExpression *****

/* * FIELDS * */

/* * ATTRIBUTE * */

/* * POJO * */

/* * FUNCTION * */

}

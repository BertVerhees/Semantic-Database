package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * An agent whose signature is of a function, i.e.
 * has a result type.
 * 
*/
public interface ElFunctionAgent extends ElAgent {

/* * ATTRIBUTE * */

/**
 * 
 * Reference to definition of a routine for which this is a direct call instance, if one exists.
 * 
*/
    ElFunctionAgent getDefinition();
    void setDefinition(value ElFunctionAgent);

/* * FUNCTION * */

}

package nl.rosa.semanticdatabase.bmm.class_features;

/**
 * 
 * A routine parameter variable.
 * 
*/
public interface BmmParameter extends BmmVariable {

/* * ATTRIBUTE * */

/**
 * 
 * Optional read/write direction of the parameter.
 * If none-supplied, the parameter is treated as in, i.e.
 * readable.
 * 
*/
    BmmParameterDirection getDirection();
    void setDirection(value BmmParameterDirection);

/* * FUNCTION * */

}

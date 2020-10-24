package nl.rosa.semanticdatabase.bmm.class_features;

/**
 * 
 * A routine parameter variable.
 * 
*/
public interface BmmParameter extends BmmVariable {

/**
 * 
 * Optional read/write direction of the parameter.
 * If none-supplied, the parameter is treated as in, i.e.
 * readable.
 * 
*/
BmmParameterDirection getDirection()
setDirection(var BmmParameterDirection)

}

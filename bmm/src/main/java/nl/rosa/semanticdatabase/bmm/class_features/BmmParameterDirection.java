package nl.rosa.semanticdatabase.;

/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * 
 * Enumeration of parameter read/write direction values.
 * 
*/
public enum BmmParameterDirection {

/**
 * 
 * Parameter is an input parameter, and treated as readonly by the receiving routine.
 * 
*/
    in,

/**
 * 
 * Parameter is an output parameter, and treated as a reference to an entity writeable by the receiving routine.
 * 
*/
    out,

/**
 * 
 * Parameter is an input and output parameter, and treated as a reference to an entity readable and writeable by the receiving routine.
 * 
*/
    inOut

}

package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * An agent whose signature is of a procedure, i.e.
 * has no result type.
 * 
*/
public interface ElProcedureAgent extends ElAgent {

/**
 * 
 * Reference to definition of routine for which this is a call instance.
 * 
*/
BmmProcedure getDefinition()
setDefinition(var BmmProcedure)

}

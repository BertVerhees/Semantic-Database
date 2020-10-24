package nl.rosa.semanticdatabase.bmm.class_features;

/**
 * 
 * A feature defining a routine, scoped to a class.
 * 
*/
public interface BmmRoutine extends BmmClassFeature {

/**
 * 
 * Formal parameters of the routine.
 * 
*/
List<bmmParameter> getParameters()
setParameters(var List<bmmParameter>)

/**
 * 
 * Local variables of the routine.
 * 
*/
List<bmmLocal> getLocals()
setLocals(var List<bmmLocal>)

/**
 * 
 * 
 * 
*/
List<bmmAssertion> getPreConditions()
setPreConditions(var List<bmmAssertion>)

/**
 * 
 * 
 * 
*/
List<bmmAssertion> getPostConditions()
setPostConditions(var List<bmmAssertion>)

/**
 * 
 * Body of a routine, i.e.
 * executable program.
 * 
*/
BmmRoutineBody getBody()
setBody(var BmmRoutineBody)

}

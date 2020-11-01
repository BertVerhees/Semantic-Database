package nl.rosa.semanticdatabase.bmm.class_features;

/**
 * 
 * A formal element with signature of the form: name ({arg:TArg}*):TResult.
 * A function is a computed (rather than data) element, generally assumed to be non-state-changing.
 * 
*/
public interface BmmFunction extends BmmTypedFeature,BmmRoutine {

/* * ATTRIBUTE * */

/**
 * 
 * Optional details enabling a function to be represented as an operator in a syntactic representation.
 * 
*/
    BmmOperator getOperatorDefinition();
    void setOperatorDefinition(BmmOperator value);

/**
 * 
 * Automatically created Result variable, usable in body and post-condition.
 * 
*/
    BmmResult getResult();
    void setResult(BmmResult value);

/* * FUNCTION * */

}

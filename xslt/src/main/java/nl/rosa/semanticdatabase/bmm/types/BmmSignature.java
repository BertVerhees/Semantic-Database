package nl.rosa.semanticdatabase.bmm.types;

/**
 * 
 * Non-entity meta-type that expresses the type structure of any referenceable element of a model.
 * Consists of potential arguments and result, with constraints in descendants determining the exact form.
 * 
*/
public interface BmmSignature extends BmmEffectiveType {

/**
 * 
 * Base name (built-in).
 * 
*/
String = "signature" getBaseName()
setBaseName(var String = "signature")

/**
 * 
 * Type of arguments in the signature, if any; represented as a type-tuple (list of arbitrary types).
 * 
*/
BmmTupleType getArgumentTypes()
setArgumentTypes(var BmmTupleType)

/**
 * 
 * Result type of signature, if any.
 * 
*/
BmmType getResultType()
setResultType(var BmmType)

}

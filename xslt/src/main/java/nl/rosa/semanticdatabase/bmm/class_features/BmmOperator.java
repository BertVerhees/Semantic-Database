package nl.rosa.semanticdatabase.bmm.class_features;

/**
 * 
 * Definition of a symbolic operator associated with a function.
 * 
*/
public interface BmmOperator {

/**
 * 
 * Position of operator in syntactic representation.
 * 
*/
BmmOperatorPosition getPosition()
setPosition(var BmmOperatorPosition)

/**
 * 
 * Set of String symbols that may be used to represent this operator in a textual representation of a BMM model.
 * 
*/
List<string> getSymbols()
setSymbols(var List<string>)

/**
 * 
 * Formal name of the operator, e.g.
 * 'minus' etc.
 * 
*/
String getName()
setName(var String)

}

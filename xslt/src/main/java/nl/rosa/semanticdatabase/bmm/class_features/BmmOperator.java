package nl.rosa.semanticdatabase.bmm.class_features;

/**
 * 
 * Definition of a symbolic operator associated with a function.
 * 
*/
public interface BmmOperator {

/* * ATTRIBUTE * */

/**
 * 
 * Position of operator in syntactic representation.
 * 
*/
    BmmOperator getPosition();
    void setPosition(value BmmOperator);

/**
 * 
 * Set of String symbols that may be used to represent this operator in a textual representation of a BMM model.
 * 
*/
    List<string> getSymbols();
    void setSymbols(value List<string>);

/**
 * 
 * Formal name of the operator, e.g.
 * 'minus' etc.
 * 
*/
    String getName();
    void setName(value String);

/* * FUNCTION * */

}

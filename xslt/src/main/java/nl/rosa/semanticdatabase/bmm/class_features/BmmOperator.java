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
    void setPosition(BmmOperator value);

/**
 * 
 * Set of String symbols that may be used to represent this operator in a textual representation of a BMM model.
 * 
*/
    BmmOperator getSymbols();
    void setSymbols(BmmOperator value);

/**
 * 
 * Formal name of the operator, e.g.
 * 'minus' etc.
 * 
*/
    BmmOperator getName();
    void setName(BmmOperator value);

/* * FUNCTION * */

}

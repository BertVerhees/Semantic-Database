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
    BmmOperatorPosition getPosition();
    void setPosition(BmmOperatorPosition value);

/**
 * 
 * Set of String symbols that may be used to represent this operator in a textual representation of a BMM model.
 * 
*/
     getSymbols();
    void setSymbols( value);

/**
 * 
 * Formal name of the operator, e.g.
 * 'minus' etc.
 * 
*/
     getName();
    void setName( value);

/* * FUNCTION * */

}

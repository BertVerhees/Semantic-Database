package nl.rosa.semanticdatabase.base_types.builtins_package;

/**
 * 
 * A basic statistical evaluator class providing common functions on collections of numbers.
 * 
*/
public interface StatisticalEvaluator {

/* * ATTRIBUTE * */

/* * FUNCTION * */

/**
 * 
 * Sum of a container of values.
 * 
*/
    Double  sum();

/**
 * 
 * Mean (average) of a container of values.
 * 
*/
    Double  mean();

/**
 * 
 * Mode (most frequent) of a container of values.
 * 
*/
    Numeric  mode();

/**
 * 
 * Maximum of a container of values.
 * 
*/
    Numeric  max();

/**
 * 
 * Minimum of a container of values.
 * 
*/
    Numeric  min();

}

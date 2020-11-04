package nl.rosa.semanticdatabase.bmm.class_features;

/**
 * 
 * An immutable, static value-returning element scoped to a class.
 * The value is the result of the evaluation of the generator, which may be as simple as a literal value, or may be any expression, including a function call.
 * 
*/
public interface BmmConstant extends BmmInstantiable,BmmClassFeature {

/* * ATTRIBUTE * */

/**
 * 
 * Generator expression for the constant value.
 * In the degenerate case, this is just a literal value, but may also be any other expression valid in the context.
 * 
*/
    ElInstanceRef getGenerator();
    void setGenerator(ElInstanceRef value);

/* * FUNCTION * */

/* * CONSTANTS * */

}

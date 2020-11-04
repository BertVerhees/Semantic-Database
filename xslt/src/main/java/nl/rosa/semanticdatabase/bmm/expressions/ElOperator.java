package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * Abstract parent of operator types.
 * 
*/
public interface ElOperator extends ElSimple {

/* * ATTRIBUTE * */

/**
 * 
 * True if the natural precedence of operators is overridden in the expression represented by this node of the expression tree.
 * If True, parentheses should be introduced around the totality of the syntax expression corresponding to this operator node and its operands.
 * 
*/
    Boolean getPrecedenceOverridden();
    void setPrecedenceOverridden(Boolean value);

/**
 * 
 * The symbol actually used in the expression, or intended to be used for serialisation.
 * Must be a member of OPERATOR_DEF.symbols.
 * 
*/
    String getSymbol();
    void setSymbol(String value);

/**
 * 
 * Function equivalent to this operator, inferred by matching operator against functions defined in interface of principal operand.
 * 
*/
    BmmFunction getDefinition();
    void setDefinition(BmmFunction value);

/* * FUNCTION * */

/**
 * 
 * Operator definition derived from definition.operator_definition().
 * 
*/
    BmmOperator  operator_definition();

/**
 * 
 * Function call equivalent to this operator.
 * 
*/
    ElFunctionCall  equivalent_call();

/* * CONSTANTS * */

}

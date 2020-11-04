package nl.rosa.semanticdatabase.bmm.expressions;

/**
 * 
 * Unary operator expression node.
 * 
*/
public class ElUnaryOperatorImpl implements ElOperator{

    //***** ElUnaryOperator *****

/* * FIELDS * */

/**
 * 
 * Operand node.
 * 
*/
    private ElSimple operand;

        />
    
    //***** ElOperator *****

/* * FIELDS * */

/**
 * 
 * True if the natural precedence of operators is overridden in the expression represented by this node of the expression tree.
 * If True, parentheses should be introduced around the totality of the syntax expression corresponding to this operator node and its operands.
 * 
*/
    private Boolean precedence_overridden;

        />
    
/**
 * 
 * The symbol actually used in the expression, or intended to be used for serialisation.
 * Must be a member of OPERATOR_DEF.symbols.
 * 
*/
    private String symbol;

        />
    
/**
 * 
 * Function equivalent to this operator, inferred by matching operator against functions defined in interface of principal operand.
 * 
*/
    private BmmFunction definition;

        />
    
    //***** ElSimple *****

/* * FIELDS * */

    //***** ElExpression *****

/* * FIELDS * */

/* * ATTRIBUTE * */

/* * POJO * */

/* * FUNCTION * */

}

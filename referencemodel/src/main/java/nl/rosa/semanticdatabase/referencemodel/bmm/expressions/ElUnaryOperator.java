package nl.rosa.semanticdatabase.referencemodel.bmm.expressions;


import nl.rosa.semanticdatabase.referencemodel.bmm.class_features.BmmFunction;

/**
 * Class ElUnaryOperator
 * Unary operator expression node.
 */
public class ElUnaryOperator implements ElOperator {

  //
  // Fields
  //

  // ElOperator
  /**
   * True if the natural precedence of operators is overridden in the expression represented by this node of the expression tree. If True, parentheses should be introduced around the totality of the syntax expression corresponding to this operator node and its operands.
   */
  private boolean precedenceOverridden;
  /**
   * The symbol actually used in the expression, or intended to be used for serialisation. Must be a member of OPERATOR_DEF.symbols.
   */
  private String symbol;
  /**
   * Function equivalent to this operator, inferred by matching operator against functions defined in interface of principal operand.
   */
  private BmmFunction definition;


  /**
   * Operand node.
   */
  private ElExpression operand;
  
  //
  // Constructors
  //
  public ElUnaryOperator () { };
  
  //
  // Methods
  //
}

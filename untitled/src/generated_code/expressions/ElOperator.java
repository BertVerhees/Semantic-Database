package expressions;
import class_features.BmmFunction;
import class_features.BmmOperator;


/**
 * Class ElOperator
 * Abstract parent of operator nl.rosa.semanticdatabase.bmm.model.types.
 */
abstract public class ElOperator extends ElExpression {

  //
  // Fields
  //

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
  private class_features.BmmFunction definition;
  
  //
  // Constructors
  //
  public ElOperator () { };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  /**
   * Set the value of precedenceOverridden
   * True if the natural precedence of operators is overridden in the expression
   * represented by this node of the expression tree. If True, parentheses should be
   * introduced around the totality of the syntax expression corresponding to this
   * operator node and its operands.
   * @param newVar the new value of precedenceOverridden
   */
  public void setPrecedenceOverridden (boolean newVar) {
    precedenceOverridden = newVar;
  }

  /**
   * Get the value of precedenceOverridden
   * True if the natural precedence of operators is overridden in the expression
   * represented by this node of the expression tree. If True, parentheses should be
   * introduced around the totality of the syntax expression corresponding to this
   * operator node and its operands.
   * @return the value of precedenceOverridden
   */
  public boolean getPrecedenceOverridden () {
    return precedenceOverridden;
  }

  /**
   * Set the value of symbol
   * The symbol actually used in the expression, or intended to be used for
   * serialisation. Must be a member of OPERATOR_DEF.symbols.
   * @param newVar the new value of symbol
   */
  public void setSymbol (String newVar) {
    symbol = newVar;
  }

  /**
   * Get the value of symbol
   * The symbol actually used in the expression, or intended to be used for
   * serialisation. Must be a member of OPERATOR_DEF.symbols.
   * @return the value of symbol
   */
  public String getSymbol () {
    return symbol;
  }

  /**
   * Set the value of definition
   * Function equivalent to this operator, inferred by matching operator against
   * functions defined in interface of principal operand.
   * @param newVar the new value of definition
   */
  public void setDefinition (class_features.BmmFunction newVar) {
    definition = newVar;
  }

  /**
   * Get the value of definition
   * Function equivalent to this operator, inferred by matching operator against
   * functions defined in interface of principal operand.
   * @return the value of definition
   */
  public class_features.BmmFunction getDefinition () {
    return definition;
  }

  //
  // Other methods
  //

  /**
   * Operator definition derived from definition.operator_definition().
   * @return       class_features.BmmOperator
   */
  public class_features.BmmOperator operatorDefinition()
  {
  }


  /**
   * Function call equivalent to this operator.
   * @return       expressions.ElFunctionCall
   */
  public expressions.ElFunctionCall equivalentCall()
  {
  }


}

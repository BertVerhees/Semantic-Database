package nl.rosa.semanticdatabase.bmmdata.model.expressions;

import nl.rosa.semanticdatabase.bmmdata.model.class_features.BmmOperator;
import nl.rosa.semanticdatabase.bmmdata.model.class_features.BmmFunction;


/**
 * Class ElOperator
 * Abstract parent of operator nl.rosa.semanticdatabase.bmm.model.types.
 */
public interface ElOperator extends ElExpression {
  /**
   * Set the value of precedenceOverridden
   * True if the natural precedence of operators is overridden in the expression
   * represented by this node of the expression tree. If True, parentheses should be
   * introduced around the totality of the syntax expression corresponding to this
   * operator node and its operands.
   * @param newVar the new value of precedenceOverridden
   */
  void setPrecedenceOverridden (boolean newVar);

  /**
   * Get the value of precedenceOverridden
   * True if the natural precedence of operators is overridden in the expression
   * represented by this node of the expression tree. If True, parentheses should be
   * introduced around the totality of the syntax expression corresponding to this
   * operator node and its operands.
   * @return the value of precedenceOverridden
   */
  boolean isPrecedenceOverridden ();

  /**
   * Set the value of symbol
   * The symbol actually used in the expression, or intended to be used for
   * serialisation. Must be a member of OPERATOR_DEF.symbols.
   * @param newVar the new value of symbol
   */
  void setSymbol (String newVar);

  /**
   * Get the value of symbol
   * The symbol actually used in the expression, or intended to be used for
   * serialisation. Must be a member of OPERATOR_DEF.symbols.
   * @return the value of symbol
   */
  String getSymbol ();

  /**
   * Set the value of definition
   * Function equivalent to this operator, inferred by matching operator against
   * functions defined in interface of principal operand.
   * @param newVar the new value of definition
   */
  void setDefinition (BmmFunction newVar);

  /**
   * Get the value of definition
   * Function equivalent to this operator, inferred by matching operator against
   * functions defined in interface of principal operand.
   * @return the value of definition
   */
  BmmFunction getDefinition ();

  //
  // Other methods
  //

  /**
   * Operator definition derived from definition.operator_definition().
   * @return       class_features.BmmOperator
   */
  BmmOperator operatorDefinition();

  /**
   * Function call equivalent to this operator.
   * @return       expressions.ElFunctionCall
   */
  ElFunctionCall equivalentCall();
}

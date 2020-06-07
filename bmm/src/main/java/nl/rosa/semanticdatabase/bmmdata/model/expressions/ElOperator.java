package nl.rosa.semanticdatabase.bmmdata.model.expressions;

import nl.rosa.semanticdatabase.bmmdata.model.class_features.BmmOperator;
import nl.rosa.semanticdatabase.bmmdata.model.class_features.BmmFunction;


/**
 * Class ElOperator
 * Abstract parent of operator nl.rosa.semanticdatabase.bmm.model.types.
 */
public interface ElOperator extends ElExpression {
  /**
   * 0..1
   * precedence_overridden: Boolean
   * True if the natural precedence of operators is overridden in the expression
   * represented by this node of the expression tree. If True, parentheses should be
   * introduced around the totality of the syntax expression corresponding to this
   * operator node and its operands.
   */
  void setPrecedenceOverridden (Boolean newVar);
  Boolean getPrecedenceOverridden ();

  /**
   * 0..1
   * symbol: String
   * The symbol actually used in the expression, or intended to be used for
   * serialisation. Must be a member of OPERATOR_DEF.symbols.
   */
  void setSymbol (String newVar);
  String getSymbol ();

  /**
   * 1..1
   * definition: BMM_FUNCTION
   * Function equivalent to this operator, inferred by matching operator against
   * functions defined in interface of principal operand.
   */
  void setDefinition (BmmFunction newVar);
  BmmFunction getDefinition ();
}

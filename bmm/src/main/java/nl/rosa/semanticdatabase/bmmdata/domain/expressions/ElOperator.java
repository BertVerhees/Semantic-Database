package nl.rosa.semanticdatabase.bmmdata.domain.expressions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.domain.class_features.BmmFunction;
import nl.rosa.semanticdatabase.bmmdata.domain.class_features.BmmOperator;


/**
 * Class ElOperator
 * Abstract parent of operator nl.rosa.semanticdatabase.bmm.model.types.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class ElOperator extends ElExpression {
  /**
   * 0..1
   * precedence_overridden: Boolean
   * True if the natural precedence of operators is overridden in the expression
   * represented by this node of the expression tree. If True, parentheses should be
   * introduced around the totality of the syntax expression corresponding to this
   * operator node and its operands.
   */
  private Boolean precedenceOverriden;

  /**
   * 0..1
   * symbol: String
   * The symbol actually used in the expression, or intended to be used for
   * serialisation. Must be a member of OPERATOR_DEF.symbols.
   */
  private String symbol;

  /**
   * 1..1
   * definition: BMM_FUNCTION
   * Function equivalent to this operator, inferred by matching operator against
   * functions defined in interface of principal operand.
   */
  private BmmFunction definition;

  // Functions

  /**
   * 1..1
   * operator_definition (): BMM_OPERATOR
   * Operator definition derived from definition.operator_definition().
   * @return
   */
  public BmmOperator operatorDefinition() {
    return null;
  }

  /**
   * 1..1
   * equivalent_call (): EL_FUNCTION_CALL
   * Function call equivalent to this operator.
   * @return
   */
  public ElFunctionCall equivalentCall() {
    return null;
  }
}

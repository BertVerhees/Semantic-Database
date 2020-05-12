package nl.rosa.semanticdatabase.referencemodel.bmm.expressions;


import lombok.Data;
import nl.rosa.semanticdatabase.referencemodel.bmm.class_features.BmmFunction;
import nl.rosa.semanticdatabase.referencemodel.bmm.class_features.BmmOperator;
import nl.rosa.semanticdatabase.referencemodel.bmm.types.BmmType;

/**
 * Class ElBinaryOperator
 * Binary operator expression node
 */
@Data
public class ElBinaryOperator implements ElOperator {

  // ElOperator
  /**
   * True if the natural precedence of operators is overridden in the expression represented
   * by this node of the expression tree.
   * If True, parentheses should be introduced around the totality of the syntax expression
   * corresponding to this operator node and its operands.
   */
  private boolean precedenceOverridden;
  /**
   * The symbol actually used in the expression, or intended to be used for serialisation.
   * Must be a member of OPERATOR_DEF.symbols.
   */
  private String symbol;
  /**
   * Function equivalent to this operator, inferred by matching operator against functions
   * defined in interface of principal operand.
   */
  private BmmFunction definition;


  /**
   * Left operand node.
   */
  private ElExpression leftOperand;
  /**
   * Right operand node.
   */
  private ElTerminal rightOperand;
  
  //
  // Constructors
  //
  public ElBinaryOperator () { };

  @Override
  public BmmType evalType() {
    //TODO
    return null;
  }

  @Override
  public boolean isBoolean() {
    //TODO
    return false;
  }

  @Override
  public BmmOperator operatorDefinition() {
    //TODO
    return null;
  }

  @Override
  public ElFunctionCall equivalentCall() {
    //TODO
    return null;
  }
}

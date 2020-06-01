package nl.rosa.semanticdatabase.bmmdata.model.expressions;


import lombok.Data;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.class_features.BmmFunction;
import nl.rosa.semanticdatabase.bmmdata.model.class_features.BmmOperator;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;

import javax.validation.constraints.NotNull;

/**
 * Class ElBinaryOperator
 * Binary operator expression node
 */
@Data
public class ElBinaryOperator extends BmmBaseEntity implements ElOperator {
/**
 * ElOperator
 *  ElExpression
 */
  /**
   * ElOperator
   */
  private Boolean precedenceOverridden;
  private String symbol;
  @NotNull
  private BmmFunction definition;
  // Functions
  @NotNull
  public BmmOperator operatorDefinition(){
    return null;
  }
  @NotNull
  public ElFunctionCall equivalentcall;
  /**
   * ElExpression
   */
@NotNull
public BmmType evalType(){
  return null;
}
  @NotNull
  public Boolean isBoolean(){
    return null;
  }
//========================================================================


  // ElOperator
  /**
   * True if the natural precedence of operators is overridden in the expression represented
   * by this node of the expression tree.
   * If True, parentheses should be introduced around the totality of the syntax expression
   * corresponding to this operator node and its operands.
   */
  private Boolean precedenceOverridden;
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
  public Boolean isBoolean() {
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

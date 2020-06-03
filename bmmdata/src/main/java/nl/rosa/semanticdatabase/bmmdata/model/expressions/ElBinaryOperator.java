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
  public ElFunctionCall equivalentCall() {
    //TODO
    return null;
  }
}

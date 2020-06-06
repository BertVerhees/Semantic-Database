package nl.rosa.semanticdatabase.bmmdata.model.expressions;


import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.class_features.BmmFunction;
import nl.rosa.semanticdatabase.bmmdata.model.class_features.BmmOperator;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;

import lombok.NonNull;

/**
 * Class ElBinaryOperator
 * Binary operator expression node
 */
@Data
@EqualsAndHashCode(callSuper = true)
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
  @NonNull
  private BmmFunction definition;

  // Functions
  @NonNull
  public BmmOperator operatorDefinition(){
    return null;
  }
  @NonNull
  public ElFunctionCall equivalentcall;
  /**
   * ElExpression
   */
@NonNull
public BmmType evalType(){
  return null;
}
  @NonNull
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

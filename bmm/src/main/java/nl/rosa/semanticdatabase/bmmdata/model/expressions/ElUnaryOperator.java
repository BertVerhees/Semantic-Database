package nl.rosa.semanticdatabase.bmmdata.model.expressions;


import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.class_features.BmmFunction;
import nl.rosa.semanticdatabase.bmmdata.model.class_features.BmmOperator;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;

import lombok.NonNull;

/**
 * Class ElUnaryOperator
 * Unary operator expression node.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ElUnaryOperator extends BmmBaseEntity implements ElOperator {
/**
 *      ElOperator
 *        ElExpression
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
//======================================================================================

  /**
   * Operand node.
   */
  private ElExpression operand;

  @Override
  public ElFunctionCall equivalentCall() {
    //TODO
    return null;
  }

}

package nl.rosa.semanticdatabase.bmmdata.model.expressions;


import lombok.Data;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.class_features.BmmFunction;
import nl.rosa.semanticdatabase.bmmdata.model.class_features.BmmOperator;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;

import javax.validation.constraints.NotNull;

/**
 * Class ElUnaryOperator
 * Unary operator expression node.
 */
@Data
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
//======================================================================================

  /**
   * Operand node.
   */
  private ElExpression operand;
  
  //
  // Constructors
  //
  public ElUnaryOperator () { };

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

  //
  // Methods
  //
}

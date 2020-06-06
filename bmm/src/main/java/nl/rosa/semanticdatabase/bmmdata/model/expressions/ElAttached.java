package nl.rosa.semanticdatabase.bmmdata.model.expressions;


import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.class_features.BmmFunction;
import nl.rosa.semanticdatabase.bmmdata.model.class_features.BmmOperator;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmSimpleType;

import lombok.NonNull;

/**
 * Class ElAttached
 * A predicate on any object reference (including function call) that returns True
 * if the reference is attached, i.e. non-Void.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ElAttached extends BmmBaseEntity implements ElPredicate {
/**
 * ElPredicate
 *  ElTerminal
 *    ElExpression
 *
 */
  /**
   * ElPredicate
   */
  private ElInstanceRef operand;
  // Functions
  public BmmSimpleType evalType(){
    return null;
  }
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
//========================================================================
  @Override
  public Boolean isBoolean() {
    return false;
  }
}

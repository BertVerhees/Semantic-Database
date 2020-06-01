package nl.rosa.semanticdatabase.bmmdata.model.expressions;


import lombok.Data;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.class_features.BmmFunction;
import nl.rosa.semanticdatabase.bmmdata.model.class_features.BmmOperator;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmSimpleType;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;

import javax.validation.constraints.NotNull;

/**
 * Class ElAttached
 * A predicate on any object reference (including function call) that returns True
 * if the reference is attached, i.e. non-Void.
 */
@Data
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
  //
  // Fields
  //

  // ElPredicate
  /**
   * The target instance of this predicate.
   */
  private ElInstanceRef operand;



  //
  // Constructors
  //
  public ElAttached () { };

  @Override
  public BmmSimpleType evalType() {
    return null;
  }

  @Override
  public Boolean isBoolean() {
    return false;
  }
}

package nl.rosa.semanticdatabase.bmmdata.model.expressions;


import lombok.Data;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;

import javax.validation.constraints.NotNull;

/**
 * Class ElConstraintExpression
 * Special kind of expression representing a constraint on values. Used with the
 * 'matches' operator. Does not follow the ordinary model of binary operator, since
 * the constraint is not itself a value-returning expression.
 */
@Data
public class ElConstraintExpression extends BmmBaseEntity implements ElExpression {
/**
 * ElExpression
 */
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
   * Left operand of constraint expression.
   */
  private ElExpression leftOperand;
  /**
   * Right hand side of the constraint expression. Redefined in sub-nl.rosa.semanticdatabase.bmm.model.types.
   */
  private Object constraint;
  
  //
  // Constructors
  //
  public ElConstraintExpression () { };
  
  //
  // Other methods
  //
  @Override
  public BmmType evalType() {
    return null;
  }

  @Override
  public Boolean isBoolean() {
    return false;
  }


}

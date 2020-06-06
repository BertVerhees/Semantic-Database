package nl.rosa.semanticdatabase.bmmdata.model.expressions;


import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmSimpleType;

import lombok.NonNull;

/**
 * Class ElDefined
 * A predicate taking one external variable reference argument, that returns true
 * if the reference is resolvable, i.e. the external value is obtainable.
 * 
 * NOTE
 * probably to be removed.
 * 
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ElDefined extends BmmBaseEntity implements ElPredicate {
/**
 * ElPredicate
 *  ElTerminal
 *    ElExpression
 */
  /**
   * ElPredicate
   */
  private ElInstanceRef operand;
  // Functions
  @NonNull
  public BmmSimpleType evalType(){
    return null;
  }
  /**
   * ElTerminal
   */
  /**
   * ElExpression
   */
  @NonNull
  public Boolean isBoolean(){
    return null;
  }
//========================================================================
}

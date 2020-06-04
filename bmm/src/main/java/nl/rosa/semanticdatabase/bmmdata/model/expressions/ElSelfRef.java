package nl.rosa.semanticdatabase.bmmdata.model.expressions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;


/**
 * Class ElSelfRef
 * Special meta-type used to represent a reference that may appear in any routine,
 * pre- or post-condition, or invariant, and resolves to the current object within
 * which feature references are scoped; corresponds to 'self', 'this' or 'Current'
 * in various programming languages.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ElSelfRef extends BmmBaseEntity implements ElInstanceRef {
/**
 *    ElInstanceRef
 *      ElTerminal
 *        ElExpression
 */
  /**
   * ElInstanceRef
   */
  /**
   * ElTerminal
   */
  /**
   * ElExpression
   */
//======================================================================================

  /**
   * Type of the current scoping instance, inferred from expression context.
   */
  private BmmType type;
  
  /**
   * Return type.
   * @return       nl.rosa.semanticdatabase.bmm.model.types.BmmType
   */
  public BmmType evalType()
  {
    //TODO
    return null;
  }

  @Override
  public Boolean isBoolean() {
    //TODO
    return false;
  }


}

package nl.rosa.semanticdatabase.bmmdata.model.expressions;

import lombok.Data;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;

import javax.validation.constraints.NotNull;


/**
 * Class ElSelfRef
 * Special meta-type used to represent a reference that may appear in any routine,
 * pre- or post-condition, or invariant, and resolves to the current object within
 * which feature references are scoped; corresponds to 'self', 'this' or 'Current'
 * in various programming languages.
 */
@Data
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
   * Type of the current scoping instance, inferred from expression context.
   */
  private BmmType type;
  
  //
  // Constructors
  //
  public ElSelfRef () { };
  //
  // Other methods
  //

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

package nl.rosa.semanticdatabase.bmmdata.model.expressions;


import lombok.Data;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmSimpleType;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;

import javax.validation.constraints.NotNull;

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
  public BmmSimpleType evalType(){
    return null;
  }
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
//========================================================================

  // ElPredicate
  /**
   * The target instance of this predicate.
   */
  private ElInstanceRef operand;



  //
  // Constructors
  //
  public ElDefined () { };

  @Override
  public BmmSimpleType evalType() {
    return null;
  }

  @Override
  public Boolean isBoolean() {
    return false;
  }

}

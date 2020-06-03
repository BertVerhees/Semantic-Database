package nl.rosa.semanticdatabase.bmmdata.model.expressions;

import lombok.Data;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmTupleType;

import javax.validation.constraints.NotNull;


/**
 * Class ElTuple
 * Defines an array of optionally named items each of any type.
 */
@Data
public class ElTuple extends BmmBaseEntity implements ElInstanceRef {
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

  //
  // Fields
  //

  /**
   * Items in the tuple, potentially with names. Typical use is to represent an argument list to routine call.
   */
  private ElTupleItem items;
  /**
   * Static type inferred from literal value.
   */
  private BmmTupleType type;
  
  //
  // Constructors
  //
  public ElTuple () { };
  
  //
  // Methods
  //

}

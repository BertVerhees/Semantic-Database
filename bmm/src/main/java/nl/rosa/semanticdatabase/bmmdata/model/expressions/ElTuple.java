package nl.rosa.semanticdatabase.bmmdata.model.expressions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmTupleType;

import lombok.NonNull;


/**
 * Class ElTuple
 * Defines an array of optionally named items each of any type.
 */
@Data
@EqualsAndHashCode(callSuper = true)
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
  @NonNull
  public BmmType evalType(){
    return null;
  }
  @NonNull
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

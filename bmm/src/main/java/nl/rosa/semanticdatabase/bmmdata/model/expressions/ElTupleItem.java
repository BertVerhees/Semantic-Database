package nl.rosa.semanticdatabase.bmmdata.model.expressions;


import lombok.Data;
import nl.rosa.semanticdatabase.bmmdata.model.BmmBaseEntity;

/**
 * Class ElTupleItem
 * A single tuple item, with an optional name.
 */
@Data
public class ElTupleItem extends BmmBaseEntity {

  /**
   * Reference to value entity. If Void, this indicates that the item in this position is Void, e.g. within a routine call parameter list.
   */
  private ElExpression item;  /**

   * 
   * 
   * Optional name of tuple item.
   *    */

  private String name;
  
  //
  // Constructors
  //
  public ElTupleItem () { };
  
}

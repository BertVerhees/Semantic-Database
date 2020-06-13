package nl.rosa.semanticdatabase.bmmdata.domain.expressions;


import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.domain.BmmBaseEntity;

/**
 * Class ElTupleItem
 * A single tuple item, with an optional name.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ElTupleItem extends BmmBaseEntity {

  /**
   * 0..1
   * item: EL_EXPRESSION
   * Reference to value entity. If Void, this indicates that the item in this position
   * is Void, e.g. within a routine call parameter list.
   */
  private ElExpression item;

  /**
   * 0..1
   * name: String
   * Optional name of tuple item.
   */

  private String name;
}

package nl.rosa.semanticdatabase.bmmdata.domain.expressions;


import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.bmmdata.domain.BmmBase;

/**
 * Class ElTupleItem
 * A single tuple item, with an optional name.
 */
public class ElTupleItem extends BmmBase {

  /**
   * 0..1
   * item: EL_EXPRESSION
   * Reference to value entity. If Void, this indicates that the item in this position
   * is Void, e.g. within a routine call parameter list.
   */
  @Getter
  @Setter
  private ElExpression item;

  /**
   * 0..1
   * name: String
   * Optional name of tuple item.
   */
  @Getter
  @Setter
  private String name;
}

package nl.rosa.semanticdatabase.bmmdata.domain.expressions;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import nl.rosa.semanticdatabase.bmmdata.domain.Bmm;

/**
 * Class ElTupleItem
 * A single tuple item, with an optional name.
 */
@EqualsAndHashCode(callSuper = true)
public class ElTupleItem extends Bmm {

  /**
   * 0..1
   * item: EL_EXPRESSION
   * Reference to value entity. If Void, this indicates that the item in this position
   * is Void, e.g. within a routine call parameter list.
   */
  @Getter
  private ElExpression item;
  public ElTupleItem setItem(ElExpression item) {
    this.item = item;

  }

  /**
   * 0..1
   * name: String
   * Optional name of tuple item.
   */
  @Getter
  private String name;
  public ElTupleItem setName(String name) {
    this.name = name;

  }
}

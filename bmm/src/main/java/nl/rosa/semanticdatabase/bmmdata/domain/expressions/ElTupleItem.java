package nl.rosa.semanticdatabase.bmmdata.domain.expressions;


import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.domain.Bmm;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Class ElTupleItem
 * A single tuple item, with an optional name.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("BBE_ETI")
public class ElTupleItem extends Bmm {

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

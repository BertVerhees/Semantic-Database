package nl.rosa.semanticdatabase.bmmdata.model.expressions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmTupleType;
import nl.rosa.semanticdatabase.bmmdata.model.types.BmmType;


/**
 * Class ElTuple
 * Defines an array of optionally named items each of any type.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ElTuple extends ElInstanceRef {
  /**
   * 0..1
   * items: List<EL_TUPLE_ITEM>
   * Items in the tuple, potentially with names. Typical use is to represent an argument list to routine call.
   */
  private ElTupleItem items;
  /**
   * 1..1
   * type: BMM_TUPLE_TYPE
   * Static type inferred from literal value.
   */
  private BmmTupleType type;

  @Override
  public BmmType evalType() {
    return null;
  }
}

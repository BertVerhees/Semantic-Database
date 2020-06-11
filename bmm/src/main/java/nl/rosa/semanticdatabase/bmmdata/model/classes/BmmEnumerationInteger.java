package nl.rosa.semanticdatabase.bmmdata.model.classes;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Class BmmEnumerationInteger
 * Integer-based enumeration meta-type.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BmmEnumerationInteger extends BmmEnumeration {
  /**
   * 0..1
   * (redefined)
   * item_values: List<BMM_INTEGER_VALUE>
   * Optional list of specific values. Must be 1:1 with item_names list.
   */
  public List<Integer> itemValues()
  {
    return null;
  }


}

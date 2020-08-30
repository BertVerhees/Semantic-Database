package nl.rosa.semanticdatabase.bmmdata.domain.classes;

import nl.rosa.semanticdatabase.bmmdata.domain.literal_values.BmmIntegerValue;

import java.util.Set;

/**
 * Class BmmEnumerationInteger
 * Integer-based enumeration meta-type.
 */
public class BmmEnumerationInteger extends BmmEnumeration<BmmIntegerValue> {
  /**
   * 0..1
   * (redefined)
   * item_values: List<BMM_INTEGER_VALUE>
   * Optional list of specific values. Must be 1:1 with item_names list.
   */
  private Set<BmmIntegerValue> itemValues;
  void setItemValues(Set<BmmIntegerValue> items) {
    this.itemValues = items;
  }
}

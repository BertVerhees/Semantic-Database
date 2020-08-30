package nl.rosa.semanticdatabase.bmmdata.domain.classes;


import nl.rosa.semanticdatabase.bmmdata.domain.literal_values.BmmStringValue;

import java.util.*;

/**
 * Class BmmEnumerationString
 * String-based enumeration meta-type.
 */
public class BmmEnumerationString extends BmmEnumeration<BmmStringValue> {
  /**
   * 0..1
   * (redefined)
   * item_values: List<BMM_STRING_VALUE>
   * Optional list of specific values. Must be 1:1 with item_names list.
   * @return
   */
  private Set<BmmStringValue> itemValues;
  Set<BmmStringValue> getItemValues() {
    return itemValues;
  }
  void setItemValues(Set<BmmStringValue> items) {
    this.itemValues = items;
  }
}

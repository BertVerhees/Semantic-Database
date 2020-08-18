package nl.rosa.semanticdatabase.bmmdata.domain.classes;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.domain.literal_values.BmmIntegerValue;
import nl.rosa.semanticdatabase.bmmdata.domain.literal_values.BmmStringValue;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class BmmEnumerationInteger
 * Integer-based enumeration meta-type.
 */
@EqualsAndHashCode(callSuper = true)
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

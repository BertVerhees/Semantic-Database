package nl.rosa.semanticdatabase.bmmdata.domain.classes;


import lombok.EqualsAndHashCode;
import lombok.NonNull;
import nl.rosa.semanticdatabase.bmmdata.domain.literal_values.BmmLiteralValue;
import nl.rosa.semanticdatabase.bmmdata.domain.literal_values.BmmStringValue;

import javax.management.StringValueExp;
import java.util.*;

/**
 * Class BmmEnumerationString
 * String-based enumeration meta-type.
 */
public class BmmEnumerationString extends BmmEnumeration {
  /**
   * 0..1
   * (redefined)
   * item_values: List<BMM_STRING_VALUE>
   * Optional list of specific values. Must be 1:1 with item_names list.
   * @return
   */
  private Set<BmmStringValue> itemValues;
  public void addItemValue(@NonNull BmmStringValue value){
    if(itemValues==null){
      itemValues = new HashSet<>();
    }
    itemValues.add(value);

  }
  public void addItemValues(Set<BmmStringValue> items){
    items.forEach(this::addItemValue);

  }
  public void removeItemValue(BmmStringValue item){
    if(itemValues!=null) {
      itemValues.remove(item);
    }
  }
  void setItemValues(Set<BmmLiteralValue> items) {
    this.itemValues = new HashSet<>();
    items.forEach(item -> {
      this.itemValues.add((BmmStringValue) item);
    });
  }
  private Set<BmmStringValue> getItemValues() {
    return itemValues;
  }

}

package nl.rosa.semanticdatabase.bmmdata.model.classes;

import lombok.Data;

import java.util.List;

/**
 * Class BmmEnumerationInteger
 * Integer-based enumeration meta-type.
 */
@Data
public class BmmEnumerationInteger extends BmmEnumeration {
  /**
   * Optional list of specific values. Must be 1:1 with item_names list.
   */
  public List<Integer> itemValues()
  {
    return null;
  }


}

package nl.rosa.semanticdatabase.bmmdata.domain.classes;


import java.util.List;

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
  public List<String> itemValues()
  {
    return null;
  }


}

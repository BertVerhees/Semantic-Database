package nl.rosa.semanticdatabase.bmmdata.model.classes;

import lombok.Data;
import lombok.EqualsAndHashCode;
import nl.rosa.semanticdatabase.bmmdata.model.literal_values.BmmLiteralValue;

import java.util.List;
import java.util.Map;


/**
 * Class BmmEnumeration
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BmmEnumeration extends BmmSimpleClass {
 /**
  * 0..1
  * item_names: List<String>
  * The list of names of the enumeration. If no values are supplied, the integer values 0, 1, 2, …​ are assumed.
   */
  private List<String> itemNames;
  /**
   * 0..1
   * item_values: List<BMM_LITERAL_VALUE>
   * Optional list of specific values. Must be 1:1 with item_names list.
   */
  private BmmLiteralValue itemValues;
  /**
   * 1..1
   * name_map (): Hash<String, String>
   * Map of item_names to item_values (stringified).
   */
  public Map<String,String> nameMap()
  {
    //TODO
    return null;
  }
}

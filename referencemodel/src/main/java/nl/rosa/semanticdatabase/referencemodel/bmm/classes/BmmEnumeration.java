package nl.rosa.semanticdatabase.referencemodel.bmm.classes;

import lombok.Data;
import nl.rosa.semanticdatabase.referencemodel.bmm.literal_values.BmmLiteralValue;

import java.util.List;
import java.util.Map;


/**
 * Class BmmEnumeration
 */
@Data
public class BmmEnumeration extends BmmSimpleClass {

  //
  // Fields
  //

  /**
   * The list of names of the enumeration. If no values are supplied, the integer values 0, 1, 2, �? are assumed.
   */
  private List<String> itemNames;
  /**
   * Optional list of specific values. Must be 1:1 with item_names list.
   */
  private BmmLiteralValue itemValues;
  
  //
  // Constructors
  //
  public BmmEnumeration () { };
  
  //
  // Other methods
  //

  /**
   * @return       Hash<String,String>
   */
  public Map<String,String> nameMap()
  {
    //TODO
    return null;
  }


}

package nl.rosa.semanticdatabase.bmmdata.domain.classes;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import java.util.List;

/**
 * Class BmmEnumerationString
 * String-based enumeration meta-type.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
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

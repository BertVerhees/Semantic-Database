package nl.rosa.semanticdatabase.bmmdata.domain.classes;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

/**
 * Class BmmEnumerationString
 * String-based enumeration meta-type.
 */
@Entity
@DiscriminatorValue("BBE_BD_BM_BC_BSC_BE_BES")
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

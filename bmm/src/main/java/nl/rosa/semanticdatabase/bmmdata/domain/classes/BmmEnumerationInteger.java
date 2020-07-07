package nl.rosa.semanticdatabase.bmmdata.domain.classes;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

/**
 * Class BmmEnumerationInteger
 * Integer-based enumeration meta-type.
 */
@Entity
@DiscriminatorValue("BBE_BD_BM_BC_BSC_BE_BEI")
public class BmmEnumerationInteger extends BmmEnumeration {
  /**
   * 0..1
   * (redefined)
   * item_values: List<BMM_INTEGER_VALUE>
   * Optional list of specific values. Must be 1:1 with item_names list.
   */
  public List<Integer> itemValues()
  {
    return null;
  }


}

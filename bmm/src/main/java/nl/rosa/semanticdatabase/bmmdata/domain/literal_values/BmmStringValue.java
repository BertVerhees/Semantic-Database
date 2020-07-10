package nl.rosa.semanticdatabase.bmmdata.domain.literal_values;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * Class BmmStringValue
 * Meta-type for a literal String value, for which type is fixed to the BMM_TYPE
 * representing String and value is of type String.
 */
public class BmmStringValue extends BmmLiteralValue {
  /**
   * 1..1
   * (redefined)
   * value: String
   * Native String value.
   */
  @NonNull
  @Getter
  @Setter
  private String value;

}

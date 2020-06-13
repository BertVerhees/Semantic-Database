package nl.rosa.semanticdatabase.bmmdata.domain.literal_values;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.Entity;

/**
 * Class BmmStringValue
 * Meta-type for a literal String value, for which type is fixed to the BMM_TYPE
 * representing String and value is of type String.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class BmmStringValue extends BmmLiteralValue {
  /**
   * 1..1
   * (redefined)
   * value: String
   * Native String value.
   */
  @NonNull
  private String value;

}

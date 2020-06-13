package nl.rosa.semanticdatabase.bmmdata.domain.literal_values;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

import javax.persistence.Entity;

/**
 * Class BmmIntegerValue
 * Meta-type for a literal Integer value, for which type is fixed to the BMM_TYPE
 * representing Integer and value is of type Integer.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class BmmIntegerValue extends BmmLiteralValue {
  /**
   * 1..1
   * (redefined)
   * value: Integer
   * Native Integer value.
   */
  @NonNull
  private Integer value;
}

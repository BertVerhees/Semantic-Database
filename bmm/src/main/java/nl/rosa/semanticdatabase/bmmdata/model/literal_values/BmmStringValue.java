package nl.rosa.semanticdatabase.bmmdata.model.literal_values;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

/**
 * Class BmmStringValue
 * Meta-type for a literal String value, for which type is fixed to the BMM_TYPE
 * representing String and value is of type String.
 */
@Data
@EqualsAndHashCode(callSuper = true)
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

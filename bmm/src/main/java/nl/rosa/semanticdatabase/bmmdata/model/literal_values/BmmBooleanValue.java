package nl.rosa.semanticdatabase.bmmdata.model.literal_values;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

/**
 * Class BmmBooleanValue
 * Meta-type for a literal Boolean value, for which type is fixed to the BMM_TYPE
 * representing Boolean and value is of type Boolean.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BmmBooleanValue extends BmmLiteralValue {
  /**
   * 1..1
   * (redefined)
   * value: Boolean
   * Native Boolean value.
   */
  @NonNull
  private Boolean value;
}

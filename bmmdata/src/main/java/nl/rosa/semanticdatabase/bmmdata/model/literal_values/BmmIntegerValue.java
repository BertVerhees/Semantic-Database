package nl.rosa.semanticdatabase.bmmdata.model.literal_values;


import lombok.Data;

/**
 * Class BmmIntegerValue
 * Meta-type for a literal Integer value, for which type is fixed to the BMM_TYPE
 * representing Integer and value is of type Integer.
 */
@Data
public class BmmIntegerValue extends BmmLiteralValue {
  /**
   * Native Integer value.
   */
  private Integer value;
}

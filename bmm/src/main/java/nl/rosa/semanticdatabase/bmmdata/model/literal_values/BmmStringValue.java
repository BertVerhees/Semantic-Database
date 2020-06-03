package nl.rosa.semanticdatabase.bmmdata.model.literal_values;


import lombok.Data;

/**
 * Class BmmStringValue
 * Meta-type for a literal String value, for which type is fixed to the BMM_TYPE
 * representing String and value is of type String.
 */
@Data
public class BmmStringValue extends BmmLiteralValue {
  /**
   * Native String value.
   */
  private String value;

}

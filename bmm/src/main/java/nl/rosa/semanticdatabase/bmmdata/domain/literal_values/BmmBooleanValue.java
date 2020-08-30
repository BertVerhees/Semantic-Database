package nl.rosa.semanticdatabase.bmmdata.domain.literal_values;


import lombok.*;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmSimpleType;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmType;

import javax.persistence.Entity;

/**
 * Class BmmBooleanValue
 * Meta-type for a literal Boolean value, for which type is fixed to the BMM_TYPE
 * representing Boolean and value is of type Boolean.
 */
public class BmmBooleanValue extends BmmPrimitiveValue<BmmSimpleType, Boolean> {
  /**
   * 1..1
   * (redefined)
   * value: Boolean
   * Native Boolean value.
   */
}

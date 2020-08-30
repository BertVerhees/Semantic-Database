package nl.rosa.semanticdatabase.bmmdata.domain.literal_values;


import lombok.*;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmSimpleType;
import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmType;

import javax.persistence.Entity;

/**
 * Class BmmIntegerValue
 * Meta-type for a literal Integer value, for which type is fixed to the BMM_TYPE
 * representing Integer and value is of type Integer.
 */
public class BmmIntegerValue extends BmmPrimitiveValue<BmmSimpleType, Integer> {
    /**
     * 1..1
     * (redefined)
     * value: Integer
     * Native Integer value.
     */
}

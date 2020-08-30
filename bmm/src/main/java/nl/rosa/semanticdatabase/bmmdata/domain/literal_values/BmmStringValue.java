package nl.rosa.semanticdatabase.bmmdata.domain.literal_values;

import nl.rosa.semanticdatabase.bmmdata.domain.types.BmmSimpleType;

/**
 * Class BmmStringValue
 * Meta-type for a literal String value, for which type is fixed to the BMM_TYPE
 * representing String and value is of type String.
 */
public class BmmStringValue extends BmmPrimitiveValue<BmmSimpleType, String> {
    /**
     * 1..1
     * (redefined)
     * value: String
     * Native String value.
     */
}

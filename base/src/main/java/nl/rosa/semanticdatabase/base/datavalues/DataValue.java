package nl.rosa.semanticdatabase.base.datavalues;


import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.encapsulated.DvParsable;
import nl.rosa.semanticdatabase.base.datavalues.quantity.*;
import nl.rosa.semanticdatabase.base.datavalues.quantity.datetime.DvDate;
import nl.rosa.semanticdatabase.base.datavalues.quantity.datetime.DvDateTime;
import nl.rosa.semanticdatabase.base.datavalues.quantity.datetime.DvDuration;
import nl.rosa.semanticdatabase.base.datavalues.quantity.datetime.DvTime;
import nl.rosa.semanticdatabase.base.datavalues.text.DvCodedText;
import nl.rosa.semanticdatabase.base.datavalues.text.DvText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO: check if we can add common fields here for convenience, for example value and magnitude
 * <p>
 * Originally: Created by pieter.bos on 04/11/15.
 */
public abstract class DataValue {

    /**
     * Parse a serialised dataValue and returns a concrete DataValue class
     *
     * The format is the following:
     * [REFERENCE_MODEL_CLASS_NAME],[SERIALIZED FORMAT]
     *
     * @param value
     * @return instance of DataValue
     */
    public static DataValue parseValue(String value) {
        if(value == null) {
            throw new IllegalArgumentException("null value");
        }

        int i = value.indexOf(",");
        if(i < 0 || i == value.length()) {
            throw new IllegalArgumentException("wrong string format (" + value + ")");
        }

        String rmName = value.substring(0, i);
        DataValue dv = dataValueMap.get(rmName);

        if(dv == null) {
            throw new IllegalArgumentException("unsupported RM class[" + rmName + "]");
        }

        String v = value.substring(i + 1).trim();
        return dv.parse(v);
    }

    /**
     * Parse a serialised dataValue. Implemented by subclasses.
     *
     * @param value
     * @return instance of DataValue
     */
    public DataValue parse(String value) {
        throw new RuntimeException("no implementation");
    }

    private final static Map<String, DataValue> dataValueMap;

    /*
     * Initiate the mapping between ReferenceModelName and concrete dataValue
     */
    static {
        DvText normal = new DvText("normal");
        DvCount lower = new DvCount(1L);
        DvCount upper = new DvCount(10L);
        ReferenceRange<DvCount> normalRange = new ReferenceRange(normal, new DvInterval<>(lower, upper));
        List<ReferenceRange> otherReferenceRanges = new ArrayList<>();
        otherReferenceRanges.add(normalRange);

        dataValueMap = new HashMap<String, DataValue>();
        dataValueMap.put(ReferenceModelName.DV_COUNT.getName(), new DvCount(0L));
        dataValueMap.put(ReferenceModelName.DV_BOOLEAN.getName(), new DvBoolean(false));
        dataValueMap.put(ReferenceModelName.DV_QUANTITY.getName(), new DvQuantity(1));
        dataValueMap.put(ReferenceModelName.DV_PROPORTION.getName(), new DvProportion(1,1, ProportionKind.FRACTION, 0L));
        dataValueMap.put(ReferenceModelName.DV_TEXT.getName(), new DvText("text"));
        dataValueMap.put(ReferenceModelName.DV_CODED_TEXT.getName(), new DvCodedText("text", new CodePhrase("tm", "cd")));
        dataValueMap.put(ReferenceModelName.CODE_PHRASE.getName(), new CodePhrase("tm","cd"));
        dataValueMap.put(ReferenceModelName.DV_ORDINAL.getName(), new DvOrdinal(0L,"text","tm","cd"));
        dataValueMap.put(ReferenceModelName.DV_DATE_TIME.getName(), new DvDateTime("2001-02-11T00"));
        dataValueMap.put(ReferenceModelName.DV_DATE.getName(), new DvDate("2001-02-11"));
        dataValueMap.put(ReferenceModelName.DV__TIME.getName(), new DvTime("00:00:00.000Z"));
        dataValueMap.put(ReferenceModelName.DV_DURATION.getName(), new DvDuration("P10D"));
        dataValueMap.put(ReferenceModelName.DV_PARSABLE.getName(), new DvParsable("text", "txt"));
    }
}

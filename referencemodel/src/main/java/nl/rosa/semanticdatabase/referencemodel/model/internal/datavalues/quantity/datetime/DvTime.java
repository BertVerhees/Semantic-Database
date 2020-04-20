package nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.quantity.datetime;

import nl.rosa.semanticdatabase.referencemodel.model.internal.datatypes.CodePhrase;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.SingleValuedDataValue;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.quantity.DvInterval;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.quantity.ReferenceRange;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datetime.DateTimeParsers;
import org.springframework.lang.Nullable;

import java.time.LocalTime;
import java.time.temporal.TemporalAccessor;
import java.util.List;

public class DvTime extends DvTemporal<Double> implements SingleValuedDataValue<TemporalAccessor> {

    private TemporalAccessor value;


    public DvTime() {
    }

    public DvTime(TemporalAccessor value) {
        this.value = value;
    }

    /**
     * Constructs a DVTime form an Iso8601 Time String
     *
     * @param iso8601Time
     */
    public DvTime(String iso8601Time) {
        this.value = DateTimeParsers.parseTimeValue(iso8601Time);
    }

    public DvTime(
            @Nullable List<ReferenceRange> otherReferenceRanges,
            @Nullable DvInterval normalRange,
            @Nullable CodePhrase normalStatus,
            @Nullable String magnitudeStatus,
            @Nullable DvDuration accuracy,
            TemporalAccessor value) {
        super(otherReferenceRanges, normalRange, normalStatus, magnitudeStatus, accuracy);
        this.value = value;
    }

    public void setMagnitude(Double magnitude) {
        if(magnitude == null) {
            value = null;
        } else {
            value = LocalTime.ofSecondOfDay(Math.round(magnitude));
        }
    }
}

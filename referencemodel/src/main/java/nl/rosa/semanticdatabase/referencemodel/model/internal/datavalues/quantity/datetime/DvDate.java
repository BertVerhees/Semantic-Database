package nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.quantity.datetime;

import lombok.Getter;
import lombok.Setter;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datatypes.CodePhrase;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.quantity.DvInterval;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.quantity.ReferenceRange;
import nl.rosa.semanticdatabase.referencemodel.model.internal.datetime.DateTimeParsers;
import org.springframework.lang.Nullable;

import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.util.List;

@Getter
@Setter
public class DvDate extends DvTemporal<Long> {
    private Temporal value;
    public DvDate() {
    }

    @Override
    public DvDuration getAccuracy() {
        return accuracy;
    }

    @Override
    public Long getMagnitude() {
        return null;
    }

    public DvDate(Temporal value) {
        setValue(value);
    }
    /**
     * Constructs a DvDate from an ISO 8601 Date String
     *
     * @param iso8601Date
     */
    public DvDate(String iso8601Date) {

        setValue(DateTimeParsers.parseDateValue(iso8601Date));
    }

    public DvDate(
            @Nullable List<ReferenceRange> otherReferenceRanges,
            @Nullable DvInterval normalRange,
            @Nullable CodePhrase normalStatus,
            @Nullable String magnitudeStatus,
            @Nullable DvDuration accuracy,
            Temporal value) {
        super(otherReferenceRanges, normalRange, normalStatus, magnitudeStatus, accuracy);
        this.value = value;
    }

    public Temporal getValue() {
        return value;
    }

    public void setValue(Temporal value) {
        if(value.isSupported(ChronoField.HOUR_OF_DAY)) {
            //TODO: do we really need this validation?
            throw new IllegalArgumentException("value must only have a year, month or date, but this supports hours: " + value);
        }
        this.value = value;
    }
}

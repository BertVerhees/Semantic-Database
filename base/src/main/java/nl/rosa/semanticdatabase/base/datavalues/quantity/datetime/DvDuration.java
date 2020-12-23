package nl.rosa.semanticdatabase.base.datavalues.quantity.datetime;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.SingleValuedDataValue;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvAmount;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvInterval;
import nl.rosa.semanticdatabase.base.datavalues.quantity.ReferenceRange;
import nl.rosa.semanticdatabase.base.utils.datetime.DateTimeParsers;
import org.threeten.extra.PeriodDuration;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;
import java.util.List;
import java.util.Objects;

/**
 * TODO: magnitude of duration is not defined properly
 * Originally: Created by pieter.bos on 04/11/15.
 */

public class DvDuration
        extends DvAmount<Long>
        implements SingleValuedDataValue<PeriodDuration> {

    private PeriodDuration value;

    public DvDuration() {
    }

    public DvDuration(PeriodDuration value) {
        this.value = value;
    }

    /**
     * Constructs a DvDuration form an Iso8601 Duration
     *
     * @param iso8601Duration
     */
    public DvDuration(String iso8601Duration) {
        this.value = DateTimeParsers.parseDurationValue(iso8601Duration);
    }

    public DvDuration(
            List<ReferenceRange> otherReferenceRanges,
            DvInterval normalRange,
            CodePhrase normalStatus,
            Double accuracy,
            Boolean accuracyIsPercent,
            String magnitudeStatus,
            PeriodDuration value) {
        super(otherReferenceRanges, normalRange, normalStatus, accuracy, accuracyIsPercent, magnitudeStatus);
        this.value = value;
    }

    @Override
    public PeriodDuration getValue() {
        return value;
    }

    @Override
    public void setValue(PeriodDuration value) {
        this.value = value;
    }

    @Override
    public Long getMagnitude() {
        return null;
    }

    /**
     * Create a Duration from two instances of DvWorldTime
     *
     * @param start
     * @param end
     */
    public static Duration getDifference(DvTemporal start, DvTemporal end) {
        return Duration.between(start.getDateTime(), end.getDateTime());
    }
    /**
     * Addition of a Duration to this DvDuration.
     * @param q
     * @return product of addition
     */
    @Override
    public PeriodDuration add(DvDuration q) {
        PeriodDuration duration = q.getValue();
        return value.plus(duration);
    }

    /**
     * Subtract a DvDuration from this DvDuration.
     * @param q
     * @return product of substration
     */
    @Override
    public PeriodDuration subtract(DvDuration q) {
        PeriodDuration duration = q.getValue();
        return value.minus(duration);
    }

    /**
     * Difference between this DvDuration and other.
     * @param other
     * @return diff type
     */
    public PeriodDuration diff(DvDuration other) {
        PeriodDuration duration = other.getValue();
        return value.minus(duration);
    }

    /**
     * Negated version of current duration.
     *
     * Assuming the current duration is positive, the negated version represents a time prior to some
     * origin point, or a negative age (e.g. so-called 'adjusted age' of premature infant).
     * @return
     */
    public PeriodDuration negative(){
        return value.negated();
    }

    /**
     * True if other is less than this Quantified object. Based on comparison of magnitude.
     * @param other
     * @return
     */
    public Boolean lessThan(PeriodDuration other){
        return value.compareTo(value.from(other))<0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        DvDuration that = (DvDuration) o;

        return Objects.equals(value, that.value);

    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value);
    }
}

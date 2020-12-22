package nl.rosa.semanticdatabase.base.datavalues.quantity.datetime;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.SingleValuedDataValue;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvAmount;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvInterval;
import nl.rosa.semanticdatabase.base.datavalues.quantity.ReferenceRange;
import nl.rosa.semanticdatabase.base.utils.datetime.DateTimeParsers;

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
        implements SingleValuedDataValue<TemporalAmount> {

    private Duration value;

    public DvDuration() {
    }

    public DvDuration(Duration value) {
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
            TemporalAmount value) {
        super(otherReferenceRanges, normalRange, normalStatus, accuracy, accuracyIsPercent, magnitudeStatus);
        this.value = value;
    }

    @Override
    public TemporalAmount getValue() {
        return value;
    }

    @Override
    public void setValue(TemporalAmount value) {
        this.value = value;
    }

    @Override
    public Long getMagnitude() {
        return null; //no magnitude defined in spec
    }

    /**
     * Create a Duration from two instances of DvWorldTime
     *
     * @param start
     * @param end
     */
    public static DvDuration getDifference(DvTemporal start, DvTemporal end) {
        return new DvDuration(
                null,
                null,
                null,
                0.0,
                false,
                null,
                Duration.between(start.getDateTime(), end.getDateTime()));
    }
    /**
     * Addition of a Duration to this DvDuration.
     * @param q
     * @return product of addition
     */
    @Override
    public DvDuration add(DvDuration q) {
        DvDuration d = (DvDuration) q;
        return new DvDuration(
                getOtherReferenceRanges(),
                getNormalRange(),
                getNormalStatus(),
                getAccuracy(),
                getMagnitudeStatus(),
                ((Duration)d.getValue()).addTo(q.getValue()));
    }

    /**
     * Subtract a DvDuration from this DvDuration.
     * @param q
     * @return product of substration
     */
    @Override
    public DvDuration subtract(DvDuration q) {
        if (!getDiffType().isInstance(q)) {
            throw new IllegalArgumentException("invalid difference type");
        }
        return add(q.negative());
    }

    /**
     * Difference between this DvDuration and other.
     * @param other
     * @return diff type
     */
    public DvDuration diff(DvDuration other) {
        return null;
    }

    /**
     * Negated version of current duration.
     *
     * Assuming the current duration is positive, the negated version represents a time prior to some
     * origin point, or a negative age (e.g. so-called 'adjusted age' of premature infant).
     * @return
     */
    public DvDuration negative(){
        return null;
    }

    /**
     * True if other is less than this Quantified object. Based on comparison of magnitude.
     * @param other
     * @return
     */
    public Boolean lessThan(DvDuration other){
        return null;
    }

    /**
     * True, for any two Dates.
     * @param other
     * @return
     */
    public Boolean isStrictlyComparableTo(DvDuration other){
        return null;
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

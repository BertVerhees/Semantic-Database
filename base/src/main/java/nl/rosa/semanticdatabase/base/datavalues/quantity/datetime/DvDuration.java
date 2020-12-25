package nl.rosa.semanticdatabase.base.datavalues.quantity.datetime;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.SingleValuedDataValue;
import nl.rosa.semanticdatabase.base.datavalues.quantity.*;
import nl.rosa.semanticdatabase.base.utils.datetime.DateTimeParsers;
import nl.rosa.semanticdatabase.utils.datetime.AlmostComparablePeriodDuration;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Objects;

/**
 * TODO: magnitude of duration is not defined properly
 * Originally: Created by pieter.bos on 04/11/15.
 */

public class DvDuration
        extends DvAmount<DvDuration>{

    private AlmostComparablePeriodDuration value;

    public DvDuration() {
    }

    public DvDuration(AlmostComparablePeriodDuration value) {
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
            AlmostComparablePeriodDuration value) {
        super(otherReferenceRanges, normalRange, normalStatus, accuracy, accuracyIsPercent, magnitudeStatus);
        this.value = value;
    }

    @Override
    public AlmostComparablePeriodDuration getValue() {
        return value;
    }

    @Override
    public void setValue(AlmostComparablePeriodDuration value) {
        this.value = value;
    }

    @Override
    public AlmostComparablePeriodDuration getMagnitude() {
        return null;
    }

    /**
     * Create a Duration from two instances of DvWorldTime
     *
     * @param start
     * @param end
     */
    public static AlmostComparablePeriodDuration getDifference(DvTemporal start, DvTemporal end) {
        return AlmostComparablePeriodDuration.between(start.getDateTime(), end.getDateTime());
    }
    /**
     * Addition of a Duration to this DvDuration.
     * @param q
     * @return product of addition
     */
    @Override
    public DvQuantified<DvDuration> add(DvQuantified q) {
        AlmostComparablePeriodDuration duration = ((DvDuration)q).getValue();
        return new DvDuration(getOtherReferenceRanges(), getNormalRange(),
                getNormalStatus(), getAccuracy(), getAccuracyIsPercent(),
                getMagnitudeStatus(), value.plus(duration));
    }

    /**
     * Subtract a DvDuration from this DvDuration.
     * @param q
     * @return product of substration
     */
    @Override
    public DvQuantified<DvDuration> subtract(DvQuantified q) {
        AlmostComparablePeriodDuration duration = ((DvDuration)q).getValue();
        return new DvDuration(getOtherReferenceRanges(), getNormalRange(),
                getNormalStatus(), getAccuracy(), getAccuracyIsPercent(),
                getMagnitudeStatus(), value.minus(duration));
    }

    /**
     * Difference between this DvDuration and other.
     * @param other
     * @return diff type
     */
    public AlmostComparablePeriodDuration diff(DvDuration other) {
        AlmostComparablePeriodDuration duration = other.getValue();
        return value.minus(duration);
    }

    /**
     * Negated version of current duration.
     *
     * Assuming the current duration is positive, the negated version represents a time prior to some
     * origin point, or a negative age (e.g. so-called 'adjusted age' of premature infant).
     * @return
     */
    public AlmostComparablePeriodDuration negative(){
        return value.negated();
    }

    /**
     * True if other is less than this Quantified object. Based on comparison of magnitude.
     * @param other
     * @return
     */
    public Boolean lessThan(AlmostComparablePeriodDuration other){
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

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure
     * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))}
     * for all {@code x} and {@code y}.  (This
     * implies that {@code x.compareTo(y)} must throw an exception iff
     * {@code y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
     * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for
     * all {@code z}.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
     * <i>signum</i> function, which is defined to return one of {@code -1},
     * {@code 0}, or {@code 1} according to whether the value of
     * <i>expression</i> is negative, zero, or positive, respectively.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(DvOrdered o) {
        final DvDuration d = (DvDuration) o;

        /*
         * if (period.getYears() > d.period.getYears()) { return 1; } else if
         * (period.getYears() < d.period.getYears()) { return -1; } if
         * (period.getMonths() > d.period.getMonths()) { return 1; } else if
         * (period.getMonths() < d.period.getMonths()) { return -1; } if
         * (period.getWeeks() > d.period.getWeeks()) { return 1; } else if
         * (period.getWeeks() < d.period.getWeeks()) { return -1; } if
         * (period.getDays() > d.period.getDays()) { return 1; } else if
         * (period.getDays() < d.period.getDays()) { return -1; }
         *
         * if (period.getHours() > d.period.getHours()) { return 1; } else if
         * (period.getHours() < d.period.getHours()) { return -1; }
         *
         * if (period.getMinutes() > d.period.getMinutes()) { return 1; } else
         * if (period.getMinutes() < d.period.getMinutes()) { return -1; }
         *
         * if (period.getSeconds() > d.period.getSeconds()) { return 1; } else
         * if (period.getSeconds() < d.period.getSeconds()) { return -1; }
         *
         * if (period.getMillis() > d.period.getMillis()) { return 1; } else if
         * (period.getMillis() < d.period.getMillis()) { return -1; }
         */
        LocalDateTime dt = LocalDateTime.ofEpochSecond(0L,0,);
        Duration duration = period.toDurationFrom(dt);
        Duration otherD = d.period.toDurationFrom(dt);
        return duration.compareTo(otherD);
        // return 0;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure
     * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))}
     * for all {@code x} and {@code y}.  (This
     * implies that {@code x.compareTo(y)} must throw an exception iff
     * {@code y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
     * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for
     * all {@code z}.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
     * <i>signum</i> function, which is defined to return one of {@code -1},
     * {@code 0}, or {@code 1} according to whether the value of
     * <i>expression</i> is negative, zero, or positive, respectively.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(DvDuration o) {
        return 0;
    }
}

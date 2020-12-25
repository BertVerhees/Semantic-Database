package nl.rosa.semanticdatabase.base.datavalues.quantity.datetime;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.SingleValuedDataValue;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvAmount;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvInterval;
import nl.rosa.semanticdatabase.base.datavalues.quantity.ReferenceRange;
import nl.rosa.semanticdatabase.base.utils.datetime.DateTimeFormatters;
import nl.rosa.semanticdatabase.base.utils.datetime.DateTimeParsers;
import nl.rosa.semanticdatabase.utils.datetime.AlmostComparablePeriodDuration;

import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQueries;
import java.util.List;
import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 */

public class DvDateTime
        extends DvTemporal<DvDateTime> {

    /**
     * Addition of a Duration to this DvDateTime.
     * @param q
     * @return product of addition
     */
    @Override
    public DvDateTime add(DvDuration q) {
        LocalDateTime dateTime = getValue();
        AlmostComparablePeriodDuration duration = q.getValue();
        return new DvDateTime(getOtherReferenceRanges(), getNormalRange(),
                getNormalStatus(), getAccuracy(), getMagnitudeStatus(),
                dateTime.plus(duration));
    }

    /**
     * Subtract a Duration from this DvDateTime.
     * @param q
     * @return product of substration
     */
    @Override
    public DvDateTime subtract(DvDuration q) {
        LocalDateTime dateTime = getValue();
        AlmostComparablePeriodDuration duration = q.getValue();
        return new DvDateTime(getOtherReferenceRanges(), getNormalRange(),
                getNormalStatus(), getAccuracy(), getMagnitudeStatus(),
                dateTime.minus(duration));
    }

    /**
     * Difference between this DvDateTime and other.
     * @param other
     * @return diff type
     */
    public AlmostComparablePeriodDuration diff(LocalDateTime other) {
        return AlmostComparablePeriodDuration.between(value, other);
    }

    /**
     * True if other is less than this Quantified object. Based on comparison of magnitude.
     * @param other
     * @return
     */
    public Boolean lessThan(LocalDateTime other){
        return value.compareTo(value.from(other))<0;
    }

    public DvDateTime(LocalDateTime value) {
        this.value = value;
    }

    /**
     * Constructs a DvDateTime from an ISO 8601 Date-Time String
     *
     * @param iso8601DateTime
     */
    public DvDateTime(String iso8601DateTime) {
        this.value = DateTimeParsers.parseDateTimeValue(iso8601DateTime);
    }


    public DvDateTime(
            List<ReferenceRange> otherReferenceRanges,
            DvInterval normalRange,
            CodePhrase normalStatus,
            DvDuration accuracy,
            String magnitudeStatus,
            LocalDateTime value) {
        super(otherReferenceRanges, normalRange, normalStatus, accuracy, magnitudeStatus, value);
    }

    @Override
    public LocalDateTime getValue() {
        return value;
    }

    @Override
    public void setValue(LocalDateTime value) {
        this.value = value;
    }

    @Override
    public LocalDateTime getMagnitude() {
            return value;
    }

    public void setMagnitude(LocalDateTime magnitude) {
            value = magnitude;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        DvDateTime that = (DvDateTime) o;

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
    public int compareTo(DvDateTime o) {
        return 0;
    }
}

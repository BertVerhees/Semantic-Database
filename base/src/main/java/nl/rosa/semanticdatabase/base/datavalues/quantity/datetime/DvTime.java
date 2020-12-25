package nl.rosa.semanticdatabase.base.datavalues.quantity.datetime;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.SingleValuedDataValue;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvAmount;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvInterval;
import nl.rosa.semanticdatabase.base.datavalues.quantity.ReferenceRange;
import nl.rosa.semanticdatabase.base.utils.datetime.DateTimeParsers;
import nl.rosa.semanticdatabase.utils.datetime.AlmostComparablePeriodDuration;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import java.util.Objects;

/**
 * TODO: implement java.time.Temporal for this object?
 * <p>
 * Deviation from the standard: the standard uses a String to represent a value here.
 * We do not, we use the java time types. Perhaps we will add a parser later.
 * possible issue: people constraining the String field of DvTime directly instead of using a Ctime. Ask people if this is an issue.
 * <p>
 * Originally: Created by pieter.bos on 04/11/15.
 */
public class DvTime
        extends DvTemporal<DvTime> {

    public DvTime(LocalTime value) {
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
            List<ReferenceRange> otherReferenceRanges,
            DvInterval normalRange,
            CodePhrase normalStatus,
            DvDuration accuracy,
            String magnitudeStatus,
            LocalTime value) {
        super(otherReferenceRanges, normalRange, normalStatus, accuracy, magnitudeStatus, value);
    }

    @Override
    public void setValue(LocalTime value) {
        this.value = value;
    }

    @Override
//    @XmlElements({
//            @XmlElement(type=OffsetTime.class),
//            @XmlElement(type=LocalTime.class)
//    })    
    public LocalTime getValue() {
        return value;
    }

    @Override
    public LocalTime getMagnitude() {
        return value;
    }

    public void setMagnitude(LocalTime magnitude) {
            value = magnitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        DvTime dvTime = (DvTime) o;

        return Objects.equals(value, dvTime.value);

    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value);
    }

    /**
     * Addition of a Duration to this DvTime.
     * @param q
     * @return product of addition
     */
    @Override
    public DvTime add(DvDuration q) {
        LocalTime time = getValue();
        AlmostComparablePeriodDuration duration = q.getValue();
        return new DvTime(getOtherReferenceRanges(), getNormalRange(),
                getNormalStatus(), getAccuracy(), getMagnitudeStatus(),
                time.plus(duration));
    }

    /**
     * Subtract a Duration from this DvTime.
     * @param q
     * @return product of substration
     */
    @Override
    public DvTime subtract(DvDuration q) {
        LocalTime time = getValue();
        AlmostComparablePeriodDuration duration = q.getValue();
        return new DvTime(getOtherReferenceRanges(), getNormalRange(),
                getNormalStatus(), getAccuracy(), getMagnitudeStatus(),
                time.minus(duration));
    }

    /**
     * Difference between this DvTime and other.
     * @param other
     * @return diff type
     */
    public MyPeriodDuration diff(LocalTime other) {
        return MyPeriodDuration.between(value, other);
    }

    /**
     * True if other is less than this Quantified object. Based on comparison of magnitude.
     * @param other
     * @return
     */
    public Boolean lessThan(LocalTime other){
        return value.compareTo(value.from(other))<0;
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
    public int compareTo(DvTime o) {
        return 0;
    }
}

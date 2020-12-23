package nl.rosa.semanticdatabase.base.datavalues.quantity.datetime;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.SingleValuedDataValue;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvAmount;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvInterval;
import nl.rosa.semanticdatabase.base.datavalues.quantity.ReferenceRange;
import nl.rosa.semanticdatabase.base.utils.datetime.DateTimeParsers;

import java.time.Duration;
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
        extends DvTemporal<LocalTime>
        implements SingleValuedDataValue<LocalTime> {

    private LocalTime value;


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
            String magnitudeStatus,
            DvDuration accuracy,
            LocalTime value) {
        super(otherReferenceRanges, normalRange, normalStatus, magnitudeStatus, accuracy);
        this.value = value;
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
    public LocalTime add(DvDuration q) {
        Duration duration = q.getValue();
        return value.plus(duration);
    }

    /**
     * Subtract a Duration from this DvTime.
     * @param q
     * @return product of substration
     */
    @Override
    public LocalTime subtract(DvDuration q) {
        Duration duration = q.getValue();
        return value.minus(duration);
    }

    /**
     * Difference between this DvTime and other.
     * @param other
     * @return diff type
     */
    public Duration diff(LocalTime other) {
        return Duration.between(value, other);
    }

    /**
     * True if other is less than this Quantified object. Based on comparison of magnitude.
     * @param other
     * @return
     */
    public Boolean lessThan(LocalTime other){
        return value.compareTo(value.from(other))<0;
    }
}

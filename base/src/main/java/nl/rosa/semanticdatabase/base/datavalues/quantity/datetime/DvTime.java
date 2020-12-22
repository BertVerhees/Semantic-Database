package nl.rosa.semanticdatabase.base.datavalues.quantity.datetime;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.SingleValuedDataValue;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvAmount;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvInterval;
import nl.rosa.semanticdatabase.base.datavalues.quantity.ReferenceRange;
import nl.rosa.semanticdatabase.base.utils.datetime.DateTimeParsers;

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
        extends DvTemporal<DvTime>
        implements SingleValuedDataValue<TemporalAccessor> {

    private TemporalAccessor value;


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
            List<ReferenceRange> otherReferenceRanges,
            DvInterval normalRange,
            CodePhrase normalStatus,
            String magnitudeStatus,
            DvDuration accuracy,
            TemporalAccessor value) {
        super(otherReferenceRanges, normalRange, normalStatus, magnitudeStatus, accuracy);
        this.value = value;
    }

    @Override
    public void setValue(TemporalAccessor value) {
        this.value = value;
    }

    @Override
//    @XmlElements({
//            @XmlElement(type=OffsetTime.class),
//            @XmlElement(type=LocalTime.class)
//    })    
    public TemporalAccessor getValue() {
        return value;
    }

    @Override
    public Double getMagnitude() {
        return value == null ? null : (double) LocalTime.from(value).toSecondOfDay();
    }

    public void setMagnitude(Double magnitude) {
        if (magnitude == null) {
            value = null;
        } else {
            value = LocalTime.ofSecondOfDay(Math.round(magnitude));
        }
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
        if (!getDiffType().isInstance(q)) {
            throw new IllegalArgumentException("invalid difference type");
        }
        DvDuration d = (DvDuration) q;
        LocalDateTime mdate = getDateTime();
        mdate.plus(d.getValue());
        return new DvTime(
                getOtherReferenceRanges(),
                getNormalRange(),
                getNormalStatus(),
                getAccuracy(),
                getMagnitudeStatus(),
                mdate.plus(d.getValue()));
    }

    /**
     * Subtract a Duration from this DvTime.
     * @param q
     * @return product of substration
     */
    @Override
    public DvTime subtract(DvDuration q) {
        if (!getDiffType().isInstance(q)) {
            throw new IllegalArgumentException("invalid difference type");
        }
        return add(q.negative());
    }

    /**
     * Difference between this DvTime and other.
     * @param other
     * @return diff type
     */
    public DvDuration diff(DvTime other) {
        return null;
    }

    /**
     * True if other is less than this Quantified object. Based on comparison of magnitude.
     * @param other
     * @return
     */
    public Boolean lessThan(DvTime other){
        return null;
    }

    /**
     * True, for any two Dates.
     * @param other
     * @return
     */
    public Boolean isStrictlyComparableTo(DvTime other){
        return null;
    }
}

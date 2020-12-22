package nl.rosa.semanticdatabase.base.datavalues.quantity.datetime;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvAbsoluteQuantity;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvInterval;
import nl.rosa.semanticdatabase.base.datavalues.quantity.ReferenceRange;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 01/03/16.
 */
public abstract class DvTemporal<MT extends Comparable>
        extends DvAbsoluteQuantity<DvDuration, MT> {

    
    private DvDuration accuracy;
    private LocalDateTime dateTime;

    public DvTemporal() {
    }

    public DvTemporal( DvDuration accuracy) {
        this.accuracy = accuracy;
    }

    public DvTemporal(
            List<ReferenceRange> otherReferenceRanges,
            DvInterval normalRange,
            CodePhrase normalStatus,
            String magnitudeStatus,
            DvDuration accuracy) {
        super(otherReferenceRanges, normalRange, normalStatus, magnitudeStatus);
        this.accuracy = accuracy;
    }

    /**
     * Addition of a Duration to this Date.
     * @param q
     * @return product of addition
     */
    public DvTemporal add(DvDuration q) {
        if (!getDiffType().isInstance(q)) {
            throw new IllegalArgumentException("invalid difference type");
        }
        DvDuration d = (DvDuration) q;
        LocalDateTime mdate = getDateTime();
        mdate.plus(d.getValue());
        return new DvDate(
                getOtherReferenceRanges(),
                getNormalRange(),
                getNormalStatus(),
                getAccuracy(),
                getMagnitudeStatus(),
                mdate.plus(d.getValue()));
    }

    /**
     * Subtract a Duration from this Date.
     * @param q
     * @return product of substration
     */
    @Override
    public DvTemporal subtract(DvDuration q) {
        if (!getDiffType().isInstance(q)) {
            throw new IllegalArgumentException("invalid difference type");
        }
        return add(q.negative());
    }

    /**
     * Difference between this Date and other.
     * @param other
     * @return diff type
     */
    public DvDuration diff(DvTemporal other) {
        return null;
    }

    /**
     * True if other is less than this Quantified object. Based on comparison of magnitude.
     * @param other
     * @return
     */
    public Boolean lessThan(DvTemporal other){
        return null;
    }

    /**
     * True, for any two Dates.
     * @param other
     * @return
     */
    public Boolean isStrictlyComparableTo(DvTemporal other){
        return null;
    }
    /**
     * Type of quantity which can be added or subtracted to this quantity.
     * Usually the same type, but may be different as in the case of dates and
     * times.
     *
     * @return diff type
     */
    public Class<DvDuration> getDiffType() {
        return DvDuration.class;
    }

    @Override
    public DvDuration getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(DvDuration accuracy) {
        this.accuracy = accuracy;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        DvTemporal<?> that = (DvTemporal<?>) o;

        return Objects.equals(accuracy, that.accuracy);

    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), accuracy);
    }
}

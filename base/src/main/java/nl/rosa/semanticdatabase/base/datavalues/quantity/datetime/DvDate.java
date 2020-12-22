package nl.rosa.semanticdatabase.base.datavalues.quantity.datetime;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.SingleValuedDataValue;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvAmount;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvInterval;
import nl.rosa.semanticdatabase.base.datavalues.quantity.ReferenceRange;
import nl.rosa.semanticdatabase.base.utils.datetime.DateTimeParsers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 */
public class DvDate
        extends DvTemporal<DvDate>
        implements SingleValuedDataValue<TemporalAccessor> {

    private TemporalAccessor value;


    public DvDate() {
    }

    /**
     * Addition of a Duration to this Date.
     * @param q
     * @return product of addition
     */
    @Override
    public DvDate add(DvDuration q) {
        if (!getDiffType().isInstance(q)) {
            throw new IllegalArgumentException("invalid difference type");
        }
        return new DvDate(
                getOtherReferenceRanges(),
                getNormalRange(),
                getNormalStatus(),
                getAccuracy(),
                getMagnitudeStatus(),
                q.getValue().);
    }

    /**
     * Subtract a Duration from this Date.
     * @param q
     * @return product of substration
     */
    @Override
    public DvDate subtract(DvDuration q) {
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
    public DvDuration diff(DvDate other) {
        return null;
    }

    /**
     * True if other is less than this Quantified object. Based on comparison of magnitude.
     * @param other
     * @return
     */
    public Boolean lessThan(DvDate other){
        return null;
    }

    /**
     * True, for any two Dates.
     * @param other
     * @return
     */
    public Boolean isStrictlyComparableTo(DvDate other){
        return null;
    }



    public DvDate(TemporalAccessor value) {
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
            List<ReferenceRange> otherReferenceRanges,
            DvInterval normalRange,
            CodePhrase normalStatus,
            DvDuration accuracy,
            String magnitudeStatus,
            Temporal value) {
        super(otherReferenceRanges, normalRange, normalStatus, magnitudeStatus, accuracy);
        this.value = value;
    }

    public DvDate(
            List<ReferenceRange> otherReferenceRanges,
            DvInterval normalRange,
            CodePhrase normalStatus,
            DvDuration accuracy,
            String magnitudeStatus,
            LocalDateTime value) {
        super(otherReferenceRanges, normalRange, normalStatus, magnitudeStatus, accuracy);
        this.value = value;
    }

    @Override
    public TemporalAccessor getValue() {
        return value;
    }

    @Override
    public void setValue(TemporalAccessor temporalAccessor) {

    }

    @Override
    public void setValue(TemporalAccessor value) {
        if (value.isSupported(ChronoField.HOUR_OF_DAY)) {
            //TODO: do we really need this validation?
            throw new IllegalArgumentException("value must only have a year, month or date, but this supports hours: " + value);
        }
        this.value = value;
    }

    @Override
    public Long getMagnitude() {
        return value == null ? null : (long) LocalDate.from(value).toEpochDay();
    }

    public void setMagnitude(Long magnitude) {
        if (magnitude == null) {
            value = null;
        } else {
            value = LocalDate.ofEpochDay(magnitude);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DvDate dvDate = (DvDate) o;
        return Objects.equals(getValue(), dvDate.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getValue());
    }
}

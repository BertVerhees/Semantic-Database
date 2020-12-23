package nl.rosa.semanticdatabase.base.datavalues.quantity.datetime;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.SingleValuedDataValue;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvInterval;
import nl.rosa.semanticdatabase.base.datavalues.quantity.ReferenceRange;
import org.threeten.extra.PeriodDuration;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import java.util.Objects;

import static nl.rosa.semanticdatabase.base.utils.datetime.DateTimeParsers.*;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 */
public class DvDate
        extends DvTemporal<LocalDate>
        implements SingleValuedDataValue<LocalDate> {

    private LocalDate value;

    public DvDate() {
    }

    public DvDate(LocalDate value) {
        setValue(value);
    }

    /**
     * Constructs a DvDate from an ISO 8601 Date String
     *
     * @param iso8601Date
     */
    public DvDate(String iso8601Date) {
        setValue(parseDateValue(iso8601Date));
    }

    public DvDate(
            List<ReferenceRange> otherReferenceRanges,
            DvInterval normalRange,
            CodePhrase normalStatus,
            DvDuration accuracy,
            String magnitudeStatus,
            LocalDate value) {
        super(otherReferenceRanges, normalRange, normalStatus, magnitudeStatus, accuracy);
        this.value = value;
    }


    /**
     * Addition of a Duration to this Date.
     * @param q
     * @return product of addition
     */
    @Override
    public LocalDate add(DvDuration q) {
        LocalDateTime dateTime = value.atStartOfDay();
        MyPeriodDuration duration = q.getValue();
        return dateTime.plus(duration).toLocalDate();
    }

    /**
     * Subtract a Duration from this Date.
     * @param q
     * @return product of substration
     */
    @Override
    public LocalDate subtract(DvDuration q) {
        LocalDateTime dateTime = value.atStartOfDay();
        MyPeriodDuration duration = q.getValue();
        return dateTime.minus(duration).toLocalDate();
    }

    /**
     * Difference between this Date and other.
     * @param other
     * @return diff type
     */
    @Override
    public MyPeriodDuration diff(LocalDate other) {
        return MyPeriodDuration.between(value, other);
    }

    /**
     * True if other is less than this Quantified object. Based on comparison of magnitude.
     * @param other
     * @return
     */
    public Boolean lessThan(LocalDate other){
        return value.compareTo(value.from(other))<0;
    }

    @Override
    public LocalDate getValue() {
        return value;
    }

    @Override
    public void setValue(LocalDate value) {
        this.value = value;
    }

    @Override
    public LocalDate getMagnitude() {
        return value;
    }

    public void setMagnitude(LocalDate magnitude) {
            value = magnitude;
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

package nl.rosa.semanticdatabase.base.datavalues.quantity.datetime;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.SingleValuedDataValue;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvAmount;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvInterval;
import nl.rosa.semanticdatabase.base.datavalues.quantity.ReferenceRange;
import nl.rosa.semanticdatabase.base.utils.datetime.DateTimeFormatters;
import nl.rosa.semanticdatabase.base.utils.datetime.DateTimeParsers;

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
        extends DvTemporal<LocalDateTime>
        implements SingleValuedDataValue<LocalDateTime> {

    public TemporalAccessor parseDateTimeValue(String text) {
        try {
            return DateTimeFormatters.ISO_8601_DATE_TIME.parseBest(text, OffsetDateTime::from, LocalDateTime::from, LocalDate::from, YearMonth::from, Year::from);
        } catch (DateTimeParseException e) {
            try {
                //some more interesting date_time expression without hyphens...
                return DateTimeFormatters.ISO_8601_DATE_TIME_COMPACT.parseBest(text, OffsetDateTime::from,  LocalDateTime::from);
            } catch (DateTimeParseException e2) {
                throw new IllegalArgumentException(e2.getMessage() + ":" + text);
            }
        }
    }

    private LocalDateTime value;


    public DvDateTime() {
    }

    /**
     * Addition of a Duration to this DvDateTime.
     * @param q
     * @return product of addition
     */
    @Override
    public LocalDateTime add(DvDuration q) {
        MyPeriodDuration duration = q.getValue();
        return value.plus(duration);
    }

    /**
     * Subtract a Duration from this DvDateTime.
     * @param q
     * @return product of substration
     */
    @Override
    public LocalDateTime subtract(DvDuration q) {
        MyPeriodDuration duration = q.getValue();
        return value.minus(duration);
    }

    /**
     * Difference between this DvDateTime and other.
     * @param other
     * @return diff type
     */
    public MyPeriodDuration diff(LocalDateTime other) {
        return Duration.between(value, other);
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
            String magnitudeStatus,
            DvDuration accuracy,
            LocalDateTime value) {
        super(otherReferenceRanges, normalRange, normalStatus, magnitudeStatus, accuracy);
        this.value = value;
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
}

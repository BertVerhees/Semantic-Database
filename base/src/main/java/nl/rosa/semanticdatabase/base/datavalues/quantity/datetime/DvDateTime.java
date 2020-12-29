package nl.rosa.semanticdatabase.base.datavalues.quantity.datetime;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvAmount;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvInterval;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvOrdered;
import nl.rosa.semanticdatabase.base.datavalues.quantity.ReferenceRange;
import nl.rosa.semanticdatabase.base.terminology.TerminologyService;
import nl.rosa.semanticdatabase.base.utils.datetime.DateTimeParsers;
import nl.rosa.semanticdatabase.utils.datetime.KindOfComparablePeriodDuration;

import java.time.*;
import java.util.List;
import java.util.Objects;

import static java.time.ZoneOffset.UTC;

/**
 * Originally: Created by pieter.bos on 04/11/15.
 */

public class DvDateTime
        extends DvTemporal<DvDateTime> {

    private LocalDateTime value;

    /**
     * Addition of a Duration to this DvDateTime.
     * @param q
     * @return product of addition
     */
    @Override
    public DvDateTime add(DvDuration q) {
        LocalDateTime dateTime = getValue();
        KindOfComparablePeriodDuration duration = q.getValue();
        return new DvDateTime(getOtherReferenceRanges(),
                getNormalRange(),
                getNormalStatus(),
                getTerminologyService(),
                getAccuracy(),
                getMagnitudeStatus(),
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
        KindOfComparablePeriodDuration duration = q.getValue();
        return new DvDateTime(getOtherReferenceRanges(),
                getNormalRange(),
                getNormalStatus(),
                getTerminologyService(),
                getAccuracy(),
                getMagnitudeStatus(),
                dateTime.minus(duration));
    }

    /**
     * Difference between this DvDateTime and other.
     *
     * @param other
     * @return diff type
     */
    @Override
    public DvDuration diff(DvDateTime other) {
        LocalDateTime dateTime = getValue();
        KindOfComparablePeriodDuration duration =
                KindOfComparablePeriodDuration.between(dateTime, other.getValue());
        return new DvDuration(duration);
    }

    public DvDateTime(LocalDateTime value) {
        super(null,
                null,
                null,
                null,
                null,
                null);
        this.value = value;
    }

    /**
     * Constructs a DvDateTime from an ISO 8601 Date-Time String
     *
     * @param iso8601DateTime
     */
    public DvDateTime(String iso8601DateTime) {
        super(null,
                null,
                null,
                null,
                null,
                null);
        this.value = DateTimeParsers.parseDateTimeValue(iso8601DateTime);
    }


    public DvDateTime(
            List<ReferenceRange<DvDateTime>> otherReferenceRanges,
            DvInterval<DvDateTime> normalRange,
            CodePhrase normalStatus,
            TerminologyService terminologyService,
            DvDuration accuracy,
            String magnitudeStatus,
            LocalDateTime value) {
        super(otherReferenceRanges, normalRange, normalStatus, terminologyService, accuracy, magnitudeStatus);
        this.value = value;
    }

    public LocalDateTime getValue() {
        return value;
    }

    public void setValue(LocalDateTime value) {
        this.value = value;
    }

    public Long getMagnitude() {
        return value.toEpochSecond(UTC);
    }

    public void setMagnitude(Long magnitude) {
        value = LocalDateTime.ofEpochSecond(magnitude, 0, UTC);
    }


    /**
     * Test if two instances are strictly comparable. Effected in descendants.
     *
     * @param other
     * @return
     */
    @Override
    public Boolean isStrictlyComparableTo(DvOrdered<DvDateTime> other) {
        return other instanceof DvDateTime;
    }

    @Override
    public Boolean lessThan(DvOrdered<DvDateTime> other) {
        DvDateTime o = (DvDateTime) other;
        return value.compareTo(value.from(o.value))<0;
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
        return value.compareTo(value.from(o.value));
    }
}
/**
 * ***** BEGIN LICENSE BLOCK *****
 * <p>
 * ISC License
 * <p>
 * Copyright (c) 2020, Bert Verhees
 * <p>
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 * <p>
 * ***** END LICENSE BLOCK *****
 */
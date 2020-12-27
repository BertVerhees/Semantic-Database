package nl.rosa.semanticdatabase.base.datavalues.quantity.datetime;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvAbsoluteQuantity;
import nl.rosa.semanticdatabase.base.datavalues.quantity.DvInterval;
import nl.rosa.semanticdatabase.base.datavalues.quantity.ReferenceRange;
import nl.rosa.semanticdatabase.base.utils.datetime.DateTimeParsers;
import nl.rosa.semanticdatabase.utils.datetime.KindOfComparablePeriodDuration;

import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.List;
import java.util.Objects;

/**
 * Originally: Created by pieter.bos on 01/03/16.
 */
public abstract class DvTemporal<T extends DvTemporal>
        extends DvAbsoluteQuantity<DvDuration, T> {

    
    private DvDuration accuracy;
    private Temporal value;

    protected DvTemporal( LocalDateTime value) {
        this(null, null, null, null, null, value);
    }

    protected DvTemporal(
            List<ReferenceRange> otherReferenceRanges,
            DvInterval normalRange,
            CodePhrase normalStatus,
            DvDuration accuracy,
            String magnitudeStatus,
            String value
            ) {
        super(otherReferenceRanges, normalRange, normalStatus, accuracy, magnitudeStatus);
        this.value = DateTimeParsers.parseDateTimeValue(value);
    }

    protected DvTemporal(
            List<ReferenceRange> otherReferenceRanges,
            DvInterval normalRange,
            CodePhrase normalStatus,
            DvDuration accuracy,
            String magnitudeStatus,
            Temporal value
    ) {
        super(otherReferenceRanges, normalRange, normalStatus, accuracy, magnitudeStatus);
        this.value = value;
    }

    /**
     * Difference of two quantities.
     *
     * @return diff type
     */
    public abstract KindOfComparablePeriodDuration diff(T other);

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

    public Temporal getValue(){
        return value;
    }

    public void setValue(Temporal value){
        this.value = value;
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
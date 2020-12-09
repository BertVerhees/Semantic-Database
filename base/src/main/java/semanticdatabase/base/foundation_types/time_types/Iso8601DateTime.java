package semanticdatabase.base.foundation_types.time_types;


import java.time.LocalDateTime;
import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Represents an ISO 8601 date/time, including partial and extended forms.
 * Value may be: YYYY-MM-DDThh:mm:ss[,sss][Z | ±hh[mm]] (extended, preferred) or YYYYMMDDThhmmss[,sss][Z | ±hh[mm]] (compact) or a partial variant.
 * See valid_iso8601_date_time() for validity.
 * Note that this class includes 2 deviations from ISO 8601:2004: for partial date/times, any part of the date/time up to the month may be missing, not just seconds and minutes as in the standard; the time 24:00:00 is not allowed, since it would mean the date was really on the next day.
 */
public class Iso8601DateTime extends Iso8601Type {

    private LocalDateTime dateTime;

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Extract the year part of the date as an Integer.
     * cardinality: 1..1
     */
    public Integer year() {
        Integer result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Extract the month part of the date/time as an Integer, or return 0 if not present.
     * cardinality: 1..1
     */
    public Integer month() {
        //TODO
        return 0;
    }

    /**
     * Extract the day part of the date/time as an Integer, or return 0 if not present.
     * cardinality: 1..1
     */
    public Integer day() {
        //TODO
        return 0;
    }

    /**
     * Extract the hour part of the date/time as an Integer, or return 0 if not present.
     * cardinality: 1..1
     */
    public Integer hour() {
        //TODO
        return 0;
    }

    /**
     * Extract the minute part of the date/time as an Integer, or return 0 if not present.
     * cardinality: 1..1
     */
    public Integer minute() {
        //TODO
        return 0;
    }

    /**
     * Extract the integral seconds part of the date/time (i.e.
     * prior to any decimal sign) as an Integer, or return 0 if not present.
     * cardinality: 1..1
     */
    public Integer second() {
        //TODO
        return 0;
    }

    /**
     * Extract the fractional seconds part of the date/time (i.e.
     * following to any decimal sign) as a Real, or return 0.0 if not present.
     * cardinality: 1..1
     */
    public Double fractionalSecond() {
        Double result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Timezone; may be Void.
     * cardinality: 1..1
     */
    public Iso8601Timezone timezone() {
        Iso8601Timezone result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Indicates whether month in year is unknown.
     * cardinality: 1..1
     */
    public boolean monthUnknown() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Indicates whether day in month is unknown.
     * cardinality: 1..1
     */
    public boolean dayUnknown() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Indicates whether minute in hour is known.
     * cardinality: 1..1
     */
    public boolean minuteUnknown() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Indicates whether minute in hour is known.
     * cardinality: 1..1
     */
    public boolean secondUnknown() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if this time has a decimal part indicated by ',' (comma) rather than '.' (period).
     * cardinality: 1..1
     */
    public boolean isDecimalSignComma() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if this date time is partial, i.e.
     * if seconds or more is missing.
     * cardinality: 1..1 (effected)
     */
    public boolean isPartial() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if this date/time uses '-', ':' separators.
     * cardinality: 1..1 (effected)
     */
    public boolean isExtended() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if the fractional_second part is significant (i.e.
     * even if = 0.0).
     * cardinality: 1..1
     */
    public boolean hasFractionalSecond() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Return the string value in extended format.
     * cardinality: 1..1
     */
    public String asString() {
        String result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Arithmetic addition of a duration to a date/time.
     * cardinality: 1..1
     */
    public Iso8601DateTime add(
    Iso8601Duration a_diff)

    {
        if (a_diff == null) {
            throw new NullPointerException("Parameter a_diff has cardinality NonNull, but is null.");
        }
        Iso8601DateTime result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Arithmetic subtraction of a duration from a date/time.
     * cardinality: 1..1
     */
    public Iso8601DateTime subtract(
    Iso8601Duration a_diff)

    {
        if (a_diff == null) {
            throw new NullPointerException("Parameter a_diff has cardinality NonNull, but is null.");
        }
        Iso8601DateTime result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Difference of two date/times.
     * cardinality: 1..1
     */
    public Iso8601Duration diff(
    Iso8601DateTime a_date_time)

    {
        if (a_date_time == null) {
            throw new NullPointerException("Parameter a_date_time has cardinality NonNull, but is null.");
        }
        Iso8601Duration result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Addition of nominal duration represented by a_diff.
     * See Iso8601_date.add_nominal() for semantics.
     * cardinality: 1..1
     */
    public Iso8601Date addNominal(
    Iso8601Duration a_diff)

    {
        if (a_diff == null) {
            throw new NullPointerException("Parameter a_diff has cardinality NonNull, but is null.");
        }
        Iso8601Date result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Subtraction of nominal duration represented by a_diff.
     * See add_nominal() for semantics.
     * cardinality: 1..1
     */
    public Iso8601Date subtractNominal(
    Iso8601Duration a_diff)

    {
        if (a_diff == null) {
            throw new NullPointerException("Parameter a_diff has cardinality NonNull, but is null.");
        }
        Iso8601Date result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** Iso8601DateTime *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    public Iso8601DateTime(
            String value
    ) {
    }

    //***** Iso8601DateTime *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        return dateTime.equals(object);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode()
        );
    }

    @Override
    public String toString() {
        return
                "Iso8601DateTime {" +
                        dateTime.toString() +
                        '}';
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

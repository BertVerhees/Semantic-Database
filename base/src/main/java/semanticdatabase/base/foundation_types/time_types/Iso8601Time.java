package semanticdatabase.base.foundation_types.time_types;

import java.time.LocalTime;
import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Represents an ISO 8601 time, including partial and extended forms.
 * Value may be: hh:mm:ss[,sss][Z|±hh[mm]] (extended, preferred) or hhmmss[,sss][Z|±hh[mm]] (compact) or a partial invariant.
 * See valid_iso8601_time() for validity.
 * Note A small deviation to the ISO 8601:2004 standard in this class is that the time 24:00:00 is not allowed, for consistency with Iso8601_date_time.
 */
public class Iso8601Time extends Iso8601Type {

    private LocalTime time;

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Extract the hour part of the date/time as an Integer.
     * cardinality: 1..1
     */
    public Integer hour() {
        Integer result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Extract the minute part of the time as an Integer, or return 0 if not present.
     * cardinality: 1..1
     */
    public Integer minute() {
        Integer result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Extract the integral seconds part of the time (i.e.
     * prior to any decimal sign) as an Integer, or return 0 if not present.
     * cardinality: 1..1
     */
    public Integer second() {
        Integer result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Extract the fractional seconds part of the time (i.e.
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
     * Indicates whether minute is unknown.
     * If so, the time is of the form “hh”.
     * cardinality: 1..1
     */
    public Boolean minuteUnknown() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Indicates whether second is unknown.
     * If so and month is known, the time is of the form "hh:mm" or "hhmm".
     * cardinality: 1..1
     */
    public Boolean secondUnknown() {
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
    public Boolean isDecimalSignComma() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if this time is partial, i.e.
     * if seconds or more is missing.
     * cardinality: 1..1 (effected)
     */
    public Boolean isPartial() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if this time uses '-', ':' separators.
     * cardinality: 1..1 (effected)
     */
    public Boolean isExtended() {
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
    public Boolean hasFractionalSecond() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Return string value in extended format.
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
     * Arithmetic addition of a duration to a time.
     * cardinality: 1..1
     */
    public Iso8601Time add(
    Iso8601Duration a_diff)

    {
        if (a_diff == null) {
            throw new NullPointerException("Parameter a_diff has cardinality NonNull, but is null.");
        }
        Iso8601Time result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Arithmetic subtraction of a duration from a time.
     * cardinality: 1..1
     */
    public Iso8601Time subtract(
    Iso8601Duration a_diff)

    {
        if (a_diff == null) {
            throw new NullPointerException("Parameter a_diff has cardinality NonNull, but is null.");
        }
        Iso8601Time result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Difference of two times.
     * cardinality: 1..1
     */
    public Iso8601Duration diff(
    Iso8601Time a_time)

    {
        if (a_time == null) {
            throw new NullPointerException("Parameter a_time has cardinality NonNull, but is null.");
        }
        Iso8601Duration result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** Iso8601Time *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    public Iso8601Time(
            String value
    ) {
    }

    //***** Iso8601Time *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        return time.equals(object);
    }

    public int hashCode() {
        return Objects.hash(
                time.hashCode()
        );
    }

    @Override
    public String toString() {
        return
                "Iso8601Time {" +
                        time.toString() +
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

package semanticdatabase.foundation_types.time_types;

import java.time.Duration;
import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Represents an ISO 8601 duration, which may have multiple parts from years down to seconds.
 * The value attribute is a String in the format: P[nnY][nnM][nnW][nnD][T[nnH][nnM][nnS]] Note two deviations from ISO 8601 are supported, the first, to allow a negative sign, and the second allowing the 'W' designator to be mixed with other designators.
 */
public class Iso8601Duration extends Iso8601Type {

    private Duration duration;

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Returns True.
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
     * Returns False.
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
     * Number of years in the value, i.e.
     * the number preceding the 'Y' in the 'YMD' part, if one exists.
     * cardinality: 1..1
     */
    public Integer years() {
        Integer result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Number of months in the value, i.e.
     * the value preceding the 'M' in the 'YMD' part, if one exists.
     * cardinality: 1..1
     */
    public Integer months() {
        Integer result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Number of days in the value, i.e.
     * the number preceding the 'D' in the 'YMD' part, if one exists.
     * cardinality: 1..1
     */
    public Integer days() {
        Integer result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Number of hours in the value, i.e.
     * the number preceding the 'H' in the 'HMS' part, if one exists.
     * cardinality: 1..1
     */
    public Integer hours() {
        Integer result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Number of minutes in the value, i.e.
     * the number preceding the 'M' in the 'HMS' part, if one exists.
     * cardinality: 1..1
     */
    public Integer minutes() {
        Integer result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Number of seconds in the value, i.e.
     * the integer number preceding the 'S' in the 'HMS' part, if one exists.
     * cardinality: 1..1
     */
    public Integer seconds() {
        Integer result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Fractional seconds in the value, i.e.
     * the decimal part of the number preceding the 'S' in the 'HMS' part, if one exists.
     * cardinality: 1..1
     */
    public Double fractionalSeconds() {
        Double result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Number of weeks in the value, i.e.
     * the value preceding the W, if one exists.
     * cardinality: 1..1
     */
    public Long weeks() {
        Long result = null;


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
     * Total number of seconds equivalent (including fractional) of entire duration.
     * Where non-definite elements such as year and month (i.e.
     * 'Y' and 'M') are included, the corresponding 'average' durations from Time_definitions are used to compute the result.
     * cardinality: 1..1
     */
    public Double toSeconds() {
        Double result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Return the duration string value.
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
     * Arithmetic addition of a duration to a duration, via conversion to seconds, using Time_definitions.Average_days_in_year and Time_definitions.Average_days_in_month
     * cardinality: 1..1
     */
    public Iso8601Duration add(Iso8601Duration a_val)

    {
        if (a_val == null) {
            throw new NullPointerException("Parameter a_val has cardinality NonNull, but is null.");
        }
        Iso8601Duration result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Arithmetic subtraction of a duration from a duration, via conversion to seconds, using Time_definitions.Average_days_in_year and Time_definitions.Average_days_in_month
     * cardinality: 1..1
     */
    public Iso8601Duration subtract(Iso8601Duration a_val)

    {
        if (a_val == null) {
            throw new NullPointerException("Parameter a_val has cardinality NonNull, but is null.");
        }
        Iso8601Duration result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Arithmetic multiplication a duration by a number.
     * cardinality: 1..1
     */
    public Iso8601Duration multiply(Double a_val)
    {
        if (a_val == null) {
            throw new NullPointerException("Parameter a_val has cardinality NonNull, but is null.");
        }
        Iso8601Duration result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Arithmetic division of a duration by a number.
     * cardinality: 1..1
     */
    public Iso8601Duration divide(Double a_val)

    {
        if (a_val == null) {
            throw new NullPointerException("Parameter a_val has cardinality NonNull, but is null.");
        }
        Iso8601Duration result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Generate negative of current duration value.
     * cardinality: 1..1
     */
    public Iso8601Duration negative()

    {
        Iso8601Duration result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** Iso8601Duration *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    public Iso8601Duration(
            String value
    ) {

    }

    //***** Iso8601Duration *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        return duration.equals(object);
    }

    public int hashCode() {
        return Objects.hash(
                duration.hashCode()
        );
    }

    @Override
    public String toString() {
        return
                "Iso8601Duration {" +
                        duration.toString() +
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

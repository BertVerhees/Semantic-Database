package semanticdatabase.foundation_types.time_types;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Objects;

import semanticdatabase.foundation_types.primitive_types.Integer;
import semanticdatabase.foundation_types.primitive_types.Boolean;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * ISO8601 timezone string, in format: Z | ±hh[mm] where: hh is "00" - "23" (0-filled to two digits) mm is "00" - "59" (0-filled to two digits) Z is a literal meaning UTC (modern replacement for GMT), i.e.
 * timezone +0000
 */
public class Iso8601Timezone extends Iso8601Type {

    private ZoneOffset zoneOffset;

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Extract the hour part of timezone, as an Integer in the range 00 - 13.
     * cardinality: 1..1
     */
    public Integer hour() {
        return ZoneOffset.of(value).getTotalSeconds()/3600;
    }

    /**
     * Extract the hour part of timezone, as an Integer, usually either 0 or 30.
     * cardinality: 1..1
     */
    public Integer minute() {
        return ZoneOffset.of(value).getTotalSeconds()/60;
    }

    /**
     * Direction of timezone expresssed as +1 or -1.
     * cardinality: 1..1
     */
    public Integer sign() {
        if(minute()<0){
            return -1;
        }else{
            return 1;
        }
    }

    /**
     * Indicates whether minute part known.
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
     * True if this time zone is partial, i.e.
     * if minutes is missing.
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
     * True if this time-zone uses ‘:’ separators.
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
     * True if timezone is UTC, i.e.
     * +0000.
     * cardinality: 1..1
     */
    public Boolean isGmt() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Return timezone string.
     * cardinality: 1..1
     */
    public String asString() {
        String result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** Iso8601Timezone *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected Iso8601Timezone() {
    }

    public Iso8601Timezone(
            String value,
            Integer maxDaysInYear
    ) {
        super(
                value,
                maxDaysInYear
        );
    }

    private Iso8601Timezone(Builder builder) {
        this.setValue(builder.value);
        this.setMaxDaysInYear(builder.maxDaysInYear);
    }

    public static class Builder {
        private final String value;  //required
        private final Integer maxDaysInYear;  //required

        public Builder(
                String value,
                Integer maxDaysInYear
        ) {
            if (value == null) {
                throw new NullPointerException("Property:value has cardinality NonNull, but is null");
            }
            if (maxDaysInYear == null) {
                throw new NullPointerException("Property:maxDaysInYear has cardinality NonNull, but is null");
            }
            this.value = value;
            this.maxDaysInYear = maxDaysInYear;
        }

        public Iso8601Timezone build() {
            return new Iso8601Timezone(this);
        }
    }


    //***** Iso8601Timezone *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        return true;
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode()
        );
    }

    @Override
    public String toString() {
        return
                "Iso8601Timezone {" +
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

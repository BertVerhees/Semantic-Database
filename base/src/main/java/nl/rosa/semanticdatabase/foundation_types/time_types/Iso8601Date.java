package nl.rosa.semanticdatabase.foundation_types.time_types;

import nl.rosa.semanticdatabase.foundation_types.primitive_types.Integer;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Boolean;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.String;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Represents an ISO 8601 date, including partial and extended forms.
 * Value may be: YYYY-MM-DD (extended, preferred) YYYYMMDD (compactd) a partial invariant.
 * See Time_definitions.valid_iso8601_date() for validity.
 * 
*/
public class Iso8601Date extends Iso8601Type {

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Extract the year part of the date as an Integer.
 * cardinality: 1..1
 * 
*/
    public Integer  year() {
        Integer  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Extract the month part of the date as an Integer, or return 0 if not present.
 * cardinality: 1..1
 * 
*/
    public not month_unknown  month() {
        not month_unknown  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Extract the day part of the date as an Integer, or return 0 if not present.
 * cardinality: 1..1
 * 
*/
    public not day_unknown  day() {
        not day_unknown  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Timezone; may be Void.
 * cardinality: 1..1
 * 
*/
    public Iso8601Timezone  timezone() {
        Iso8601Timezone  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Indicates whether month in year is unknown.
 * If so, the date is of the form "YYYY".
 * cardinality: 1..1
 * 
*/
    public Boolean  monthUnknown() {
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Indicates whether day in month is unknown.
 * If so, and month is known, the date is of the form "YYYY-MM" or "YYYYMM".
 * cardinality: 1..1
 * 
*/
    public Boolean  dayUnknown() {
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if this date is partial, i.e.
 * if days or more is missing.
 * cardinality: 1..1 (effected)
 * 
*/
    public Boolean  isPartial() {
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if this date uses '-' separators.
 * cardinality: 1..1 (effected)
 * 
*/
    public Boolean  isExtended() {
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Return string value in extended format.
 * cardinality: 1..1
 * 
*/
    public String  asString() {
        String  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Arithmetic addition of a duration to a date.
 * cardinality: 1..1
 * 
*/
    public Iso8601Date  add alias "+"(Iso8601Duration a_diff) {
        if (a_diff == null ) {
            throw new NullPointerException("Parameter a_diff has cardinality NonNull, but is null.");
        }
        Iso8601Date  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Arithmetic subtraction of a duration from a date.
 * cardinality: 1..1
 * 
*/
    public Iso8601Date  subtract alias "-"(Iso8601Duration a_diff) {
        if (a_diff == null ) {
            throw new NullPointerException("Parameter a_diff has cardinality NonNull, but is null.");
        }
        Iso8601Date  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Difference of two dates.
 * cardinality: 1..1
 * 
*/
    public Iso8601Duration  diff alias "-"(Iso8601Date a_date) {
        if (a_date == null ) {
            throw new NullPointerException("Parameter a_date has cardinality NonNull, but is null.");
        }
        Iso8601Duration  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Addition of nominal duration represented by a_diff.
 * For example, a duration of 'P1Y' means advance to the same date next year, with the exception of the date 29 February in a leap year, to which the addition of a nominal year will result in 28 February of the following year.
 * Similarly, 'P1M' is understood here as a nominal month, the addition of which will result in one of: the same date in the following month, or; one or two days less where the following month is shorter, or; in the case of adding a month to the date 31 Jan, the result will be 28 Feb in a non-leap year (i.e.
 * three less) and 29 Feb in a leap year (i.e.
 * two less).
 * cardinality: 1..1
 * 
*/
    public Iso8601Date  addNominal alias "++"(Iso8601Duration a_diff) {
        if (a_diff == null ) {
            throw new NullPointerException("Parameter a_diff has cardinality NonNull, but is null.");
        }
        Iso8601Date  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Subtraction of nominal duration represented by a_diff.
 * See add_nominal() for semantics.
 * cardinality: 1..1
 * 
*/
    public Iso8601Date  subtractNominal alias "--"(Iso8601Duration a_diff) {
        if (a_diff == null ) {
            throw new NullPointerException("Parameter a_diff has cardinality NonNull, but is null.");
        }
        Iso8601Date  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** Iso8601Date *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public Iso8601Date build() {
        return new Iso8601Date(
            value,
            maxDaysInYear
        );
    }

    public Iso8601Date(
            String value,
            Integer maxDaysInYear
    ){
        if ( value == null ) {
            throw new NullPointerException("Property:value has cardinality NonNull, but is null");
        }
        if ( maxDaysInYear == null ) {
            throw new NullPointerException("Property:maxDaysInYear has cardinality NonNull, but is null");
        }
        this.value = value;
        this.maxDaysInYear = maxDaysInYear;
    }

}

/**
 * 
 * ***** BEGIN LICENSE BLOCK *****
 * 
 * ISC License
 * 
 * Copyright (c) 2020, Bert Verhees
 * 
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 * 
 * ***** END LICENSE BLOCK *****
 * 
*/

package nl.rosa.semanticdatabase.foundation_types.time_types;

import nl.rosa.semanticdatabase.foundation_types.primitive_types.Integer;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Double;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Boolean;

/**
 * 
 * #Generated: 2020-11-24T17:04:33.085+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Definitions for date/time classes.
 * Note that the timezone limits are set by where the international dateline is.
 * Thus, time in New Zealand is quoted using +12:00, not -12:00.
 * 
*/
public class TimeDefinitions {

    //***** TimeDefinitions *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Maximum number of days in a year, i.e.
 * accounting for leap years.
 * cardinality: 1..1
 * 
*/
    private Integer maxDaysInYear;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Maximum number of days in a year, i.e.
 * accounting for leap years.
 * cardinality: 1..1
 * 
*/
    public Integer getMaxDaysInYear() {
        return maxDaysInYear;
    }
    public setMaxDaysInYear(Integer value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:maxDaysInYear failed, it has cardinality NonNull, but is null");
        }
        this.maxDaysInYear = maxDaysInYear;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * True if y >= 0.
 * cardinality: 1..1
 * 
*/
    public Result = y >= 0  validYear(Integer y) {
        if (y == null ) {
            throw new NullPointerException("Parameter y has cardinality NonNull, but is null.");
        }
        Result = y >= 0  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if m >= 1 and m <= months_in_year.
 * cardinality: 1..1
 * 
*/
    public Result = m >= 1 and m <>  validMonth(Integer m) {
        if (m == null ) {
            throw new NullPointerException("Parameter m has cardinality NonNull, but is null.");
        }
        Result = m >= 1 and m <>  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if d >= 1 and d <= days_in_month (m, y).
 * cardinality: 1..1
 * 
*/
    public Result = d >= 1 and d <>  validDay(Integer y, Integer m, Integer d) {
        if (y == null ) {
            throw new NullPointerException("Parameter y has cardinality NonNull, but is null.");
        }
        if (m == null ) {
            throw new NullPointerException("Parameter m has cardinality NonNull, but is null.");
        }
        if (d == null ) {
            throw new NullPointerException("Parameter d has cardinality NonNull, but is null.");
        }
        Result = d >= 1 and d <>  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if (h >= 0 and h < Hours_in_day) or (h = Hours_in_day and m = 0 and s = 0) .
 * cardinality: 1..1
 * 
*/
    public Result = (h >= 0 and h <>  validHour(Integer h, Integer m, Integer s) {
        if (h == null ) {
            throw new NullPointerException("Parameter h has cardinality NonNull, but is null.");
        }
        if (m == null ) {
            throw new NullPointerException("Parameter m has cardinality NonNull, but is null.");
        }
        if (s == null ) {
            throw new NullPointerException("Parameter s has cardinality NonNull, but is null.");
        }
        Result = (h >= 0 and h <>  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if m >= 0 and m < Minutes_in_hour.
 * cardinality: 1..1
 * 
*/
    public Result = m >= 0 and m <>  validMinute(Integer m) {
        if (m == null ) {
            throw new NullPointerException("Parameter m has cardinality NonNull, but is null.");
        }
        Result = m >= 0 and m <>  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if s >= 0 and s < Seconds_in_minute .
 * cardinality: 1..1
 * 
*/
    public Result = s >= 0 and s <>  validSecond(Integer s) {
        if (s == null ) {
            throw new NullPointerException("Parameter s has cardinality NonNull, but is null.");
        }
        Result = s >= 0 and s <>  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if fs >= 0.0 and fs < 1.0 .
 * cardinality: 1..1
 * 
*/
    public Result = fs >= 0.0 and fs <>  validFractionalSecond(Double fs) {
        if (fs == null ) {
            throw new NullPointerException("Parameter fs has cardinality NonNull, but is null.");
        }
        Result = fs >= 0.0 and fs <>  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * String is a valid ISO 8601 date, i.e.
 * takes the complete form: YYYY-MM-DD (extended, preferred) or one of the partial forms YYYY-MM or YYYY YYYYMMDD (compact) or a partial variant YYYYMM.
 * Where: YYYY is the string form of any positive number in the range 0000 - 9999 (zero-filled to four digits) MM is 01 - 12 (zero-filled to two digits) DD is 01 - 31 (zero-filled to two digits) The combinations of YYYY, MM, DD numbers must be correct with respect to the Gregorian calendar.
 * cardinality: 1..1
 * 
*/
    public Boolean  validIso8601Date(String s) {
        if (s == null ) {
            throw new NullPointerException("Parameter s has cardinality NonNull, but is null.");
        }
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * String is a valid ISO 8601 date, i.e.
 * takes the form: hh:mm:ss[(,|.)s+][Z|±hh[:mm]] (extended) hhmmss[(,|.)s+][Z|±hh[mm]] (compact) or one of the partial forms: hh:mm (extended) hhmm or hh (compact) with an additional optional timezone indicator of: Z or ±hh[:mm] (extended) ±hh[mm] (compact) Where: hh is "00" - "23" (0-filled to two digits) mm is "00" - "59" (0-filled to two digits) ss is "00" - "60" (0-filled to two digits) [(,|.)s+] is an optional string consisting of a comma or decimal point followed by numeric string of 1 or more digits, representing a fractional second Z is a literal meaning UTC (modern replacement for GMT), i.e.
 * timezone +0000
 * cardinality: 1..1
 * 
*/
    public Boolean  validIso8601Time(String s) {
        if (s == null ) {
            throw new NullPointerException("Parameter s has cardinality NonNull, but is null.");
        }
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * String is a valid ISO 8601 date-time, i.e.
 * takes the form: YYYY-MM-DDThh:mm:ss[(,|.)s+][Z|±hh[:mm]] (extended) YYYYMMDDThhmmss[(,|.)s+][Z|±hh[mm]] (compact) or one of the partial forms: YYYY-MM-DDThh:mm or YYYY-MM-DDThh (extended) YYYYMMDDThhmm or YYYYMMDDThh (compact)
 * cardinality: 1..1
 * 
*/
    public Boolean  validIso8601DateTime(String s) {
        if (s == null ) {
            throw new NullPointerException("Parameter s has cardinality NonNull, but is null.");
        }
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * String is a valid ISO 8601 duration, i.e.
 * takes the form: P[nnY][nnM][nnW][nnD][T[nnH][nnM][nnS]] Where each nn represents a number of years, months, etc.
 * nnW represents a number of 7-day weeks.
 * Note: allowing the W designator in the same expression as other designators is an exception to the published standard, but necessary in clinical information (typically for representing pregnancy duration).
 * Parameters s String is a valid ISO 8601 duration, i.e.
 * takes the form: P[nnY][nnM][nnW][nnD][T[nnH][nnM][nnS]] Where each nn represents a number of years, months, etc.
 * nnW represents a number of 7- day weeks.
 * Note allowing the W designator in the same expression as other designators is an exception to the published standard, but necessary in clinical information (typically for representing pregnancy duration).
 * cardinality: 1..1
 * 
*/
    public Boolean  validIso8601Duration(String s) {
        if (s == null ) {
            throw new NullPointerException("Parameter s has cardinality NonNull, but is null.");
        }
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/*=========================================================*/
/* * CONSTANTS * */
/*=========================================================*/

/**
 * 
 * Number of seconds in a minute.
 * 
*/
    final Integer secondsInMinute = 60;

/**
 * 
 * Number of minutes in an hour.
 * 
*/
    final Integer minutesInHour = 60;

/**
 * 
 * Number of clock hours in a day, i.e.
 * 24.
 * 
*/
    final Integer hoursInDay = 24;

/**
 * 
 * Used for conversions of durations containing months to days and / or seconds.
 * 
*/
    final Real averageDaysInMonth = 30.42;

/**
 * 
 * Maximum number of days in any month.
 * 
*/
    final Integer maxDaysInMonth = 31;

/**
 * 
 * Calendar days in a normal year, i.e.
 * 365.
 * 
*/
    final Integer daysInYear = 365;

/**
 * 
 * Used for conversions of durations containing years to days and / or seconds.
 * 
*/
    final Real averageDaysInYear = 365.24;

/**
 * 
 * Calendar days in a standard leap year, i.e.
 * 366.
 * 
*/
    final Integer daysInLeapYear = 366;

/**
 * 
 * Number of days in a week.
 * 
*/
    final Integer daysInWeek = 7;

    final Integer monthsInYear = 12;

/**
 * 
 * Minimum hour value of a timezone according to ISO 8601 (note that the -ve sign is supplied in the ISO8601_TIMEZONE class).
 * 
*/
    final Integer minTimezoneHour = 12;

/**
 * 
 * Maximum hour value of a timezone according to ISO 8601.
 * 
*/
    final Integer maxTimezoneHour = 13;

/**
 * 
 * Used for conversions of durations containing months to days and / or seconds.
 * 
*/
    final Real nominalDaysInMonth = 30.42;

/**
 * 
 * Used for conversions of durations containing years to days and / or seconds.
 * 
*/
    final Real nominalDaysInYear = 365.24;

    //***** TimeDefinitions *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    public TimeDefinitions(
            Integer maxDaysInYear
        ){
        if ( maxDaysInYear == null ) {
            throw new NullPointerException("Property:maxDaysInYear has cardinality NonNull, but is null");
        }
        this.maxDaysInYear = maxDaysInYear;
    }

    private TimeDefinitions(Builder builder) {
        this.setMaxDaysInYear( builder.maxDaysInYear );
    }

    public static class Builder {
        private final Integer maxDaysInYear;  //required

        public Builder (
            Integer maxDaysInYear
        ){
            if ( maxDaysInYear == null ) {
                throw new NullPointerException("Property:maxDaysInYear has cardinality NonNull, but is null");
            }
            this.maxDaysInYear = maxDaysInYear;
        }

        public TimeDefinitions build(){
            return new TimeDefinitions( this );
        }
    }


    //***** TimeDefinitions *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        TimeDefinitions that = (TimeDefinitions) object;
        return
            java.util.Objects.equals(maxDaysInYear, that.maxDaysInYear);
        }
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            maxDaysInYear
        );
    }

    @Override
    public String toString() {
        return
            "TimeDefinitions {" +
            "maxDaysInYear='" + maxDaysInYear + '\''; +
            '}';
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

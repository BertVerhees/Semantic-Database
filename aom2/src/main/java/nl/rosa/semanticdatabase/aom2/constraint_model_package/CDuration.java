package nl.rosa.semanticdatabase.aom2.constraint_model_package;

import java.util.Objects;
import nl.rosa.semanticdatabase..;
import nl.rosa.semanticdatabase.foundation_types.time_types.Iso8601Duration;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Boolean;

/**
 * 
 * #Generated: 2020-11-24T17:57:46.357+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Constraint on instances representing duration, which is assumed to have the same parts as the ISO 8601 duration string.
 * Thus, constraints are of the form "PWD" (weeks and/or days), "PDTHMS" (days, hours, minutes, seconds) and so on.
 * Both range and the constraint pattern can be set at the same time, corresponding to the ADL constraint "PWD/|P0W..P50W|".
 * As for all of openEHR, two ISO 8601 exceptions are allowed: the ‘W’ (week) designator can be mixed in - the allowed patterns are: P[Y|y][M|m][D|d][T[H|h][M|m][S|s]] and P[W|w]; the values used in an interval constraint may be negated, i.e.
 * a leading minus ('-') sign may be used.
 * 
*/
public class CDuration extends CTemporal {

    //***** CDuration *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Formal constraint on the assumed primitive Iso8601_duration type, in the form of List of Interval<Iso8601_duration>, i.e.
 * one or more intervals of Iso8601_duration.
 * cardinality: 0..1 (redefined)
 * 
*/
    private Interval<Iso8601Duration> constraint;

/**
 * 
 * Default value set in a template, and present in an operational template.
 * Generally limited to leaf and near-leaf nodes.
 * cardinality: 0..1 (redefined)
 * 
*/
    private Iso8601Duration defaultValue;

/**
 * 
 * Value to be assumed if none sent in data.
 * cardinality: 0..1 (redefined)
 * 
*/
    private Iso8601Duration assumedValue;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Formal constraint on the assumed primitive Iso8601_duration type, in the form of List of Interval<Iso8601_duration>, i.e.
 * one or more intervals of Iso8601_duration.
 * cardinality: 0..1 (redefined)
 * 
*/
    public Interval<Iso8601Duration> getConstraint() {
        return constraint;
    }
    public void setConstraint(Interval<Iso8601Duration> value) {
        this.constraint = constraint;
    }

/**
 * 
 * Default value set in a template, and present in an operational template.
 * Generally limited to leaf and near-leaf nodes.
 * cardinality: 0..1 (redefined)
 * 
*/
    public Iso8601Duration getDefaultValue() {
        return defaultValue;
    }
    public void setDefaultValue(Iso8601Duration value) {
        this.defaultValue = defaultValue;
    }

/**
 * 
 * Value to be assumed if none sent in data.
 * cardinality: 0..1 (redefined)
 * 
*/
    public Iso8601Duration getAssumedValue() {
        return assumedValue;
    }
    public void setAssumedValue(Iso8601Duration value) {
        this.assumedValue = assumedValue;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * True if years are allowed in the constrained Duration.
 * cardinality: 1..1
 * 
*/
    public Boolean  yearsAllowed:() {
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if months are allowed in the constrained Duration.
 * cardinality: 1..1
 * 
*/
    public Boolean  monthsAllowed:() {
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if weeks are allowed in the constrained Duration.
 * cardinality: 1..1
 * 
*/
    public Boolean  weeksAllowed:() {
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if days are allowed in the constrained Duration.
 * cardinality: 1..1
 * 
*/
    public Boolean  daysAllowed() {
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if hours are allowed in the constrained Duration.
 * cardinality: 1..1
 * 
*/
    public Boolean  hoursAllowed() {
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if minutes are allowed in the constrained Duration.
 * cardinality: 1..1
 * 
*/
    public Boolean  minutesAllowed() {
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if seconds are allowed in the constrained Duration.
 * cardinality: 1..1
 * 
*/
    public Boolean  secondsAllowed() {
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** CDuration *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected CDuration() {}

    public CDuration(
            Interval<iso8601Duration> constraint,
            Iso8601Duration defaultValue,
            Iso8601Duration assumedValue
        ){
        this.constraint = constraint;
        this.defaultValue = defaultValue;
        this.assumedValue = assumedValue;
    }

    private CDuration(Builder builder) {
        this.setConstraint( builder.constraint );
        this.setDefaultValue( builder.defaultValue );
        this.setAssumedValue( builder.assumedValue );
    }

    public static class Builder {
        private Interval<iso8601Duration> constraint;
        private Iso8601Duration defaultValue;
        private Iso8601Duration assumedValue;

        public Builder (
        ){
        }

        public Builder setConstraint(Interval<iso8601Duration> value) {
            this.constraint = constraint;
            return this;
        }

        public Builder setDefaultValue(Iso8601Duration value) {
            this.defaultValue = defaultValue;
            return this;
        }

        public Builder setAssumedValue(Iso8601Duration value) {
            this.assumedValue = assumedValue;
            return this;
        }

        public CDuration build(){
            return new CDuration( this );
        }
    }


    //***** CDuration *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CDuration that = (CDuration) object;
        return
            Objects.equals(constraint, that.constraint) &&
            Objects.equals(defaultValue, that.defaultValue) &&
            Objects.equals(assumedValue, that.assumedValue);
        }
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            constraint,
            defaultValue,
            assumedValue
        );
    }

    @Override
    public String toString() {
        return
            "CDuration {" +
            "constraint='" + constraint + '\''; +
            "defaultValue='" + defaultValue + '\''; +
            "assumedValue='" + assumedValue + '\''; +
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

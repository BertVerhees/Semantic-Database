package nl.rosa.semanticdatabase.aom_2.constraint_model_package;

import java.util.Objects;
import nl.rosa.semanticdatabase.foundation_types.time_types.Iso8601DateTime;
import nl.rosa.semanticdatabase.base_types.definitions_package.ValidityKind;

/**
 * 
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Constraint on instances representing date/times, i.e.
 * instants in time.
 * There is no validity flag for year, since it must always be by definition mandatory in order to have a sensible date/time at all.
 * Syntax expressions of instances of this class include "YYYY-MM-DDT??:??:??" (date/time with optional time) and "YYYY-MMDDTHH:MM:xx" (date/time, seconds not allowed).
 * 
*/
public class CDateTime extends CTemporal {

    //***** CDateTime *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Formal constraint on the assumed primitive Iso8601_date_time type, in the form of List of Interval<Iso8601_date_time>, i.e.
 * one or more intervals of Iso8601_date_time.
 * cardinality: 0..1 (redefined)
 * 
*/
    private Interval<Iso8601DateTime> constraint;

/**
 * 
 * Default value set in a template, and present in an operational template.
 * Generally limited to leaf and near-leaf nodes.
 * cardinality: 0..1 (redefined)
 * 
*/
    private Iso8601DateTime defaultValue;

/**
 * 
 * Value to be assumed if none sent in data.
 * cardinality: 0..1 (redefined)
 * 
*/
    private Iso8601DateTime assumedValue;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Formal constraint on the assumed primitive Iso8601_date_time type, in the form of List of Interval<Iso8601_date_time>, i.e.
 * one or more intervals of Iso8601_date_time.
 * cardinality: 0..1 (redefined)
 * 
*/
    public Interval<Iso8601DateTime> getConstraint() {
        return constraint;
    }
    public void setConstraint(Interval<Iso8601DateTime> value) {
        this.constraint = constraint;
    }

/**
 * 
 * Default value set in a template, and present in an operational template.
 * Generally limited to leaf and near-leaf nodes.
 * cardinality: 0..1 (redefined)
 * 
*/
    public Iso8601DateTime getDefaultValue() {
        return defaultValue;
    }
    public void setDefaultValue(Iso8601DateTime value) {
        this.defaultValue = defaultValue;
    }

/**
 * 
 * Value to be assumed if none sent in data.
 * cardinality: 0..1 (redefined)
 * 
*/
    public Iso8601DateTime getAssumedValue() {
        return assumedValue;
    }
    public void setAssumedValue(Iso8601DateTime value) {
        this.assumedValue = assumedValue;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Validity of month in constrained date.
 * cardinality: 1..1
 * 
*/
    public ValidityKind  monthValidity() {
        ValidityKind  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Validity of day in constrained date.
 * cardinality: 1..1
 * 
*/
    public ValidityKind  dayValidity() {
        ValidityKind  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Validity of timezone in constrained date.
 * cardinality: 1..1
 * 
*/
    public ValidityKind  timezoneValidity() {
        ValidityKind  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Validity of minute in constrained time.
 * cardinality: 1..1
 * 
*/
    public ValidityKind  minuteValidity() {
        ValidityKind  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Validity of second in constrained time.
 * cardinality: 1..1
 * 
*/
    public ValidityKind  secondValidity() {
        ValidityKind  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Validity of millisecond in constrained time.
 * cardinality: 1..1
 * 
*/
    public ValidityKind  millisecondValidity() {
        ValidityKind  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** CDateTime *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected CDateTime() {}

    public CDateTime(
            Interval<iso8601DateTime> constraint,
            Iso8601DateTime defaultValue,
            Iso8601DateTime assumedValue
        ){
        this.constraint = constraint;
        this.defaultValue = defaultValue;
        this.assumedValue = assumedValue;
    }

    private CDateTime(Builder builder) {
        this.setConstraint( builder.constraint );
        this.setDefaultValue( builder.defaultValue );
        this.setAssumedValue( builder.assumedValue );
    }

    public static class Builder {
        private Interval<iso8601DateTime> constraint;
        private Iso8601DateTime defaultValue;
        private Iso8601DateTime assumedValue;

        public Builder (
        ){
        }

        public Builder setConstraint(Interval<iso8601DateTime> value) {
            this.constraint = constraint;
            return this;
        }

        public Builder setDefaultValue(Iso8601DateTime value) {
            this.defaultValue = defaultValue;
            return this;
        }

        public Builder setAssumedValue(Iso8601DateTime value) {
            this.assumedValue = assumedValue;
            return this;
        }

        public CDateTime build(){
            return new CDateTime( this );
        }
    }


    //***** CDateTime *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CDateTime that = (CDateTime) object;
        return
            Objects.equals(constraint, that.constraint) &&
            Objects.equals(defaultValue, that.defaultValue) &&
            Objects.equals(assumedValue, that.assumedValue);
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
            "CDateTime {" +
            "constraint='" + constraint + '\'' +
            "defaultValue='" + defaultValue + '\'' +
            "assumedValue='" + assumedValue + '\'' +
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

package nl.rosa.semanticdatabase.foundation_types.interval;

import nl.rosa.semanticdatabase.foundation_types.overview.Any;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Boolean;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Interval abstraction, featuring upper and lower limits that may be open or closed, included or not included.
 * Interval of ordered items.
 * 
*/
public abstract class Interval<T> extends Object {

    //***** Interval<t> *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Lower bound.
 * lower bound.
 * cardinality: 0..1
 * 
*/
    private T lower;

/**
 * 
 * Upper bound.
 * Upper bound.
 * cardinality: 0..1
 * 
*/
    private T upper;

/**
 * 
 * lower boundary open (i.e.
 * = -infinity).
 * lower boundary open (i.e.
 * = -infinity)
 * cardinality: 1..1
 * 
*/
    private Boolean lowerUnbounded;

/**
 * 
 * upper boundary open (i.e.
 * = +infinity).
 * upper boundary open (i.e.
 * = +infinity)
 * cardinality: 1..1
 * 
*/
    private Boolean upperUnbounded;

/**
 * 
 * lower boundary value included in range if not lower_unbounded.
 * lower boundary value included in range if not lower_unbounded.
 * cardinality: 1..1
 * 
*/
    private Boolean lowerIncluded;

/**
 * 
 * upper boundary value included in range if not upper_unbounded.
 * upper boundary value included in range if not upper_unbounded.
 * cardinality: 1..1
 * 
*/
    private Boolean upperIncluded;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Lower bound.
 * lower bound.
 * cardinality: 0..1
 * 
*/
    public T getLower() {
        return lower;
    }
    public Interval<T> setLower(T value) {
        this.lower = lower;
        return this;
    }

/**
 * 
 * Upper bound.
 * Upper bound.
 * cardinality: 0..1
 * 
*/
    public T getUpper() {
        return upper;
    }
    public Interval<T> setUpper(T value) {
        this.upper = upper;
        return this;
    }

/**
 * 
 * lower boundary open (i.e.
 * = -infinity).
 * lower boundary open (i.e.
 * = -infinity)
 * cardinality: 1..1
 * 
*/
    public Boolean getLowerUnbounded() {
        return lowerUnbounded;
    }
    public Interval<T> setLowerUnbounded(Boolean value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:lowerUnbounded failed, it has cardinality NonNull, but is null");
        }
        this.lowerUnbounded = lowerUnbounded;
        return this;
    }

/**
 * 
 * upper boundary open (i.e.
 * = +infinity).
 * upper boundary open (i.e.
 * = +infinity)
 * cardinality: 1..1
 * 
*/
    public Boolean getUpperUnbounded() {
        return upperUnbounded;
    }
    public Interval<T> setUpperUnbounded(Boolean value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:upperUnbounded failed, it has cardinality NonNull, but is null");
        }
        this.upperUnbounded = upperUnbounded;
        return this;
    }

/**
 * 
 * lower boundary value included in range if not lower_unbounded.
 * lower boundary value included in range if not lower_unbounded.
 * cardinality: 1..1
 * 
*/
    public Boolean getLowerIncluded() {
        return lowerIncluded;
    }
    public Interval<T> setLowerIncluded(Boolean value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:lowerIncluded failed, it has cardinality NonNull, but is null");
        }
        this.lowerIncluded = lowerIncluded;
        return this;
    }

/**
 * 
 * upper boundary value included in range if not upper_unbounded.
 * upper boundary value included in range if not upper_unbounded.
 * cardinality: 1..1
 * 
*/
    public Boolean getUpperIncluded() {
        return upperIncluded;
    }
    public Interval<T> setUpperIncluded(Boolean value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:upperIncluded failed, it has cardinality NonNull, but is null");
        }
        this.upperIncluded = upperIncluded;
        return this;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * True if the value e is properly contained in this Interval.
 * True if (lower_unbounded or lower_included and v >= lower) or v > lower and (upper_unbounded or upper_included and v <= upper or v < upper)
 * cardinality: 1..1 (abstract)
 * 
*/
    public abstract Result = (lower_unbounded or lower_included and v >= lower) or v > lower and (upper_unbounded or upper_included and v <>  has(T e);

/**
 * 
 * True if there is any overlap between intervals represented by Current and other.
 * True if at least one limit of other is strictly inside the limits of this interval.
 * cardinality: 1..1 (abstract)
 * 
*/
    public abstract Boolean  intersects(Interval other);

/**
 * 
 * True if current interval properly contains other? True if all points of other are inside the current interval.
 * cardinality: 1..1 (abstract)
 * 
*/
    public abstract Boolean  contains(Interval other);

/**
 * 
 * True if current object’s interval is semantically same as other.
 * cardinality: 1..1 (effected)
 * 
*/
    public Boolean  isEqual(Any other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
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

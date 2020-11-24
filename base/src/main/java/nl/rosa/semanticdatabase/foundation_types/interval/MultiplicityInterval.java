package nl.rosa.semanticdatabase.foundation_types.interval;

import nl.rosa.semanticdatabase..;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Boolean;

/**
 * 
 * #Generated: 2020-11-24T17:04:33.085+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * An Interval of Integer, used to represent multiplicity, cardinality and optionality in models.
 * 
*/
public class MultiplicityInterval extends ProperInterval {

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * True if this interval imposes no constraints, i.e.
 * is set to 0..*.
 * cardinality: 1..1
 * 
*/
    public Boolean  isOpen() {
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if this interval expresses optionality, i.e.
 * 0..1.
 * cardinality: 1..1
 * 
*/
    public Boolean  isOptional() {
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if this interval expresses mandation, i.e.
 * 1..1.
 * cardinality: 1..1
 * 
*/
    public Boolean  isMandatory() {
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if this interval is set to 0..0.
 * cardinality: 1..1
 * 
*/
    public Boolean  isProhibited() {
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
 * Marker to use in string form of interval between limits.
 * 
*/
    final String multiplicityRangeMarker = "..";

/**
 * 
 * Symbol to use to indicate upper limit unbounded.
 * 
*/
    final char multiplicityUnboundedMarker = '*';

    //***** MultiplicityInterval *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    public MultiplicityInterval(
            
        ){
    }

    private MultiplicityInterval(Builder builder) {
    }

    public static class Builder {

        public Builder (
        ){
        }

        public MultiplicityInterval build(){
            return new MultiplicityInterval( this );
        }
    }


    //***** MultiplicityInterval *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        MultiplicityInterval that = (MultiplicityInterval) object;
        return
        }
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
        );
    }

    @Override
    public String toString() {
        return
            "MultiplicityInterval {" +
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

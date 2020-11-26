package nl.rosa.semanticdatabase.foundation_types.overview;

import java.util.Objects;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Boolean;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Ordered;

/**
 * 
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Abstract ancestor class for all other classes.
 * Usually maps to a type like Any or Object in an object-oriented technology.
 * Defined here to provide value and reference equality semantics.
 * 
*/
public abstract class Any {

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Value equality: return True if this and other are attached to objects considered to be equal in value.
 * Parameters other Other object for comparison.
 * cardinality: 1..1 (abstract)
 * 
*/
    public abstract Boolean  isEqual(Any other);

/**
 * 
 * Reference equality for reference types, value equality for value types.
 * Parameters other Other object for comparison.
 * cardinality: 1..1
 * 
*/
    public Boolean  equal alias "=", "=="(Any other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Boolean  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Create new instance of a type.
 * cardinality: 1..1
 * 
*/
    public Any  instanceOf(String a_type) {
        if (a_type == null ) {
            throw new NullPointerException("Parameter a_type has cardinality NonNull, but is null.");
        }
        Any  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Type name of an object as a string.
 * May include generic parameters, as in "Interval<Time>".
 * cardinality: 1..1
 * 
*/
    public String  typeOf(Any an_object) {
        if (an_object == null ) {
            throw new NullPointerException("Parameter an_object has cardinality NonNull, but is null.");
        }
        String  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if current object not equal to other.
 * Returns not equal().
 * cardinality: 1..1
 * 
*/
    public Boolean  notEqual alias "!=", "≠"(Ordered other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Boolean  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** Any *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected Any() {}

    protected Any(
            
        ){
    }


    //***** Any *****

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
            "Any {" +
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

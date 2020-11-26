package nl.rosa.semanticdatabase.foundation_types.primitive_types;

import java.util.Objects;

/**
 * 
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Type used to represent double-precision decimal numbers.
 * Corresponds to a double-precision floating point value in most languages.
 * 
*/
public class Double extends OrderedNumeric {

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Return the greatest integer no greater than the value of this object.
 * cardinality: 1..1
 * 
*/
    public Integer  floor() {
        Integer  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Double-precision real number addition.
 * cardinality: 1..1 (effected)
 * 
*/
    public Double  add alias "+"(Double other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Double  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Double-precision real number subtraction.
 * cardinality: 1..1 (effected)
 * 
*/
    public Double  subtract alias "-"(Double other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Double  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Double-precision real number multiplication.
 * cardinality: 1..1 (effected)
 * 
*/
    public Double  multiply alias "*"(Double other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Double  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Double-precision real number division.
 * cardinality: 1..1 (effected)
 * 
*/
    public Double  divide alias "/"(Double other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Double  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Double-precision real number exponentiation.
 * cardinality: 1..1 (effected)
 * 
*/
    public Double  exponent alias "^"(Double other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Double  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Returns True if current Double is less than other.
 * cardinality: 1..1 (effected)
 * 
*/
    public Boolean  lessThan alias "<"(Double other) {
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
 * Generate negative of current Double value.
 * cardinality: 1..1 (effected)
 * 
*/
    public Double  negative alias "-"() {
        Double  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Value equality: return True if this and other are attached to objects considered to be equal in value.
 * Parameters other Other object for comparison.
 * cardinality: 1..1 (effected)
 * 
*/
    public Boolean  isEqual(Double other) {
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
 * Reference equality for reference types, value equality for value types.
 * Parameters other Other object for comparison.
 * cardinality: 1..1 (redefined)
 * 
*/
    public Boolean  equal alias "=", "=="(Double other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Boolean  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** Double *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected Double() {}

    public Double(
            
        ){
    }

    private Double(Builder builder) {
    }

    public static class Builder {

        public Builder (
        ){
        }

        public Double build(){
            return new Double( this );
        }
    }


    //***** Double *****

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
    public java.lang.String toString() {
        return
            "Double {" +
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

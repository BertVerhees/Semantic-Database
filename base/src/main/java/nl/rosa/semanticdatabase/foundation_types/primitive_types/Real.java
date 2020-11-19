package nl.rosa.semanticdatabase.foundation_types.primitive_types;


/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Type used to represent decimal numbers.
 * Corresponds to a single-precision floating point value in most languages.
 * 
*/
public class Real extends OrderedNumeric {

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
        Integer  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Real number addition.
 * cardinality: 1..1 (effected)
 * 
*/
    public Real  add alias "+"(Real other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Real  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Real number subtraction.
 * cardinality: 1..1 (effected)
 * 
*/
    public Real  subtract alias "-"(Real other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Real  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Real number multiplication.
 * cardinality: 1..1 (effected)
 * 
*/
    public Real  multiply alias "*"(Real other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Real  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Real number division.
 * cardinality: 1..1 (effected)
 * 
*/
    public Double  divide alias "/"(Real other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Double  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Real number exponentiation.
 * cardinality: 1..1 (effected)
 * 
*/
    public Double  exponent alias "^"(Double other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Double  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Returns True if current Real is less than other.
 * cardinality: 1..1 (effected)
 * 
*/
    public Boolean  lessThan alias "<"(Real other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Generate negative of current Real value.
 * cardinality: 1..1 (effected)
 * 
*/
    public Real  negative alias "-"() {
        Real  result;


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
    public Boolean  isEqual(Real other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Boolean  result;


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
    public Boolean  equal alias "=", "=="(Real other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** Real *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public Real build() {
        return new Real(
            
        );
    }

    public Real(
            
    ){
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

package nl.rosa.semanticdatabase.foundation_types.primitive_types;


/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Type representing minimal interface of built-in Integer type.
 * 
*/
public class Integer extends OrderedNumeric {

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Integer addition.
 * cardinality: 1..1 (effected)
 * 
*/
    public Integer  add alias "+"(Integer other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Integer  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Integer subtraction.
 * cardinality: 1..1 (effected)
 * 
*/
    public Integer  subtract alias "-"(Integer other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Integer  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Integer multiplication.
 * cardinality: 1..1 (effected)
 * 
*/
    public Integer  multiply alias "*"(Integer other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Integer  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Integer division.
 * cardinality: 1..1 (effected)
 * 
*/
    public Double  divide alias "/"(Integer other) {
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
 * Integer exponentiation.
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
 * Return self modulo other.
 * cardinality: 1..1
 * 
*/
    public Integer  modulo alias "mod", "\\"(Integer mod) {
        if (mod == null ) {
            throw new NullPointerException("Parameter mod has cardinality NonNull, but is null.");
        }
        Integer  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Returns True if current Integer is less than other.
 * cardinality: 1..1 (effected)
 * 
*/
    public Boolean  lessThan alias "<"(Integer other) {
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
 * Generate negative of current Integer value.
 * cardinality: 1..1 (effected)
 * 
*/
    public Integer  negative alias "-"() {
        Integer  result;


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
    public Boolean  isEqual(Integer other) {
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
    public Boolean  equal alias "=", "=="(Integer other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** Integer *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public Integer build() {
        return new Integer(
            
        );
    }

    public Integer(
            
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

package nl.rosa.semanticdatabase.foundation_types.primitive_types;


/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Type representing minimal interface of built-in String type, as used to represent textual data in any natural or formal language.
 * 
*/
public class String extends Ordered {

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * True if string is empty, i.e.
 * equal to "".
 * cardinality: 1..1
 * 
*/
    public Boolean  isEmpty() {
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if string can be parsed as an integer.
 * cardinality: 1..1
 * 
*/
    public Boolean  isInteger() {
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Return the integer corresponding to the integer value represented in this string.
 * cardinality: 1..1
 * 
*/
    public Integer  asInteger() {
        Integer  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Concatenation operator - causes other to be appended to this string.
 * cardinality: 1..1
 * 
*/
    public String  append alias "+"(String other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        String  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Lexical comparison of string content based on ordering in relevant character set.
 * cardinality: 1..1 (effected)
 * 
*/
    public Boolean  lessThan alias "<"(String other) {
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
 * Return True if this String contains other (case-sensitive).
 * cardinality: 1..1
 * 
*/
    public Boolean  contains(String other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** String *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public String build() {
        return new String(
            
        );
    }

    public String(
            
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

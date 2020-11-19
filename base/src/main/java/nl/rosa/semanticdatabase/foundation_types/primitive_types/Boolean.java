package nl.rosa.semanticdatabase.foundation_types.primitive_types;

import nl.rosa.semanticdatabase.foundation_types.overview.Any;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Type representing minimal interface of built-in Boolean type.
 * 
*/
public class Boolean extends Any {

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Logical conjunction of this with other.
 * cardinality: 1..1
 * 
*/
    public Result = (other and self)  conjunction alias "and", "∧", "&"(Boolean other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Result = (other and self)  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Boolean semi-strict conjunction with other.
 * cardinality: 1..1
 * 
*/
    public Result = not (not self or else not other)  semistrictConjunction alias "and then", "&&"(Boolean other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Result = not (not self or else not other)  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Boolean disjunction with other.
 * cardinality: 1..1
 * 
*/
    public Result implies (self or else other)  disjunction alias "or", "∨", "|"(Boolean other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Result implies (self or else other)  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Boolean semi-strict disjunction with other.
 * cardinality: 1..1
 * 
*/
    public Result = not (not self and then not other)  semistrictDisjunction alias "or else", "||"(Boolean other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Result = not (not self and then not other)  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Boolean exclusive or with other.
 * cardinality: 1..1
 * 
*/
    public Result = self or other) and not (self and other  exclusiveDisjunction alias "xor", "⊻"(Boolean other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Result = self or other) and not (self and other  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Boolean implication of other (semi-strict)
 * cardinality: 1..1
 * 
*/
    public Result = (not self or else other)  implication alias "implies", "⇒"(Boolean other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Result = (not self or else other)  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Boolean negation of the current value.
 * cardinality: 1..1
 * 
*/
    public Boolean  negation alias "not", "¬", "!"() {
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** Boolean *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public Boolean build() {
        return new Boolean(
            
        );
    }

    public Boolean(
            
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

package nl.rosa.semanticdatabase.foundation_types.primitive_types;

import java.util.Objects;
import nl.rosa.semanticdatabase.foundation_types.overview.Any;

/**
 * 
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Abstract parent class of ordered types i.e.
 * types on which the '<' operator is defined.
 * 
*/
public abstract class Ordered extends Any {

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Arithmetic value comparison.
 * Returns True if current object is less than other.
 * This operator is effected and/or redefined in descendants to provide the appropriate ordering semantics for concrete types.
 * In conjunction with =, enables the definition of the related functions greater_than() etc.
 * cardinality: 1..1 (abstract)
 * 
*/
    public abstract Boolean  lessThan alias "<"(Ordered other);

/**
 * 
 * True if current object less than or equal to other.
 * cardinality: 1..1
 * 
*/
    public not (other <>  lessThanOrEqual alias "<=", "≤"(Ordered other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        not (other <>  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if current object greater than other.
 * cardinality: 1..1
 * 
*/
    public Result = (other <>  greaterThan alias ">"(Ordered other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Result = (other <>  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if current object greater than or equal to other.
 * cardinality: 1..1
 * 
*/
    public Result = (other <>  greaterThanOrEqual alias ">=", "≥"(Ordered other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Result = (other <>  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** Ordered *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected Ordered() {}

    protected Ordered(
            
        ){
    }


    //***** Ordered *****

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
            "Ordered {" +
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

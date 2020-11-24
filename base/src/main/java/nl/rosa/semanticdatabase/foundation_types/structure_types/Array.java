package nl.rosa.semanticdatabase.foundation_types.structure_types;

import nl.rosa.semanticdatabase..;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Integer;

/**
 * 
 * #Generated: 2020-11-24T17:04:33.085+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Container whose storage is assumed to be contiguous.
 * 
*/
public class Array<t> extends Container {

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Return item for key a_key.
 * cardinality: 1..1
 * 
*/
    public T  item alias "[]"(Integer a_key) {
        if (a_key == null ) {
            throw new NullPointerException("Parameter a_key has cardinality NonNull, but is null.");
        }
        T  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** Array<t> *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    public Array<t>(
            
        ){
    }

    private Array<t>(Builder builder) {
    }

    public static class Builder {

        public Builder (
        ){
        }

        public Array<t> build(){
            return new Array<t>( this );
        }
    }


    //***** Array<t> *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Array<t> that = (Array<t>) object;
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
            "Array<t> {" +
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

package nl.rosa.semanticdatabase.foundation_types.interval;

import nl.rosa.semanticdatabase..;

/**
 * 
 * #Generated: 2020-11-24T17:04:33.085+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Type representing a 'proper' Interval, i.e.
 * any two-sided or one-sided interval.
 * 
*/
public class ProperInterval<t> extends Interval {

    //***** ProperInterval<t> *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    public ProperInterval<t>(
            
        ){
    }

    private ProperInterval<t>(Builder builder) {
    }

    public static class Builder {

        public Builder (
        ){
        }

        public ProperInterval<t> build(){
            return new ProperInterval<t>( this );
        }
    }


    //***** ProperInterval<t> *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ProperInterval<t> that = (ProperInterval<t>) object;
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
            "ProperInterval<t> {" +
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

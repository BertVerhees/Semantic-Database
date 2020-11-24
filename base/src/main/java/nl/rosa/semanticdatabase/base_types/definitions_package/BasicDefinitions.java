package nl.rosa.semanticdatabase.base_types.definitions_package;


/**
 * 
 * #Generated: 2020-11-24T17:04:33.085+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Defines globally used constant values.
 * 
*/
public class BasicDefinitions {

/*=========================================================*/
/* * CONSTANTS * */
/*=========================================================*/

/**
 * 
 * Carriage return character.
 * 
*/
    final char cr = '\015';

/**
 * 
 * Line feed character.
 * 
*/
    final char lf = '\012';

    final String anyTypeName = "Any";

    final String regexAnyPattern = ".*";

    final String defaultEncoding = "UTF-8";

    final String noneTypeName = "None";

    //***** BasicDefinitions *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    public BasicDefinitions(
            
        ){
    }

    private BasicDefinitions(Builder builder) {
    }

    public static class Builder {

        public Builder (
        ){
        }

        public BasicDefinitions build(){
            return new BasicDefinitions( this );
        }
    }


    //***** BasicDefinitions *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BasicDefinitions that = (BasicDefinitions) object;
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
            "BasicDefinitions {" +
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

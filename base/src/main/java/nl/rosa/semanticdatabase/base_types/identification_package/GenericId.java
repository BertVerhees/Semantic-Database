package nl.rosa.semanticdatabase.base_types.identification_package;

import java.util.Objects;

/**
 * 
 * #Generated: 2020-11-25T09:35:00.89+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Generic identifier type for identifiers whose format is otherwise unknown to openEHR.
 * Includes an attribute for naming the identification scheme (which may well be local).
 * 
*/
public class GenericId extends ObjectId {

    //***** GenericId *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Name of the scheme to which this identifier conforms.
 * Ideally this name will be recognisable globally but realistically it may be a local ad hoc scheme whose name is not controlled or standardised in any way.
 * cardinality: 1..1
 * 
*/
    private String scheme;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Name of the scheme to which this identifier conforms.
 * Ideally this name will be recognisable globally but realistically it may be a local ad hoc scheme whose name is not controlled or standardised in any way.
 * cardinality: 1..1
 * 
*/
    public String getScheme() {
        return scheme;
    }
    public void setScheme(String value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:scheme failed, it has cardinality NonNull, but is null");
        }
        this.scheme = scheme;
    }

    //***** GenericId *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected GenericId() {}

    public GenericId(
            String scheme,
            String value
        ){
        super( 
            value
        );
        if ( scheme == null ) {
            throw new NullPointerException("Property:scheme has cardinality NonNull, but is null");
        }
        this.scheme = scheme;
    }

    private GenericId(Builder builder) {
        this.setScheme( builder.scheme );
        this.setValue( builder.value );
    }

    public static class Builder {
        private final String scheme;  //required
        private final String value;  //required

        public Builder (
            String scheme,
            String value
        ){
            if ( scheme == null ) {
                throw new NullPointerException("Property:scheme has cardinality NonNull, but is null");
            }
            if ( value == null ) {
                throw new NullPointerException("Property:value has cardinality NonNull, but is null");
            }
            this.scheme = scheme;
            this.value = value;
        }

        public GenericId build(){
            return new GenericId( this );
        }
    }


    //***** GenericId *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        GenericId that = (GenericId) object;
        return
            Objects.equals(scheme, that.scheme);
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            scheme
        );
    }

    @Override
    public String toString() {
        return
            "GenericId {" +
            "scheme='" + scheme + '\'' +
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

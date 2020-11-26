package nl.rosa.semanticdatabase.base_types.identification_package;

import java.util.Objects;

/**
 * 
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Identifier for terminologies such as accessed via a terminology query service.
 * In this class, the value attribute identifies the Terminology in the terminology service, e.g.
 * SNOMED-CT .
 * A terminology is assumed to be in a particular language, which must be explicitly specified.
 * The value if the id attribute is the precise terminology id identifier, including actual release (i.e.
 * actual version), local modifications etc; e.g.
 * ICPC2.
 * Lexical form: name [ '(' version ')' ].
 * 
*/
public class TerminologyId extends ObjectId {

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Return the terminology id (which includes the version in some cases).
 * Distinct names correspond to distinct (i.e.
 * non-compatible) terminologies.
 * Thus the names ICD10AM and ICD10 refer to distinct terminologies.
 * cardinality: 1..1
 * 
*/
    public String  name() {
        String  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Version of this terminology, if versioning supported, else the empty string.
 * cardinality: 1..1
 * 
*/
    public String  versionId() {
        String  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** TerminologyId *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected TerminologyId() {}

    public TerminologyId(
            String value
        ){
        super( 
            value
        );
    }

    private TerminologyId(Builder builder) {
        this.setValue( builder.value );
    }

    public static class Builder {
        private final String value;  //required

        public Builder (
            String value
        ){
            if ( value == null ) {
                throw new NullPointerException("Property:value has cardinality NonNull, but is null");
            }
            this.value = value;
        }

        public TerminologyId build(){
            return new TerminologyId( this );
        }
    }


    //***** TerminologyId *****

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
    public String toString() {
        return
            "TerminologyId {" +
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

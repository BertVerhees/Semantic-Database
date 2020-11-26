package nl.rosa.semanticdatabase.base_types.identification_package;

import java.util.Objects;

/**
 * 
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Identifier for parties in a demographic or identity service.
 * There are typically a number of subtypes of the PARTY class, including PERSON, ORGANISATION, etc.
 * Abstract supertypes are allowed if the referenced object is of a type not known by the current implementation of this class (in other words, if the demographic model is changed by the addition of a new PARTY or ACTOR subtypes, valid PARTY_REFs can still be constructed to them).
 * 
*/
public class PartyRef extends ObjectRef {

    //***** PartyRef *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected PartyRef() {}

    public PartyRef(
            String namespace,
            String type,
            ObjectId id
        ){
        super( 
            namespace,
            type,
            id
        );
    }

    private PartyRef(Builder builder) {
        this.setNamespace( builder.namespace );
        this.setType( builder.type );
        this.setId( builder.id );
    }

    public static class Builder {
        private final String namespace;  //required
        private final String type;  //required
        private final ObjectId id;  //required

        public Builder (
            String namespace,
            String type,
            ObjectId id
        ){
            if ( namespace == null ) {
                throw new NullPointerException("Property:namespace has cardinality NonNull, but is null");
            }
            if ( type == null ) {
                throw new NullPointerException("Property:type has cardinality NonNull, but is null");
            }
            if ( id == null ) {
                throw new NullPointerException("Property:id has cardinality NonNull, but is null");
            }
            this.namespace = namespace;
            this.type = type;
            this.id = id;
        }

        public PartyRef build(){
            return new PartyRef( this );
        }
    }


    //***** PartyRef *****

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
            "PartyRef {" +
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

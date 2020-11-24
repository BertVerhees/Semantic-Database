package nl.rosa.semanticdatabase.bmm.literal_values;

import nl.rosa.semanticdatabase.bmm.types.BmmIndexedContainerType;

/**
 * 
 * #Generated: 2020-11-24T17:04:33.085+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Meta-type for literals whose concrete type is an indexed container, i.e.
 * Hash table, Map etc.
 * 
*/
public class BmmIndexedContainerValue extends BmmContainerValue {

    //***** BmmIndexedContainerValue *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Declared or inferred static type of the entity.
 * cardinality: 1..1 (redefined)
 * 
*/
    private BmmIndexedContainerType type;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Declared or inferred static type of the entity.
 * cardinality: 1..1 (redefined)
 * 
*/
    public BmmIndexedContainerType getType() {
        return type;
    }
    public setType(BmmIndexedContainerType value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:type failed, it has cardinality NonNull, but is null");
        }
        this.type = type;
    }

    //***** BmmIndexedContainerValue *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    public BmmIndexedContainerValue(
            BmmIndexedContainerType type,
            BmmContainerType type,
            String valueLiteral,
            Any value,
            String syntax,
            BmmType type
        ){
        super( 
            valueLiteral,
            value,
            syntax
        );
        if ( type == null ) {
            throw new NullPointerException("Property:type has cardinality NonNull, but is null");
        }
        this.type = type;
    }

    private BmmIndexedContainerValue(Builder builder) {
        this.setType( builder.type );
        this.setType( builder.type );
        this.setValueLiteral( builder.valueLiteral );
        this.setValue( builder.value );
        this.setSyntax( builder.syntax );
        this.setType( builder.type );
    }

    public static class Builder {
        private final BmmIndexedContainerType type;  //required
        private final BmmContainerType type;  //required
        private final String valueLiteral;  //required
        private Any value;
        private String syntax;
        private final BmmType type;  //required

        public Builder (
            BmmIndexedContainerType type,
            BmmContainerType type,
            String valueLiteral,
            BmmType type
        ){
            if ( type == null ) {
                throw new NullPointerException("Property:type has cardinality NonNull, but is null");
            }
            if ( type == null ) {
                throw new NullPointerException("Property:type has cardinality NonNull, but is null");
            }
            if ( valueLiteral == null ) {
                throw new NullPointerException("Property:valueLiteral has cardinality NonNull, but is null");
            }
            if ( type == null ) {
                throw new NullPointerException("Property:type has cardinality NonNull, but is null");
            }
            this.type = type;
            this.type = type;
            this.valueLiteral = valueLiteral;
            this.type = type;
        }

        public Builder setValue(Any value) {
            this.value = value;
            return this;
        }

        public Builder setSyntax(String value) {
            this.syntax = syntax;
            return this;
        }

        public BmmIndexedContainerValue build(){
            return new BmmIndexedContainerValue( this );
        }
    }


    //***** BmmIndexedContainerValue *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmIndexedContainerValue that = (BmmIndexedContainerValue) object;
        return
            java.util.Objects.equals(type, that.type);
        }
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            type
        );
    }

    @java.lang.Override
    public java.lang.String toString() {
        return
            "BmmIndexedContainerValue {" +
            "type='" + type + '\''; +
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

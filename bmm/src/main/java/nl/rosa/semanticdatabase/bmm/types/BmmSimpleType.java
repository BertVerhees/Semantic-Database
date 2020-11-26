package nl.rosa.semanticdatabase.bmm.types;

import java.util.Objects;
import nl.rosa.semanticdatabase.bmm.classes.BmmSimpleClass;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Boolean;

/**
 * 
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Type reference to a single type i.e.
 * not generic or container type.
 * 
*/
public class BmmSimpleType extends BmmModelType {

    //***** BmmSimpleType *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Defining class of this type.
 * cardinality: 1..1 (redefined)
 * 
*/
    private BmmSimpleClass baseClass;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Defining class of this type.
 * cardinality: 1..1 (redefined)
 * 
*/
    public BmmSimpleClass getBaseClass() {
        return baseClass;
    }
    public void setBaseClass(BmmSimpleClass value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:baseClass failed, it has cardinality NonNull, but is null");
        }
        this.baseClass = baseClass;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Result is base_class.name.
 * cardinality: 1..1 (effected)
 * 
*/
    public String  typeName() {
        String  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Result is base_class.is_abstract.
 * cardinality: 1..1 (effected)
 * 
*/
    public Boolean  isAbstract() {
        Boolean  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Result is base_class.name .
 * cardinality: 1..1 (effected)
 * 
*/
    public List<String>  flattenedTypeList() {
        List<String>  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Main design class for this type, from which properties etc can be extracted.
 * cardinality: 1..1
 * 
*/
    public BmmSimpleClass  effectiveBaseClass() {
        BmmSimpleClass  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** BmmSimpleType *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected BmmSimpleType() {}

    public BmmSimpleType(
            BmmSimpleClass baseClass,
            BmmValueSetSpec valueConstraint,
            BmmClass baseClass
        ){
        super( 
            valueConstraint
        );
        if ( baseClass == null ) {
            throw new NullPointerException("Property:baseClass has cardinality NonNull, but is null");
        }
        this.baseClass = baseClass;
    }

    private BmmSimpleType(Builder builder) {
        this.setBaseClass( builder.baseClass );
        this.setValueConstraint( builder.valueConstraint );
        this.setBaseClass( builder.baseClass );
    }

    public static class Builder {
        private final BmmSimpleClass baseClass;  //required
        private BmmValueSetSpec valueConstraint;
        private final BmmClass baseClass;  //required

        public Builder (
            BmmSimpleClass baseClass,
            BmmClass baseClass
        ){
            if ( baseClass == null ) {
                throw new NullPointerException("Property:baseClass has cardinality NonNull, but is null");
            }
            if ( baseClass == null ) {
                throw new NullPointerException("Property:baseClass has cardinality NonNull, but is null");
            }
            this.baseClass = baseClass;
            this.baseClass = baseClass;
        }

        public Builder setValueConstraint(BmmValueSetSpec value) {
            this.valueConstraint = valueConstraint;
            return this;
        }

        public BmmSimpleType build(){
            return new BmmSimpleType( this );
        }
    }


    //***** BmmSimpleType *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmSimpleType that = (BmmSimpleType) object;
        return
            java.util.Objects.equals(baseClass, that.baseClass);
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            baseClass
        );
    }

    @java.lang.Override
    public java.lang.String toString() {
        return
            "BmmSimpleType {" +
            "baseClass='" + baseClass + '\'' +
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

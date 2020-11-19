package nl.rosa.semanticdatabase.bmm.types;

import nl.rosa.semanticdatabase.foundation_types.primitive_types.String;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Meta-type of linear container type that indexes the contained items in the manner of a standard Hash table, map or dictionary.
 * 
*/
public class BmmIndexedContainerType extends BmmContainerType {

    //***** BmmIndexedContainerType *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Type of the element index, typically String or Integer, but may be a numeric type or indeed any type from which a hash value can be derived.
 * cardinality: 1..1
 * 
*/
    private BmmSimpleType indexType;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Type of the element index, typically String or Integer, but may be a numeric type or indeed any type from which a hash value can be derived.
 * cardinality: 1..1
 * 
*/
    public BmmSimpleType getIndexType() {
        return indexType;
    }
    public BmmIndexedContainerType setIndexType(BmmSimpleType value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:indexType failed, it has cardinality NonNull, but is null");
        }
        this.indexType = indexType;
        return this;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Return full type name, e.g.
 * HashMap<String, ELEMENT>.
 * cardinality: 1..1 (effected)
 * 
*/
    public String  typeName() {
        String  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** BmmIndexedContainerType *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public BmmIndexedContainerType build() {
        return new BmmIndexedContainerType(
            indexType,
            containerClass,
            itemType
        );
    }

    public BmmIndexedContainerType(
            BmmSimpleType indexType,
            BmmGenericClass containerClass,
            BmmUnitaryType itemType
    ){
        if ( indexType == null ) {
            throw new NullPointerException("Property:indexType has cardinality NonNull, but is null");
        }
        if ( containerClass == null ) {
            throw new NullPointerException("Property:containerClass has cardinality NonNull, but is null");
        }
        if ( itemType == null ) {
            throw new NullPointerException("Property:itemType has cardinality NonNull, but is null");
        }
        this.indexType = indexType;
        this.containerClass = containerClass;
        this.itemType = itemType;
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

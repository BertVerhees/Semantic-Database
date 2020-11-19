package nl.rosa.semanticdatabase.bmm.expressions;

import nl.rosa.semanticdatabase.bmm.types.BmmType;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Special meta-type used to represent a reference that may appear in any routine, pre- or post-condition, or invariant, and resolves to the current object within which feature references are scoped; corresponds to 'self', 'this' or 'Current' in various programming languages.
 * 
*/
public class ElSelfRef extends ElInstanceRef {

    //***** ElSelfRef *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Type of the current scoping instance, inferred from expression context.
 * cardinality: 1..1
 * 
*/
    private BmmType type;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Type of the current scoping instance, inferred from expression context.
 * cardinality: 1..1
 * 
*/
    public BmmType getType() {
        return type;
    }
    public ElSelfRef setType(BmmType value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:type failed, it has cardinality NonNull, but is null");
        }
        this.type = type;
        return this;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Return type.
 * cardinality: 1..1 (effected)
 * 
*/
    public BmmType  evalType() {
        BmmType  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** ElSelfRef *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public ElSelfRef build() {
        return new ElSelfRef(
            type
        );
    }

    public ElSelfRef(
            BmmType type
    ){
        if ( type == null ) {
            throw new NullPointerException("Property:type has cardinality NonNull, but is null");
        }
        this.type = type;
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

package nl.rosa.semanticdatabase.bmm.classes;

import nl.rosa.semanticdatabase.foundation_types.primitive_types.String;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Definition of a range-constrained class whose value range is defined by reference to a 'value set' within an external resource, e.g.
 * a reference data service.
 * 
*/
public class BmmValueSetSpec {

    //***** BmmValueSetSpec *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Identifier of a resource (typically available as a service) that contains legal values of a specific type.
 * This is typically a URI but need not be.
 * cardinality: 1..1
 * 
*/
    private String resourceId;

/**
 * 
 * Identifier of a value set within the resource identified by resource_id, which specifies the set of legal values of a type.
 * This might be a URI, but need not be.
 * cardinality: 1..1
 * 
*/
    private String valueSetId;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Identifier of a resource (typically available as a service) that contains legal values of a specific type.
 * This is typically a URI but need not be.
 * cardinality: 1..1
 * 
*/
    public String getResourceId() {
        return resourceId;
    }
    public BmmValueSetSpec setResourceId(String value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:resourceId failed, it has cardinality NonNull, but is null");
        }
        this.resourceId = resourceId;
        return this;
    }

/**
 * 
 * Identifier of a value set within the resource identified by resource_id, which specifies the set of legal values of a type.
 * This might be a URI, but need not be.
 * cardinality: 1..1
 * 
*/
    public String getValueSetId() {
        return valueSetId;
    }
    public BmmValueSetSpec setValueSetId(String value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:valueSetId failed, it has cardinality NonNull, but is null");
        }
        this.valueSetId = valueSetId;
        return this;
    }

    //***** BmmValueSetSpec *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public BmmValueSetSpec build() {
        return new BmmValueSetSpec(
            resourceId,
            valueSetId
        );
    }

    public BmmValueSetSpec(
            String resourceId,
            String valueSetId
    ){
        if ( resourceId == null ) {
            throw new NullPointerException("Property:resourceId has cardinality NonNull, but is null");
        }
        if ( valueSetId == null ) {
            throw new NullPointerException("Property:valueSetId has cardinality NonNull, but is null");
        }
        this.resourceId = resourceId;
        this.valueSetId = valueSetId;
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

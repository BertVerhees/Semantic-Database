package nl.rosa.semanticdatabase.base_types.identification_package;

import nl.rosa.semanticdatabase.foundation_types.primitive_types.String;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Purpose Reference to a LOCATABLE instance inside the top-level content structure inside a VERSION<T>; the path attribute is applied to the object that VERSION.data points to.
 * 
*/
public class LocatableRef extends ObjectRef {

    //***** LocatableRef *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * The path to an instance in question, as an absolute path with respect to the object found at VERSION.data.
 * An empty path means that the object referred to by id being specified.
 * cardinality: 0..1
 * 
*/
    private String path;

/**
 * 
 * Globally unique id of an object, regardless of where it is stored.
 * cardinality: 1..1 (redefined)
 * 
*/
    private UidBasedId id;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * The path to an instance in question, as an absolute path with respect to the object found at VERSION.data.
 * An empty path means that the object referred to by id being specified.
 * cardinality: 0..1
 * 
*/
    public String getPath() {
        return path;
    }
    public LocatableRef setPath(String value) {
        this.path = path;
        return this;
    }

/**
 * 
 * Globally unique id of an object, regardless of where it is stored.
 * cardinality: 1..1 (redefined)
 * 
*/
    public UidBasedId getId() {
        return id;
    }
    public LocatableRef setId(UidBasedId value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:id failed, it has cardinality NonNull, but is null");
        }
        this.id = id;
        return this;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * A URI form of the reference, created by concatenating the following: scheme, e.g.
 * ehr:, derived from namespace id.value / + path, where path is non-empty
 * cardinality: 1..1
 * 
*/
    public String  asUri() {
        String  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** LocatableRef *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public LocatableRef build() {
        return new LocatableRef(
            path,
            id,
            namespace,
            type,
            id
        );
    }

    public LocatableRef(
            String path,
            UidBasedId id,
            String namespace,
            String type,
            ObjectId id
    ){
        if ( id == null ) {
            throw new NullPointerException("Property:id has cardinality NonNull, but is null");
        }
        if ( namespace == null ) {
            throw new NullPointerException("Property:namespace has cardinality NonNull, but is null");
        }
        if ( type == null ) {
            throw new NullPointerException("Property:type has cardinality NonNull, but is null");
        }
        if ( id == null ) {
            throw new NullPointerException("Property:id has cardinality NonNull, but is null");
        }
        this.path = path;
        this.id = id;
        this.namespace = namespace;
        this.type = type;
        this.id = id;
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

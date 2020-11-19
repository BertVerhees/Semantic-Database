package nl.rosa.semanticdatabase.bmm.class_features;

import nl.rosa.semanticdatabase.bmm.types.BmmIndexedContainerType;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.String;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Meta-type of for properties of linear container type, such as Hash<Index_type, T> etc.
 * 
*/
public class BmmIndexedContainerProperty extends BmmContainerProperty {

    //***** BmmIndexedContainerProperty *****

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
    public BmmIndexedContainerProperty setType(BmmIndexedContainerType value) {
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
 * Name of this property in form name: ContainerTypeName<IndexTypeName, …​>.
 * cardinality: 1..1 (redefined)
 * 
*/
    public String  displayName() {
        String  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** BmmIndexedContainerProperty *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public BmmIndexedContainerProperty build() {
        return new BmmIndexedContainerProperty(
            type,
            cardinality,
            type,
            type,
            visibility,
            featureExtensions,
            group,
            scope,
            name,
            documentation,
            scope,
            extensions
        );
    }

    public BmmIndexedContainerProperty(
            BmmIndexedContainerType type,
            MultiplicityInterval cardinality,
            BmmContainerType type,
            BmmType type,
            BmmVisibility visibility,
            List<BMM_FEATURE_EXTENSION> featureExtensions,
            BmmFeatureGroup group,
            BmmClass scope,
            String name,
            Map<String, Any> documentation,
            BmmDeclaration scope,
            Map<String, Any> extensions
    ){
        if ( type == null ) {
            throw new NullPointerException("Property:type has cardinality NonNull, but is null");
        }
        if ( type == null ) {
            throw new NullPointerException("Property:type has cardinality NonNull, but is null");
        }
        if ( type == null ) {
            throw new NullPointerException("Property:type has cardinality NonNull, but is null");
        }
        if ( group == null ) {
            throw new NullPointerException("Property:group has cardinality NonNull, but is null");
        }
        if ( scope == null ) {
            throw new NullPointerException("Property:scope has cardinality NonNull, but is null");
        }
        if ( name == null ) {
            throw new NullPointerException("Property:name has cardinality NonNull, but is null");
        }
        if ( scope == null ) {
            throw new NullPointerException("Property:scope has cardinality NonNull, but is null");
        }
        this.type = type;
        this.cardinality = cardinality;
        this.type = type;
        this.type = type;
        this.visibility = visibility;
        this.featureExtensions = featureExtensions;
        this.group = group;
        this.scope = scope;
        this.name = name;
        this.documentation = documentation;
        this.scope = scope;
        this.extensions = extensions;
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

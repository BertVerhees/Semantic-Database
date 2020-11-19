package nl.rosa.semanticdatabase.bmm.classes;

import nl.rosa.semanticdatabase.bmm.types.BmmSimpleType;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Definition of a simple class, i.e.
 * a class that has no generic parameters and is 1:1 with the type it generates.
 * 
*/
public class BmmSimpleClass extends BmmClass {

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Generate a type object that represents the type of this class.
 * Can only be an instance of BMM_SIMPLE_TYPE or a descendant.
 * cardinality: 1..1 (effected)
 * 
*/
    public BmmSimpleType  type() {
        BmmSimpleType  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** BmmSimpleClass *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public BmmSimpleClass build() {
        return new BmmSimpleClass(
            ancestors,
            package,
            properties,
            sourceSchemaId,
            immediateDescendants,
            isOverride,
            constants,
            functions,
            procedures,
            invariants,
            creators,
            converters,
            featureGroups,
            scope,
            name,
            documentation,
            scope,
            extensions
        );
    }

    public BmmSimpleClass(
            Map<String,BmmModelType> ancestors,
            BmmPackage package,
            Map<String,BmmProperty> properties,
            String sourceSchemaId,
            List<BmmClass> immediateDescendants,
            Boolean isOverride,
            Map<String,BmmConstant> constants,
            Map<String,BmmFunction> functions,
            Map<String,BmmProcedure> procedures,
            List<BmmAssertion> invariants,
            Map<String,BmmProcedure> creators,
            Map<String,BmmProcedure> converters,
            List<BmmFeatureGroup> featureGroups,
            BmmModel scope,
            String name,
            Map<String, Any> documentation,
            BmmDeclaration scope,
            Map<String, Any> extensions
    ){
        if ( package == null ) {
            throw new NullPointerException("Property:package has cardinality NonNull, but is null");
        }
        if ( sourceSchemaId == null ) {
            throw new NullPointerException("Property:sourceSchemaId has cardinality NonNull, but is null");
        }
        if ( isOverride == null ) {
            throw new NullPointerException("Property:isOverride has cardinality NonNull, but is null");
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
        this.ancestors = ancestors;
        this.package = package;
        this.properties = properties;
        this.sourceSchemaId = sourceSchemaId;
        this.immediateDescendants = immediateDescendants;
        this.isOverride = isOverride;
        this.constants = constants;
        this.functions = functions;
        this.procedures = procedures;
        this.invariants = invariants;
        this.creators = creators;
        this.converters = converters;
        this.featureGroups = featureGroups;
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

package nl.rosa.semanticdatabase.bmm.class_features;

import nl.rosa.semanticdatabase.bmm.expressions.ElInstanceRef;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * An immutable, static value-returning element scoped to a class.
 * The value is the result of the evaluation of the generator, which may be as simple as a literal value, or may be any expression, including a function call.
 * 
*/
public class BmmConstant extends BmmClassFeature implements BmmInstantiable {

    //***** BmmConstant *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Generator expression for the constant value.
 * In the degenerate case, this is just a literal value, but may also be any other expression valid in the context.
 * cardinality: 1..1
 * 
*/
    private ElInstanceRef generator;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Generator expression for the constant value.
 * In the degenerate case, this is just a literal value, but may also be any other expression valid in the context.
 * cardinality: 1..1
 * 
*/
    public ElInstanceRef getGenerator() {
        return generator;
    }
    public BmmConstant setGenerator(ElInstanceRef value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:generator failed, it has cardinality NonNull, but is null");
        }
        this.generator = generator;
        return this;
    }

/*=========================================================*/
/* * CONSTANTS * */
/*=========================================================*/

/**
 * 
 * True if this element can be null (Void) at execution time.
 * May be interpreted as optionality in subtypes..
 * 
*/
    final Boolean {default isNullable = false};

    //***** BmmTyped *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Declared or inferred static type of the entity.
 * cardinality: 1..1
 * 
*/
    private BmmType type;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Declared or inferred static type of the entity.
 * cardinality: 1..1
 * 
*/
    public BmmType getType() {
        return type;
    }
    public BmmTyped setType(BmmType value) {
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
 * True if type is notionally Boolean (i.e.
 * a BMM_SIMPLE_TYPE with type_name() = 'Boolean').
 * cardinality: 1..1
 * 
*/
    public Result = type().equal( {BMM_MODEL}.boolean_type_definition())  isBoolean() {
        Result = type().equal( {BMM_MODEL}.boolean_type_definition())  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** BmmConstant *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public BmmConstant build() {
        return new BmmConstant(
            generator,
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

    public BmmConstant(
            ElInstanceRef generator,
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
        if ( generator == null ) {
            throw new NullPointerException("Property:generator has cardinality NonNull, but is null");
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
        this.generator = generator;
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

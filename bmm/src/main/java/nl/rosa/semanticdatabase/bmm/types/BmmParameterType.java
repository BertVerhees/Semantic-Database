package nl.rosa.semanticdatabase.bmm.types;

import nl.rosa.semanticdatabase.foundation_types.primitive_types.String;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Boolean;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Definition of a generic parameter in a class definition of a generic type.
 * 
*/
public class BmmParameterType extends BmmUnitaryType {

    //***** BmmParameterType *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Name of the parameter, e.g.
 * 'T' etc.
 * The name is limited to 1 character and upper-case.
 * cardinality: 1..1
 * 
*/
    private String name;

/**
 * 
 * Optional conformance constraint that must be the name of a defined type.
 * cardinality: 0..1
 * 
*/
    private BmmEffectiveType typeConstraint;

/**
 * 
 * If set, is the corresponding generic parameter definition in an ancestor class.
 * cardinality: 0..1
 * 
*/
    private BmmParameterType inheritancePrecursor;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Name of the parameter, e.g.
 * 'T' etc.
 * The name is limited to 1 character and upper-case.
 * cardinality: 1..1
 * 
*/
    public String getName() {
        return name;
    }
    public BmmParameterType setName(String value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:name failed, it has cardinality NonNull, but is null");
        }
        this.name = name;
        return this;
    }

/**
 * 
 * Optional conformance constraint that must be the name of a defined type.
 * cardinality: 0..1
 * 
*/
    public BmmEffectiveType getTypeConstraint() {
        return typeConstraint;
    }
    public BmmParameterType setTypeConstraint(BmmEffectiveType value) {
        this.typeConstraint = typeConstraint;
        return this;
    }

/**
 * 
 * If set, is the corresponding generic parameter definition in an ancestor class.
 * cardinality: 0..1
 * 
*/
    public BmmParameterType getInheritancePrecursor() {
        return inheritancePrecursor;
    }
    public BmmParameterType setInheritancePrecursor(BmmParameterType value) {
        this.inheritancePrecursor = inheritancePrecursor;
        return this;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Result is either conforms_to_type or inheritance_precursor.flattened_conforms_to_type.
 * cardinality: 1..1
 * 
*/
    public BmmEffectiveType  flattenedConformsToType() {
        BmmEffectiveType  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Signature form of the open type, including constrainer type if there is one, e.g.
 * T:Ordered.
 * cardinality: 1..1 (redefined)
 * 
*/
    public String  typeSignature() {
        String  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Result = False - generic parameters are understood by definition to be non-primitive.
 * cardinality: 1..1 (effected)
 * 
*/
    public Boolean  isPrimitive() {
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Result = False - generic parameters are understood by definition to be non-abstract.
 * cardinality: 1..1 (effected)
 * 
*/
    public Boolean  isAbstract() {
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Return name.
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

/**
 * 
 * Result is either flattened_conforms_to_type.flattened_type_list or the Any type.
 * cardinality: 1..1 (effected)
 * 
*/
    public List<String>  flattenedTypeList() {
        List<String>  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Generate ultimate conformance type, which is either flattened_conforms_to_type or if not set, 'Any'.
 * cardinality: 1..1 (effected)
 * 
*/
    public BmmEffectiveType  effectiveType() {
        BmmEffectiveType  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** BmmParameterType *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public BmmParameterType build() {
        return new BmmParameterType(
            name,
            typeConstraint,
            inheritancePrecursor
        );
    }

    public BmmParameterType(
            String name,
            BmmEffectiveType typeConstraint,
            BmmParameterType inheritancePrecursor
    ){
        if ( name == null ) {
            throw new NullPointerException("Property:name has cardinality NonNull, but is null");
        }
        this.name = name;
        this.typeConstraint = typeConstraint;
        this.inheritancePrecursor = inheritancePrecursor;
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

package nl.rosa.semanticdatabase.bmm.literal_values;

import nl.rosa.semanticdatabase.bmm.class_features.BmmTyped;
import nl.rosa.semanticdatabase.foundation_types.overview.Any;

/**
 * 
 * #Generated: 2020-11-24T17:04:33.085+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Meta-type for literal instance values declared in a model.
 * Instance values may be inline values of primitive types in the usual fashion or complex objects in syntax form, e.g.
 * JSON.
 * 
*/
public abstract class BmmLiteralValue implements BmmTyped {

    //***** BmmLiteralValue *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * A serial representation of the value.
 * cardinality: 1..1
 * 
*/
    private String valueLiteral;

/**
 * 
 * A native representation of the value, possibly derived by deserialising value_literal.
 * cardinality: 0..1
 * 
*/
    private Any value;

/**
 * 
 * Optional specification of formalism of the value_literal attribute for complex values.
 * Value may be any of json | yawl | xml | odin | rdf or another value agreed by the user community.
 * If not set, json is assumed.
 * cardinality: 0..1
 * 
*/
    private String syntax;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * A serial representation of the value.
 * cardinality: 1..1
 * 
*/
    public String getValueLiteral() {
        return valueLiteral;
    }
    public setValueLiteral(String value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:valueLiteral failed, it has cardinality NonNull, but is null");
        }
        this.valueLiteral = valueLiteral;
    }

/**
 * 
 * A native representation of the value, possibly derived by deserialising value_literal.
 * cardinality: 0..1
 * 
*/
    public Any getValue() {
        return value;
    }
    public setValue(Any value) {
        this.value = value;
    }

/**
 * 
 * Optional specification of formalism of the value_literal attribute for complex values.
 * Value may be any of json | yawl | xml | odin | rdf or another value agreed by the user community.
 * If not set, json is assumed.
 * cardinality: 0..1
 * 
*/
    public String getSyntax() {
        return syntax;
    }
    public setSyntax(String value) {
        this.syntax = syntax;
    }

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
    public setType(BmmType value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:type failed, it has cardinality NonNull, but is null");
        }
        this.type = type;
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

    //***** BmmLiteralValue *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected BmmLiteralValue(
            String valueLiteral,
            Any value,
            String syntax,
            BmmType type
        ){
        if ( valueLiteral == null ) {
            throw new NullPointerException("Property:valueLiteral has cardinality NonNull, but is null");
        }
        if ( type == null ) {
            throw new NullPointerException("Property:type has cardinality NonNull, but is null");
        }
        this.valueLiteral = valueLiteral;
        this.value = value;
        this.syntax = syntax;
        this.type = type;
    }


    //***** BmmLiteralValue *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmLiteralValue that = (BmmLiteralValue) object;
        return
            java.util.Objects.equals(valueLiteral, that.valueLiteral) &&
            java.util.Objects.equals(value, that.value) &&
            java.util.Objects.equals(syntax, that.syntax) &&
            java.util.Objects.equals(type, that.type);
        }
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            valueLiteral,
            value,
            syntax,
            type
        );
    }

    @java.lang.Override
    public java.lang.String toString() {
        return
            "BmmLiteralValue {" +
            "valueLiteral='" + valueLiteral + '\''; +
            "value='" + value + '\''; +
            "syntax='" + syntax + '\''; +
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

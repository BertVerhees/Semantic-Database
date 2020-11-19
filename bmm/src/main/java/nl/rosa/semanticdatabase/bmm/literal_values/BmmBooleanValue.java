package nl.rosa.semanticdatabase.bmm.literal_values;

import nl.rosa.semanticdatabase.foundation_types.primitive_types.Boolean;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Meta-type for a literal Boolean value, for which type is fixed to the BMM_TYPE representing Boolean and value is of type Boolean.
 * 
*/
public class BmmBooleanValue extends BmmPrimitiveValue {

    //***** BmmBooleanValue *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Native Boolean value.
 * cardinality: 1..1 (redefined)
 * 
*/
    private Boolean value;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Native Boolean value.
 * cardinality: 1..1 (redefined)
 * 
*/
    public Boolean getValue() {
        return value;
    }
    public BmmBooleanValue setValue(Boolean value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:value failed, it has cardinality NonNull, but is null");
        }
        this.value = value;
        return this;
    }

    //***** BmmBooleanValue *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public BmmBooleanValue build() {
        return new BmmBooleanValue(
            value,
            type,
            type,
            valueLiteral,
            value,
            syntax,
            type
        );
    }

    public BmmBooleanValue(
            Boolean value,
            BmmSimpleType type,
            BmmUnitaryType type,
            String valueLiteral,
            Any value,
            String syntax,
            BmmType type
    ){
        if ( value == null ) {
            throw new NullPointerException("Property:value has cardinality NonNull, but is null");
        }
        if ( type == null ) {
            throw new NullPointerException("Property:type has cardinality NonNull, but is null");
        }
        if ( type == null ) {
            throw new NullPointerException("Property:type has cardinality NonNull, but is null");
        }
        if ( valueLiteral == null ) {
            throw new NullPointerException("Property:valueLiteral has cardinality NonNull, but is null");
        }
        if ( type == null ) {
            throw new NullPointerException("Property:type has cardinality NonNull, but is null");
        }
        this.value = value;
        this.type = type;
        this.type = type;
        this.valueLiteral = valueLiteral;
        this.value = value;
        this.syntax = syntax;
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

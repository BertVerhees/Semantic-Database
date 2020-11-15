package nl.rosa.semanticdatabase.bmm.literal_values;

import nl.rosa.semanticdatabase.bmm.class_features.BmmTyped;

/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
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
    private Object value;

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
        return value_literal;
    }
    public void setValueLiteral(String value) {
        if (value_literal == null ) {
            throw new NullPointerException(" value_literal has cardinality NonNull, but is null")
        }
        this.value_literal = value_literal;
    }

/**
 * 
 * A native representation of the value, possibly derived by deserialising value_literal.
 * cardinality: 0..1
 * 
*/
    public Object getValue() {
        return value;
    }
    public void setValue(Object value) {
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
    public void setSyntax(String value) {
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
    public void setType(BmmType value) {
        if (type == null ) {
            throw new NullPointerException(" type has cardinality NonNull, but is null")
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
    public abstract Result = type().equal( {BMM_MODEL}.boolean_type_definition())  isBoolean();

}

/**
 * 
 * ***** BEGIN LICENSE BLOCK ***** Version: MPL 1.1/GPL 2.0/LGPL 2.1
 * 
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with the
 * License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * 
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied.
 * See the License for
 * the specific language governing rights and limitations under the License.
 * 
 * The Initial Developer of the Original Code is Bert Verhees.
 * the Initial Developer Copyright (C) 2020 the Initial Developer.
 * All Rights Reserved.
 * 
 * Contributor(s): Bert Verhees
 * 
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied.
 * See the License for
 * the specific language governing rights and limitations under the License.
 * 
 * ***** END LICENSE BLOCK *****
 * 
*/

package nl.rosa.semanticdatabase.bmm.types;


/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
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
    public void setName(String value) {
        if (name == null ) {
            throw new NullPointerException(" name has cardinality NonNull, but is null")
        }
        this.name = name;
    }

/**
 * 
 * Optional conformance constraint that must be the name of a defined type.
 * cardinality: 0..1
 * 
*/
    public BmmEffectiveType getTypeConstraint() {
        return type_constraint;
    }
    public void setTypeConstraint(BmmEffectiveType value) {
        this.type_constraint = type_constraint;
    }

/**
 * 
 * If set, is the corresponding generic parameter definition in an ancestor class.
 * cardinality: 0..1
 * 
*/
    public BmmParameterType getInheritancePrecursor() {
        return inheritance_precursor;
    }
    public void setInheritancePrecursor(BmmParameterType value) {
        this.inheritance_precursor = inheritance_precursor;
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
    public abstract BmmEffectiveType  flattenedConformsToType();

/**
 * 
 * Signature form of the open type, including constrainer type if there is one, e.g.
 * T:Ordered.
 * cardinality: 1..1 (redefined)
 * 
*/
    public abstract String  typeSignature();

/**
 * 
 * Result = False - generic parameters are understood by definition to be non-primitive.
 * cardinality: 1..1 (effected)
 * 
*/
    public abstract Boolean  isPrimitive();

/**
 * 
 * Result = False - generic parameters are understood by definition to be non-abstract.
 * cardinality: 1..1 (effected)
 * 
*/
    public abstract Boolean  isAbstract();

/**
 * 
 * Return name.
 * cardinality: 1..1 (effected)
 * 
*/
    public abstract String  typeName();

/**
 * 
 * Result is either flattened_conforms_to_type.flattened_type_list or the Any type.
 * cardinality: 1..1 (effected)
 * 
*/
    public abstract List<String>  flattenedTypeList();

/**
 * 
 * Generate ultimate conformance type, which is either flattened_conforms_to_type or if not set, 'Any'.
 * cardinality: 1..1 (effected)
 * 
*/
    public abstract BmmEffectiveType  effectiveType();

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

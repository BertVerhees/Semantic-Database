package nl.rosa.semanticdatabase.bmm.types;

import nl.rosa.semanticdatabase.bmm.classes.BmmValueSetSpec;
import nl.rosa.semanticdatabase.bmm.classes.BmmClass;

/**
 * 
 * #Generated: 2020-11-15T17:28:03.861+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * A type that is defined by a class (or classes) in the model.
 * 
*/
public abstract class BmmModelType extends BmmEffectiveType {

    //***** BmmModelType *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * cardinality: 0..1
 * 
*/
    private BmmValueSetSpec valueConstraint;

/**
 * 
 * Base class of this type.
 * cardinality: 1..1
 * 
*/
    private BmmClass baseClass;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * cardinality: 0..1
 * 
*/
    public BmmValueSetSpec getValueConstraint() {
        return value_constraint;
    }
    public void setValueConstraint(BmmValueSetSpec value) {
        this.value_constraint = value_constraint;
    }

/**
 * 
 * Base class of this type.
 * cardinality: 1..1
 * 
*/
    public BmmClass getBaseClass() {
        return base_class;
    }
    public void setBaseClass(BmmClass value) {
        if (base_class == null ) {
            throw new NullPointerException(" base_class has cardinality NonNull, but is null")
        }
        this.base_class = base_class;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Result = base_class.name.
 * cardinality: 1..1 (effected)
 * 
*/
    public String  typeBaseName() {
        String  result;

        return  result;
    }

/**
 * 
 * Result = base_class.is_primitive.
 * cardinality: 1..1 (effected)
 * 
*/
    public Boolean  isPrimitive() {
        Boolean  result;

        return  result;
    }

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

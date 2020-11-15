package nl.rosa.semanticdatabase.bmm.types;

import nl.rosa.semanticdatabase.bmm.classes.BmmSimpleClass;

/**
 * 
 * #Generated: 2020-11-15T17:28:03.861+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Type reference to a single type i.e.
 * not generic or container type.
 * 
*/
public class BmmSimpleType extends BmmModelType {

    //***** BmmSimpleType *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Defining class of this type.
 * cardinality: 1..1 (redefined)
 * 
*/
    private BmmSimpleClass baseClass;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Defining class of this type.
 * cardinality: 1..1 (redefined)
 * 
*/
    public BmmSimpleClass getBaseClass() {
        return base_class;
    }
    public void setBaseClass(BmmSimpleClass value) {
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
 * Result is base_class.name.
 * cardinality: 1..1 (effected)
 * 
*/
    public String  typeName() {
        String  result;

        return  result;
    }

/**
 * 
 * Result is base_class.is_abstract.
 * cardinality: 1..1 (effected)
 * 
*/
    public Boolean  isAbstract() {
        Boolean  result;

        return  result;
    }

/**
 * 
 * Result is base_class.name .
 * cardinality: 1..1 (effected)
 * 
*/
    public List<String>  flattenedTypeList() {
        List<String>  result;

        return  result;
    }

/**
 * 
 * Main design class for this type, from which properties etc can be extracted.
 * cardinality: 1..1
 * 
*/
    public BmmSimpleClass  effectiveBaseClass() {
        BmmSimpleClass  result;

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

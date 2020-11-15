package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

import nl.rosa.semanticdatabase.bmm.classes.BmmEnumerationInteger;

/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Persistent form of an instance of BMM_ENUMERATION_INTEGER.
 * 
*/
public class PBmmEnumerationInteger extends PBmmEnumeration {

    //***** PBmmEnumerationInteger *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * BMM_CLASS object build by create_bmm_class_definition and populate_bmm_class_definition.
 * cardinality: 0..1 (redefined)
 * 
*/
    private BmmEnumerationInteger bmmClass;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * BMM_CLASS object build by create_bmm_class_definition and populate_bmm_class_definition.
 * cardinality: 0..1 (redefined)
 * 
*/
    public BmmEnumerationInteger getBmmClass() {
        return bmm_class;
    }
    public void setBmmClass(BmmEnumerationInteger value) {
        this.bmm_class = bmm_class;
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

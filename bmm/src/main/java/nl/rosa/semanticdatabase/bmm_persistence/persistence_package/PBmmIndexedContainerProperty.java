package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

import nl.rosa.semanticdatabase.bmm.class_features.BmmIndexedContainerProperty;

/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * 
 * 
*/
public class PBmmIndexedContainerProperty extends PBmmContainerProperty {

    //***** PBmmIndexedContainerProperty *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Type definition of this property, if not a simple String type reference.
 * Persistent attribute.
 * cardinality: 0..1 (redefined)
 * 
*/
    private PBmmIndexedContainerType typeDef;

/**
 * 
 * BMM_PROPERTY created by create_bmm_property.
 * cardinality: 0..1 (redefined)
 * 
*/
    private BmmIndexedContainerProperty bmmProperty;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Type definition of this property, if not a simple String type reference.
 * Persistent attribute.
 * cardinality: 0..1 (redefined)
 * 
*/
    public PBmmIndexedContainerType getTypeDef() {
        return type_def;
    }
    public void setTypeDef(PBmmIndexedContainerType value) {
        this.type_def = type_def;
    }

/**
 * 
 * BMM_PROPERTY created by create_bmm_property.
 * cardinality: 0..1 (redefined)
 * 
*/
    public BmmIndexedContainerProperty getBmmProperty() {
        return bmm_property;
    }
    public void setBmmProperty(BmmIndexedContainerProperty value) {
        this.bmm_property = bmm_property;
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

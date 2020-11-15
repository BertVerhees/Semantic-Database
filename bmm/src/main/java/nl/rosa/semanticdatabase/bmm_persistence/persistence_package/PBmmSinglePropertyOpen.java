package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

import nl.rosa.semanticdatabase.bmm.class_features.BmmUnitaryProperty;

/**
 * 
 * #Generated: 2020-11-15T17:28:03.861+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Persistent form of a BMM_SINGLE_PROPERTY_OPEN.
 * 
*/
public class PBmmSinglePropertyOpen extends PBmmProperty {

    //***** PBmmSinglePropertyOpen *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Type definition of this property computed from type for later use in bmm_property.
 * cardinality: 0..1
 * 
*/
    private PBmmOpenType typeRef;

/**
 * 
 * Type definition of this property, if a simple String type reference.
 * Really we should use type_def to be regular in the schema, but that makes the schema more wordy and less clear.
 * So we use this persisted String value, and compute the type_def on the fly.
 * Persisted attribute.
 * cardinality: 0..1
 * 
*/
    private String type;

/**
 * 
 * BMM_PROPERTY created by create_bmm_property_definition.
 * cardinality: 0..1 (redefined)
 * 
*/
    private BmmUnitaryProperty bmmProperty;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Type definition of this property computed from type for later use in bmm_property.
 * cardinality: 0..1
 * 
*/
    public PBmmOpenType getTypeRef() {
        return type_ref;
    }
    public void setTypeRef(PBmmOpenType value) {
        this.type_ref = type_ref;
    }

/**
 * 
 * Type definition of this property, if a simple String type reference.
 * Really we should use type_def to be regular in the schema, but that makes the schema more wordy and less clear.
 * So we use this persisted String value, and compute the type_def on the fly.
 * Persisted attribute.
 * cardinality: 0..1
 * 
*/
    public String getType() {
        return type;
    }
    public void setType(String value) {
        this.type = type;
    }

/**
 * 
 * BMM_PROPERTY created by create_bmm_property_definition.
 * cardinality: 0..1 (redefined)
 * 
*/
    public BmmUnitaryProperty getBmmProperty() {
        return bmm_property;
    }
    public void setBmmProperty(BmmUnitaryProperty value) {
        this.bmm_property = bmm_property;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Generate type_ref from type and save.
 * cardinality: 1..1
 * 
*/
    public PBmmOpenType  typeDef() {
        PBmmOpenType  result;

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

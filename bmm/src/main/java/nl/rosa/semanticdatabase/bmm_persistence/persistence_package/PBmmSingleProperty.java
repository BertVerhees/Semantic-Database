package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

import nl.rosa.semanticdatabase.bmm.class_features.BmmUnitaryProperty;

/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Persistent form of BMM_SINGLE_PROPERTY.
 * 
*/
public class PBmmSingleProperty extends PBmmProperty {

    //***** PBmmSingleProperty *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * If the type is a simple type, then this attribute will hold the type name.
 * If the type is a container or generic, then type_ref will hold the type definition.
 * The resulting type is generated in type_def.
 * cardinality: 0..1
 * 
*/
    private String type;

/**
 * 
 * Type definition of this property computed from type for later use in bmm_property.
 * cardinality: 0..1
 * 
*/
    private PBmmSimpleType typeRef;

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
 * If the type is a simple type, then this attribute will hold the type name.
 * If the type is a container or generic, then type_ref will hold the type definition.
 * The resulting type is generated in type_def.
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
 * Type definition of this property computed from type for later use in bmm_property.
 * cardinality: 0..1
 * 
*/
    public PBmmSimpleType getTypeRef() {
        return type_ref;
    }
    public void setTypeRef(PBmmSimpleType value) {
        this.type_ref = type_ref;
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
    public abstract PBmmSimpleType  typeDef();

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

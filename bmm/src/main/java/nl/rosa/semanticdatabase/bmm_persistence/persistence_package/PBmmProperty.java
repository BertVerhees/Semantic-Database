package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

import nl.rosa.semanticdatabase.bmm.class_features.BmmProperty;
import nl.rosa.semanticdatabase.bmm.model_structure.BmmModel;
import nl.rosa.semanticdatabase.bmm.classes.BmmClass;

/**
 * 
 * #Generated: 2020-11-15T17:28:03.861+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Persistent form of BMM_PROPERTY.
 * 
*/
public abstract class PBmmProperty extends PBmmModelElement {

    //***** PBmmProperty *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Name of this property within its class.
 * Persisted attribute.
 * cardinality: 1..1
 * 
*/
    private String name;

/**
 * 
 * True if this property is mandatory in its class.
 * Persisted attribute.
 * cardinality: 0..1
 * 
*/
    private Boolean isMandatory;

/**
 * 
 * True if this property is computed rather than stored in objects of this class.
 * Persisted Attribute.
 * cardinality: 0..1
 * 
*/
    private Boolean isComputed;

/**
 * 
 * True if this property is info model 'infrastructure' rather than 'data'.
 * Persisted attribute.
 * cardinality: 0..1
 * 
*/
    private Boolean isImInfrastructure;

/**
 * 
 * True if this property is info model 'runtime' settable property.
 * Persisted attribute.
 * cardinality: 0..1
 * 
*/
    private Boolean isImRuntime;

/**
 * 
 * Type definition of this property, if not a simple String type reference.
 * Persisted attribute.
 * cardinality: 0..1
 * 
*/
    private PBmmType typeDef;

/**
 * 
 * BMM_PROPERTY created by create_bmm_property_definition.
 * cardinality: 0..1
 * 
*/
    private BmmProperty bmmProperty;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Name of this property within its class.
 * Persisted attribute.
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
 * True if this property is mandatory in its class.
 * Persisted attribute.
 * cardinality: 0..1
 * 
*/
    public Boolean getIsMandatory() {
        return is_mandatory;
    }
    public void setIsMandatory(Boolean value) {
        this.is_mandatory = is_mandatory;
    }

/**
 * 
 * True if this property is computed rather than stored in objects of this class.
 * Persisted Attribute.
 * cardinality: 0..1
 * 
*/
    public Boolean getIsComputed() {
        return is_computed;
    }
    public void setIsComputed(Boolean value) {
        this.is_computed = is_computed;
    }

/**
 * 
 * True if this property is info model 'infrastructure' rather than 'data'.
 * Persisted attribute.
 * cardinality: 0..1
 * 
*/
    public Boolean getIsImInfrastructure() {
        return is_im_infrastructure;
    }
    public void setIsImInfrastructure(Boolean value) {
        this.is_im_infrastructure = is_im_infrastructure;
    }

/**
 * 
 * True if this property is info model 'runtime' settable property.
 * Persisted attribute.
 * cardinality: 0..1
 * 
*/
    public Boolean getIsImRuntime() {
        return is_im_runtime;
    }
    public void setIsImRuntime(Boolean value) {
        this.is_im_runtime = is_im_runtime;
    }

/**
 * 
 * Type definition of this property, if not a simple String type reference.
 * Persisted attribute.
 * cardinality: 0..1
 * 
*/
    public PBmmType getTypeDef() {
        return type_def;
    }
    public void setTypeDef(PBmmType value) {
        this.type_def = type_def;
    }

/**
 * 
 * BMM_PROPERTY created by create_bmm_property_definition.
 * cardinality: 0..1
 * 
*/
    public BmmProperty getBmmProperty() {
        return bmm_property;
    }
    public void setBmmProperty(BmmProperty value) {
        this.bmm_property = bmm_property;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Create bmm_property_definition from P_BMM_XX parts.
 * cardinality: 0..1
 * 
*/
    public void  createBmmProperty() {
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

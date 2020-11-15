package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

import nl.rosa.semanticdatabase.bmm.types.BmmParameterType;
import nl.rosa.semanticdatabase.bmm.model_structure.BmmModel;

/**
 * 
 * #Generated: 2020-11-15T17:28:03.861+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Persistent form of BMM_GENERIC_PARAMETER.
 * 
*/
public class PBmmGenericParameter extends PBmmModelElement {

    //***** PBmmGenericParameter *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Name of the parameter, e.g.
 * 'T' etc.
 * Persisted attribute.
 * Name is limited to 1 character, upper case.
 * cardinality: 1..1
 * 
*/
    private String name;

/**
 * 
 * Optional conformance constraint - the name of a type to which a concrete substitution of this generic parameter must conform.
 * Persisted attribute.
 * cardinality: 0..1
 * 
*/
    private String conformsToType;

/**
 * 
 * BMM_GENERIC_PARAMETER created by create_bmm_generic_parameter.
 * cardinality: 0..1
 * 
*/
    private BmmParameterType bmmGenericParameter;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Name of the parameter, e.g.
 * 'T' etc.
 * Persisted attribute.
 * Name is limited to 1 character, upper case.
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
 * Optional conformance constraint - the name of a type to which a concrete substitution of this generic parameter must conform.
 * Persisted attribute.
 * cardinality: 0..1
 * 
*/
    public String getConformsToType() {
        return conforms_to_type;
    }
    public void setConformsToType(String value) {
        this.conforms_to_type = conforms_to_type;
    }

/**
 * 
 * BMM_GENERIC_PARAMETER created by create_bmm_generic_parameter.
 * cardinality: 0..1
 * 
*/
    public BmmParameterType getBmmGenericParameter() {
        return bmm_generic_parameter;
    }
    public void setBmmGenericParameter(BmmParameterType value) {
        this.bmm_generic_parameter = bmm_generic_parameter;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Create bmm_generic_parameter.
 * cardinality: 0..1
 * 
*/
    public void  createBmmGenericParameter() {
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

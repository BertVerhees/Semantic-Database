package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

import nl.rosa.semanticdatabase.bmm.types.BmmContainerType;

/**
 * 
 * #Generated: 2020-11-15T17:28:03.861+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Persistent form of BMM_CONTAINER_TYPE.
 * 
*/
public class PBmmContainerType extends PBmmType {

    //***** PBmmContainerType *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * The type of the container.
 * This converts to the root_type in BMM_GENERIC_TYPE.
 * Persisted attribute.
 * cardinality: 1..1
 * 
*/
    private String containerType;

/**
 * 
 * Type definition of type, if not a simple String type reference.
 * Persisted attribute.
 * cardinality: 0..1
 * 
*/
    private PBmmBaseType typeDef;

/**
 * 
 * The target type; this converts to the first parameter in generic_parameters in BMM_GENERIC_TYPE.
 * Persisted attribute.
 * cardinality: 0..1
 * 
*/
    private String type;

/**
 * 
 * Result of create_bmm_type() call.
 * cardinality: 0..1 (redefined)
 * 
*/
    private BmmContainerType bmmType;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * The type of the container.
 * This converts to the root_type in BMM_GENERIC_TYPE.
 * Persisted attribute.
 * cardinality: 1..1
 * 
*/
    public String getContainerType() {
        return container_type;
    }
    public void setContainerType(String value) {
        if (container_type == null ) {
            throw new NullPointerException(" container_type has cardinality NonNull, but is null")
        }
        this.container_type = container_type;
    }

/**
 * 
 * Type definition of type, if not a simple String type reference.
 * Persisted attribute.
 * cardinality: 0..1
 * 
*/
    public PBmmBaseType getTypeDef() {
        return type_def;
    }
    public void setTypeDef(PBmmBaseType value) {
        this.type_def = type_def;
    }

/**
 * 
 * The target type; this converts to the first parameter in generic_parameters in BMM_GENERIC_TYPE.
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
 * Result of create_bmm_type() call.
 * cardinality: 0..1 (redefined)
 * 
*/
    public BmmContainerType getBmmType() {
        return bmm_type;
    }
    public void setBmmType(BmmContainerType value) {
        this.bmm_type = bmm_type;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * The target type; this converts to the first parameter in generic_parameters in BMM_GENERIC_TYPE.
 * Persisted attribute.
 * cardinality: 1..1
 * 
*/
    public PBmmBaseType  typeRef() {
        PBmmBaseType  result;

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

package nl.rosa.semanticdatabase.bmm.classes;


/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Definition of a range-constrained class whose value range is defined by reference to a 'value set' within an external resource, e.g.
 * a reference data service.
 * 
*/
public class BmmValueSetSpec {

    //***** BmmValueSetSpec *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Identifier of a resource (typically available as a service) that contains legal values of a specific type.
 * This is typically a URI but need not be.
 * cardinality: 1..1
 * 
*/
    private String resourceId;

/**
 * 
 * Identifier of a value set within the resource identified by resource_id, which specifies the set of legal values of a type.
 * This might be a URI, but need not be.
 * cardinality: 1..1
 * 
*/
    private String valueSetId;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Identifier of a resource (typically available as a service) that contains legal values of a specific type.
 * This is typically a URI but need not be.
 * cardinality: 1..1
 * 
*/
    public String getResourceId() {
        return resource_id;
    }
    public void setResourceId(String value) {
        if (resource_id == null ) {
            throw new NullPointerException(" resource_id has cardinality NonNull, but is null")
        }
        this.resource_id = resource_id;
    }

/**
 * 
 * Identifier of a value set within the resource identified by resource_id, which specifies the set of legal values of a type.
 * This might be a URI, but need not be.
 * cardinality: 1..1
 * 
*/
    public String getValueSetId() {
        return value_set_id;
    }
    public void setValueSetId(String value) {
        if (value_set_id == null ) {
            throw new NullPointerException(" value_set_id has cardinality NonNull, but is null")
        }
        this.value_set_id = value_set_id;
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

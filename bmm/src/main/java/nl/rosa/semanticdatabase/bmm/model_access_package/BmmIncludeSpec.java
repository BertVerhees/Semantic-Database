package nl.rosa.semanticdatabase.bmm.model_access_package;


/**
 * 
 * #Generated: 2020-11-15T17:28:03.861+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Schema inclusion structure.
 * 
*/
public class BmmIncludeSpec {

    //***** BmmIncludeSpec *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Full identifier of the included schema, e.g.
 * "openehr_primitive_types_1.0.2".
 * cardinality: 1..1
 * 
*/
    private String id;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Full identifier of the included schema, e.g.
 * "openehr_primitive_types_1.0.2".
 * cardinality: 1..1
 * 
*/
    public String getId() {
        return id;
    }
    public void setId(String value) {
        if (id == null ) {
            throw new NullPointerException(" id has cardinality NonNull, but is null")
        }
        this.id = id;
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

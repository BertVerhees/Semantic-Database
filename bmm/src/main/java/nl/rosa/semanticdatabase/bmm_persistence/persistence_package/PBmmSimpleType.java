package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

import nl.rosa.semanticdatabase.bmm.types.BmmSimpleType;

/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Persistent form of BMM_SIMPLE_TYPE.
 * 
*/
public class PBmmSimpleType extends PBmmBaseType {

    //***** PBmmSimpleType *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Name of type - must be a simple class name.
 * cardinality: 1..1
 * 
*/
    private String type;

/**
 * 
 * Result of create_bmm_type() call.
 * cardinality: 0..1 (redefined)
 * 
*/
    private BmmSimpleType bmmType;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Name of type - must be a simple class name.
 * cardinality: 1..1
 * 
*/
    public String getType() {
        return type;
    }
    public void setType(String value) {
        if (type == null ) {
            throw new NullPointerException(" type has cardinality NonNull, but is null")
        }
        this.type = type;
    }

/**
 * 
 * Result of create_bmm_type() call.
 * cardinality: 0..1 (redefined)
 * 
*/
    public BmmSimpleType getBmmType() {
        return bmm_type;
    }
    public void setBmmType(BmmSimpleType value) {
        this.bmm_type = bmm_type;
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

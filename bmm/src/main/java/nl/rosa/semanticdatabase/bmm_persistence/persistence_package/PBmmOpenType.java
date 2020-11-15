package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;


/**
 * 
 * #Generated: 2020-11-15T17:28:03.861+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Persistent form of BMM_PARAMETER_TYPE.
 * 
*/
public class PBmmOpenType extends PBmmBaseType {

    //***** PBmmOpenType *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Simple type parameter as a single letter like 'T', 'G' etc.
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
    private @@ bmmType;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Simple type parameter as a single letter like 'T', 'G' etc.
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
    public @@ getBmmType() {
        return bmm_type;
    }
    public void setBmmType(@@ value) {
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

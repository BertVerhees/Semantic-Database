package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

import nl.rosa.semanticdatabase.bmm.types.BmmType;
import nl.rosa.semanticdatabase.bmm.model_structure.BmmModel;
import nl.rosa.semanticdatabase.bmm.classes.BmmClass;

/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Persistent form of BMM_TYPE.
 * 
*/
public abstract class PBmmType {

    //***** PBmmType *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Result of create_bmm_type() call.
 * cardinality: 0..1
 * 
*/
    private BmmType bmmType;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Result of create_bmm_type() call.
 * cardinality: 0..1
 * 
*/
    public BmmType getBmmType() {
        return bmm_type;
    }
    public void setBmmType(BmmType value) {
        this.bmm_type = bmm_type;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Create appropriate BMM_XXX object; effected in descendants.
 * cardinality: 0..1 (abstract)
 * 
*/
    public abstract void  createBmmType();

/**
 * 
 * Formal name of the type for display.
 * cardinality: 1..1 (abstract)
 * 
*/
    public abstract String  asTypeString();

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

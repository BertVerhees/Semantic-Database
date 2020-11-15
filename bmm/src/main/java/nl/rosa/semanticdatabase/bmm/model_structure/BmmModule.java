package nl.rosa.semanticdatabase.bmm.model_structure;


/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Meta-type defining a generalised module concept.
 * Descendants define actual structure and contents.
 * 
*/
public abstract class BmmModule extends BmmDeclaration {

    //***** BmmModule *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Model within which module is defined.
 * cardinality: 1..1 (redefined)
 * 
*/
    private BmmModel scope;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Model within which module is defined.
 * cardinality: 1..1 (redefined)
 * 
*/
    public BmmModel getScope() {
        return scope;
    }
    public void setScope(BmmModel value) {
        if (scope == null ) {
            throw new NullPointerException(" scope has cardinality NonNull, but is null")
        }
        this.scope = scope;
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

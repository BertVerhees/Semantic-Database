package nl.rosa.semanticdatabase.bmm.expressions;

import nl.rosa.semanticdatabase.bmm.types.BmmSimpleType;

/**
 * 
 * #Generated: 2020-11-15T17:28:03.861+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Parent type of predicate of any object reference.
 * 
*/
public abstract class ElPredicate extends ElTerminal {

    //***** ElPredicate *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * The target instance of this predicate.
 * cardinality: 1..1
 * 
*/
    private ElInstanceRef operand;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * The target instance of this predicate.
 * cardinality: 1..1
 * 
*/
    public ElInstanceRef getOperand() {
        return operand;
    }
    public void setOperand(ElInstanceRef value) {
        if (operand == null ) {
            throw new NullPointerException(" operand has cardinality NonNull, but is null")
        }
        this.operand = operand;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Return {BMM_MODEL}.boolean_type_definition().
 * cardinality: 1..1 (effected)
 * 
*/
    public BmmSimpleType  evalType() {
        BmmSimpleType  result;

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

package nl.rosa.semanticdatabase.bmm.statements;

import nl.rosa.semanticdatabase.bmm.expressions.ElExpression;

/**
 * 
 * #Generated: 2020-11-15T17:28:03.861+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Statement type representing an assignment from a value-generating source to a writable entity, i.e.
 * a variable reference or property.
 * 
*/
public class BmmAssignment extends BmmStatement {

    //***** BmmAssignment *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * The target variable on the notional left-hand side of this assignment.
 * cardinality: 1..1
 * 
*/
    private EL_INSTANTIABLE_REF target;

/**
 * 
 * Source right hand side) of the assignment.
 * cardinality: 1..1
 * 
*/
    private ElExpression source;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * The target variable on the notional left-hand side of this assignment.
 * cardinality: 1..1
 * 
*/
    public EL_INSTANTIABLE_REF getTarget() {
        return target;
    }
    public void setTarget(EL_INSTANTIABLE_REF value) {
        if (target == null ) {
            throw new NullPointerException(" target has cardinality NonNull, but is null")
        }
        this.target = target;
    }

/**
 * 
 * Source right hand side) of the assignment.
 * cardinality: 1..1
 * 
*/
    public ElExpression getSource() {
        return source;
    }
    public void setSource(ElExpression value) {
        if (source == null ) {
            throw new NullPointerException(" source has cardinality NonNull, but is null")
        }
        this.source = source;
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

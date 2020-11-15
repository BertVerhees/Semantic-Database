package nl.rosa.semanticdatabase.bmm.expressions;


/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Abstract parent for second-order or constrained forms of first-order expression meta-types.
 * 
*/
public abstract class ElConstrained {

    //***** ElConstrained *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * The base expression of this constrained form.
 * cardinality: 1..1
 * 
*/
    private ElExpression baseExpression;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * The base expression of this constrained form.
 * cardinality: 1..1
 * 
*/
    public ElExpression getBaseExpression() {
        return base_expression;
    }
    public void setBaseExpression(ElExpression value) {
        if (base_expression == null ) {
            throw new NullPointerException(" base_expression has cardinality NonNull, but is null")
        }
        this.base_expression = base_expression;
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

package nl.rosa.semanticdatabase.bmm.statements;

import nl.rosa.semanticdatabase.bmm.expressions.ElBooleanExpression;

/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * A statement that asserts the truth of its expression.
 * If not, generates an exception (depending on run-time settings).
 * May be rendered in syntax as assert condition or similar.
 * 
*/
public class BmmAssertion extends BmmStatement {

    //***** BmmAssertion *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * cardinality: 1..1
 * 
*/
    private ElBooleanExpression expression;

/**
 * 
 * Optional tag, typically used to designate design intention of the assertion, e.g.
 * "Inv_all_members_valid".
 * cardinality: 0..1
 * 
*/
    private String tag;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * cardinality: 1..1
 * 
*/
    public ElBooleanExpression getExpression() {
        return expression;
    }
    public void setExpression(ElBooleanExpression value) {
        if (expression == null ) {
            throw new NullPointerException(" expression has cardinality NonNull, but is null")
        }
        this.expression = expression;
    }

/**
 * 
 * Optional tag, typically used to designate design intention of the assertion, e.g.
 * "Inv_all_members_valid".
 * cardinality: 0..1
 * 
*/
    public String getTag() {
        return tag;
    }
    public void setTag(String value) {
        this.tag = tag;
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

package nl.rosa.semanticdatabase.bmm.statements;

import nl.rosa.semanticdatabase.bmm.expressions.ElBooleanExpression;

/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Conditional, or 'gated' statement, consisting of a Boolean-returning condition and the target statement.
 * 
*/
public class BmmConditionalAction {

    //***** BmmConditionalAction *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * The gate condition for the target statement.
 * cardinality: 1..1
 * 
*/
    private ElBooleanExpression condition;

/**
 * 
 * Target statement.
 * cardinality: 1..1
 * 
*/
    private BmmStatementItem statement;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * The gate condition for the target statement.
 * cardinality: 1..1
 * 
*/
    public ElBooleanExpression getCondition() {
        return condition;
    }
    public void setCondition(ElBooleanExpression value) {
        if (condition == null ) {
            throw new NullPointerException(" condition has cardinality NonNull, but is null")
        }
        this.condition = condition;
    }

/**
 * 
 * Target statement.
 * cardinality: 1..1
 * 
*/
    public BmmStatementItem getStatement() {
        return statement;
    }
    public void setStatement(BmmStatementItem value) {
        if (statement == null ) {
            throw new NullPointerException(" statement has cardinality NonNull, but is null")
        }
        this.statement = statement;
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

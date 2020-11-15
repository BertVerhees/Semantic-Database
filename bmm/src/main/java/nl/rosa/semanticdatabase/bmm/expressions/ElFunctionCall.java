package nl.rosa.semanticdatabase.bmm.expressions;

import nl.rosa.semanticdatabase.bmm.types.BmmType;

/**
 * 
 * #Generated: 2020-11-15T17:28:03.861+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * A call made on a closed function agent, returning a result.
 * Equivalent to an 'application' of a function in Lambda calculus.
 * 
*/
public class ElFunctionCall extends ElScopedRef implements ElAgentCall {

    //***** ElFunctionCall *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * The function agent being called.
 * cardinality: 1..1 (redefined)
 * 
*/
    private ElFunctionAgent agent;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * The function agent being called.
 * cardinality: 1..1 (redefined)
 * 
*/
    public ElFunctionAgent getAgent() {
        return agent;
    }
    public void setAgent(ElFunctionAgent value) {
        if (agent == null ) {
            throw new NullPointerException(" agent has cardinality NonNull, but is null")
        }
        this.agent = agent;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Return agent.definition.type.
 * cardinality: 1..1 (effected)
 * 
*/
    public BmmType  evalType() {
        BmmType  result;

        return  result;
    }

    //***** ElAgentCall *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * The agent being called.
 * cardinality: 1..1
 * 
*/
    private ElAgent agent;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * The agent being called.
 * cardinality: 1..1
 * 
*/
    public ElAgent getAgent() {
        return agent;
    }
    public void setAgent(ElAgent value) {
        if (agent == null ) {
            throw new NullPointerException(" agent has cardinality NonNull, but is null")
        }
        this.agent = agent;
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

package nl.rosa.semanticdatabase.bmm.statements;

import nl.rosa.semanticdatabase.bmm.expressions.ElAgentCall;
import nl.rosa.semanticdatabase.bmm.expressions.ElProcedureAgent;

/**
 * 
 * #Generated: 2020-11-15T17:28:03.861+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * A call made on a closed procedure agent.
 * 
*/
public class BmmProcedureCall extends BmmStatement implements ElAgentCall {

    //***** BmmProcedureCall *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * The procedure agent being called.
 * cardinality: 1..1 (redefined)
 * 
*/
    private ElProcedureAgent agent;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * The procedure agent being called.
 * cardinality: 1..1 (redefined)
 * 
*/
    public ElProcedureAgent getAgent() {
        return agent;
    }
    public void setAgent(ElProcedureAgent value) {
        if (agent == null ) {
            throw new NullPointerException(" agent has cardinality NonNull, but is null")
        }
        this.agent = agent;
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

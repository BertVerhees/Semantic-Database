package nl.rosa.semanticdatabase.bmm.statements;

import nl.rosa.semanticdatabase.bmm.expressions.ElAgentCall;
import nl.rosa.semanticdatabase.bmm.expressions.ElProcedureAgent;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
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
    public BmmProcedureCall setAgent(ElProcedureAgent value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:agent failed, it has cardinality NonNull, but is null");
        }
        this.agent = agent;
        return this;
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
    public ElAgentCall setAgent(ElAgent value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:agent failed, it has cardinality NonNull, but is null");
        }
        this.agent = agent;
        return this;
    }

    //***** BmmProcedureCall *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public BmmProcedureCall build() {
        return new BmmProcedureCall(
            agent,
            agent
        );
    }

    public BmmProcedureCall(
            ElProcedureAgent agent,
            ElAgent agent
    ){
        if ( agent == null ) {
            throw new NullPointerException("Property:agent has cardinality NonNull, but is null");
        }
        if ( agent == null ) {
            throw new NullPointerException("Property:agent has cardinality NonNull, but is null");
        }
        this.agent = agent;
        this.agent = agent;
    }

}

/**
 * 
 * ***** BEGIN LICENSE BLOCK *****
 * 
 * ISC License
 * 
 * Copyright (c) 2020, Bert Verhees
 * 
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 * 
 * ***** END LICENSE BLOCK *****
 * 
*/

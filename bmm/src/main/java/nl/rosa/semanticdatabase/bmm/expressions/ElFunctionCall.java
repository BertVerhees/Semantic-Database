package nl.rosa.semanticdatabase.bmm.expressions;

import nl.rosa.semanticdatabase.bmm.types.BmmType;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
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
    public ElFunctionCall setAgent(ElFunctionAgent value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:agent failed, it has cardinality NonNull, but is null");
        }
        this.agent = agent;
        return this;
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


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
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
    public ElAgentCall setAgent(ElAgent value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:agent failed, it has cardinality NonNull, but is null");
        }
        this.agent = agent;
        return this;
    }

    //***** ElFunctionCall *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public ElFunctionCall build() {
        return new ElFunctionCall(
            agent,
            agent,
            scope
        );
    }

    public ElFunctionCall(
            ElFunctionAgent agent,
            ElAgent agent,
            ElInstanceRef scope
    ){
        if ( agent == null ) {
            throw new NullPointerException("Property:agent has cardinality NonNull, but is null");
        }
        if ( agent == null ) {
            throw new NullPointerException("Property:agent has cardinality NonNull, but is null");
        }
        this.agent = agent;
        this.agent = agent;
        this.scope = scope;
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

package nl.rosa.semanticdatabase.bmm.expressions;

import nl.rosa.semanticdatabase.bmm.class_features.BmmFunction;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * An agent whose signature is of a function, i.e.
 * has a result type.
 * 
*/
public class ElFunctionAgent extends ElAgent {

    //***** ElFunctionAgent *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Reference to definition of a routine for which this is a direct call instance, if one exists.
 * cardinality: 0..1 (redefined)
 * 
*/
    private BmmFunction definition;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Reference to definition of a routine for which this is a direct call instance, if one exists.
 * cardinality: 0..1 (redefined)
 * 
*/
    public BmmFunction getDefinition() {
        return definition;
    }
    public ElFunctionAgent setDefinition(BmmFunction value) {
        this.definition = definition;
        return this;
    }

    //***** ElFunctionAgent *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public ElFunctionAgent build() {
        return new ElFunctionAgent(
            definition,
            name,
            closedArgs,
            openArgs,
            definition,
            scope
        );
    }

    public ElFunctionAgent(
            BmmFunction definition,
            String name,
            ElTuple closedArgs,
            List<String> openArgs,
            BmmRoutine definition,
            ElInstanceRef scope
    ){
        if ( name == null ) {
            throw new NullPointerException("Property:name has cardinality NonNull, but is null");
        }
        this.definition = definition;
        this.name = name;
        this.closedArgs = closedArgs;
        this.openArgs = openArgs;
        this.definition = definition;
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

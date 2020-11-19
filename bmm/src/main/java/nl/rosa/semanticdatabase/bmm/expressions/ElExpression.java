package nl.rosa.semanticdatabase.bmm.expressions;

import nl.rosa.semanticdatabase.bmm.types.BmmType;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Abstract parent of all typed expression meta-types.
 * 
*/
public abstract class ElExpression {

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Meta-type of expression entity used in type-checking and evaluation.
 * Effected in descendants.
 * cardinality: 1..1 (abstract)
 * 
*/
    public abstract BmmType  evalType();

/**
 * 
 * True if eval_type is notionally Boolean (i.e.
 * a BMM_SIMPLE_TYPE with type_name() = Boolean).
 * cardinality: 1..1
 * 
*/
    public Result = eval_type().equal( {BMM_MODEL}.boolean_type_definition())  isBoolean() {
        Result = eval_type().equal( {BMM_MODEL}.boolean_type_definition())  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
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

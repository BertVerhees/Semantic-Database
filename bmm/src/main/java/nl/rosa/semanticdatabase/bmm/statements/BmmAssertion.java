package nl.rosa.semanticdatabase.bmm.statements;

import nl.rosa.semanticdatabase.bmm.expressions.ElBooleanExpression;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.String;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
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
    public BmmAssertion setExpression(ElBooleanExpression value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:expression failed, it has cardinality NonNull, but is null");
        }
        this.expression = expression;
        return this;
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
    public BmmAssertion setTag(String value) {
        this.tag = tag;
        return this;
    }

    //***** BmmAssertion *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public BmmAssertion build() {
        return new BmmAssertion(
            expression,
            tag
        );
    }

    public BmmAssertion(
            ElBooleanExpression expression,
            String tag
    ){
        if ( expression == null ) {
            throw new NullPointerException("Property:expression has cardinality NonNull, but is null");
        }
        this.expression = expression;
        this.tag = tag;
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

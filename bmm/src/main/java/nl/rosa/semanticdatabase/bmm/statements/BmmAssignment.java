package nl.rosa.semanticdatabase.bmm.statements;

import nl.rosa.semanticdatabase.bmm.expressions.ElExpression;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Statement type representing an assignment from a value-generating source to a writable entity, i.e.
 * a variable reference or property.
 * 
*/
public class BmmAssignment extends BmmStatement {

    //***** BmmAssignment *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * The target variable on the notional left-hand side of this assignment.
 * cardinality: 1..1
 * 
*/
    private EL_INSTANTIABLE_REF target;

/**
 * 
 * Source right hand side) of the assignment.
 * cardinality: 1..1
 * 
*/
    private ElExpression source;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * The target variable on the notional left-hand side of this assignment.
 * cardinality: 1..1
 * 
*/
    public EL_INSTANTIABLE_REF getTarget() {
        return target;
    }
    public BmmAssignment setTarget(EL_INSTANTIABLE_REF value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:target failed, it has cardinality NonNull, but is null");
        }
        this.target = target;
        return this;
    }

/**
 * 
 * Source right hand side) of the assignment.
 * cardinality: 1..1
 * 
*/
    public ElExpression getSource() {
        return source;
    }
    public BmmAssignment setSource(ElExpression value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:source failed, it has cardinality NonNull, but is null");
        }
        this.source = source;
        return this;
    }

    //***** BmmAssignment *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public BmmAssignment build() {
        return new BmmAssignment(
            target,
            source
        );
    }

    public BmmAssignment(
            EL_INSTANTIABLE_REF target,
            ElExpression source
    ){
        if ( target == null ) {
            throw new NullPointerException("Property:target has cardinality NonNull, but is null");
        }
        if ( source == null ) {
            throw new NullPointerException("Property:source has cardinality NonNull, but is null");
        }
        this.target = target;
        this.source = source;
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

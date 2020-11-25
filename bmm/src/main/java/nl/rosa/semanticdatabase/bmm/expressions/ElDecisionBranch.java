package nl.rosa.semanticdatabase.bmm.expressions;

import java.util.Objects;

/**
 * 
 * #Generated: 2020-11-25T09:35:00.89+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * 
 * 
*/
public abstract class ElDecisionBranch {

    //***** ElDecisionBranch *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Result expression of conditional, if its condition evaluates to True.
 * cardinality: 1..1
 * 
*/
    private ElExpression result;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Result expression of conditional, if its condition evaluates to True.
 * cardinality: 1..1
 * 
*/
    public ElExpression getResult() {
        return result;
    }
    public void setResult(ElExpression value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:result failed, it has cardinality NonNull, but is null");
        }
        this.result = result;
    }

    //***** ElDecisionBranch *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected ElDecisionBranch() {}

    protected ElDecisionBranch(
            ElExpression result
        ){
        if ( result == null ) {
            throw new NullPointerException("Property:result has cardinality NonNull, but is null");
        }
        this.result = result;
    }


    //***** ElDecisionBranch *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ElDecisionBranch that = (ElDecisionBranch) object;
        return
            java.util.Objects.equals(result, that.result);
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            result
        );
    }

    @java.lang.Override
    public java.lang.String toString() {
        return
            "ElDecisionBranch {" +
            "result='" + result + '\'' +
            '}';
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

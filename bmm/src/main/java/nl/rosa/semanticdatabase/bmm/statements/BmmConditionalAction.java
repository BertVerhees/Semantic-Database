package nl.rosa.semanticdatabase.bmm.statements;

import nl.rosa.semanticdatabase.bmm.expressions.ElBooleanExpression;

/**
 * 
 * #Generated: 2020-11-24T17:04:33.085+01:00
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
    public setCondition(ElBooleanExpression value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:condition failed, it has cardinality NonNull, but is null");
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
    public setStatement(BmmStatementItem value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:statement failed, it has cardinality NonNull, but is null");
        }
        this.statement = statement;
    }

    //***** BmmConditionalAction *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    public BmmConditionalAction(
            ElBooleanExpression condition,
            BmmStatementItem statement
        ){
        if ( condition == null ) {
            throw new NullPointerException("Property:condition has cardinality NonNull, but is null");
        }
        if ( statement == null ) {
            throw new NullPointerException("Property:statement has cardinality NonNull, but is null");
        }
        this.condition = condition;
        this.statement = statement;
    }

    private BmmConditionalAction(Builder builder) {
        this.setCondition( builder.condition );
        this.setStatement( builder.statement );
    }

    public static class Builder {
        private final ElBooleanExpression condition;  //required
        private final BmmStatementItem statement;  //required

        public Builder (
            ElBooleanExpression condition,
            BmmStatementItem statement
        ){
            if ( condition == null ) {
                throw new NullPointerException("Property:condition has cardinality NonNull, but is null");
            }
            if ( statement == null ) {
                throw new NullPointerException("Property:statement has cardinality NonNull, but is null");
            }
            this.condition = condition;
            this.statement = statement;
        }

        public BmmConditionalAction build(){
            return new BmmConditionalAction( this );
        }
    }


    //***** BmmConditionalAction *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmConditionalAction that = (BmmConditionalAction) object;
        return
            java.util.Objects.equals(condition, that.condition) &&
            java.util.Objects.equals(statement, that.statement);
        }
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            condition,
            statement
        );
    }

    @java.lang.Override
    public java.lang.String toString() {
        return
            "BmmConditionalAction {" +
            "condition='" + condition + '\''; +
            "statement='" + statement + '\''; +
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

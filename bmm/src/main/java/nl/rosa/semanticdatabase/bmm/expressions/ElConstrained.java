package nl.rosa.semanticdatabase.bmm.expressions;


/**
 * 
 * #Generated: 2020-11-24T17:04:33.085+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Abstract parent for second-order or constrained forms of first-order expression meta-types.
 * 
*/
public abstract class ElConstrained {

    //***** ElConstrained *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * The base expression of this constrained form.
 * cardinality: 1..1
 * 
*/
    private ElExpression baseExpression;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * The base expression of this constrained form.
 * cardinality: 1..1
 * 
*/
    public ElExpression getBaseExpression() {
        return baseExpression;
    }
    public setBaseExpression(ElExpression value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:baseExpression failed, it has cardinality NonNull, but is null");
        }
        this.baseExpression = baseExpression;
    }

    //***** ElConstrained *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected ElConstrained(
            ElExpression baseExpression
        ){
        if ( baseExpression == null ) {
            throw new NullPointerException("Property:baseExpression has cardinality NonNull, but is null");
        }
        this.baseExpression = baseExpression;
    }


    //***** ElConstrained *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ElConstrained that = (ElConstrained) object;
        return
            java.util.Objects.equals(baseExpression, that.baseExpression);
        }
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            baseExpression
        );
    }

    @java.lang.Override
    public java.lang.String toString() {
        return
            "ElConstrained {" +
            "baseExpression='" + baseExpression + '\''; +
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

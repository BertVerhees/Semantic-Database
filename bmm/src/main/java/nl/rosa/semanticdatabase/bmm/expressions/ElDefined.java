package nl.rosa.semanticdatabase.bmm.expressions;

import java.util.Objects;

/**
 * 
 * #Generated: 2020-11-25T09:35:00.89+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * A predicate taking one external variable reference argument, that returns true if the reference is resolvable, i.e.
 * the external value is obtainable.
 * Note probably to be removed.
 * 
*/
public class ElDefined extends ElPredicate {

    //***** ElDefined *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected ElDefined() {}

    public ElDefined(
            ElInstanceRef operand
        ){
        super( 
            operand
        );
    }

    private ElDefined(Builder builder) {
        this.setOperand( builder.operand );
    }

    public static class Builder {
        private final ElInstanceRef operand;  //required

        public Builder (
            ElInstanceRef operand
        ){
            if ( operand == null ) {
                throw new NullPointerException("Property:operand has cardinality NonNull, but is null");
            }
            this.operand = operand;
        }

        public ElDefined build(){
            return new ElDefined( this );
        }
    }


    //***** ElDefined *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        return true;
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode()
        );
    }

    @java.lang.Override
    public java.lang.String toString() {
        return
            "ElDefined {" +
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

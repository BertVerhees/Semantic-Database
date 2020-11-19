package nl.rosa.semanticdatabase.bmm.expressions;


/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Binary operator expression node.
 * 
*/
public class ElBinaryOperator extends ElOperator {

    //***** ElBinaryOperator *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Left operand node.
 * cardinality: 1..1
 * 
*/
    private ElSimple leftOperand;

/**
 * 
 * Right operand node.
 * cardinality: 1..1
 * 
*/
    private ElTerminal rightOperand;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Left operand node.
 * cardinality: 1..1
 * 
*/
    public ElSimple getLeftOperand() {
        return leftOperand;
    }
    public ElBinaryOperator setLeftOperand(ElSimple value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:leftOperand failed, it has cardinality NonNull, but is null");
        }
        this.leftOperand = leftOperand;
        return this;
    }

/**
 * 
 * Right operand node.
 * cardinality: 1..1
 * 
*/
    public ElTerminal getRightOperand() {
        return rightOperand;
    }
    public ElBinaryOperator setRightOperand(ElTerminal value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:rightOperand failed, it has cardinality NonNull, but is null");
        }
        this.rightOperand = rightOperand;
        return this;
    }

    //***** ElBinaryOperator *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public ElBinaryOperator build() {
        return new ElBinaryOperator(
            leftOperand,
            rightOperand,
            precedenceOverridden,
            symbol,
            definition
        );
    }

    public ElBinaryOperator(
            ElSimple leftOperand,
            ElTerminal rightOperand,
            Boolean precedenceOverridden,
            String symbol,
            BmmFunction definition
    ){
        if ( leftOperand == null ) {
            throw new NullPointerException("Property:leftOperand has cardinality NonNull, but is null");
        }
        if ( rightOperand == null ) {
            throw new NullPointerException("Property:rightOperand has cardinality NonNull, but is null");
        }
        if ( definition == null ) {
            throw new NullPointerException("Property:definition has cardinality NonNull, but is null");
        }
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.precedenceOverridden = precedenceOverridden;
        this.symbol = symbol;
        this.definition = definition;
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

package nl.rosa.semanticdatabase.bmm.expressions;


/**
 * 
 * #Generated: 2020-11-15T17:28:03.861+01:00
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
        return left_operand;
    }
    public void setLeftOperand(ElSimple value) {
        if (left_operand == null ) {
            throw new NullPointerException(" left_operand has cardinality NonNull, but is null")
        }
        this.left_operand = left_operand;
    }

/**
 * 
 * Right operand node.
 * cardinality: 1..1
 * 
*/
    public ElTerminal getRightOperand() {
        return right_operand;
    }
    public void setRightOperand(ElTerminal value) {
        if (right_operand == null ) {
            throw new NullPointerException(" right_operand has cardinality NonNull, but is null")
        }
        this.right_operand = right_operand;
    }

}

/**
 * 
 * ***** BEGIN LICENSE BLOCK ***** Version: MPL 1.1/GPL 2.0/LGPL 2.1
 * 
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with the
 * License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * 
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied.
 * See the License for
 * the specific language governing rights and limitations under the License.
 * 
 * The Initial Developer of the Original Code is Bert Verhees.
 * the Initial Developer Copyright (C) 2020 the Initial Developer.
 * All Rights Reserved.
 * 
 * Contributor(s): Bert Verhees
 * 
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied.
 * See the License for
 * the specific language governing rights and limitations under the License.
 * 
 * ***** END LICENSE BLOCK *****
 * 
*/

package nl.rosa.semanticdatabase.bmm.expressions;

import nl.rosa.semanticdatabase.bmm.class_features.BmmFunction;
import nl.rosa.semanticdatabase.bmm.class_features.BmmOperator;

/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Abstract parent of operator types.
 * 
*/
public abstract class ElOperator extends ElSimple {

    //***** ElOperator *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * True if the natural precedence of operators is overridden in the expression represented by this node of the expression tree.
 * If True, parentheses should be introduced around the totality of the syntax expression corresponding to this operator node and its operands.
 * cardinality: 0..1
 * 
*/
    private Boolean precedenceOverridden;

/**
 * 
 * The symbol actually used in the expression, or intended to be used for serialisation.
 * Must be a member of OPERATOR_DEF.symbols.
 * cardinality: 0..1
 * 
*/
    private String symbol;

/**
 * 
 * Function equivalent to this operator, inferred by matching operator against functions defined in interface of principal operand.
 * cardinality: 1..1
 * 
*/
    private BmmFunction definition;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * True if the natural precedence of operators is overridden in the expression represented by this node of the expression tree.
 * If True, parentheses should be introduced around the totality of the syntax expression corresponding to this operator node and its operands.
 * cardinality: 0..1
 * 
*/
    public Boolean getPrecedenceOverridden() {
        return precedence_overridden;
    }
    public void setPrecedenceOverridden(Boolean value) {
        this.precedence_overridden = precedence_overridden;
    }

/**
 * 
 * The symbol actually used in the expression, or intended to be used for serialisation.
 * Must be a member of OPERATOR_DEF.symbols.
 * cardinality: 0..1
 * 
*/
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String value) {
        this.symbol = symbol;
    }

/**
 * 
 * Function equivalent to this operator, inferred by matching operator against functions defined in interface of principal operand.
 * cardinality: 1..1
 * 
*/
    public BmmFunction getDefinition() {
        return definition;
    }
    public void setDefinition(BmmFunction value) {
        if (definition == null ) {
            throw new NullPointerException(" definition has cardinality NonNull, but is null")
        }
        this.definition = definition;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Operator definition derived from definition.operator_definition().
 * cardinality: 1..1
 * 
*/
    public abstract BmmOperator  operatorDefinition();

/**
 * 
 * Function call equivalent to this operator.
 * cardinality: 1..1
 * 
*/
    public abstract ElFunctionCall  equivalentCall();

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

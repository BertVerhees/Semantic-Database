package nl.rosa.semanticdatabase.bmm.expressions;


/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Compound expression consisting of a chain of condition-gated expressions, and an ungated else member that as a whole, represents an if/then/elseif/else chains.
 * Evaluated by iterating through items and for each one, evaluating its condition, which if True, causes the evaluation result of the chain to be that item’s result evaluation result.
 * If no member of items has a True-returning condition, the evaluation result is the result of evaluating the else expression.
 * 
*/
public class ElConditionChain extends ElDecisionTable {

    //***** ElConditionChain *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Members of the chain, equivalent to branches in an if/then/else chain and cases in a case statement.
 * cardinality: 1..1 (redefined)
 * 
*/
    private List<ElConditionalExpression> items = new ArrayList<> ();

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Members of the chain, equivalent to branches in an if/then/else chain and cases in a case statement.
 * cardinality: 1..1 (redefined)
 * 
*/

    public void addToItem(ElConditionalExpression value ) {
        items.add( value);
    }

    public void addToItems(List<ElConditionalExpression> values ) {
        values.forEach(value -> addItem(value));
    }

    public void removeFromItem(ElConditionalExpression item ) {
        if (items != null ) {
            items.remove(item);
        }
    }
    public void removeFromItems( Collection <ElConditionalExpression> values ) {
        values.forEach(this::removeItem);
    }
    ElConditionalExpression getItems() {
        return this.items;
    }
    void setItems(ElConditionalExpression items) {
        if (items == null ) {
            throw new NullPointerException(" items has cardinality NonNull, but is null")
        }
        this.items = items;
    }
    public List<ElConditionalExpression> items() {
        return Collections.unmodifiableList(this.items);
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

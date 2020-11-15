package nl.rosa.semanticdatabase.bmm.expressions;


/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Complex expression structure representing a logical decision table.
 * 
*/
public abstract class ElDecisionTable extends ElExpression {

    //***** ElDecisionTable *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Result expression of the chain if no member of items succeeds in evaluation.
 * cardinality: 1..1
 * 
*/
    private ElExpression else;

/**
 * 
 * Members of the chain, equivalent to branches in an if/then/else chain and cases in a case statement.
 * cardinality: 1..1
 * 
*/
    private List<ElDecisionBranch> items = new ArrayList<> ();

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Result expression of the chain if no member of items succeeds in evaluation.
 * cardinality: 1..1
 * 
*/
    public ElExpression getElse() {
        return else;
    }
    public void setElse(ElExpression value) {
        if (else == null ) {
            throw new NullPointerException(" else has cardinality NonNull, but is null")
        }
        this.else = else;
    }

/**
 * 
 * Members of the chain, equivalent to branches in an if/then/else chain and cases in a case statement.
 * cardinality: 1..1
 * 
*/

    public void addToItem(ElDecisionBranch value ) {
        items.add( value);
    }

    public void addToItems(List<ElDecisionBranch> values ) {
        values.forEach(value -> addItem(value));
    }

    public void removeFromItem(ElDecisionBranch item ) {
        if (items != null ) {
            items.remove(item);
        }
    }
    public void removeFromItems( Collection <ElDecisionBranch> values ) {
        values.forEach(this::removeItem);
    }
    ElDecisionBranch getItems() {
        return this.items;
    }
    void setItems(ElDecisionBranch items) {
        if (items == null ) {
            throw new NullPointerException(" items has cardinality NonNull, but is null")
        }
        this.items = items;
    }
    public List<ElDecisionBranch> items() {
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

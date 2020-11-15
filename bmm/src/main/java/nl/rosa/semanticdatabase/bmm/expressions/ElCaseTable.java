package nl.rosa.semanticdatabase.bmm.expressions;


/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Compound expression consisting of a list of value-range / expression pairs, and an else member that as a whole, represents a case statement flavour of decision table.
 * Evaluated by iterating through items and for each one, comparing input to the item value_range.
 * If the input is in the range, the evaluation result of the table is that item’s result evaluation result.
 * If no member of items has a True-returning condition, the evaluation result is the result of evaluating the else expression.
 * 
*/
public class ElCaseTable extends ElDecisionTable {

    //***** ElCaseTable *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Input value that is compared against each items[i].value_range to determine the overall result.
 * cardinality: 1..1
 * 
*/
    private ElSimple input;

/**
 * 
 * Members of the chain, equivalent to branches in an if/then/else chain and cases in a case statement.
 * cardinality: 1..1 (redefined)
 * 
*/
    private List<ElCase> items = new ArrayList<> ();

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Input value that is compared against each items[i].value_range to determine the overall result.
 * cardinality: 1..1
 * 
*/
    public ElSimple getInput() {
        return input;
    }
    public void setInput(ElSimple value) {
        if (input == null ) {
            throw new NullPointerException(" input has cardinality NonNull, but is null")
        }
        this.input = input;
    }

/**
 * 
 * Members of the chain, equivalent to branches in an if/then/else chain and cases in a case statement.
 * cardinality: 1..1 (redefined)
 * 
*/

    public void addToItem(ElCase value ) {
        items.add( value);
    }

    public void addToItems(List<ElCase> values ) {
        values.forEach(value -> addItem(value));
    }

    public void removeFromItem(ElCase item ) {
        if (items != null ) {
            items.remove(item);
        }
    }
    public void removeFromItems( Collection <ElCase> values ) {
        values.forEach(this::removeItem);
    }
    ElCase getItems() {
        return this.items;
    }
    void setItems(ElCase items) {
        if (items == null ) {
            throw new NullPointerException(" items has cardinality NonNull, but is null")
        }
        this.items = items;
    }
    public List<ElCase> items() {
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

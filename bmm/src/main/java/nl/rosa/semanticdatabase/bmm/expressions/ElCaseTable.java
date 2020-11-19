package nl.rosa.semanticdatabase.bmm.expressions;


/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
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
    public ElCaseTable setInput(ElSimple value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:input failed, it has cardinality NonNull, but is null");
        }
        this.input = input;
        return this;
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
    public ElCaseTable setItems(ElCase items) {
        if (items == null ) {
            throw new NullPointerException(" items has cardinality NonNull, but is null");
        }
        this.items = items;
        return this;
    }
    public List<ElCase> items() {
        return Collections.unmodifiableList(this.items);
    }

    //***** ElCaseTable *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public ElCaseTable build() {
        return new ElCaseTable(
            input,
            items,
            else,
            items
        );
    }

    public ElCaseTable(
            ElSimple input,
            List<ElCase> items,
            ElExpression else,
            List<ElDecisionBranch> items
    ){
        if ( input == null ) {
            throw new NullPointerException("Property:input has cardinality NonNull, but is null");
        }
        if ( items == null ) {
            throw new NullPointerException("Property:items has cardinality NonNull, but is null");
        }
        if ( else == null ) {
            throw new NullPointerException("Property:else has cardinality NonNull, but is null");
        }
        if ( items == null ) {
            throw new NullPointerException("Property:items has cardinality NonNull, but is null");
        }
        this.input = input;
        this.items = items;
        this.else = else;
        this.items = items;
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

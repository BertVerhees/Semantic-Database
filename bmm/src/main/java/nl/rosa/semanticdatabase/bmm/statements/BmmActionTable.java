package nl.rosa.semanticdatabase.bmm.statements;


/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Multi-branch conditional statement structure
 * 
*/
public class BmmActionTable extends BmmStatement {

    //***** BmmActionTable *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Decision branches.
 * cardinality: 1..1
 * 
*/
    private List<BmmConditionalAction> items = new ArrayList<> ();

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Decision branches.
 * cardinality: 1..1
 * 
*/

    public void addToItem(BmmConditionalAction value ) {
        items.add( value);
    }

    public void addToItems(List<BmmConditionalAction> values ) {
        values.forEach(value -> addItem(value));
    }

    public void removeFromItem(BmmConditionalAction item ) {
        if (items != null ) {
            items.remove(item);
        }
    }
    public void removeFromItems( Collection <BmmConditionalAction> values ) {
        values.forEach(this::removeItem);
    }
    BmmConditionalAction getItems() {
        return this.items;
    }
    public BmmActionTable setItems(BmmConditionalAction items) {
        if (items == null ) {
            throw new NullPointerException(" items has cardinality NonNull, but is null");
        }
        this.items = items;
        return this;
    }
    public List<BmmConditionalAction> items() {
        return Collections.unmodifiableList(this.items);
    }

    //***** BmmActionTable *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public BmmActionTable build() {
        return new BmmActionTable(
            items
        );
    }

    public BmmActionTable(
            List<BmmConditionalAction> items
    ){
        if ( items == null ) {
            throw new NullPointerException("Property:items has cardinality NonNull, but is null");
        }
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

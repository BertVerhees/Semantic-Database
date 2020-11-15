package nl.rosa.semanticdatabase.bmm.statements;


/**
 * 
 * #Generated: 2020-11-15T17:28:03.861+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * A statement 'block' corresponding to the programming language concept of the same name.
 * May be used to establish scope in specific languages.
 * 
*/
public class BmmStatementBlock extends BmmStatementItem {

    //***** BmmStatementBlock *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Child blocks of the current block.
 * cardinality: 0..1
 * 
*/
    private List<BmmStatementItem> items;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Child blocks of the current block.
 * cardinality: 0..1
 * 
*/

    public void addToItem(BmmStatementItem value ) {
        if (items == null ) {
            items = new ArrayList<> ();
        }
        items.add( value);
    }

    public void addToItems(List<BmmStatementItem> values ) {
        values.forEach(value -> addItem(value));
    }

    public void removeFromItem(BmmStatementItem item ) {
        if (items != null ) {
            items.remove(item);
        }
    }
    public void removeFromItems( Collection <BmmStatementItem> values ) {
        values.forEach(this::removeItem);
    }
    BmmStatementItem getItems() {
        return this.items;
    }
    void setItems(BmmStatementItem items) {
        this.items = items;
    }
    public List<BmmStatementItem> items() {
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

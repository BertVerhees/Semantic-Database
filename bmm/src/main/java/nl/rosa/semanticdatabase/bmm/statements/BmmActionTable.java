package nl.rosa.semanticdatabase.bmm.statements;


/**
 * 
 * #Generated: 2020-11-15T17:28:03.861+01:00
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
    void setItems(BmmConditionalAction items) {
        if (items == null ) {
            throw new NullPointerException(" items has cardinality NonNull, but is null")
        }
        this.items = items;
    }
    public List<BmmConditionalAction> items() {
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

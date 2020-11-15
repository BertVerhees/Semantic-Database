package nl.rosa.semanticdatabase.bmm.expressions;

import nl.rosa.semanticdatabase.bmm.types.BmmTupleType;
import nl.rosa.semanticdatabase.bmm.types.BmmType;

/**
 * 
 * #Generated: 2020-11-15T17:28:03.861+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Defines an array of optionally named items each of any type.
 * 
*/
public class ElTuple extends ElInstanceRef {

    //***** ElTuple *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Items in the tuple, potentially with names.
 * Typical use is to represent an argument list to routine call.
 * cardinality: 0..1
 * 
*/
    private List<ElTupleItem> items;

/**
 * 
 * Static type inferred from literal value.
 * cardinality: 1..1
 * 
*/
    private BmmTupleType type;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Items in the tuple, potentially with names.
 * Typical use is to represent an argument list to routine call.
 * cardinality: 0..1
 * 
*/

    public void addToItem(ElTupleItem value ) {
        if (items == null ) {
            items = new ArrayList<> ();
        }
        items.add( value);
    }

    public void addToItems(List<ElTupleItem> values ) {
        values.forEach(value -> addItem(value));
    }

    public void removeFromItem(ElTupleItem item ) {
        if (items != null ) {
            items.remove(item);
        }
    }
    public void removeFromItems( Collection <ElTupleItem> values ) {
        values.forEach(this::removeItem);
    }
    ElTupleItem getItems() {
        return this.items;
    }
    void setItems(ElTupleItem items) {
        this.items = items;
    }
    public List<ElTupleItem> items() {
        return Collections.unmodifiableList(this.items);
    }

/**
 * 
 * Static type inferred from literal value.
 * cardinality: 1..1
 * 
*/
    public BmmTupleType getType() {
        return type;
    }
    public void setType(BmmTupleType value) {
        if (type == null ) {
            throw new NullPointerException(" type has cardinality NonNull, but is null")
        }
        this.type = type;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Return type.
 * cardinality: 1..1 (effected)
 * 
*/
    public BmmType  evalType() {
        BmmType  result;

        return  result;
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

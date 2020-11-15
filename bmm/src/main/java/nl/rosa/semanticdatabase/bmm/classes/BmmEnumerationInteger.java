package nl.rosa.semanticdatabase.bmm.classes;

import nl.rosa.semanticdatabase.bmm.literal_values.BmmIntegerValue;

/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Integer-based enumeration meta-type.
 * 
*/
public class BmmEnumerationInteger extends BmmEnumeration {

    //***** BmmEnumerationInteger *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Optional list of specific values.
 * Must be 1:1 with item_names list.
 * cardinality: 0..1 (redefined)
 * 
*/
    private List<BmmIntegerValue> itemValues;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Optional list of specific values.
 * Must be 1:1 with item_names list.
 * cardinality: 0..1 (redefined)
 * 
*/

    public void addToItemValue(BmmIntegerValue value ) {
        if (itemValues == null ) {
            itemValues = new ArrayList<> ();
        }
        itemValues.add( value);
    }

    public void addToItemValues(List<BmmIntegerValue> values ) {
        values.forEach(value -> addItemvalue(value));
    }

    public void removeFromItemValue(BmmIntegerValue item ) {
        if (itemValues != null ) {
            itemValues.remove(item);
        }
    }
    public void removeFromItemValues( Collection <BmmIntegerValue> values ) {
        values.forEach(this::removeItemValue);
    }
    BmmIntegerValue getItemValues() {
        return this.itemValues;
    }
    void setItemValues(BmmIntegerValue itemValues) {
        this.itemValues = itemValues;
    }
    public List<BmmIntegerValue> itemValues() {
        return Collections.unmodifiableList(this.itemValues);
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

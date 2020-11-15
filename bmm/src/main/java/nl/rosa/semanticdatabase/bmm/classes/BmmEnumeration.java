package nl.rosa.semanticdatabase.bmm.classes;

import nl.rosa.semanticdatabase.bmm.literal_values.BmmPrimitiveValue;

/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Definition of an enumeration class, understood as a class whose value range is constrained extensionally, i.e.
 * by an explicit enumeration of named singleton instances.
 * Only one inheritance ancestor is allowed in order to provide the base type to which the range constraint is applied.
 * The common notion of a set of literals with no explicit defined values is represented as the degenerate subtype BMM_ENUMERATION_INTEGER, whose values are 0, 1, …​
 * 
*/
public class BmmEnumeration extends BmmSimpleClass {

    //***** BmmEnumeration *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * The list of names of the enumeration.
 * If no values are supplied, the integer values 0, 1, 2, …​ are assumed.
 * cardinality: 0..1
 * 
*/
    private List<String> itemNames;

/**
 * 
 * Optional list of specific values.
 * Must be 1:1 with item_names list.
 * cardinality: 0..1
 * 
*/
    private List<BmmPrimitiveValue> itemValues;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * The list of names of the enumeration.
 * If no values are supplied, the integer values 0, 1, 2, …​ are assumed.
 * cardinality: 0..1
 * 
*/

    public void addToItemName(String value ) {
        if (itemNames == null ) {
            itemNames = new ArrayList<> ();
        }
        itemNames.add( value);
    }

    public void addToItemNames(List<String> values ) {
        values.forEach(value -> addItemname(value));
    }

    public void removeFromItemName(String item ) {
        if (itemNames != null ) {
            itemNames.remove(item);
        }
    }
    public void removeFromItemNames( Collection <String> values ) {
        values.forEach(this::removeItemName);
    }
    String getItemNames() {
        return this.itemNames;
    }
    void setItemNames(String itemNames) {
        this.itemNames = itemNames;
    }
    public List<String> itemNames() {
        return Collections.unmodifiableList(this.itemNames);
    }

/**
 * 
 * Optional list of specific values.
 * Must be 1:1 with item_names list.
 * cardinality: 0..1
 * 
*/

    public void addToItemValue(BmmPrimitiveValue value ) {
        if (itemValues == null ) {
            itemValues = new ArrayList<> ();
        }
        itemValues.add( value);
    }

    public void addToItemValues(List<BmmPrimitiveValue> values ) {
        values.forEach(value -> addItemvalue(value));
    }

    public void removeFromItemValue(BmmPrimitiveValue item ) {
        if (itemValues != null ) {
            itemValues.remove(item);
        }
    }
    public void removeFromItemValues( Collection <BmmPrimitiveValue> values ) {
        values.forEach(this::removeItemValue);
    }
    BmmPrimitiveValue getItemValues() {
        return this.itemValues;
    }
    void setItemValues(BmmPrimitiveValue itemValues) {
        this.itemValues = itemValues;
    }
    public List<BmmPrimitiveValue> itemValues() {
        return Collections.unmodifiableList(this.itemValues);
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Map of item_names to item_values (stringified).
 * cardinality: 1..1
 * 
*/
    public abstract Map<String, String>  nameMap();

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

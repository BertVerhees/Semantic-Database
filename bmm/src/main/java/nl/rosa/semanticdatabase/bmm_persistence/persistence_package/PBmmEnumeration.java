package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

import nl.rosa.semanticdatabase.bmm.classes.BmmEnumeration;

/**
 * 
 * #Generated: 2020-11-15T17:28:03.861+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Persistent form of BMM_ENUMERATION attributes.
 * 
*/
public class PBmmEnumeration extends PBmmClass {

    //***** PBmmEnumeration *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * cardinality: 0..1
 * 
*/
    private List<String> itemNames;

/**
 * 
 * cardinality: 0..1
 * 
*/
    private List<Object> itemValues;

/**
 * 
 * BMM_CLASS object build by create_bmm_class_definition and populate_bmm_class_definition.
 * cardinality: 0..1 (redefined)
 * 
*/
    private BmmEnumeration bmmClass;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
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
 * cardinality: 0..1
 * 
*/

    public void addToItemValue(Object value ) {
        if (itemValues == null ) {
            itemValues = new ArrayList<> ();
        }
        itemValues.add( value);
    }

    public void addToItemValues(List<Object> values ) {
        values.forEach(value -> addItemvalue(value));
    }

    public void removeFromItemValue(Object item ) {
        if (itemValues != null ) {
            itemValues.remove(item);
        }
    }
    public void removeFromItemValues( Collection <Object> values ) {
        values.forEach(this::removeItemValue);
    }
    Object getItemValues() {
        return this.itemValues;
    }
    void setItemValues(Object itemValues) {
        this.itemValues = itemValues;
    }
    public List<Object> itemValues() {
        return Collections.unmodifiableList(this.itemValues);
    }

/**
 * 
 * BMM_CLASS object build by create_bmm_class_definition and populate_bmm_class_definition.
 * cardinality: 0..1 (redefined)
 * 
*/
    public BmmEnumeration getBmmClass() {
        return bmm_class;
    }
    public void setBmmClass(BmmEnumeration value) {
        this.bmm_class = bmm_class;
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

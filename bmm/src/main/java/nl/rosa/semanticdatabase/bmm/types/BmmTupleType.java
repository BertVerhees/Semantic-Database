package nl.rosa.semanticdatabase.bmm.types;


/**
 * 
 * #Generated: 2020-11-15T17:28:03.861+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Special type representing the type of a tuple, i.e.
 * an array of any number of other types.
 * This includes both container and unitary types, since tuple instances represent concrete objects.
 * Note that both open and closed generic parameters are allowed, as with any generic type, but open generic parameters are only valid within the scope of a generic class.
 * 
*/
public class BmmTupleType extends BmmEffectiveType {

    //***** BmmTupleType *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * List of types of the items of the tuple, keyed by purpose in the tuple.
 * cardinality: 1..1
 * 
*/
    private Map<String,BmmType> itemTypes = new HashMap<> ();

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * List of types of the items of the tuple, keyed by purpose in the tuple.
 * cardinality: 1..1
 * 
*/

    public void putItemtype(String key, BmmType value ) {
        itemTypes.put( key, value);
    }

    public void putItemtypes(Map<String,BmmType> items ) {
        items.keySet().forEach(key -> putItemtype(key, items.get(key)));
    }

    public BmmType getItemtype(String key ) {
        return itemTypes.get( key);
    }

    public void removeItemtype(String key ) {
        if (itemTypes != null ) {
            itemTypes.remove(key);
        }
    }
    public void removeItemtypes( Collection <String> keys ) {
        keys.forEach(this::removeItemtype);
    }
    Map<String,BmmType> getItemtypes() {
        return this.itemTypes;
    }
    void setItemtypes(Map<String,BmmType> itemTypes) {
        if (itemTypes == null ) {
            throw new NullPointerException(" itemTypes has cardinality NonNull, but is null")
        }
        this.itemTypes = itemTypes;
    }
    public Map<String,BmmType> itemTypes() {
        return Collections.unmodifiableMap(this.itemTypes);
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Return base_name.
 * cardinality: 1..1 (effected)
 * 
*/
    public Result.is_equal (base_name())  typeBaseName() {
        Result.is_equal (base_name())  result;

        return  result;
    }

/**
 * 
 * Result = True.
 * cardinality: 1..1 (effected)
 * 
*/
    public Boolean  isPrimitive() {
        Boolean  result;

        return  result;
    }

/**
 * 
 * Result = False.
 * cardinality: 1..1 (effected)
 * 
*/
    public Boolean  isAbstract() {
        Boolean  result;

        return  result;
    }

/**
 * 
 * Return base_name.
 * cardinality: 1..1 (effected)
 * 
*/
    public Result.is_equal (base_name())  typeName() {
        Result.is_equal (base_name())  result;

        return  result;
    }

/**
 * 
 * Return the logical set (i.e.
 * unique types) from the merge of flattened_type_list() called on each member of item_types.
 * cardinality: 1..1 (effected)
 * 
*/
    public List<String>  flattenedTypeList() {
        List<String>  result;

        return  result;
    }

/*=========================================================*/
/* * CONSTANTS * */
/*=========================================================*/

/**
 * 
 * Base name (built-in).
 * 
*/
    final String baseName = "Tuple";

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

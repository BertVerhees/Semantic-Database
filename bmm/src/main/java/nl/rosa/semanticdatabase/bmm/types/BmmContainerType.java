package nl.rosa.semanticdatabase.bmm.types;

import nl.rosa.semanticdatabase.bmm.classes.BmmGenericClass;

/**
 * 
 * #Generated: 2020-11-15T17:28:03.861+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Meta-type that specifies linear containers with a generic parameter corresponding to the type of contained item, and whose container type is a generic type such as List<T>, Set<T> etc.
 * 
*/
public class BmmContainerType extends BmmType {

    //***** BmmContainerType *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * The type of the container.
 * This converts to the root_type in BMM_GENERIC_TYPE.
 * cardinality: 1..1
 * 
*/
    private BmmGenericClass containerClass;

/**
 * 
 * The container item type.
 * cardinality: 1..1
 * 
*/
    private BmmUnitaryType itemType;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * The type of the container.
 * This converts to the root_type in BMM_GENERIC_TYPE.
 * cardinality: 1..1
 * 
*/
    public BmmGenericClass getContainerClass() {
        return container_class;
    }
    public void setContainerClass(BmmGenericClass value) {
        if (container_class == null ) {
            throw new NullPointerException(" container_class has cardinality NonNull, but is null")
        }
        this.container_class = container_class;
    }

/**
 * 
 * The container item type.
 * cardinality: 1..1
 * 
*/
    public BmmUnitaryType getItemType() {
        return item_type;
    }
    public void setItemType(BmmUnitaryType value) {
        if (item_type == null ) {
            throw new NullPointerException(" item_type has cardinality NonNull, but is null")
        }
        this.item_type = item_type;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Return full type name, e.g.
 * List<ELEMENT>.
 * cardinality: 1..1 (effected)
 * 
*/
    public String  typeName() {
        String  result;

        return  result;
    }

/**
 * 
 * True if the container class is abstract.
 * cardinality: 1..1 (effected)
 * 
*/
    public Result = container_type.is_abstract  isAbstract() {
        Result = container_type.is_abstract  result;

        return  result;
    }

/**
 * 
 * Flattened list of type names of item_type, i.e.
 * item_type.flattened_type_list().
 * cardinality: 1..1 (effected)
 * 
*/
    public Result = item_type.flattened_type_list  flattenedTypeList() {
        Result = item_type.flattened_type_list  result;

        return  result;
    }

/**
 * 
 * Return item_type.
 * cardinality: 1..1 (effected)
 * 
*/
    public BmmUnitaryType  unitaryType() {
        BmmUnitaryType  result;

        return  result;
    }

/**
 * 
 * True if item_type is primitive.
 * cardinality: 1..1 (effected)
 * 
*/
    public Result = item_type.is_primitive  isPrimitive() {
        Result = item_type.is_primitive  result;

        return  result;
    }

/**
 * 
 * Return item_type.effective_type().
 * cardinality: 1..1 (effected)
 * 
*/
    public BmmEffectiveType  effectiveType() {
        BmmEffectiveType  result;

        return  result;
    }

/*=========================================================*/
/* * CONSTANTS * */
/*=========================================================*/

/**
 * 
 * True indicates that order of the items in the container attribute is considered significant and must be preserved, e.g.
 * across sessions, serialisation, deserialisation etc.
 * Otherwise known as 'list' semantics.
 * 
*/
    final Boolean {default isOrdered = true};

/**
 * 
 * True indicates that only unique instances of items in the container are allowed.
 * Otherwise known as 'set' semantics.
 * 
*/
    final Boolean {default isUnique = false};

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

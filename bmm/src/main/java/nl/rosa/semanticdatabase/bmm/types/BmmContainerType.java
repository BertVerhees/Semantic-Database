package nl.rosa.semanticdatabase.bmm.types;

import java.util.Objects;
import nl.rosa.semanticdatabase.bmm.classes.BmmGenericClass;

/**
 * 
 * #Generated: 2020-11-25T09:35:00.89+01:00
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
        return containerClass;
    }
    public void setContainerClass(BmmGenericClass value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:containerClass failed, it has cardinality NonNull, but is null");
        }
        this.containerClass = containerClass;
    }

/**
 * 
 * The container item type.
 * cardinality: 1..1
 * 
*/
    public BmmUnitaryType getItemType() {
        return itemType;
    }
    public void setItemType(BmmUnitaryType value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:itemType failed, it has cardinality NonNull, but is null");
        }
        this.itemType = itemType;
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


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
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


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
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


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
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


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
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


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
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


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
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

    //***** BmmContainerType *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected BmmContainerType() {}

    public BmmContainerType(
            BmmGenericClass containerClass,
            BmmUnitaryType itemType
        ){
        if ( containerClass == null ) {
            throw new NullPointerException("Property:containerClass has cardinality NonNull, but is null");
        }
        if ( itemType == null ) {
            throw new NullPointerException("Property:itemType has cardinality NonNull, but is null");
        }
        this.containerClass = containerClass;
        this.itemType = itemType;
    }

    private BmmContainerType(Builder builder) {
        this.setContainerClass( builder.containerClass );
        this.setItemType( builder.itemType );
    }

    public static class Builder {
        private final BmmGenericClass containerClass;  //required
        private final BmmUnitaryType itemType;  //required

        public Builder (
            BmmGenericClass containerClass,
            BmmUnitaryType itemType
        ){
            if ( containerClass == null ) {
                throw new NullPointerException("Property:containerClass has cardinality NonNull, but is null");
            }
            if ( itemType == null ) {
                throw new NullPointerException("Property:itemType has cardinality NonNull, but is null");
            }
            this.containerClass = containerClass;
            this.itemType = itemType;
        }

        public BmmContainerType build(){
            return new BmmContainerType( this );
        }
    }


    //***** BmmContainerType *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmContainerType that = (BmmContainerType) object;
        return
            java.util.Objects.equals(containerClass, that.containerClass) &&
            java.util.Objects.equals(itemType, that.itemType);
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            containerClass,
            itemType
        );
    }

    @java.lang.Override
    public java.lang.String toString() {
        return
            "BmmContainerType {" +
            "containerClass='" + containerClass + '\'' +
            "itemType='" + itemType + '\'' +
            '}';
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

package nl.rosa.semanticdatabase.bmm.types;

import nl.rosa.semanticdatabase.bmm.classes.BmmGenericClass;

/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Meta-type based on a non-container generic class, e.g.
 * Packet<Header>.
 * 
*/
public class BmmGenericType extends BmmModelType {

    //***** BmmGenericType *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Generic parameters of the root_type in this type specifier.
 * The order must match the order of the owning class’s formal generic parameter declarations, and the types may be defined types or formal parameter types.
 * cardinality: 1..1
 * 
*/
    private List<BmmUnitaryType> genericParameters = new ArrayList<> ();

/**
 * 
 * Defining generic class of this type.
 * cardinality: 1..1 (redefined)
 * 
*/
    private BmmGenericClass baseClass;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Generic parameters of the root_type in this type specifier.
 * The order must match the order of the owning class’s formal generic parameter declarations, and the types may be defined types or formal parameter types.
 * cardinality: 1..1
 * 
*/

    public void addToGenericParameter(BmmUnitaryType value ) {
        genericParameters.add( value);
    }

    public void addToGenericParameters(List<BmmUnitaryType> values ) {
        values.forEach(value -> addGenericparameter(value));
    }

    public void removeFromGenericParameter(BmmUnitaryType item ) {
        if (genericParameters != null ) {
            genericParameters.remove(item);
        }
    }
    public void removeFromGenericParameters( Collection <BmmUnitaryType> values ) {
        values.forEach(this::removeGenericParameter);
    }
    BmmUnitaryType getGenericParameters() {
        return this.genericParameters;
    }
    void setGenericParameters(BmmUnitaryType genericParameters) {
        if (genericParameters == null ) {
            throw new NullPointerException(" genericParameters has cardinality NonNull, but is null")
        }
        this.genericParameters = genericParameters;
    }
    public List<BmmUnitaryType> genericParameters() {
        return Collections.unmodifiableList(this.genericParameters);
    }

/**
 * 
 * Defining generic class of this type.
 * cardinality: 1..1 (redefined)
 * 
*/
    public BmmGenericClass getBaseClass() {
        return base_class;
    }
    public void setBaseClass(BmmGenericClass value) {
        if (base_class == null ) {
            throw new NullPointerException(" base_class has cardinality NonNull, but is null")
        }
        this.base_class = base_class;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Return the full name of the type including generic parameters, e.g.
 * DV_INTERVAL<T>, TABLE<List<THING>,String>.
 * cardinality: 1..1 (effected)
 * 
*/
    public abstract String  typeName();

/**
 * 
 * Signature form of the type, which for generics includes generic parameter constrainer types E.g.
 * Interval<T:Ordered>.
 * cardinality: 1..1 (redefined)
 * 
*/
    public abstract String  typeSignature();

/**
 * 
 * True if base_class.is_abstract or if any (non-open) parameter type is abstract.
 * cardinality: 1..1 (effected)
 * 
*/
    public abstract Boolean  isAbstract();

/**
 * 
 * Result is base_class.name followed by names of all generic parameter type names, which may be open or closed.
 * cardinality: 1..1 (effected)
 * 
*/
    public abstract List<String>  flattenedTypeList();

/**
 * 
 * Returns True if there is any substituted generic parameter.
 * cardinality: 1..1
 * 
*/
    public abstract Boolean  isPartiallyClosed();

/**
 * 
 * Effective underlying class for this type, abstracting away any container type.
 * cardinality: 1..1
 * 
*/
    public abstract BmmGenericClass  effectiveBaseClass();

/**
 * 
 * True if all generic parameters from ancestor generic types have been substituted in this type.
 * cardinality: 1..1
 * 
*/
    public abstract Boolean  isOpen();

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

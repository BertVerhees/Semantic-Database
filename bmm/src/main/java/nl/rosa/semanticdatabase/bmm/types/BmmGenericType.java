package nl.rosa.semanticdatabase.bmm.types;

import nl.rosa.semanticdatabase.bmm.classes.BmmGenericClass;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.String;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Boolean;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
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
    public BmmGenericType setGenericParameters(BmmUnitaryType genericParameters) {
        if (genericParameters == null ) {
            throw new NullPointerException(" genericParameters has cardinality NonNull, but is null");
        }
        this.genericParameters = genericParameters;
        return this;
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
        return baseClass;
    }
    public BmmGenericType setBaseClass(BmmGenericClass value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:baseClass failed, it has cardinality NonNull, but is null");
        }
        this.baseClass = baseClass;
        return this;
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
    public String  typeName() {
        String  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Signature form of the type, which for generics includes generic parameter constrainer types E.g.
 * Interval<T:Ordered>.
 * cardinality: 1..1 (redefined)
 * 
*/
    public String  typeSignature() {
        String  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if base_class.is_abstract or if any (non-open) parameter type is abstract.
 * cardinality: 1..1 (effected)
 * 
*/
    public Boolean  isAbstract() {
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Result is base_class.name followed by names of all generic parameter type names, which may be open or closed.
 * cardinality: 1..1 (effected)
 * 
*/
    public List<String>  flattenedTypeList() {
        List<String>  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Returns True if there is any substituted generic parameter.
 * cardinality: 1..1
 * 
*/
    public Boolean  isPartiallyClosed() {
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Effective underlying class for this type, abstracting away any container type.
 * cardinality: 1..1
 * 
*/
    public BmmGenericClass  effectiveBaseClass() {
        BmmGenericClass  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if all generic parameters from ancestor generic types have been substituted in this type.
 * cardinality: 1..1
 * 
*/
    public Boolean  isOpen() {
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** BmmGenericType *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public BmmGenericType build() {
        return new BmmGenericType(
            genericParameters,
            baseClass,
            valueConstraint,
            baseClass
        );
    }

    public BmmGenericType(
            List<BmmUnitaryType> genericParameters,
            BmmGenericClass baseClass,
            BmmValueSetSpec valueConstraint,
            BmmClass baseClass
    ){
        if ( genericParameters == null ) {
            throw new NullPointerException("Property:genericParameters has cardinality NonNull, but is null");
        }
        if ( baseClass == null ) {
            throw new NullPointerException("Property:baseClass has cardinality NonNull, but is null");
        }
        if ( baseClass == null ) {
            throw new NullPointerException("Property:baseClass has cardinality NonNull, but is null");
        }
        this.genericParameters = genericParameters;
        this.baseClass = baseClass;
        this.valueConstraint = valueConstraint;
        this.baseClass = baseClass;
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

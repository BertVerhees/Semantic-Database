package nl.rosa.semanticdatabase.bmm.types;

import java.util.List;

/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Abstract idea of specifying a type in some context.
 * This is not the same as 'defining' a class.
 * A type specification is essentially a reference of some kind, that defines the type of an attribute, or function result or argument.
 * It may include generic parameters that might or might not be bound.
 * See subtypes.
 * 
*/
public abstract class BmmType {

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Formal string form of the type as per UML.
 * cardinality: 1..1 (abstract)
 * 
*/
    public abstract String  typeName();

/**
 * 
 * Signature form of the type name, which for generics includes generic parameter constrainer types E.g.
 * Interval<T:Ordered>.
 * Defaults to the value of type_name().
 * cardinality: 1..1
 * 
*/
    public abstract String  typeSignature();

/**
 * 
 * If true, indicates an abstract class in a BMM model, or a type based on an abstract class, i.e.
 * a type that cannot be directly instantiated.
 * cardinality: 1..1 (abstract)
 * 
*/
    public abstract Boolean  isAbstract();

/**
 * 
 * If True, indicates that the entity in a BMM model is considered to relate to a primitive type set, i.e.
 * be a primitive type, or be a definer of one.
 * cardinality: 1..1 (abstract)
 * 
*/
    public abstract Boolean  isPrimitive();

/**
 * 
 * Type with any container abstracted away; may be a formal generic type.
 * cardinality: 1..1 (abstract)
 * 
*/
    public abstract BmmUnitaryType  unitaryType();

/**
 * 
 * Type with any container abstracted away, and any formal parameter replaced by its effective constraint type.
 * cardinality: 1..1 (abstract)
 * 
*/
    public abstract BmmEffectiveType  effectiveType();

/**
 * 
 * Completely flattened list of type names, flattening out all generic parameters.
 * cardinality: 1..1 (abstract)
 * 
*/
    public abstract List<String> flattenedTypeList();

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

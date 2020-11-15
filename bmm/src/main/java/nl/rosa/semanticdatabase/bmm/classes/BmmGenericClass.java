package nl.rosa.semanticdatabase.bmm.classes;

import nl.rosa.semanticdatabase.bmm.types.BmmParameterType;
import nl.rosa.semanticdatabase.bmm.types.BmmGenericType;

/**
 * 
 * #Generated: 2020-11-15T17:28:03.861+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Definition of a generic class in an object model.
 * 
*/
public class BmmGenericClass extends BmmClass {

    //***** BmmGenericClass *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * List of formal generic parameters, keyed by name.
 * These are defined either directly on this class or by the inclusion of an ancestor class which is generic.
 * cardinality: 1..1
 * 
*/
    private Map<String,BmmParameterType> genericParameters = new HashMap<> ();

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * List of formal generic parameters, keyed by name.
 * These are defined either directly on this class or by the inclusion of an ancestor class which is generic.
 * cardinality: 1..1
 * 
*/

    public void putGenericparameter(String key, BmmParameterType value ) {
        genericParameters.put( key, value);
    }

    public void putGenericparameters(Map<String,BmmParameterType> items ) {
        items.keySet().forEach(key -> putGenericparameter(key, items.get(key)));
    }

    public BmmParameterType getGenericparameter(String key ) {
        return genericParameters.get( key);
    }

    public void removeGenericparameter(String key ) {
        if (genericParameters != null ) {
            genericParameters.remove(key);
        }
    }
    public void removeGenericparameters( Collection <String> keys ) {
        keys.forEach(this::removeGenericparameter);
    }
    Map<String,BmmParameterType> getGenericparameters() {
        return this.genericParameters;
    }
    void setGenericparameters(Map<String,BmmParameterType> genericParameters) {
        if (genericParameters == null ) {
            throw new NullPointerException(" genericParameters has cardinality NonNull, but is null")
        }
        this.genericParameters = genericParameters;
    }
    public Map<String,BmmParameterType> genericParameters() {
        return Collections.unmodifiableMap(this.genericParameters);
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Add suppliers from generic parameters.
 * cardinality: 0..1 (redefined)
 * 
*/
    public List<String>  suppliers() {
        List<String>  result;

        return  result;
    }

/**
 * 
 * Generate a fully open BMM_GENERIC_TYPE instance that corresponds to this class definition
 * cardinality: 1..1 (effected)
 * 
*/
    public BmmGenericType  type() {
        BmmGenericType  result;

        return  result;
    }

/**
 * 
 * For a generic class, type to which generic parameter a_name conforms e.g.
 * if this class is Interval <T:Comparable> then the Result will be the single type Comparable.
 * For an unconstrained type T, the Result will be Any.
 * cardinality: 1..1
 * 
*/
    public String  genericParameterConformanceType() {
        String  result;

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

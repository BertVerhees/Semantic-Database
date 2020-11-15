package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

import nl.rosa.semanticdatabase.bmm.types.BmmGenericType;

/**
 * 
 * #Generated: 2020-11-15T17:28:03.861+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Persistent form of BMM_GENERIC_TYPE.
 * 
*/
public class PBmmGenericType extends PBmmBaseType {

    //***** PBmmGenericType *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Root type of this generic type, e.g.
 * Interval in Interval<Integer>.
 * cardinality: 1..1
 * 
*/
    private String rootType;

/**
 * 
 * Generic parameters of the root_type in this type specifier if non-simple types.
 * The order must match the order of the owning class’s formal generic parameter declarations.
 * Persistent attribute.
 * cardinality: 1..1
 * 
*/
    private List<PBmmType> genericParameterDefs = new ArrayList<> ();

/**
 * 
 * Generic parameters of the root_type in this type specifier, if simple types.
 * The order must match the order of the owning class’s formal generic parameter declarations.
 * Persistent attribute.
 * cardinality: 0..1
 * 
*/
    private List<String> genericParameters;

/**
 * 
 * Result of create_bmm_type() call.
 * cardinality: 0..1 (redefined)
 * 
*/
    private BmmGenericType bmmType;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Root type of this generic type, e.g.
 * Interval in Interval<Integer>.
 * cardinality: 1..1
 * 
*/
    public String getRootType() {
        return root_type;
    }
    public void setRootType(String value) {
        if (root_type == null ) {
            throw new NullPointerException(" root_type has cardinality NonNull, but is null")
        }
        this.root_type = root_type;
    }

/**
 * 
 * Generic parameters of the root_type in this type specifier if non-simple types.
 * The order must match the order of the owning class’s formal generic parameter declarations.
 * Persistent attribute.
 * cardinality: 1..1
 * 
*/

    public void addToGenericParameterDef(PBmmType value ) {
        genericParameterDefs.add( value);
    }

    public void addToGenericParameterDefs(List<PBmmType> values ) {
        values.forEach(value -> addGenericparameterdef(value));
    }

    public void removeFromGenericParameterDef(PBmmType item ) {
        if (genericParameterDefs != null ) {
            genericParameterDefs.remove(item);
        }
    }
    public void removeFromGenericParameterDefs( Collection <PBmmType> values ) {
        values.forEach(this::removeGenericParameterDef);
    }
    PBmmType getGenericParameterDefs() {
        return this.genericParameterDefs;
    }
    void setGenericParameterDefs(PBmmType genericParameterDefs) {
        if (genericParameterDefs == null ) {
            throw new NullPointerException(" genericParameterDefs has cardinality NonNull, but is null")
        }
        this.genericParameterDefs = genericParameterDefs;
    }
    public List<PBmmType> genericParameterDefs() {
        return Collections.unmodifiableList(this.genericParameterDefs);
    }

/**
 * 
 * Generic parameters of the root_type in this type specifier, if simple types.
 * The order must match the order of the owning class’s formal generic parameter declarations.
 * Persistent attribute.
 * cardinality: 0..1
 * 
*/

    public void addToGenericParameter(String value ) {
        if (genericParameters == null ) {
            genericParameters = new ArrayList<> ();
        }
        genericParameters.add( value);
    }

    public void addToGenericParameters(List<String> values ) {
        values.forEach(value -> addGenericparameter(value));
    }

    public void removeFromGenericParameter(String item ) {
        if (genericParameters != null ) {
            genericParameters.remove(item);
        }
    }
    public void removeFromGenericParameters( Collection <String> values ) {
        values.forEach(this::removeGenericParameter);
    }
    String getGenericParameters() {
        return this.genericParameters;
    }
    void setGenericParameters(String genericParameters) {
        this.genericParameters = genericParameters;
    }
    public List<String> genericParameters() {
        return Collections.unmodifiableList(this.genericParameters);
    }

/**
 * 
 * Result of create_bmm_type() call.
 * cardinality: 0..1 (redefined)
 * 
*/
    public BmmGenericType getBmmType() {
        return bmm_type;
    }
    public void setBmmType(BmmGenericType value) {
        this.bmm_type = bmm_type;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Generic parameters of the root_type in this type specifier.
 * The order must match the order of the owning class’s formal generic parameter declarations
 * cardinality: 0..1
 * 
*/
    public List<PBmmType>  genericParameterRefs() {
        List<PBmmType>  result;

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

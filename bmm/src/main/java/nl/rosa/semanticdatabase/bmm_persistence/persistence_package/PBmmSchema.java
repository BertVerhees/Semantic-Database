package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

import nl.rosa.semanticdatabase.bmm.model_access_package.BmmSchema;

/**
 * 
 * #Generated: 2020-11-15T17:28:03.861+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Persisted form of BMM_SCHEMA.
 * 
*/
public class PBmmSchema extends BmmSchema implements PBmmPackageContainer {

    //***** PBmmSchema *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Primitive type definitions.
 * Persisted attribute.
 * cardinality: 0..1
 * 
*/
    private List<PBmmClass> primitiveTypes;

/**
 * 
 * Class definitions.
 * Persisted attribute.
 * cardinality: 0..1
 * 
*/
    private List<PBmmClass> classDefinitions;

/**
 * 
 * Implementation of validate()
 * cardinality: 0..1 (effected)
 * 
*/
    private  ;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Primitive type definitions.
 * Persisted attribute.
 * cardinality: 0..1
 * 
*/

    public void addToPrimitiveType(PBmmClass value ) {
        if (primitiveTypes == null ) {
            primitiveTypes = new ArrayList<> ();
        }
        primitiveTypes.add( value);
    }

    public void addToPrimitiveTypes(List<PBmmClass> values ) {
        values.forEach(value -> addPrimitivetype(value));
    }

    public void removeFromPrimitiveType(PBmmClass item ) {
        if (primitiveTypes != null ) {
            primitiveTypes.remove(item);
        }
    }
    public void removeFromPrimitiveTypes( Collection <PBmmClass> values ) {
        values.forEach(this::removePrimitiveType);
    }
    PBmmClass getPrimitiveTypes() {
        return this.primitiveTypes;
    }
    void setPrimitiveTypes(PBmmClass primitiveTypes) {
        this.primitiveTypes = primitiveTypes;
    }
    public List<PBmmClass> primitiveTypes() {
        return Collections.unmodifiableList(this.primitiveTypes);
    }

/**
 * 
 * Class definitions.
 * Persisted attribute.
 * cardinality: 0..1
 * 
*/

    public void addToClassDefinition(PBmmClass value ) {
        if (classDefinitions == null ) {
            classDefinitions = new ArrayList<> ();
        }
        classDefinitions.add( value);
    }

    public void addToClassDefinitions(List<PBmmClass> values ) {
        values.forEach(value -> addClassdefinition(value));
    }

    public void removeFromClassDefinition(PBmmClass item ) {
        if (classDefinitions != null ) {
            classDefinitions.remove(item);
        }
    }
    public void removeFromClassDefinitions( Collection <PBmmClass> values ) {
        values.forEach(this::removeClassDefinition);
    }
    PBmmClass getClassDefinitions() {
        return this.classDefinitions;
    }
    void setClassDefinitions(PBmmClass classDefinitions) {
        this.classDefinitions = classDefinitions;
    }
    public List<PBmmClass> classDefinitions() {
        return Collections.unmodifiableList(this.classDefinitions);
    }

/**
 * 
 * Implementation of validate()
 * cardinality: 0..1 (effected)
 * 
*/
    public  get() {
        return ;
    }
    public void set( value) {
        this. = ;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Implementation of merge()
 * cardinality: 0..1 (effected)
 * 
*/
    public includes_to_process.has (included_schema.schema_id)  merge() {
        includes_to_process.has (included_schema.schema_id)  result;

        return  result;
    }

/**
 * 
 * Package structure in which all top-level qualified package names like xx.yy.zz have been expanded out to a hierarchy of BMM_PACKAGE objects.
 * cardinality: 1..1
 * 
*/
    public PBmmPackage  canonicalPackages() {
        PBmmPackage  result;

        return  result;
    }

/*=========================================================*/
/* * CONSTANTS * */
/*=========================================================*/

/**
 * 
 * Implementation of validate_created()
 * 
*/
    final state validateCreated preState = State_created Post_state: passed implies state = State_validated_created;

/**
 * 
 * Implementation of load_finalise()
 * 
*/
    final state loadFinalise preState = State_validated_created Post_state: state = State_includes_processed or state = State_includes_pending;

/**
 * 
 * Implementation of create_bmm_model()
 * 
*/
    final state createBmmModel preState = P_BMM_PACKAGE_STATE.State_includes_processed;

    //***** PBmmPackageContainer *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Package structure as a hierarchy of packages each potentially containing names of classes in that package in the original model.
 * cardinality: 1..1
 * 
*/
    private Map<String, P_BMM_PACKAGE> packages = new HashMap<> ();

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Package structure as a hierarchy of packages each potentially containing names of classes in that package in the original model.
 * cardinality: 1..1
 * 
*/

    public void putPackage(String key, PBmmPackage value ) {
        packages.put( key, value);
    }

    public void putPackages(Map<String, P_BMM_PACKAGE> items ) {
        items.keySet().forEach(key -> putPackage(key, items.get(key)));
    }

    public PBmmPackage getPackage(String key ) {
        return packages.get( key);
    }

    public void removePackage(String key ) {
        if (packages != null ) {
            packages.remove(key);
        }
    }
    public void removePackages( Collection <String> keys ) {
        keys.forEach(this::removePackage);
    }
    Map<String, P_BMM_PACKAGE> getPackages() {
        return this.packages;
    }
    void setPackages(Map<String, P_BMM_PACKAGE> packages) {
        if (packages == null ) {
            throw new NullPointerException(" packages has cardinality NonNull, but is null")
        }
        this.packages = packages;
    }
    public Map<String, P_BMM_PACKAGE> packages() {
        return Collections.unmodifiableMap(this.packages);
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

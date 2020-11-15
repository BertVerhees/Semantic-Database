package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

import nl.rosa.semanticdatabase.bmm.model_structure.BmmPackage;

/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Persisted form of a package as a tree structure whose nodes can contain more packages and/or classes.
 * 
*/
public class PBmmPackage extends PBmmModelElement implements PBmmPackageContainer {

    //***** PBmmPackage *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Name of the package from schema; this name may be qualified if it is a top-level package within the schema, or unqualified.
 * Persistent attribute.
 * cardinality: 1..1
 * 
*/
    private String name;

/**
 * 
 * List of classes in this package.
 * Persistent attribute.
 * cardinality: 0..1
 * 
*/
    private List<String> classes;

/**
 * 
 * BMM_PACKAGE created by create_bmm_package_definition.
 * cardinality: 0..1
 * 
*/
    private BmmPackage bmmPackageDefinition;

/**
 * 
 * Generate a BMM_PACKAGE_DEFINITION object and write it to bmm_package_definition.
 * cardinality: 0..1
 * 
*/
    private  ;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Name of the package from schema; this name may be qualified if it is a top-level package within the schema, or unqualified.
 * Persistent attribute.
 * cardinality: 1..1
 * 
*/
    public String getName() {
        return name;
    }
    public void setName(String value) {
        if (name == null ) {
            throw new NullPointerException(" name has cardinality NonNull, but is null")
        }
        this.name = name;
    }

/**
 * 
 * List of classes in this package.
 * Persistent attribute.
 * cardinality: 0..1
 * 
*/

    public void addToClasse(String value ) {
        if (classes == null ) {
            classes = new ArrayList<> ();
        }
        classes.add( value);
    }

    public void addToClasses(List<String> values ) {
        values.forEach(value -> addClasse(value));
    }

    public void removeFromClasse(String item ) {
        if (classes != null ) {
            classes.remove(item);
        }
    }
    public void removeFromClasses( Collection <String> values ) {
        values.forEach(this::removeClasse);
    }
    String getClasses() {
        return this.classes;
    }
    void setClasses(String classes) {
        this.classes = classes;
    }
    public List<String> classes() {
        return Collections.unmodifiableList(this.classes);
    }

/**
 * 
 * BMM_PACKAGE created by create_bmm_package_definition.
 * cardinality: 0..1
 * 
*/
    public BmmPackage getBmmPackageDefinition() {
        return bmm_package_definition;
    }
    public void setBmmPackageDefinition(BmmPackage value) {
        this.bmm_package_definition = bmm_package_definition;
    }

/**
 * 
 * Generate a BMM_PACKAGE_DEFINITION object and write it to bmm_package_definition.
 * cardinality: 0..1
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
 * Merge packages and classes from other (from an included P_BMM_SCHEMA) into this package.
 * cardinality: 0..1
 * 
*/
    public abstract void  merge();

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

package nl.rosa.semanticdatabase.bmm.model_structure;

import nl.rosa.semanticdatabase.bmm.expressions.ElProcedureAgent;

/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * A BMM model component that contains packages and classes.
 * 
*/
public abstract class BmmPackageContainer extends BmmDeclaration {

    //***** BmmPackageContainer *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Child packages; keys all in upper case for guaranteed matching.
 * cardinality: 0..1
 * 
*/
    private Map<String,BmmPackage> packages;

/**
 * 
 * Model element within which a referenceable element is known.
 * cardinality: 1..1 (redefined)
 * 
*/
    private BmmPackageContainer scope;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Child packages; keys all in upper case for guaranteed matching.
 * cardinality: 0..1
 * 
*/

    public void putPackage(String key, BmmPackage value ) {
        if (packages == null ) {
            packages = new HashMap<> ();
        }
        packages.put( key, value);
    }

    public void putPackages(Map<String,BmmPackage> items ) {
        items.keySet().forEach(key -> putPackage(key, items.get(key)));
    }

    public BmmPackage getPackage(String key ) {
        if (packages == null ) {
            return null;
        }
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
    Map<String,BmmPackage> getPackages() {
        return this.packages;
    }
    void setPackages(Map<String,BmmPackage> packages) {
        this.packages = packages;
    }
    public Map<String,BmmPackage> packages() {
        return Collections.unmodifiableMap(this.packages);
    }

/**
 * 
 * Model element within which a referenceable element is known.
 * cardinality: 1..1 (redefined)
 * 
*/
    public BmmPackageContainer getScope() {
        return scope;
    }
    public void setScope(BmmPackageContainer value) {
        if (scope == null ) {
            throw new NullPointerException(" scope has cardinality NonNull, but is null")
        }
        this.scope = scope;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Package at the path a_path.
 * cardinality: 0..1
 * 
*/
    public abstract BmmPackage  packageAtPath();

/**
 * 
 * Recursively execute action, which is a procedure taking a BMM_PACKAGE argument, on all members of packages.
 * cardinality: 0..1
 * 
*/
    public abstract void  doRecursivePackages();

/**
 * 
 * True if there is a package at the path a_path; paths are delimited with delimiter {BMM_DEFINITIONS}_Package_name_delimiter_.
 * cardinality: 1..1
 * 
*/
    public abstract Boolean  hasPackagePath();

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

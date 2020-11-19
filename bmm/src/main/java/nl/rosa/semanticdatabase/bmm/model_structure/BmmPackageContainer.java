package nl.rosa.semanticdatabase.bmm.model_structure;

import nl.rosa.semanticdatabase.foundation_types.primitive_types.String;
import nl.rosa.semanticdatabase.bmm.expressions.ElProcedureAgent;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Boolean;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
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
    public Map<String, BmmPackage> getPackages() {
        return this.packages;
    }
    public BmmPackageContainer setPackages(Map<String, BmmPackage> packages) {
        this.packages = packages;
        return this;
    }
    public Map<String, BmmPackage> packages() {
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
    public BmmPackageContainer setScope(BmmPackageContainer value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:scope failed, it has cardinality NonNull, but is null");
        }
        this.scope = scope;
        return this;
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
    public BmmPackage  packageAtPath(String a_path) {
        if (a_path == null ) {
            throw new NullPointerException("Parameter a_path has cardinality NonNull, but is null.");
        }
        BmmPackage  result;


        return  result;
    }

/**
 * 
 * Recursively execute action, which is a procedure taking a BMM_PACKAGE argument, on all members of packages.
 * cardinality: 0..1
 * 
*/
    public void  doRecursivePackages(ElProcedureAgent action) {
        if (action == null ) {
            throw new NullPointerException("Parameter action has cardinality NonNull, but is null");
        }
    }

/**
 * 
 * True if there is a package at the path a_path; paths are delimited with delimiter {BMM_DEFINITIONS}_Package_name_delimiter_.
 * cardinality: 1..1
 * 
*/
    public Boolean  hasPackagePath(String a_path) {
        if (a_path == null ) {
            throw new NullPointerException("Parameter a_path has cardinality NonNull, but is null.");
        }
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
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

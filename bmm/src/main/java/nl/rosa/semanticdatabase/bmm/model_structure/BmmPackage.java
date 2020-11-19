package nl.rosa.semanticdatabase.bmm.model_structure;

import nl.rosa.semanticdatabase.bmm.classes.BmmClass;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.String;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Abstraction of a package as a tree structure whose nodes can contain other packages and classes.
 * The name may be qualified if it is a top-level package.
 * 
*/
public class BmmPackage extends BmmPackageContainer {

    //***** BmmPackage *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Classes listed as being in this package.
 * cardinality: 0..1
 * 
*/
    private List<BmmClass> classes;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Classes listed as being in this package.
 * cardinality: 0..1
 * 
*/

    public void addToClasse(BmmClass value ) {
        if (classes == null ) {
            classes = new ArrayList<> ();
        }
        classes.add( value);
    }

    public void addToClasses(List<BmmClass> values ) {
        values.forEach(value -> addClasse(value));
    }

    public void removeFromClasse(BmmClass item ) {
        if (classes != null ) {
            classes.remove(item);
        }
    }
    public void removeFromClasses( Collection <BmmClass> values ) {
        values.forEach(this::removeClasse);
    }
    BmmClass getClasses() {
        return this.classes;
    }
    public BmmPackage setClasses(BmmClass classes) {
        this.classes = classes;
        return this;
    }
    public List<BmmClass> classes() {
        return Collections.unmodifiableList(this.classes);
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Obtain the set of top-level classes in this package, either from this package itself or by recursing into the structure until classes are obtained from child packages.
 * Recurse into each child only far enough to find the first level of classes.
 * cardinality: 0..1
 * 
*/
    public List<BmmClass>  rootClasses() {
        List<BmmClass>  result;


        return  result;
    }

/**
 * 
 * Full path of this package back to root package.
 * cardinality: 1..1
 * 
*/
    public String  path() {
        String  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** BmmPackage *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public BmmPackage build() {
        return new BmmPackage(
            classes,
            packages,
            scope,
            name,
            documentation,
            scope,
            extensions
        );
    }

    public BmmPackage(
            List<BmmClass> classes,
            Map<String,BmmPackage> packages,
            BmmPackageContainer scope,
            String name,
            Map<String, Any> documentation,
            BmmDeclaration scope,
            Map<String, Any> extensions
    ){
        if ( scope == null ) {
            throw new NullPointerException("Property:scope has cardinality NonNull, but is null");
        }
        if ( name == null ) {
            throw new NullPointerException("Property:name has cardinality NonNull, but is null");
        }
        if ( scope == null ) {
            throw new NullPointerException("Property:scope has cardinality NonNull, but is null");
        }
        this.classes = classes;
        this.packages = packages;
        this.scope = scope;
        this.name = name;
        this.documentation = documentation;
        this.scope = scope;
        this.extensions = extensions;
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

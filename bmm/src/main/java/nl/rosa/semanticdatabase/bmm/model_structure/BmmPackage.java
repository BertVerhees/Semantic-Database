package nl.rosa.semanticdatabase.bmm.model_structure;

import nl.rosa.semanticdatabase.bmm.classes.BmmClass;

/**
 * 
 * #Generated: 2020-11-15T17:28:03.861+01:00
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
    void setClasses(BmmClass classes) {
        this.classes = classes;
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

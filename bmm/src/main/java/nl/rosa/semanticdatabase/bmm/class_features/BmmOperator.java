package nl.rosa.semanticdatabase.bmm.class_features;


/**
 * 
 * #Generated: 2020-11-15T18:16:51.043+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Definition of a symbolic operator associated with a function.
 * 
*/
public class BmmOperator {

    //***** BmmOperator *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Position of operator in syntactic representation.
 * cardinality: 1..1
 * 
*/
    private BmmOperatorPosition position;

/**
 * 
 * Set of String symbols that may be used to represent this operator in a textual representation of a BMM model.
 * cardinality: 1..1
 * 
*/
    private List<String> symbols = new ArrayList<> ();

/**
 * 
 * Formal name of the operator, e.g.
 * 'minus' etc.
 * cardinality: 1..1
 * 
*/
    private String name;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Position of operator in syntactic representation.
 * cardinality: 1..1
 * 
*/
    public BmmOperatorPosition getPosition() {
        return position;
    }
    public void setPosition(BmmOperatorPosition value) {
        if (position == null ) {
            throw new NullPointerException(" position has cardinality NonNull, but is null")
        }
        this.position = position;
    }

/**
 * 
 * Set of String symbols that may be used to represent this operator in a textual representation of a BMM model.
 * cardinality: 1..1
 * 
*/

    public void addToSymbol(String value ) {
        symbols.add( value);
    }

    public void addToSymbols(List<String> values ) {
        values.forEach(value -> addSymbol(value));
    }

    public void removeFromSymbol(String item ) {
        if (symbols != null ) {
            symbols.remove(item);
        }
    }
    public void removeFromSymbols( Collection <String> values ) {
        values.forEach(this::removeSymbol);
    }
    String getSymbols() {
        return this.symbols;
    }
    void setSymbols(String symbols) {
        if (symbols == null ) {
            throw new NullPointerException(" symbols has cardinality NonNull, but is null")
        }
        this.symbols = symbols;
    }
    public List<String> symbols() {
        return Collections.unmodifiableList(this.symbols);
    }

/**
 * 
 * Formal name of the operator, e.g.
 * 'minus' etc.
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

package nl.rosa.semanticdatabase.bmm.class_features;

import nl.rosa.semanticdatabase.foundation_types.primitive_types.String;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
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
    public BmmOperator setPosition(BmmOperatorPosition value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:position failed, it has cardinality NonNull, but is null");
        }
        this.position = position;
        return this;
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
    public BmmOperator setSymbols(String symbols) {
        if (symbols == null ) {
            throw new NullPointerException(" symbols has cardinality NonNull, but is null");
        }
        this.symbols = symbols;
        return this;
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
    public BmmOperator setName(String value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:name failed, it has cardinality NonNull, but is null");
        }
        this.name = name;
        return this;
    }

    //***** BmmOperator *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public BmmOperator build() {
        return new BmmOperator(
            position,
            symbols,
            name
        );
    }

    public BmmOperator(
            BmmOperatorPosition position,
            List<String> symbols,
            String name
    ){
        if ( position == null ) {
            throw new NullPointerException("Property:position has cardinality NonNull, but is null");
        }
        if ( symbols == null ) {
            throw new NullPointerException("Property:symbols has cardinality NonNull, but is null");
        }
        if ( name == null ) {
            throw new NullPointerException("Property:name has cardinality NonNull, but is null");
        }
        this.position = position;
        this.symbols = symbols;
        this.name = name;
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

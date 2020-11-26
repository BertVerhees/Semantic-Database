package nl.rosa.semanticdatabase.foundation_types.structure_types;

import java.util.Objects;
import nl.rosa.semanticdatabase.foundation_types.overview.Any;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Boolean;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Integer;

/**
 * 
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Abstract ancestor of container types whose items are addressable in some way.
 * 
*/
public abstract class Container<t> extends Any {

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Test for membership of a value.
 * cardinality: 1..1 (abstract)
 * 
*/
    public abstract Boolean  has(T v);

/**
 * 
 * Number of items in container.
 * cardinality: 1..1 (abstract)
 * 
*/
    public abstract Integer  count();

/**
 * 
 * True if container is empty.
 * cardinality: 1..1 (abstract)
 * 
*/
    public abstract Boolean  isEmpty();

/**
 * 
 * Existential quantifier applied to container, taking one agent argument test whose signature is (v:T): Boolean.
 * cardinality: 1..1
 * 
*/
    public Boolean  thereExists alias "there exists", "∃"(Operation test) {
        if (test == null ) {
            throw new NullPointerException("Parameter test has cardinality NonNull, but is null.");
        }
        Boolean  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Universal quantifier applied to container, taking one agent argument test whose signature is (v:T): Boolean.
 * cardinality: 1..1
 * 
*/
    public Boolean  forAll alias "for all", "∀"(Operation test) {
        if (test == null ) {
            throw new NullPointerException("Parameter test has cardinality NonNull, but is null.");
        }
        Boolean  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Return a List all items matching the predicate function test which has signature (v:T): Boolean.
 * If no matches, an empty List is returned.
 * cardinality: 0..1
 * 
*/
    public List<t>  matching(Operation test) {
        if (test == null ) {
            throw new NullPointerException("Parameter test has cardinality NonNull, but is null.");
        }
        List<t>  result = null;


        return  result;
    }

/**
 * 
 * Return first item matching the predicate function test which has signature (v:T): Boolean, or Void if no match.
 * cardinality: 0..1
 * 
*/
    public T  select(Operation test) {
        if (test == null ) {
            throw new NullPointerException("Parameter test has cardinality NonNull, but is null.");
        }
        T  result = null;


        return  result;
    }

    //***** Container<t> *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected Container<t>() {}

    protected Container<t>(
            
        ){
    }


    //***** Container<t> *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        return true;
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode()
        );
    }

    @Override
    public String toString() {
        return
            "Container<t> {" +
            '}';
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

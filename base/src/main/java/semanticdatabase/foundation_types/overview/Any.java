package semanticdatabase.foundation_types.overview;

import java.util.Objects;

import semanticdatabase.foundation_types.primitive_types.Boolean;
import semanticdatabase.foundation_types.primitive_types.Ordered;
import semanticdatabase.foundation_types.primitive_types.String;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Abstract ancestor class for all other classes.
 * Usually maps to a type like Any or Object in an object-oriented technology.
 * Defined here to provide value and reference equality semantics.
 */
public abstract class Any extends Object {

    private java.lang.Object object;

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Value equality: return True if this and other are attached to objects considered to be equal in value.
     * Parameters other Other object for comparison.
     * cardinality: 1..1 (abstract)
     */
    public abstract Boolean isEqual(Any other);

    /**
     * Reference equality for reference types, value equality for value types.
     * Parameters other Other object for comparison.
     * cardinality: 1..1
     */
    public Boolean equal(Any other) {
        if (other == null) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Create new instance of a type.
     * cardinality: 1..1
     */
    public static Any instanceOf(java.lang.String aType) {
        if (aType == null) {
            throw new NullPointerException("Parameter a_type has cardinality NonNull, but is null.");
        }
        try {
            Any result = (Any) Class.forName(aType).getDeclaredConstructor().newInstance();
            if (result == null) {
                throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
            }
            return result;
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /**
     * Type name of an object as a string.
     * May include generic parameters, as in "Interval<Time>".
     * cardinality: 1..1
     */
    public String typeOf(Any anObject) {
        if (anObject == null) {
            throw new NullPointerException("Parameter an_object has cardinality NonNull, but is null.");
        }
        String result = new String(anObject.getClass().getName());

        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if current object not equal to other.
     * Returns not equal().
     * cardinality: 1..1
     */
    public Boolean notEqual(Ordered other) {
        if (other == null) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    public java.lang.Object valueOf() {
        return object;
    }

    public void value(Object object) {
        this.object = object;
    }

    //***** Any *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected Any() {
    }

    //***** Any *****

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
    public java.lang.String toString() {
        return
                "Any {" +
                        '}';
    }

}

/**
 * ***** BEGIN LICENSE BLOCK *****
 * <p>
 * ISC License
 * <p>
 * Copyright (c) 2020, Bert Verhees
 * <p>
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 * <p>
 * ***** END LICENSE BLOCK *****
 */

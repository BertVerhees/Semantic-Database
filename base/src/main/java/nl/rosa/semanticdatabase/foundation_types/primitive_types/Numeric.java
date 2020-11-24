package nl.rosa.semanticdatabase.foundation_types.primitive_types;

import nl.rosa.semanticdatabase.foundation_types.overview.Any;

/**
 * 
 * #Generated: 2020-11-24T17:04:33.085+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Abstract parent class of numeric types, which are types which have various arithmetic and comparison operators defined.
 * 
*/
public abstract class Numeric extends Any {

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Sum with other (commutative).
 * Actual type of result depends on arithmetic balancing rules.
 * cardinality: 1..1 (abstract)
 * 
*/
    public abstract Numeric  add alias "+"(Numeric other);

/**
 * 
 * Result of subtracting other.
 * Actual type of result depends on arithmetic balancing rules.
 * cardinality: 1..1 (abstract)
 * 
*/
    public abstract Numeric  subtract alias "-"(Numeric other);

/**
 * 
 * Product by other.
 * Actual type of result depends on arithmetic balancing rules.
 * cardinality: 1..1 (abstract)
 * 
*/
    public abstract Numeric  multiply alias "*"(Numeric other);

/**
 * 
 * Divide by`other`.
 * Actual type of result depends on arithmetic balancing rules.
 * cardinality: 1..1 (abstract)
 * 
*/
    public abstract Numeric  divide alias "/"(Numeric other);

/**
 * 
 * Expontiation of this by other.
 * cardinality: 1..1 (abstract)
 * 
*/
    public abstract Numeric  exponent alias "^"(Numeric other);

/**
 * 
 * Generate negative of current value.
 * cardinality: 1..1 (abstract)
 * 
*/
    public abstract Numeric  negative alias "-"();

    //***** Numeric *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected Numeric(
            
        ){
    }


    //***** Numeric *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Numeric that = (Numeric) object;
        return
        }
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
        );
    }

    @Override
    public java.lang.String toString() {
        return
            "Numeric {" +
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

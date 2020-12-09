package semanticdatabase.base.foundation_types.primitive_types;

import java.util.Objects;

import semanticdatabase.base.foundation_types.overview.Any;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Type representing minimal interface of built-in Boolean type.
 */
public class Boolean extends Any {

    private java.lang.Boolean _boolean;

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Logical conjunction of this with other.
     * cardinality: 1..1
     * <p>
     * alias "and", "∧", "&"
     * <p>
     * Post_de_Morgan: Result = not (not self or not other)
     * Post_commutative: Result = (other and self)
     */
    public semanticdatabase.base.foundation_types.primitive_types.Boolean conjunction(semanticdatabase.base.foundation_types.primitive_types.Boolean other) {
        if (other == null) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        return new semanticdatabase.base.foundation_types.primitive_types.Boolean(_boolean && other._boolean);
    }

    /**
     * Boolean semi-strict conjunction with other.
     * cardinality: 1..1
     * <p>
     * alias "and then", "&&"
     * Post_de_Morgan: Result = not (not self or else not other)
     */
    public semanticdatabase.base.foundation_types.primitive_types.Boolean semistrictConjunction(semanticdatabase.base.foundation_types.primitive_types.Boolean other) {
        if (other == null) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        return new semanticdatabase.base.foundation_types.primitive_types.Boolean(_boolean && other._boolean);
    }

    /**
     * Boolean disjunction with other.
     * cardinality: 1..1
     * <p>
     * alias "or", "∨", "|"
     * Post_de_Morgan: Result = not (not self and not other)
     * Post_commutative: Result = (other or Current)
     * Post_consistent_with_semi_strict: Result implies (self or else other)
     */
    public semanticdatabase.base.foundation_types.primitive_types.Boolean disjunction(semanticdatabase.base.foundation_types.primitive_types.Boolean other) {
        if (other == null) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        boolean b1 = _boolean;
        boolean b2 = other._boolean;
        return new semanticdatabase.base.foundation_types.primitive_types.Boolean(b1 | b2);
    }

    /**
     * Boolean semi-strict disjunction with other.
     * cardinality: 1..1
     * <p>
     * alias "or else", "||"
     * <p>
     * Post_de_Morgan: Result = not (not self and then not other)
     */
    public semanticdatabase.base.foundation_types.primitive_types.Boolean semistrictDisjunction(semanticdatabase.base.foundation_types.primitive_types.Boolean other) {
        if (other == null) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        boolean b1 = _boolean;
        boolean b2 = other._boolean;
        return new semanticdatabase.base.foundation_types.primitive_types.Boolean(b1 || b2);
    }

    /**
     * Boolean exclusive or with other.
     * cardinality: 1..1
     * <p>
     * alias "xor", "⊻"
     * <p>
     * Post_definition: Result = self or other) and not (self and other
     */
    public semanticdatabase.base.foundation_types.primitive_types.Boolean exclusiveDisjunction(semanticdatabase.base.foundation_types.primitive_types.Boolean other) {
        if (other == null) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        boolean b1 = _boolean;
        boolean b2 = other._boolean;
        return new semanticdatabase.base.foundation_types.primitive_types.Boolean((b1 || b2) && !(b1 && b2));
    }

    /**
     * Boolean implication of other (semi-strict)
     * cardinality: 1..1
     * <p>
     * alias "implies", "⇒"
     * <p>
     * Post_definition: Result = (not self or else other)
     */
    public semanticdatabase.base.foundation_types.primitive_types.Boolean implication(semanticdatabase.base.foundation_types.primitive_types.Boolean other) {
        if (other == null) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        boolean b1 = _boolean;
        boolean b2 = other._boolean;
        return new semanticdatabase.base.foundation_types.primitive_types.Boolean((b1 && b2) || !(b1 && !b2) || (!b1 && b2) || (!b1 && !b2));
    }

    /**
     * Boolean negation of the current value.
     * cardinality: 1..1
     * <p>
     * alias "not", "¬", "!"
     */
    public semanticdatabase.base.foundation_types.primitive_types.Boolean negation() {
        return new semanticdatabase.base.foundation_types.primitive_types.Boolean(!_boolean);
    }

    //***** Boolean *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    /**
     * Value equality: return True if this and other are attached to objects considered to be equal in value.
     * Parameters other Other object for comparison.
     * cardinality: 1..1 (abstract)
     *
     * @param other
     */
    @Override
    public semanticdatabase.base.foundation_types.primitive_types.Boolean isEqual(Any other) {
        return null;
    }

    public Boolean(
            java.lang.Boolean _boolean
    ) {
        this._boolean = _boolean;
    }

    //***** Boolean *****

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

    public boolean value() {
        return _boolean;
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


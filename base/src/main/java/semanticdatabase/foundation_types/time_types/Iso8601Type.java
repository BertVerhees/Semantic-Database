package semanticdatabase.foundation_types.time_types;

import java.util.Objects;

import semanticdatabase.foundation_types.primitive_types.Boolean;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Abstract ancestor type of ISO 8601 types, defining interface for 'extended' and 'partial' concepts from ISO 8601.
 */
public abstract class Iso8601Type extends Temporal, TimeDefinitions {

    //***** Iso8601Type *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Representation of all descendants is a single String.
     * cardinality: 1..1
     */
    private String value;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Representation of all descendants is a single String.
     * cardinality: 1..1
     */
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:value failed, it has cardinality NonNull, but is null");
        }
        this.value = value;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * True if this date time is partial, i.e.
     * if trailing end (right hand) value(s) is/are missing.
     * cardinality: 1..1 (abstract)
     */
    public abstract Boolean isPartial();

    /**
     * True if this ISO8601 string is in the 'extended' form, i.e.
     * uses '-' and / or ':' separators.
     * This is the preferred format.
     * cardinality: 1..1 (abstract)
     */
    public abstract Boolean isExtended();

    //***** Iso8601Type *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected Iso8601Type() {
    }

    protected Iso8601Type(
            String value,
            Integer maxDaysInYear
    ) {
        super(
                maxDaysInYear
        );
        if (value == null) {
            throw new NullPointerException("Property:value has cardinality NonNull, but is null");
        }
        this.value = value;
    }


    //***** Iso8601Type *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Iso8601Type that = (Iso8601Type) object;
        return
                Objects.equals(value, that.value);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                value
        );
    }

    @Override
    public String toString() {
        return
                "Iso8601Type {" +
                        "value='" + value + '\'' +
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

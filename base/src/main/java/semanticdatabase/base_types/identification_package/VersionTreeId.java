package semanticdatabase.base_types.identification_package;

import java.util.Objects;

import semanticdatabase.foundation_types.primitive_types.Boolean;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Version tree identifier for one version.
 * Lexical form: trunk_version [ '.' branch_number '.' branch_version ]
 */
public class VersionTreeId {

    //***** VersionTreeId *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * String form of this identifier.
     * cardinality: 1..1
     */
    private String value;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * String form of this identifier.
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
     * Trunk version number; numbering starts at 1.
     * cardinality: 1..1
     */
    public String trunkVersion() {
        String result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * True if this version identifier represents a branch, i.e.
     * has branch_number and branch_version parts.
     * cardinality: 1..1
     */
    public Boolean isBranch() {
        Boolean result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Number of branch from the trunk point; numbering starts at 1.
     * cardinality: 1..1
     */
    public String branchNumber() {
        String result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Version of the branch; numbering starts at 1.
     * cardinality: 1..1
     */
    public String branchVersion() {
        String result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** VersionTreeId *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected VersionTreeId() {
    }

    public VersionTreeId(
            String value
    ) {
        if (value == null) {
            throw new NullPointerException("Property:value has cardinality NonNull, but is null");
        }
        this.value = value;
    }

    private VersionTreeId(Builder builder) {
        this.setValue(builder.value);
    }

    public static class Builder {
        private final String value;  //required

        public Builder(
                String value
        ) {
            if (value == null) {
                throw new NullPointerException("Property:value has cardinality NonNull, but is null");
            }
            this.value = value;
        }

        public VersionTreeId build() {
            return new VersionTreeId(this);
        }
    }


    //***** VersionTreeId *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        VersionTreeId that = (VersionTreeId) object;
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
                "VersionTreeId {" +
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

package nl.rosa.semanticdatabase.bmm_persistence.persistence_package;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Persistent form of BMM_PROPER_TYPE.
 */
public abstract class PBmmBaseType extends PBmmType {

    //***** PBmmBaseType *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * cardinality: 0..1
     */
    private String valueConstraint;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * cardinality: 0..1
     */
    public String getValueConstraint() {
        return valueConstraint;
    }

    public void setValueConstraint(String value) {
        this.valueConstraint = valueConstraint;
    }

    //***** PBmmBaseType *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected PBmmBaseType() {
    }

    protected PBmmBaseType(
            String valueConstraint,
            BmmType bmmType
    ) {
        super(
                bmmType
        );
        this.valueConstraint = valueConstraint;
    }


    //***** PBmmBaseType *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        PBmmBaseType that = (PBmmBaseType) object;
        return
                Objects.equals(valueConstraint, that.valueConstraint);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                valueConstraint
        );
    }

    @Override
    public String toString() {
        return
                "PBmmBaseType {" +
                        "valueConstraint='" + valueConstraint + '\'' +
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

package semanticdatabase.base_types.identification_package;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Model of ISO’s Object Identifier (oid) as defined by the standard ISO/IEC 8824.
 * Oids are formed from integers separated by dots.
 * Each non-leaf node in an Oid starting from the left corresponds to an assigning authority, and identifies that authority’s namespace, inside which the remaining part of the identifier is locally unique.
 */
public class IsoOid extends Uid {

    //***** IsoOid *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected IsoOid() {
    }

    public IsoOid(
            String value
    ) {
        super(
                value
        );
    }

    private IsoOid(Builder builder) {
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

        public IsoOid build() {
            return new IsoOid(this);
        }
    }


    //***** IsoOid *****

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
                "IsoOid {" +
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

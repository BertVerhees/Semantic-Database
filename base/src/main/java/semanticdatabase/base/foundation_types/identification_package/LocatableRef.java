package semanticdatabase.base.foundation_types.identification_package;

import java.util.Objects;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Purpose Reference to a LOCATABLE instance inside the top-level content structure inside a VERSION<T>; the path attribute is applied to the object that VERSION.data points to.
 */
public class LocatableRef extends ObjectRef {

    //***** LocatableRef *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * The path to an instance in question, as an absolute path with respect to the object found at VERSION.data.
     * An empty path means that the object referred to by id being specified.
     * cardinality: 0..1
     */
    private String path;

    /**
     * Globally unique id of an object, regardless of where it is stored.
     * cardinality: 1..1 (redefined)
     */
    private UidBasedId id;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * The path to an instance in question, as an absolute path with respect to the object found at VERSION.data.
     * An empty path means that the object referred to by id being specified.
     * cardinality: 0..1
     */
    public String getPath() {
        return path;
    }

    public void setPath(String value) {
        this.path = path;
    }

    /**
     * Globally unique id of an object, regardless of where it is stored.
     * cardinality: 1..1 (redefined)
     */
    public UidBasedId getId() {
        return id;
    }

    public void setId(UidBasedId value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:id failed, it has cardinality NonNull, but is null");
        }
        this.id = id;
    }

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * A URI form of the reference, created by concatenating the following: scheme, e.g.
     * ehr:, derived from namespace id.value / + path, where path is non-empty
     * cardinality: 1..1
     */
    public String asUri() {
        String result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** LocatableRef *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected LocatableRef() {
    }

    public LocatableRef(
            String path,
            UidBasedId id,
            String namespace,
            String type
    ) {
        super(
                namespace,
                type,
                id
        );
        this.path = path;
    }

    private LocatableRef(Builder builder) {
        this.setPath(builder.path);
        this.setId(builder.id);
        this.setNamespace(builder.namespace);
        this.setType(builder.type);
        this.setId(builder.id);
    }

    public static class Builder {
        private String path;
        private final UidBasedId id;  //required
        private final String namespace;  //required
        private final String type;  //required

        public Builder(
                UidBasedId id,
                String namespace,
                String type
        ) {
            if (id == null) {
                throw new NullPointerException("Property:id has cardinality NonNull, but is null");
            }
            if (namespace == null) {
                throw new NullPointerException("Property:namespace has cardinality NonNull, but is null");
            }
            if (type == null) {
                throw new NullPointerException("Property:type has cardinality NonNull, but is null");
            }
            if (id == null) {
                throw new NullPointerException("Property:id has cardinality NonNull, but is null");
            }
            this.id = id;
            this.namespace = namespace;
            this.type = type;
        }

        public Builder setPath(String value) {
            this.path = path;
            return this;
        }

        public LocatableRef build() {
            return new LocatableRef(this);
        }
    }


    //***** LocatableRef *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        LocatableRef that = (LocatableRef) object;
        return
                Objects.equals(path, that.path) &&
                        Objects.equals(id, that.id);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                path,
                id
        );
    }

    @Override
    public String toString() {
        return
                "LocatableRef {" +
                        "path='" + path + '\'' +
                        "id='" + id + '\'' +
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

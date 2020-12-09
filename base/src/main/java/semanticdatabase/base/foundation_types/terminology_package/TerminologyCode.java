package semanticdatabase.base.foundation_types.terminology_package;

import java.util.Objects;

import semanticdatabase.base.foundation_types.overview.Any;
import semanticdatabase.base.foundation_types.primitive_types.Uri;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Logically primitive type representing a reference to a terminology concept, in the form of a terminology identifier, optional version, and a code or code string from the terminology.
 */
public class TerminologyCode extends Any {

    //***** TerminologyCode *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * The archetype environment namespace identifier used to identify a terminology.
     * Typically a value like "snomed_ct" that is mapped elsewhere to the full URI identifying the terminology.
     * cardinality: 1..1
     */
    private String terminologyId;

    /**
     * Optional string value representing terminology version, typically a date or dotted numeric.
     * cardinality: 0..1
     */
    private String terminologyVersion;

    /**
     * A terminology code or post-coordinated code expression, if supported by the terminology.
     * The code may refer to a single term, a value set consisting of multiple terms, or some other entity representable within the terminology.
     * cardinality: 1..1
     */
    private String codeString;

    /**
     * The URI reference that may be used as a concrete key into a notional terminology service for queries that can obtain the term text, definition, and other associated elements.
     * cardinality: 0..1
     */
    private Uri uri;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * The archetype environment namespace identifier used to identify a terminology.
     * Typically a value like "snomed_ct" that is mapped elsewhere to the full URI identifying the terminology.
     * cardinality: 1..1
     */
    public String getTerminologyId() {
        return terminologyId;
    }

    public void setTerminologyId(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:terminologyId failed, it has cardinality NonNull, but is null");
        }
        this.terminologyId = terminologyId;
    }

    /**
     * Optional string value representing terminology version, typically a date or dotted numeric.
     * cardinality: 0..1
     */
    public String getTerminologyVersion() {
        return terminologyVersion;
    }

    public void setTerminologyVersion(String value) {
        this.terminologyVersion = terminologyVersion;
    }

    /**
     * A terminology code or post-coordinated code expression, if supported by the terminology.
     * The code may refer to a single term, a value set consisting of multiple terms, or some other entity representable within the terminology.
     * cardinality: 1..1
     */
    public String getCodeString() {
        return codeString;
    }

    public void setCodeString(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:codeString failed, it has cardinality NonNull, but is null");
        }
        this.codeString = codeString;
    }

    /**
     * The URI reference that may be used as a concrete key into a notional terminology service for queries that can obtain the term text, definition, and other associated elements.
     * cardinality: 0..1
     */
    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri value) {
        this.uri = uri;
    }

    //***** TerminologyCode *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected TerminologyCode() {
    }

    public TerminologyCode(
            String terminologyId,
            String terminologyVersion,
            String codeString,
            Uri uri
    ) {
        if (terminologyId == null) {
            throw new NullPointerException("Property:terminologyId has cardinality NonNull, but is null");
        }
        if (codeString == null) {
            throw new NullPointerException("Property:codeString has cardinality NonNull, but is null");
        }
        this.terminologyId = terminologyId;
        this.terminologyVersion = terminologyVersion;
        this.codeString = codeString;
        this.uri = uri;
    }

    private TerminologyCode(Builder builder) {
        this.setTerminologyId(builder.terminologyId);
        this.setTerminologyVersion(builder.terminologyVersion);
        this.setCodeString(builder.codeString);
        this.setUri(builder.uri);
    }

    public static class Builder {
        private final String terminologyId;  //required
        private String terminologyVersion;
        private final String codeString;  //required
        private Uri uri;

        public Builder(
                String terminologyId,
                String codeString
        ) {
            if (terminologyId == null) {
                throw new NullPointerException("Property:terminologyId has cardinality NonNull, but is null");
            }
            if (codeString == null) {
                throw new NullPointerException("Property:codeString has cardinality NonNull, but is null");
            }
            this.terminologyId = terminologyId;
            this.codeString = codeString;
        }

        public Builder setTerminologyVersion(String value) {
            this.terminologyVersion = terminologyVersion;
            return this;
        }

        public Builder setUri(Uri value) {
            this.uri = uri;
            return this;
        }

        public TerminologyCode build() {
            return new TerminologyCode(this);
        }
    }


    //***** TerminologyCode *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        TerminologyCode that = (TerminologyCode) object;
        return
                Objects.equals(terminologyId, that.terminologyId) &&
                        Objects.equals(terminologyVersion, that.terminologyVersion) &&
                        Objects.equals(codeString, that.codeString) &&
                        Objects.equals(uri, that.uri);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                terminologyId,
                terminologyVersion,
                codeString,
                uri
        );
    }

    @Override
    public String toString() {
        return
                "TerminologyCode {" +
                        "terminologyId='" + terminologyId + '\'' +
                        "terminologyVersion='" + terminologyVersion + '\'' +
                        "codeString='" + codeString + '\'' +
                        "uri='" + uri + '\'' +
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

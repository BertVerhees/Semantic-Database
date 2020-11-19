package nl.rosa.semanticdatabase.foundation_types.terminology_package;

import nl.rosa.semanticdatabase.foundation_types.overview.Any;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.String;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Uri;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Logically primitive type representing a reference to a terminology concept, in the form of a terminology identifier, optional version, and a code or code string from the terminology.
 * 
*/
public class TerminologyCode extends Any {

    //***** TerminologyCode *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * The archetype environment namespace identifier used to identify a terminology.
 * Typically a value like "snomed_ct" that is mapped elsewhere to the full URI identifying the terminology.
 * cardinality: 1..1
 * 
*/
    private String terminologyId;

/**
 * 
 * Optional string value representing terminology version, typically a date or dotted numeric.
 * cardinality: 0..1
 * 
*/
    private String terminologyVersion;

/**
 * 
 * A terminology code or post-coordinated code expression, if supported by the terminology.
 * The code may refer to a single term, a value set consisting of multiple terms, or some other entity representable within the terminology.
 * cardinality: 1..1
 * 
*/
    private String codeString;

/**
 * 
 * The URI reference that may be used as a concrete key into a notional terminology service for queries that can obtain the term text, definition, and other associated elements.
 * cardinality: 0..1
 * 
*/
    private Uri uri;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * The archetype environment namespace identifier used to identify a terminology.
 * Typically a value like "snomed_ct" that is mapped elsewhere to the full URI identifying the terminology.
 * cardinality: 1..1
 * 
*/
    public String getTerminologyId() {
        return terminologyId;
    }
    public TerminologyCode setTerminologyId(String value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:terminologyId failed, it has cardinality NonNull, but is null");
        }
        this.terminologyId = terminologyId;
        return this;
    }

/**
 * 
 * Optional string value representing terminology version, typically a date or dotted numeric.
 * cardinality: 0..1
 * 
*/
    public String getTerminologyVersion() {
        return terminologyVersion;
    }
    public TerminologyCode setTerminologyVersion(String value) {
        this.terminologyVersion = terminologyVersion;
        return this;
    }

/**
 * 
 * A terminology code or post-coordinated code expression, if supported by the terminology.
 * The code may refer to a single term, a value set consisting of multiple terms, or some other entity representable within the terminology.
 * cardinality: 1..1
 * 
*/
    public String getCodeString() {
        return codeString;
    }
    public TerminologyCode setCodeString(String value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:codeString failed, it has cardinality NonNull, but is null");
        }
        this.codeString = codeString;
        return this;
    }

/**
 * 
 * The URI reference that may be used as a concrete key into a notional terminology service for queries that can obtain the term text, definition, and other associated elements.
 * cardinality: 0..1
 * 
*/
    public Uri getUri() {
        return uri;
    }
    public TerminologyCode setUri(Uri value) {
        this.uri = uri;
        return this;
    }

    //***** TerminologyCode *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public TerminologyCode build() {
        return new TerminologyCode(
            terminologyId,
            terminologyVersion,
            codeString,
            uri
        );
    }

    public TerminologyCode(
            String terminologyId,
            String terminologyVersion,
            String codeString,
            Uri uri
    ){
        if ( terminologyId == null ) {
            throw new NullPointerException("Property:terminologyId has cardinality NonNull, but is null");
        }
        if ( codeString == null ) {
            throw new NullPointerException("Property:codeString has cardinality NonNull, but is null");
        }
        this.terminologyId = terminologyId;
        this.terminologyVersion = terminologyVersion;
        this.codeString = codeString;
        this.uri = uri;
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

package nl.rosa.semanticdatabase.foundation_types.terminology_package;

import nl.rosa.semanticdatabase.foundation_types.overview.Any;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.String;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Leaf type representing a term from a terminology, which consists of the term text and the code, i.e.
 * a concept reference.
 * 
*/
public class TerminologyTerm extends Any {

    //***** TerminologyTerm *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Reference to the terminology concept formally representing this term.
 * cardinality: 1..1
 * 
*/
    private TerminologyCode concept;

/**
 * 
 * Text of term.
 * cardinality: 1..1
 * 
*/
    private String text;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Reference to the terminology concept formally representing this term.
 * cardinality: 1..1
 * 
*/
    public TerminologyCode getConcept() {
        return concept;
    }
    public TerminologyTerm setConcept(TerminologyCode value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:concept failed, it has cardinality NonNull, but is null");
        }
        this.concept = concept;
        return this;
    }

/**
 * 
 * Text of term.
 * cardinality: 1..1
 * 
*/
    public String getText() {
        return text;
    }
    public TerminologyTerm setText(String value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:text failed, it has cardinality NonNull, but is null");
        }
        this.text = text;
        return this;
    }

    //***** TerminologyTerm *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public TerminologyTerm build() {
        return new TerminologyTerm(
            concept,
            text
        );
    }

    public TerminologyTerm(
            TerminologyCode concept,
            String text
    ){
        if ( concept == null ) {
            throw new NullPointerException("Property:concept has cardinality NonNull, but is null");
        }
        if ( text == null ) {
            throw new NullPointerException("Property:text has cardinality NonNull, but is null");
        }
        this.concept = concept;
        this.text = text;
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

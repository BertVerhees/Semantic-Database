package semanticdatabase.base.foundation_types.terminology_package;

import java.util.Objects;

import semanticdatabase.base.foundation_types.overview.Any;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Leaf type representing a term from a terminology, which consists of the term text and the code, i.e.
 * a concept reference.
 */
public class TerminologyTerm extends Any {

    //***** TerminologyTerm *****

    /*=========================================================*/
    /* * FIELDS * */
    /*=========================================================*/

    /**
     * Reference to the terminology concept formally representing this term.
     * cardinality: 1..1
     */
    private TerminologyCode concept;

    /**
     * Text of term.
     * cardinality: 1..1
     */
    private String text;

    /*=========================================================*/
    /* * POJOS * */
    /*=========================================================*/

    /**
     * Reference to the terminology concept formally representing this term.
     * cardinality: 1..1
     */
    public TerminologyCode getConcept() {
        return concept;
    }

    public void setConcept(TerminologyCode value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:concept failed, it has cardinality NonNull, but is null");
        }
        this.concept = concept;
    }

    /**
     * Text of term.
     * cardinality: 1..1
     */
    public String getText() {
        return text;
    }

    public void setText(String value) {
        if (value == null) {
            throw new NullPointerException(" Setting property:text failed, it has cardinality NonNull, but is null");
        }
        this.text = text;
    }

    //***** TerminologyTerm *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected TerminologyTerm() {
    }

    public TerminologyTerm(
            TerminologyCode concept,
            String text
    ) {
        if (concept == null) {
            throw new NullPointerException("Property:concept has cardinality NonNull, but is null");
        }
        if (text == null) {
            throw new NullPointerException("Property:text has cardinality NonNull, but is null");
        }
        this.concept = concept;
        this.text = text;
    }

    private TerminologyTerm(Builder builder) {
        this.setConcept(builder.concept);
        this.setText(builder.text);
    }

    public static class Builder {
        private final TerminologyCode concept;  //required
        private final String text;  //required

        public Builder(
                TerminologyCode concept,
                String text
        ) {
            if (concept == null) {
                throw new NullPointerException("Property:concept has cardinality NonNull, but is null");
            }
            if (text == null) {
                throw new NullPointerException("Property:text has cardinality NonNull, but is null");
            }
            this.concept = concept;
            this.text = text;
        }

        public TerminologyTerm build() {
            return new TerminologyTerm(this);
        }
    }


    //***** TerminologyTerm *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        TerminologyTerm that = (TerminologyTerm) object;
        return
                Objects.equals(concept, that.concept) &&
                        Objects.equals(text, that.text);
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                concept,
                text
        );
    }

    @Override
    public String toString() {
        return
                "TerminologyTerm {" +
                        "concept='" + concept + '\'' +
                        "text='" + text + '\'' +
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

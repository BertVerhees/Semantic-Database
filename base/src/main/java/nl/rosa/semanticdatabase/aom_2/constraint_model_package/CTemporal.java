package nl.rosa.semanticdatabase.aom_2.constraint_model_package;

import nl.rosa.semanticdatabase..;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Boolean;

/**
 * 
 * #Generated: 2020-11-24T17:04:33.085+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Purpose Abstract parent of C_ORDERED types whose base type is an ISO date/time type.
 * 
*/
public abstract class CTemporal<t> extends COrdered {

    //***** CTemporal<t> *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Optional alternative constraint in the form of a pattern based on ISO8601.
 * See descendants for details.
 * cardinality: 0..1
 * 
*/
    private String patternConstraint;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Optional alternative constraint in the form of a pattern based on ISO8601.
 * See descendants for details.
 * cardinality: 0..1
 * 
*/
    public String getPatternConstraint() {
        return patternConstraint;
    }
    public setPatternConstraint(String value) {
        this.patternConstraint = patternConstraint;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * True if a_pattern is a valid constraint.
 * Define in concrete descendants.
 * cardinality: 1..1 (abstract)
 * 
*/
    public abstract Boolean  validPatternConstraint(String a_pattern);

/**
 * 
 * Return True if a_pattern can be replaced by an_other_pattern in a specialised constraint.
 * Define in concrete subtypes.
 * cardinality: 1..1 (abstract)
 * 
*/
    public abstract Boolean  validPatternConstraintReplacement(String a_pattern, String an_other_pattern);

/**
 * 
 * True if any value (i.e.
 * instance) of the reference model type would be allowed.
 * Redefined in descendants.
 * cardinality: 1..1 (effected)
 * 
*/
    public Result = precursor and pattern_constraint.is_empty  anyAllowed() {
        Result = precursor and pattern_constraint.is_empty  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if precursor() or else other.pattern_constraint is empty, or else pattern_constraint is a valid (narrower) replacement for other.pattern_constraint.
 * cardinality: 1..1 (effected)
 * 
*/
    public Boolean  cValueConformsTo(C_ORDERED other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if precursor (other) and pattern_constraint ~ other.pattern_constraint, i.e.
 * either both Void or else both non-Void and identical.
 * cardinality: 1..1 (effected)
 * 
*/
    public Boolean  cValueCongruentTo(C_ORDERED other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** CTemporal<t> *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected CTemporal<t>(
            String patternConstraint
        ){
        this.patternConstraint = patternConstraint;
    }


    //***** CTemporal<t> *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CTemporal<t> that = (CTemporal<t>) object;
        return
            java.util.Objects.equals(patternConstraint, that.patternConstraint);
        }
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            patternConstraint
        );
    }

    @Override
    public String toString() {
        return
            "CTemporal<t> {" +
            "patternConstraint='" + patternConstraint + '\''; +
            '}';
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

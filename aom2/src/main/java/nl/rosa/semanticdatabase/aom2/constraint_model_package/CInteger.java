package nl.rosa.semanticdatabase.aom2.constraint_model_package;

import java.util.Objects;
import nl.rosa.semanticdatabase..;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Integer;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Real;

/**
 * 
 * #Generated: 2020-11-24T17:57:46.357+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Constraint on instances of Integer.
 * 
*/
public class CInteger extends COrdered {

    //***** CInteger *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Formal constraint on Integer, in the form of List<Interval<Integer>>.
 * cardinality: 1..1 (redefined)
 * 
*/
    private Interval<Integer> constraint;

/**
 * 
 * Default value set in a template, and present in an operational template.
 * Generally limited to leaf and near-leaf nodes.
 * cardinality: 0..1 (redefined)
 * 
*/
    private Integer defaultValue;

/**
 * 
 * Value to be assumed if none sent in data.
 * cardinality: 0..1 (redefined)
 * 
*/
    private Real assumedValue;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Formal constraint on Integer, in the form of List<Interval<Integer>>.
 * cardinality: 1..1 (redefined)
 * 
*/
    public Interval<Integer> getConstraint() {
        return constraint;
    }
    public void setConstraint(Interval<Integer> value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:constraint failed, it has cardinality NonNull, but is null");
        }
        this.constraint = constraint;
    }

/**
 * 
 * Default value set in a template, and present in an operational template.
 * Generally limited to leaf and near-leaf nodes.
 * cardinality: 0..1 (redefined)
 * 
*/
    public Integer getDefaultValue() {
        return defaultValue;
    }
    public void setDefaultValue(Integer value) {
        this.defaultValue = defaultValue;
    }

/**
 * 
 * Value to be assumed if none sent in data.
 * cardinality: 0..1 (redefined)
 * 
*/
    public Real getAssumedValue() {
        return assumedValue;
    }
    public void setAssumedValue(Real value) {
        this.assumedValue = assumedValue;
    }

    //***** CInteger *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected CInteger() {}

    public CInteger(
            Interval<integer> constraint,
            Integer defaultValue,
            Real assumedValue
        ){
        if ( constraint == null ) {
            throw new NullPointerException("Property:constraint has cardinality NonNull, but is null");
        }
        this.constraint = constraint;
        this.defaultValue = defaultValue;
        this.assumedValue = assumedValue;
    }

    private CInteger(Builder builder) {
        this.setConstraint( builder.constraint );
        this.setDefaultValue( builder.defaultValue );
        this.setAssumedValue( builder.assumedValue );
    }

    public static class Builder {
        private final Interval<integer> constraint;  //required
        private Integer defaultValue;
        private Real assumedValue;

        public Builder (
            Interval<integer> constraint
        ){
            if ( constraint == null ) {
                throw new NullPointerException("Property:constraint has cardinality NonNull, but is null");
            }
            this.constraint = constraint;
        }

        public Builder setDefaultValue(Integer value) {
            this.defaultValue = defaultValue;
            return this;
        }

        public Builder setAssumedValue(Real value) {
            this.assumedValue = assumedValue;
            return this;
        }

        public CInteger build(){
            return new CInteger( this );
        }
    }


    //***** CInteger *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CInteger that = (CInteger) object;
        return
            Objects.equals(constraint, that.constraint) &&
            Objects.equals(defaultValue, that.defaultValue) &&
            Objects.equals(assumedValue, that.assumedValue);
        }
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            constraint,
            defaultValue,
            assumedValue
        );
    }

    @Override
    public String toString() {
        return
            "CInteger {" +
            "constraint='" + constraint + '\''; +
            "defaultValue='" + defaultValue + '\''; +
            "assumedValue='" + assumedValue + '\''; +
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

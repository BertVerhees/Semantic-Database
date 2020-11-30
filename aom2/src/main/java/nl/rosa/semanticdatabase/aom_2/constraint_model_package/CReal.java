package nl.rosa.semanticdatabase.aom_2.constraint_model_package;

import java.util.List;
import java.util.Objects;
.;
import nl.rosa.semanticdatabase.foundation_types.interval.Interval;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Real;

/**
 * 
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Constraint on instances of Real.
 * 
*/
public class CReal extends COrdered<Double> {

    //***** CReal *****

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Formal constraint on Real, in the form of List<Interval<Real>>.
 * cardinality: 1..1 (redefined)
 * 
*/
    public List<Interval<Double>> getConstraint() {
        return constraint;
    }
    public void setConstraint(List<Interval<Double>> value) {
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
    public Double getDefaultValue() {
        return defaultValue;
    }
    public void setDefaultValue(Double value) {
        this.defaultValue = defaultValue;
    }

/**
 * 
 * Value to be assumed if none sent in data.
 * cardinality: 0..1 (redefined)
 * 
*/
    public Double getAssumedValue() {
        return assumedValue;
    }
    public void setAssumedValue(Double value) {
        this.assumedValue = assumedValue;
    }

    //***** CReal *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    private CReal(Builder builder) {
        this.setConstraint( builder.constraint );
        this.setDefaultValue( builder.defaultValue );
        this.setAssumedValue( builder.assumedValue );
    }

    public static class Builder {
        private final List<Interval<Double>> constraint;  //required
        private Double defaultValue;
        private Double assumedValue;

        public Builder (
                List<Interval<Double>> constraint
        ){
            if ( constraint == null ) {
                throw new NullPointerException("Property:constraint has cardinality NonNull, but is null");
            }
            this.constraint = constraint;
        }

        public Builder setDefaultValue(Double value) {
            this.defaultValue = defaultValue;
            return this;
        }

        public Builder setAssumedValue(Double value) {
            this.assumedValue = assumedValue;
            return this;
        }

        public CReal build(){
            return new CReal( this );
        }
    }


    //***** CReal *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CReal that = (CReal) object;
        return
            Objects.equals(constraint, that.constraint) &&
            Objects.equals(defaultValue, that.defaultValue) &&
            Objects.equals(assumedValue, that.assumedValue);
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
            "CReal {" +
            "constraint='" + constraint + '\'' +
            "defaultValue='" + defaultValue + '\'' +
            "assumedValue='" + assumedValue + '\'' +
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

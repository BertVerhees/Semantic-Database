package nl.rosa.semanticdatabase.aom_2.constraint_model_package;

import java.util.*;

import nl.rosa.semanticdatabase.foundation_types.interval.MultiplicityInterval;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Boolean;

/**
 * 
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Constraint on instances of String.
 * 
*/
public class CString extends CPrimitiveObject {

    //***** CString *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * String constraint - a list of literal strings and / or regular expression strings delimited by the ‘/’ character.
 * cardinality: 1..1 (redefined)
 * 
*/
    private List<String> constraint = new ArrayList<>();

/**
 * 
 * Default String value.
 * cardinality: 0..1 (redefined)
 * 
*/
    private String defaultValue;

/**
 * 
 * Assumed String value.
 * cardinality: 0..1 (redefined)
 * 
*/
    private String assumedValue;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * String constraint - a list of literal strings and / or regular expression strings delimited by the ‘/’ character.
 * cardinality: 1..1 (redefined)
 * 
*/

    public void addToConstraint(String value ) {
        constraint.add( value);
    }

    public void addToConstraint(List<String> values ) {
        values.forEach(value -> addToConstraint(value));
    }

    public void removeFromConstraint(String item ) {
        if (constraint != null ) {
            constraint.remove(item);
        }
    }
    public void removeFromConstraint( Collection<String> values ) {
        values.forEach(this::removeFromConstraint);
    }
    public List<String> getConstraint() {
        return this.constraint;
    }
    public CString setConstraint(List<String> constraint) {
        if (constraint == null ) {
            throw new NullPointerException(" constraint has cardinality NonNull, but is null");
        }
        this.constraint = constraint;
        return this;
    }
    public List<String> constraint() {
        return Collections.unmodifiableList(this.constraint);
    }

/**
 * 
 * Default String value.
 * cardinality: 0..1 (redefined)
 * 
*/
    public String getDefaultValue() {
        return defaultValue;
    }
    public void setDefaultValue(String value) {
        this.defaultValue = defaultValue;
    }

/**
 * 
 * Assumed String value.
 * cardinality: 0..1 (redefined)
 * 
*/
    public String getAssumedValue() {
        return assumedValue;
    }
    public void setAssumedValue(String value) {
        this.assumedValue = assumedValue;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * cardinality: 1..1 (effected)
 * 
*/
    public String  prototypeValue() {
        String  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if a_value is valid with respect to constraint expressed in concrete instance of this type.
 * cardinality: 1..1 (effected)
 * 
*/
    public Boolean  validValue(String a_value) {
        if (a_value == null ) {
            throw new NullPointerException("Parameter a_value has cardinality NonNull, but is null.");
        }
        Boolean  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if any value (i.e.
 * instance) of the reference model type would be allowed.
 * Redefined in descendants.
 * cardinality: 1..1 (effected)
 * 
*/
    public Boolean anyAllowed() {
        Boolean result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if other.any_allowed or else every constraint in the constraint list exists in the other.constraint.
 * cardinality: 1..1 (effected)
 * 
*/
    public Boolean  cValueConformsTo(CString other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Boolean  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if the items in constraint are equal in number and identical pair-wise with those in other.constraint.
 * cardinality: 1..1 (effected)
 * 
*/
    public Boolean  cValueCongruentTo(CString other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Boolean  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** CString *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected CString() {}

    public CString(
            List<String> constraint,
            String defaultValue,
            String assumedValue,
            Boolean isEnumeratedTypeConstraint,
            String rmTypeName,
            MultiplicityInterval occurrences,
            String nodeId,
            Boolean isDeprecated,
            SiblingOrder siblingOrder,
            ArchetypeConstraint parent,
            CSecondOrder socParent
        ){
        super(
                assumedValue,
            isEnumeratedTypeConstraint,
            constraint,
            defaultValue,
            rmTypeName,
            occurrences,
            nodeId,
            isDeprecated,
            siblingOrder,
            parent,
            socParent
        );
        this.defaultValue = defaultValue;
    }

    private CString(Builder builder) {
        this.setConstraint( builder.constraint );
        this.setDefaultValue( builder.defaultValue );
        this.setAssumedValue( builder.assumedValue );
        this.setAssumedValue( builder.assumedValue );
        this.setIsEnumeratedTypeConstraint( builder.isEnumeratedTypeConstraint );
        this.setConstraint( builder.constraint );
        this.setDefaultValue( builder.defaultValue );
        this.setRmTypeName( builder.rmTypeName );
        this.setOccurrences( builder.occurrences );
        this.setNodeId( builder.nodeId );
        this.setIsDeprecated( builder.isDeprecated );
        this.setSiblingOrder( builder.siblingOrder );
        this.setParent( builder.parent );
        this.setSocParent( builder.socParent );
    }

    public static class Builder {
        private final List<String> constraint;  //required
        private String defaultValue;
        private String assumedValue;
        private Boolean isEnumeratedTypeConstraint;
        private final String rmTypeName;  //required
        private MultiplicityInterval occurrences;
        private final String nodeId;  //required
        private Boolean isDeprecated;
        private SiblingOrder siblingOrder;
        private ArchetypeConstraint parent;
        private CSecondOrder socParent;

        public Builder (
            List<String> constraint,
            String rmTypeName,
            String nodeId
        ){
            if ( constraint == null ) {
                throw new NullPointerException("Property:constraint has cardinality NonNull, but is null");
            }
            if ( rmTypeName == null ) {
                throw new NullPointerException("Property:rmTypeName has cardinality NonNull, but is null");
            }
            if ( nodeId == null ) {
                throw new NullPointerException("Property:nodeId has cardinality NonNull, but is null");
            }
            this.constraint = constraint;
            this.rmTypeName = rmTypeName;
            this.nodeId = nodeId;
        }

        public Builder setDefaultValue(String value) {
            this.defaultValue = defaultValue;
            return this;
        }

        public Builder setAssumedValue(String value) {
            this.assumedValue = assumedValue;
            return this;
        }

        public Builder setAssumedValue(Object value) {
            this.assumedValue = assumedValue;
            return this;
        }

        public Builder setIsEnumeratedTypeConstraint(Boolean value) {
            this.isEnumeratedTypeConstraint = isEnumeratedTypeConstraint;
            return this;
        }

        public Builder setDefaultValue(Object value) {
            this.defaultValue = defaultValue;
            return this;
        }

        public Builder setOccurrences(MultiplicityInterval value) {
            this.occurrences = occurrences;
            return this;
        }

        public Builder setIsDeprecated(Boolean value) {
            this.isDeprecated = isDeprecated;
            return this;
        }

        public Builder setSiblingOrder(SiblingOrder value) {
            this.siblingOrder = siblingOrder;
            return this;
        }

        public Builder setParent(ArchetypeConstraint value) {
            this.parent = parent;
            return this;
        }

        public Builder setSocParent(CSecondOrder value) {
            this.socParent = socParent;
            return this;
        }

        public CString build(){
            return new CString( this );
        }
    }


    //***** CString *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CString that = (CString) object;
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
            "CString {" +
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

package nl.rosa.semanticdatabase.aom2.constraint_model_package;

import java.util.Objects;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Boolean;

/**
 * 
 * #Generated: 2020-11-24T17:57:46.357+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Constraint on instances of Boolean.
 * Both attributes cannot be set to False, since this would mean that the Boolean value being constrained cannot be True or False.
 * 
*/
public class CBoolean extends CPrimitiveObject {

    //***** CBoolean *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Boolean constraint - a list of Boolean values.
 * cardinality: 0..1 (redefined)
 * 
*/
    private List<Boolean> constraint;

/**
 * 
 * Assumed Boolean value.
 * cardinality: 0..1 (redefined)
 * 
*/
    private Boolean assumedValue;

/**
 * 
 * Default Boolean value.
 * cardinality: 0..1 (redefined)
 * 
*/
    private Boolean defaultValue;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Boolean constraint - a list of Boolean values.
 * cardinality: 0..1 (redefined)
 * 
*/

    public void addToConstraint(Boolean value ) {
        if (constraint == null ) {
            constraint = new ArrayList<> ();
        }
        constraint.add( value);
    }

    public void addToConstraint(List<Boolean> values ) {
        values.forEach(value -> addToConstrain(value));
    }

    public void removeFromConstraint(Boolean item ) {
        if (constraint != null ) {
            constraint.remove(item);
        }
    }
    public void removeFromConstraint( Collection <Boolean> values ) {
        values.forEach(this::removeFromConstraint);
    }
    List<Boolean> getConstraint() {
        return this.constraint;
    }
    public CBoolean setConstraint(List<Boolean> constraint) {
        this.constraint = constraint;
        return this;
    }
    public List<Boolean> constraint() {
        return Collections.unmodifiableList(this.constraint);
    }

/**
 * 
 * Assumed Boolean value.
 * cardinality: 0..1 (redefined)
 * 
*/
    public Boolean getAssumedValue() {
        return assumedValue;
    }
    public void setAssumedValue(Boolean value) {
        this.assumedValue = assumedValue;
    }

/**
 * 
 * Default Boolean value.
 * cardinality: 0..1 (redefined)
 * 
*/
    public Boolean getDefaultValue() {
        return defaultValue;
    }
    public void setDefaultValue(Boolean value) {
        this.defaultValue = defaultValue;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Prototype Boolean value.
 * cardinality: 1..1 (effected)
 * 
*/
    public Boolean  prototypeValue() {
        Boolean  result;


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
    public Result = constraint.is_empty  anyAllowed() {
        Result = constraint.is_empty  result;


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
    public Boolean  cValueConformsTo(CBoolean other) {
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
 * True if the items in constraint are equal in number and identical pair-wise with those in other.constraint.
 * cardinality: 1..1 (effected)
 * 
*/
    public Boolean  cValueCongruentTo(CBoolean other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** CBoolean *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected CBoolean() {}

    public CBoolean(
            List<boolean> constraint,
            Boolean assumedValue,
            Boolean defaultValue,
            Any assumedValue,
            Boolean isEnumeratedTypeConstraint,
            Any constraint,
            Any defaultValue,
            String rmTypeName,
            MultiplicityInterval occurrences,
            String nodeId,
            Boolean isDeprecated,
            SiblingOrder siblingOrder,
            ArchetypeConstraint parent,
            CSecondOrder socParent
        ){
        super( 
            isEnumeratedTypeConstraint,
            rmTypeName,
            occurrences,
            nodeId,
            isDeprecated,
            siblingOrder,
            parent,
            socParent
        );
        this.constraint = constraint;
        this.assumedValue = assumedValue;
        this.defaultValue = defaultValue;
    }

    private CBoolean(Builder builder) {
        this.setConstraint( builder.constraint );
        this.setAssumedValue( builder.assumedValue );
        this.setDefaultValue( builder.defaultValue );
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
        private List<boolean> constraint;
        private Boolean assumedValue;
        private Boolean defaultValue;
        private Any assumedValue;
        private Boolean isEnumeratedTypeConstraint;
        private final Any constraint;  //required
        private Any defaultValue;
        private final String rmTypeName;  //required
        private MultiplicityInterval occurrences;
        private final String nodeId;  //required
        private Boolean isDeprecated;
        private SiblingOrder siblingOrder;
        private ArchetypeConstraint parent;
        private CSecondOrder socParent;

        public Builder (
            Any constraint,
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

        public Builder setConstraint(List<boolean> value) {
            this.constraint = constraint;
            return this;
        }

        public Builder setAssumedValue(Boolean value) {
            this.assumedValue = assumedValue;
            return this;
        }

        public Builder setDefaultValue(Boolean value) {
            this.defaultValue = defaultValue;
            return this;
        }

        public Builder setAssumedValue(Any value) {
            this.assumedValue = assumedValue;
            return this;
        }

        public Builder setIsEnumeratedTypeConstraint(Boolean value) {
            this.isEnumeratedTypeConstraint = isEnumeratedTypeConstraint;
            return this;
        }

        public Builder setDefaultValue(Any value) {
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

        public CBoolean build(){
            return new CBoolean( this );
        }
    }


    //***** CBoolean *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CBoolean that = (CBoolean) object;
        return
            Objects.equals(constraint, that.constraint) &&
            Objects.equals(assumedValue, that.assumedValue) &&
            Objects.equals(defaultValue, that.defaultValue);
        }
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            constraint,
            assumedValue,
            defaultValue
        );
    }

    @Override
    public String toString() {
        return
            "CBoolean {" +
            "constraint='" + constraint + '\''; +
            "assumedValue='" + assumedValue + '\''; +
            "defaultValue='" + defaultValue + '\''; +
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

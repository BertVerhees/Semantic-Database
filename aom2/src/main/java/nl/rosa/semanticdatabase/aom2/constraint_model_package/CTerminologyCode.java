package nl.rosa.semanticdatabase.aom2.constraint_model_package;

import java.util.Objects;
import nl.rosa.semanticdatabase.foundation_types.terminology_package.TerminologyCode;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Boolean;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Uri;

/**
 * 
 * #Generated: 2020-11-24T18:12:03.636+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Constrainer type for instances of Terminology_code.
 * The constraint attribute can contain: a single at-code a single ac-code, representing a value-set that is defined in the archetype terminology If there is an assumed value for the ac-code case above, the assumed_value attribute contains a single at-code, which must come from the list of at-codes defined as the internal value set for the ac-code.
 * The constraint_status attribute and constraint_required() function together define whether the constraint is considered formal ('required') or not.
 * In the non-required cases, a data-item matched to this constraint may be any coded term.
 * 
*/
public class CTerminologyCode extends CPrimitiveObject {

    //***** CTerminologyCode *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Constraint status of this terminology constraint.
 * If Void, equivalent to the value required.
 * cardinality: 0..1
 * 
*/
    private ConstraintStatus constraintStatus;

/**
 * 
 * Type of individual constraint - a single string that can either be a local at-code, or a local ac-code signifying a locally defined value set.
 * If an ac-code, assumed_value may contain an at-code from the value set of the ac-code.
 * cardinality: 1..1 (redefined)
 * 
*/
    private String constraint;

/**
 * 
 * Assumed Terminology code value.
 * cardinality: 0..1 (redefined)
 * 
*/
    private TerminologyCode assumedValue;

/**
 * 
 * cardinality: 0..1 (redefined)
 * 
*/
    private TerminologyCode defaultValue;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Constraint status of this terminology constraint.
 * If Void, equivalent to the value required.
 * cardinality: 0..1
 * 
*/
    public ConstraintStatus getConstraintStatus() {
        return constraintStatus;
    }
    public void setConstraintStatus(ConstraintStatus value) {
        this.constraintStatus = constraintStatus;
    }

/**
 * 
 * Type of individual constraint - a single string that can either be a local at-code, or a local ac-code signifying a locally defined value set.
 * If an ac-code, assumed_value may contain an at-code from the value set of the ac-code.
 * cardinality: 1..1 (redefined)
 * 
*/
    public String getConstraint() {
        return constraint;
    }
    public void setConstraint(String value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:constraint failed, it has cardinality NonNull, but is null");
        }
        this.constraint = constraint;
    }

/**
 * 
 * Assumed Terminology code value.
 * cardinality: 0..1 (redefined)
 * 
*/
    public TerminologyCode getAssumedValue() {
        return assumedValue;
    }
    public void setAssumedValue(TerminologyCode value) {
        this.assumedValue = assumedValue;
    }

/**
 * 
 * cardinality: 0..1 (redefined)
 * 
*/
    public TerminologyCode getDefaultValue() {
        return defaultValue;
    }
    public void setDefaultValue(TerminologyCode value) {
        this.defaultValue = defaultValue;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * True if constraint_status is defined and equals required OR if Void.
 * I.e.
 * in archetypes where C_TERMINOLOGY_CODE instances have no constraint_status, the required status is assumed, which applies to all legacy archetypes.
 * cardinality: 1..1
 * 
*/
    public Boolean  constraintRequired() {
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Effective set of at-code values corresponding to an ac-code for a locally defined value set.
 * Not defined for ac-codes that have no local value set.
 * cardinality: 0..1
 * 
*/
    public List<String>  valueSetExpanded() {
        List<String>  result;


        return  result;
    }

/**
 * 
 * For locally defined value sets within individual code bindings: return the term URI(s) substituted from bindings for local at-codes in value_set_expanded.
 * cardinality: 0..1
 * 
*/
    public List<Uri>  valueSetSubstituted() {
        List<Uri>  result;


        return  result;
    }

/**
 * 
 * For locally defined value sets within individual code bindings: final set of external codes to which value set is resolved.
 * cardinality: 0..1
 * 
*/
    public List<TerminologyCode>  valueSetResolved() {
        List<TerminologyCode>  result;


        return  result;
    }

/**
 * 
 * True if a value is valid with respect to constraint expressed in concrete instance of this type.
 * cardinality: 1..1 (effected)
 * 
*/
    public Boolean  validValue(TerminologyCode a_value) {
        if (a_value == null ) {
            throw new NullPointerException("Parameter a_value has cardinality NonNull, but is null.");
        }
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * A generated prototype value from this constraint object.
 * cardinality: 1..1 (effected)
 * 
*/
    public TerminologyCode  prototypeValue() {
        TerminologyCode  result;


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
    public = constraint.is_empty  anyAllowed() {
        = constraint.is_empty  result;


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
    public Boolean  cValueConformsTo(CTerminologyCode other) {
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
 * True if constraint and other.constraint are both value-set ids, and expand to identical value sets, or else are identical value codes.
 * cardinality: 1..1 (effected)
 * 
*/
    public Boolean  cValueCongruentTo(CTerminologyCode other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** CTerminologyCode *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected CTerminologyCode() {}

    public CTerminologyCode(
            ConstraintStatus constraintStatus,
            String constraint,
            TerminologyCode assumedValue,
            TerminologyCode defaultValue,
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
        if ( constraint == null ) {
            throw new NullPointerException("Property:constraint has cardinality NonNull, but is null");
        }
        this.constraintStatus = constraintStatus;
        this.constraint = constraint;
        this.assumedValue = assumedValue;
        this.defaultValue = defaultValue;
    }

    private CTerminologyCode(Builder builder) {
        this.setConstraintStatus( builder.constraintStatus );
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
        private ConstraintStatus constraintStatus;
        private final String constraint;  //required
        private TerminologyCode assumedValue;
        private TerminologyCode defaultValue;
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
            String constraint,
            Any constraint,
            String rmTypeName,
            String nodeId
        ){
            if ( constraint == null ) {
                throw new NullPointerException("Property:constraint has cardinality NonNull, but is null");
            }
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
            this.constraint = constraint;
            this.rmTypeName = rmTypeName;
            this.nodeId = nodeId;
        }

        public Builder setConstraintStatus(ConstraintStatus value) {
            this.constraintStatus = constraintStatus;
            return this;
        }

        public Builder setAssumedValue(TerminologyCode value) {
            this.assumedValue = assumedValue;
            return this;
        }

        public Builder setDefaultValue(TerminologyCode value) {
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

        public CTerminologyCode build(){
            return new CTerminologyCode( this );
        }
    }


    //***** CTerminologyCode *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CTerminologyCode that = (CTerminologyCode) object;
        return
            Objects.equals(constraintStatus, that.constraintStatus) &&
            Objects.equals(constraint, that.constraint) &&
            Objects.equals(assumedValue, that.assumedValue) &&
            Objects.equals(defaultValue, that.defaultValue);
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            constraintStatus,
            constraint,
            assumedValue,
            defaultValue
        );
    }

    @Override
    public String toString() {
        return
            "CTerminologyCode {" +
            "constraintStatus='" + constraintStatus + '\'' +
            "constraint='" + constraint + '\'' +
            "assumedValue='" + assumedValue + '\'' +
            "defaultValue='" + defaultValue + '\'' +
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

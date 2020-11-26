package nl.rosa.semanticdatabase.aom_2.constraint_model_package;

import java.util.List;
import java.util.Objects;

import nl.rosa.semanticdatabase.foundation_types.interval.MultiplicityInterval;
import nl.rosa.semanticdatabase.foundation_types.overview.Any;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Boolean;

/**
 * 
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Constraint on complex objects, i.e.
 * any object that consists of other object constraints.
 * 
*/
public class CComplexObject extends CDefinedObject {

    //***** CComplexObject *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * List of constraints on attributes of the reference model type represented by this object.
 * cardinality: 0..1
 * 
*/
    private List<CAttribute> attributes;

/**
 * 
 * List of attribute tuple constraints under this object constraint, if any.
 * cardinality: 0..1
 * 
*/
    private List<CAttributeTuple> attributeTuples;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * List of constraints on attributes of the reference model type represented by this object.
 * cardinality: 0..1
 * 
*/

    public void addToAttribute(CAttribute value ) {
        if (attributes == null ) {
            attributes = new ArrayList<> ();
        }
        attributes.add( value);
    }

    public void addToAttributes(List<CAttribute> values ) {
        values.forEach(value -> addToAttribute(value));
    }

    public void removeFromAttribute(CAttribute item ) {
        if (attributes != null ) {
            attributes.remove(item);
        }
    }
    public void removeFromAttributes( Collection <CAttribute> values ) {
        values.forEach(this::removeFromAttribute);
    }
    List<CAttribute> getAttributes() {
        return this.attributes;
    }
    public CComplexObject setAttributes(List<CAttribute> attributes) {
        this.attributes = attributes;
        return this;
    }
    public List<CAttribute> attributes() {
        return Collections.unmodifiableList(this.attributes);
    }

/**
 * 
 * List of attribute tuple constraints under this object constraint, if any.
 * cardinality: 0..1
 * 
*/

    public void addToAttributeTuple(CAttributeTuple value ) {
        if (attributeTuples == null ) {
            attributeTuples = new ArrayList<> ();
        }
        attributeTuples.add( value);
    }

    public void addToAttributeTuples(List<CAttributeTuple> values ) {
        values.forEach(value -> addToAttributetuple(value));
    }

    public void removeFromAttributeTuple(CAttributeTuple item ) {
        if (attributeTuples != null ) {
            attributeTuples.remove(item);
        }
    }
    public void removeFromAttributeTuples( Collection <CAttributeTuple> values ) {
        values.forEach(this::removeFromAttributeTuple);
    }
    List<CAttributeTuple> getAttributeTuples() {
        return this.attributeTuples;
    }
    public CComplexObject setAttributeTuples(List<CAttributeTuple> attributeTuples) {
        this.attributeTuples = attributeTuples;
        return this;
    }
    public List<CAttributeTuple> attributeTuples() {
        return Collections.unmodifiableList(this.attributeTuples);
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * True if any value (i.e.
 * instance) of the reference model type would be allowed.
 * Redefined in descendants.
 * cardinality: 1..1 (effected)
 * 
*/
    public Result = attributes.is_empty and not is_prohibited  anyAllowed() {
        Result = attributes.is_empty and not is_prohibited  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if constraints represented by this node, ignoring any sub-parts, are narrower or the same as other.
 * Typically used during validation of special-ised archetype nodes.
 * Parameters rmcc Reference Model conformance checker agent (lambda).
 * cardinality: 1..1 (effected)
 * 
*/
    public Boolean  cConformsTo(CComplexObject other, FUNCTION<> rmcc,  ,  ) {
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
 * True if constraints represented by this node contain no further redefinitions with respect to the node other, with the exception of node_id redefnition in C_OBJECT nodes.
 * Typically used to test if an inherited node locally contains any constraints.
 * cardinality: 1..1 (effected)
 * 
*/
    public Boolean  cCongruentTo(CComplexObject other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Boolean  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** CComplexObject *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected CComplexObject() {}

    public CComplexObject(
            List<CAttribute> attributes,
            List<CAttributeTuple> attributeTuples,
            Object defaultValue,
            String rmTypeName,
            MultiplicityInterval occurrences,
            String nodeId,
            Boolean isDeprecated,
            SiblingOrder siblingOrder,
            ArchetypeConstraint parent,
            CSecondOrder socParent
        ){
        super( 
            defaultValue,
            rmTypeName,
            occurrences,
            nodeId,
            isDeprecated,
            siblingOrder,
            parent,
            socParent
        );
        this.attributes = attributes;
        this.attributeTuples = attributeTuples;
    }

    private CComplexObject(Builder builder) {
        this.setAttributes( builder.attributes );
        this.setAttributeTuples( builder.attributeTuples );
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
        private List<cAttribute> attributes;
        private List<cAttributeTuple> attributeTuples;
        private Any defaultValue;
        private final String rmTypeName;  //required
        private MultiplicityInterval occurrences;
        private final String nodeId;  //required
        private Boolean isDeprecated;
        private SiblingOrder siblingOrder;
        private ArchetypeConstraint parent;
        private CSecondOrder socParent;

        public Builder (
            String rmTypeName,
            String nodeId
        ){
            if ( rmTypeName == null ) {
                throw new NullPointerException("Property:rmTypeName has cardinality NonNull, but is null");
            }
            if ( nodeId == null ) {
                throw new NullPointerException("Property:nodeId has cardinality NonNull, but is null");
            }
            this.rmTypeName = rmTypeName;
            this.nodeId = nodeId;
        }

        public Builder setAttributes(List<cAttribute> value) {
            this.attributes = attributes;
            return this;
        }

        public Builder setAttributeTuples(List<cAttributeTuple> value) {
            this.attributeTuples = attributeTuples;
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

        public CComplexObject build(){
            return new CComplexObject( this );
        }
    }


    //***** CComplexObject *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CComplexObject that = (CComplexObject) object;
        return
            Objects.equals(attributes, that.attributes) &&
            Objects.equals(attributeTuples, that.attributeTuples);
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            attributes,
            attributeTuples
        );
    }

    @Override
    public String toString() {
        return
            "CComplexObject {" +
            "attributes='" + attributes + '\'' +
            "attributeTuples='" + attributeTuples + '\'' +
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

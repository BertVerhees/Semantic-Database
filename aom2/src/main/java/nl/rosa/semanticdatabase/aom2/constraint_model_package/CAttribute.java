package nl.rosa.semanticdatabase.aom2.constraint_model_package;

import java.util.Objects;
import nl.rosa.semanticdatabase.foundation_types.interval.MultiplicityInterval;
import nl.rosa.semanticdatabase.foundation_types.interval.Cardinality;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Boolean;

/**
 * 
 * #Generated: 2020-11-24T17:57:46.357+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Abstract model of constraint on any kind of attribute in a class model.
 * 
*/
public class CAttribute extends ArchetypeConstraint {

    //***** CAttribute *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Reference model attribute within the enclosing type represented by a C_OBJECT.
 * cardinality: 1..1
 * 
*/
    private String rmAttributeName;

/**
 * 
 * Constraint settable on every attribute, regardless of whether it is singular or of a container type, which indicates whether its target object exists or not (i.e.
 * is mandatory or not).
 * Only set if it overrides the underlying reference model or parent archetype in the case of specialised archetypes.
 * cardinality: 0..1
 * 
*/
    private MultiplicityInterval existence;

/**
 * 
 * Child C_OBJECT nodes.
 * Each such node represents a constraint on the type of this attribute in its reference model.
 * Multiples occur both for multiple items in the case of container attributes, and alternatives in the case of singular attributes.
 * cardinality: 0..1
 * 
*/
    private List<CObject> children;

/**
 * 
 * Path to the parent object of this attribute (i.e.
 * doesn’t include the name of this attribute).
 * Used only for attributes in differential form, specialised archetypes.
 * Enables only the re-defined parts of a specialised archetype to be expressed, at the path where they occur.
 * cardinality: 0..1
 * 
*/
    private String differentialPath;

/**
 * 
 * Cardinality constraint of attribute, if a container attribute.
 * cardinality: 0..1
 * 
*/
    private Cardinality cardinality;

/**
 * 
 * Flag indicating whether this attribute constraint is on a container (i.e.
 * multiply-valued) attribute.
 * cardinality: 1..1
 * 
*/
    private Boolean isMultiple;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Reference model attribute within the enclosing type represented by a C_OBJECT.
 * cardinality: 1..1
 * 
*/
    public String getRmAttributeName() {
        return rmAttributeName;
    }
    public void setRmAttributeName(String value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:rmAttributeName failed, it has cardinality NonNull, but is null");
        }
        this.rmAttributeName = rmAttributeName;
    }

/**
 * 
 * Constraint settable on every attribute, regardless of whether it is singular or of a container type, which indicates whether its target object exists or not (i.e.
 * is mandatory or not).
 * Only set if it overrides the underlying reference model or parent archetype in the case of specialised archetypes.
 * cardinality: 0..1
 * 
*/
    public MultiplicityInterval getExistence() {
        return existence;
    }
    public void setExistence(MultiplicityInterval value) {
        this.existence = existence;
    }

/**
 * 
 * Child C_OBJECT nodes.
 * Each such node represents a constraint on the type of this attribute in its reference model.
 * Multiples occur both for multiple items in the case of container attributes, and alternatives in the case of singular attributes.
 * cardinality: 0..1
 * 
*/

    public void addToChildren(CObject value ) {
        if (children == null ) {
            children = new ArrayList<> ();
        }
        children.add( value);
    }

    public void addToChildren(List<CObject> values ) {
        values.forEach(value -> addToChildre(value));
    }

    public void removeFromChildren(CObject item ) {
        if (children != null ) {
            children.remove(item);
        }
    }
    public void removeFromChildren( Collection <CObject> values ) {
        values.forEach(this::removeFromChildren);
    }
    List<CObject> getChildren() {
        return this.children;
    }
    public CAttribute setChildren(List<CObject> children) {
        this.children = children;
        return this;
    }
    public List<CObject> children() {
        return Collections.unmodifiableList(this.children);
    }

/**
 * 
 * Path to the parent object of this attribute (i.e.
 * doesn’t include the name of this attribute).
 * Used only for attributes in differential form, specialised archetypes.
 * Enables only the re-defined parts of a specialised archetype to be expressed, at the path where they occur.
 * cardinality: 0..1
 * 
*/
    public String getDifferentialPath() {
        return differentialPath;
    }
    public void setDifferentialPath(String value) {
        this.differentialPath = differentialPath;
    }

/**
 * 
 * Cardinality constraint of attribute, if a container attribute.
 * cardinality: 0..1
 * 
*/
    public Cardinality getCardinality() {
        return cardinality;
    }
    public void setCardinality(Cardinality value) {
        this.cardinality = cardinality;
    }

/**
 * 
 * Flag indicating whether this attribute constraint is on a container (i.e.
 * multiply-valued) attribute.
 * cardinality: 1..1
 * 
*/
    public Boolean getIsMultiple() {
        return isMultiple;
    }
    public void setIsMultiple(Boolean value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:isMultiple failed, it has cardinality NonNull, but is null");
        }
        this.isMultiple = isMultiple;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * True if there is no effective constraint on the children of the RM attribute to which this C_ATTRIBUTE refers.
 * cardinality: 1..1
 * 
*/
    public = children.is_empty and not is_prohibited  anyAllowed() {
        = children.is_empty and not is_prohibited  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if this C_ATTRIBUTE has an existence constraint of 1..1, i..e.
 * mandation.
 * cardinality: 1..1
 * 
*/
    public Result = existence /= Void and then existence.is_mandatory  isMandatory() {
        Result = existence /= Void and then existence.is_mandatory  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Path of this attribute with respect to owning C_OBJECT, including differential path where applicable.
 * cardinality: 1..1
 * 
*/
    public String  rmAttributePath() {
        String  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if this node logically represents a single-valued attribute.
 * Evaluated as not is_multiple.
 * cardinality: 1..1
 * 
*/
    public Boolean  isSingle() {
        Boolean  result;


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
    public Result = existence = Void and is_single and other.is_single) or (is_multiple and other.is_multiple and cardinality = Void  cCongruentTo(ArchetypeConstraint other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Result = existence = Void and is_single and other.is_single) or (is_multiple and other.is_multiple and cardinality = Void  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if constraints represented by this node, ignoring any sub-parts, are narrower or the same as other.
 * Typically used during validation of special-ised archetype nodes.
 * cardinality: 1..1 (effected)
 * 
*/
    public Result = existence_conforms_to (other) and is_single and other.is_single) or else (is_multiple and cardinality_conforms_to (other)  cConformsTo(ArchetypeConstraint other, FUNCTION<> rmcc,  ,  ) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Result = existence_conforms_to (other) and is_single and other.is_single) or else (is_multiple and cardinality_conforms_to (other)  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if this C_ATTRIBUTE has an existence constraint of 0..0, i.e.
 * prohibition.
 * cardinality: 1..1 (effected)
 * 
*/
    public Result = existence /= Void and then existence.is_prohibited  isProhibited() {
        Result = existence /= Void and then existence.is_prohibited  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** CAttribute *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected CAttribute() {}

    public CAttribute(
            String rmAttributeName,
            MultiplicityInterval existence,
            List<cObject> children,
            String differentialPath,
            Cardinality cardinality,
            Boolean isMultiple,
            ArchetypeConstraint parent,
            CSecondOrder socParent
        ){
        super( 
            parent,
            socParent
        );
        if ( rmAttributeName == null ) {
            throw new NullPointerException("Property:rmAttributeName has cardinality NonNull, but is null");
        }
        if ( isMultiple == null ) {
            throw new NullPointerException("Property:isMultiple has cardinality NonNull, but is null");
        }
        this.rmAttributeName = rmAttributeName;
        this.existence = existence;
        this.children = children;
        this.differentialPath = differentialPath;
        this.cardinality = cardinality;
        this.isMultiple = isMultiple;
    }

    private CAttribute(Builder builder) {
        this.setRmAttributeName( builder.rmAttributeName );
        this.setExistence( builder.existence );
        this.setChildren( builder.children );
        this.setDifferentialPath( builder.differentialPath );
        this.setCardinality( builder.cardinality );
        this.setIsMultiple( builder.isMultiple );
        this.setParent( builder.parent );
        this.setSocParent( builder.socParent );
    }

    public static class Builder {
        private final String rmAttributeName;  //required
        private MultiplicityInterval existence;
        private List<cObject> children;
        private String differentialPath;
        private Cardinality cardinality;
        private final Boolean isMultiple;  //required
        private ArchetypeConstraint parent;
        private CSecondOrder socParent;

        public Builder (
            String rmAttributeName,
            Boolean isMultiple
        ){
            if ( rmAttributeName == null ) {
                throw new NullPointerException("Property:rmAttributeName has cardinality NonNull, but is null");
            }
            if ( isMultiple == null ) {
                throw new NullPointerException("Property:isMultiple has cardinality NonNull, but is null");
            }
            this.rmAttributeName = rmAttributeName;
            this.isMultiple = isMultiple;
        }

        public Builder setExistence(MultiplicityInterval value) {
            this.existence = existence;
            return this;
        }

        public Builder setChildren(List<cObject> value) {
            this.children = children;
            return this;
        }

        public Builder setDifferentialPath(String value) {
            this.differentialPath = differentialPath;
            return this;
        }

        public Builder setCardinality(Cardinality value) {
            this.cardinality = cardinality;
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

        public CAttribute build(){
            return new CAttribute( this );
        }
    }


    //***** CAttribute *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CAttribute that = (CAttribute) object;
        return
            Objects.equals(rmAttributeName, that.rmAttributeName) &&
            Objects.equals(existence, that.existence) &&
            Objects.equals(children, that.children) &&
            Objects.equals(differentialPath, that.differentialPath) &&
            Objects.equals(cardinality, that.cardinality) &&
            Objects.equals(isMultiple, that.isMultiple);
        }
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            rmAttributeName,
            existence,
            children,
            differentialPath,
            cardinality,
            isMultiple
        );
    }

    @Override
    public String toString() {
        return
            "CAttribute {" +
            "rmAttributeName='" + rmAttributeName + '\''; +
            "existence='" + existence + '\''; +
            "children='" + children + '\''; +
            "differentialPath='" + differentialPath + '\''; +
            "cardinality='" + cardinality + '\''; +
            "isMultiple='" + isMultiple + '\''; +
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

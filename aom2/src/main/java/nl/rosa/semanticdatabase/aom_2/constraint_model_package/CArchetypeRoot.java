package nl.rosa.semanticdatabase.aom_2.constraint_model_package;

import nl.rosa.semanticdatabase.foundation_types.interval.MultiplicityInterval;
import nl.rosa.semanticdatabase.foundation_types.overview.Any;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Boolean;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.String;

import java.util.List;
import java.util.Objects;

/**
 * 
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * A specialisation of C_COMPLEX_OBJECT whose node_id attribute is an archetype identifier rather than the normal internal node code (i.e.
 * id-code).
 * Used in two situations.
 * The first is to represent an 'external reference' to an archetype from within another archetype or template.
 * This supports re-use.
 * The second use is within a template, where it is used as a slot-filler.
 * For a new external reference, the node_id is set in the normal way, i.e.
 * with a new code at the specialisation level of the archetype.
 * For a slot-filler or a redefined external reference, the node_id is set to a specialised version of the node_id of the node being specialised, allowing matching to occur during flattening.
 * In all uses within source archetypes and templates, the children attribute is Void.
 * In an operational template, the node_id is converted to the archetype_ref, and the structure contains the result of flattening any template overlay structure and the underlying flat archetype.
 * 
*/
public class CArchetypeRoot extends CComplexObject {

    //***** CArchetypeRoot *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Reference to archetype is being used to fill a slot or redefine an external reference.
 * Typically an 'interface' archetype id, i.e.
 * identifier with partial version information.
 * cardinality: 1..1
 * 
*/
    private String archetypeRef;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Reference to archetype is being used to fill a slot or redefine an external reference.
 * Typically an 'interface' archetype id, i.e.
 * identifier with partial version information.
 * cardinality: 1..1
 * 
*/
    public String getArchetypeRef() {
        return archetypeRef;
    }
    public void setArchetypeRef(String value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:archetypeRef failed, it has cardinality NonNull, but is null");
        }
        this.archetypeRef = archetypeRef;
    }

    //***** CArchetypeRoot *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected CArchetypeRoot() {}

    public CArchetypeRoot(
            String archetypeRef,
            List<CAttribute> attributes,
            List<CAttributeTuple> attributeTuples,
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
            attributes,
            attributeTuples,
            defaultValue,
            rmTypeName,
            occurrences,
            nodeId,
            isDeprecated,
            siblingOrder,
            parent,
            socParent
        );
        if ( archetypeRef == null ) {
            throw new NullPointerException("Property:archetypeRef has cardinality NonNull, but is null");
        }
        this.archetypeRef = archetypeRef;
    }

    private CArchetypeRoot(Builder builder) {
        this.setArchetypeRef( builder.archetypeRef );
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
        private final String archetypeRef;  //required
        private List<CAttribute> attributes;
        private List<CAttributeTuple> attributeTuples;
        private Any defaultValue;
        private final String rmTypeName;  //required
        private MultiplicityInterval occurrences;
        private final String nodeId;  //required
        private Boolean isDeprecated;
        private SiblingOrder siblingOrder;
        private ArchetypeConstraint parent;
        private CSecondOrder socParent;

        public Builder (
            String archetypeRef,
            String rmTypeName,
            String nodeId
        ){
            if ( archetypeRef == null ) {
                throw new NullPointerException("Property:archetypeRef has cardinality NonNull, but is null");
            }
            if ( rmTypeName == null ) {
                throw new NullPointerException("Property:rmTypeName has cardinality NonNull, but is null");
            }
            if ( nodeId == null ) {
                throw new NullPointerException("Property:nodeId has cardinality NonNull, but is null");
            }
            this.archetypeRef = archetypeRef;
            this.rmTypeName = rmTypeName;
            this.nodeId = nodeId;
        }

        public Builder setAttributes(List<CAttribute> value) {
            this.attributes = attributes;
            return this;
        }

        public Builder setAttributeTuples(List<CAttributeTuple> value) {
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

        public CArchetypeRoot build(){
            return new CArchetypeRoot( this );
        }
    }


    //***** CArchetypeRoot *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CArchetypeRoot that = (CArchetypeRoot) object;
        return
            Objects.equals(archetypeRef, that.archetypeRef);
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            archetypeRef
        );
    }

    @Override
    public java.lang.String toString() {
        return
            "CArchetypeRoot {" +
            "archetypeRef='" + archetypeRef + '\'' +
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

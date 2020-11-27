package nl.rosa.semanticdatabase.aom_2.constraint_model_package;

import java.util.*;

import nl.rosa.semanticdatabase.foundation_types.interval.MultiplicityInterval;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Boolean;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.String;

/**
 * 
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Constraint describing a slot' where another archetype can occur.
 * 
*/
public class ArchetypeSlot extends CObject {

    //***** ArchetypeSlot *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * List of constraints defining other archetypes that could be included at this point.
 * cardinality: 0..1
 * 
*/
    private List<ArchetypeIdConstraint> includes;

/**
 * 
 * List of constraints defining other archetypes that cannot be included at this point.
 * cardinality: 0..1
 * 
*/
    private List<ArchetypeIdConstraint> excludes;

/**
 * 
 * True if this slot specification in this artefact is closed to further filling either in further specialisations or at runtime.
 * Default value False, i.e.
 * unless explicitly set, a slot remains open.
 * cardinality: 1..1
 * 
*/
    private Boolean isClosed;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * List of constraints defining other archetypes that could be included at this point.
 * cardinality: 0..1
 * 
*/

    public void addToInclude(ArchetypeIdConstraint value ) {
        if (includes == null ) {
            includes = new ArrayList<>();
        }
        includes.add( value);
    }

    public void addToIncludes(List<ArchetypeIdConstraint> values ) {
        values.forEach(value -> addToInclude(value));
    }

    public void removeFromInclude(ArchetypeIdConstraint item ) {
        if (includes != null ) {
            includes.remove(item);
        }
    }
    public void removeFromIncludes( Collection<ArchetypeIdConstraint> values ) {
        values.forEach(this::removeFromInclude);
    }
    List<ArchetypeIdConstraint> getIncludes() {
        return this.includes;
    }
    public ArchetypeSlot setIncludes(List<ArchetypeIdConstraint> includes) {
        this.includes = includes;
        return this;
    }
    public List<ArchetypeIdConstraint> includes() {
        return Collections.unmodifiableList(this.includes);
    }

/**
 * 
 * List of constraints defining other archetypes that cannot be included at this point.
 * cardinality: 0..1
 * 
*/

    public void addToExclude(ArchetypeIdConstraint value ) {
        if (excludes == null ) {
            excludes = new ArrayList<> ();
        }
        excludes.add( value);
    }

    public void addToExcludes(List<ArchetypeIdConstraint> values ) {
        values.forEach(value -> addToExclude(value));
    }

    public void removeFromExclude(ArchetypeIdConstraint item ) {
        if (excludes != null ) {
            excludes.remove(item);
        }
    }
    public void removeFromExcludes( Collection <ArchetypeIdConstraint> values ) {
        values.forEach(this::removeFromExclude);
    }
    List<ArchetypeIdConstraint> getExcludes() {
        return this.excludes;
    }
    public ArchetypeSlot setExcludes(List<ArchetypeIdConstraint> excludes) {
        this.excludes = excludes;
        return this;
    }
    public List<ArchetypeIdConstraint> excludes() {
        return Collections.unmodifiableList(this.excludes);
    }

/**
 * 
 * True if this slot specification in this artefact is closed to further filling either in further specialisations or at runtime.
 * Default value False, i.e.
 * unless explicitly set, a slot remains open.
 * cardinality: 1..1
 * 
*/
    public Boolean getIsClosed() {
        return isClosed;
    }
    public void setIsClosed(Boolean value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:isClosed failed, it has cardinality NonNull, but is null");
        }
        this.isClosed = isClosed;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * True if no constraints stated, and slot is not closed.
 * cardinality: 1..1
 * 
*/
    public Boolean  anyAllowed() {
        Boolean  result = null;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** ArchetypeSlot *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected ArchetypeSlot() {}

    public ArchetypeSlot(
            List<ArchetypeIdConstraint> includes,
            List<ArchetypeIdConstraint> excludes,
            Boolean isClosed,
            String rmTypeName,
            MultiplicityInterval occurrences,
            String nodeId,
            Boolean isDeprecated,
            SiblingOrder siblingOrder,
            ArchetypeConstraint parent,
            CSecondOrder socParent
        ){
        super( 
            rmTypeName,
            occurrences,
            nodeId,
            isDeprecated,
            siblingOrder,
            parent,
            socParent
        );
        if ( isClosed == null ) {
            throw new NullPointerException("Property:isClosed has cardinality NonNull, but is null");
        }
        this.includes = includes;
        this.excludes = excludes;
        this.isClosed = isClosed;
    }

    private ArchetypeSlot(Builder builder) {
        this.setIncludes( builder.includes );
        this.setExcludes( builder.excludes );
        this.setIsClosed( builder.isClosed );
        this.setRmTypeName( builder.rmTypeName );
        this.setOccurrences( builder.occurrences );
        this.setNodeId( builder.nodeId );
        this.setIsDeprecated( builder.isDeprecated );
        this.setSiblingOrder( builder.siblingOrder );
        this.setParent( builder.parent );
        this.setSocParent( builder.socParent );
    }

    public static class Builder {
        private List<ArchetypeIdConstraint> includes;
        private List<ArchetypeIdConstraint> excludes;
        private final Boolean isClosed;  //required
        private final String rmTypeName;  //required
        private MultiplicityInterval occurrences;
        private final String nodeId;  //required
        private Boolean isDeprecated;
        private SiblingOrder siblingOrder;
        private ArchetypeConstraint parent;
        private CSecondOrder socParent;

        public Builder (
            Boolean isClosed,
            String rmTypeName,
            String nodeId
        ){
            if ( isClosed == null ) {
                throw new NullPointerException("Property:isClosed has cardinality NonNull, but is null");
            }
            if ( rmTypeName == null ) {
                throw new NullPointerException("Property:rmTypeName has cardinality NonNull, but is null");
            }
            if ( nodeId == null ) {
                throw new NullPointerException("Property:nodeId has cardinality NonNull, but is null");
            }
            this.isClosed = isClosed;
            this.rmTypeName = rmTypeName;
            this.nodeId = nodeId;
        }

        public Builder setIncludes(List<ArchetypeIdConstraint> value) {
            this.includes = includes;
            return this;
        }

        public Builder setExcludes(List<ArchetypeIdConstraint> value) {
            this.excludes = excludes;
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

        public ArchetypeSlot build(){
            return new ArchetypeSlot( this );
        }
    }


    //***** ArchetypeSlot *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ArchetypeSlot that = (ArchetypeSlot) object;
        return
            Objects.equals(includes, that.includes) &&
            Objects.equals(excludes, that.excludes) &&
            Objects.equals(isClosed, that.isClosed);
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            includes,
            excludes,
            isClosed
        );
    }

    @Override
    public java.lang.String toString() {
        return
            "ArchetypeSlot {" +
            "includes='" + includes + '\'' +
            "excludes='" + excludes + '\'' +
            "isClosed='" + isClosed + '\'' +
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

package nl.rosa.semanticdatabase.aom_2.constraint_model_package;

import java.util.Objects;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Boolean;

/**
 * 
 * #Generated: 2020-11-25T09:35:00.89+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Abstract parent of classes defining second order constraints.
 * 
*/
public abstract class CSecondOrder {

    //***** CSecondOrder *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Members of this second order constrainer.
 * Normally redefined in descendants.
 * cardinality: 0..1
 * 
*/
    private List<ArchetypeConstraint> members;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Members of this second order constrainer.
 * Normally redefined in descendants.
 * cardinality: 0..1
 * 
*/

    public void addToMember(ArchetypeConstraint value ) {
        if (members == null ) {
            members = new ArrayList<> ();
        }
        members.add( value);
    }

    public void addToMembers(List<ArchetypeConstraint> values ) {
        values.forEach(value -> addToMember(value));
    }

    public void removeFromMember(ArchetypeConstraint item ) {
        if (members != null ) {
            members.remove(item);
        }
    }
    public void removeFromMembers( Collection <ArchetypeConstraint> values ) {
        values.forEach(this::removeFromMember);
    }
    List<ArchetypeConstraint> getMembers() {
        return this.members;
    }
    public CSecondOrder setMembers(List<ArchetypeConstraint> members) {
        this.members = members;
        return this;
    }
    public List<ArchetypeConstraint> members() {
        return Collections.unmodifiableList(this.members);
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * True if constraints represented by this node, ignoring any sub-parts, are narrower or the same as other.
 * Typically used during validation of specialised archetype nodes.
 * Parameters rmcc RM conformance checker agent - a lambda (i.e.
 * function object) that can compute conformance of type-names within the Reference Model on which the current archetype is based.
 * The signature provides two arguments representing respectively, the rm_type_name of the current node and the rm_type_name of the node being redefined in a specialisation parent archetype.
 * cardinality: 1..1 (abstract)
 * 
*/
    public abstract Boolean  cConformsTo(CSecondOrder other, FUNCTION<> rmcc,  ,  );

/**
 * 
 * True if constraints represented by this node contain no further redefinitions with respect to the node other.
 * Typically used to test if an inherited node locally contains any constraints.
 * cardinality: 1..1 (abstract)
 * 
*/
    public abstract Boolean  cCongruentTo(CSecondOrder other);

    //***** CSecondOrder *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected CSecondOrder() {}

    protected CSecondOrder(
            List<archetypeConstraint> members
        ){
        this.members = members;
    }


    //***** CSecondOrder *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CSecondOrder that = (CSecondOrder) object;
        return
            Objects.equals(members, that.members);
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            members
        );
    }

    @Override
    public String toString() {
        return
            "CSecondOrder {" +
            "members='" + members + '\'' +
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

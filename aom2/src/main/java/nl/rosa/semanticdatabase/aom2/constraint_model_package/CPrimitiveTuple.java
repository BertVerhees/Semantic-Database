package nl.rosa.semanticdatabase.aom2.constraint_model_package;

import java.util.Objects;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Boolean;

/**
 * 
 * #Generated: 2020-11-24T18:12:03.636+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Class representing a single object tuple instance in a tuple constraint.
 * Each such instance is a vector of object constraints, where each member (each C_PRIMITIVE_OBJECT) corresponds to one of the C_ATTRIBUTEs referred to by the owning C_ATTRIBUTE_TUPLE.
 * 
*/
public class CPrimitiveTuple extends CSecondOrder {

    //***** CPrimitiveTuple *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Object constraint members of this tuple group.
 * cardinality: 1..1 (redefined)
 * 
*/
    private List<CPrimitiveObject> members = new ArrayList<> ();

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Object constraint members of this tuple group.
 * cardinality: 1..1 (redefined)
 * 
*/

    public void addToMember(CPrimitiveObject value ) {
        members.add( value);
    }

    public void addToMembers(List<CPrimitiveObject> values ) {
        values.forEach(value -> addToMember(value));
    }

    public void removeFromMember(CPrimitiveObject item ) {
        if (members != null ) {
            members.remove(item);
        }
    }
    public void removeFromMembers( Collection <CPrimitiveObject> values ) {
        values.forEach(this::removeFromMember);
    }
    List<CPrimitiveObject> getMembers() {
        return this.members;
    }
    public CPrimitiveTuple setMembers(List<CPrimitiveObject> members) {
        if (members == null ) {
            throw new NullPointerException(" members has cardinality NonNull, but is null");
        }
        this.members = members;
        return this;
    }
    public List<CPrimitiveObject> members() {
        return Collections.unmodifiableList(this.members);
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * True if constraints represented by this node, ignoring any sub-parts, are narrower or the same as other.
 * Typically used during validation of specialised archetype nodes.
 * Parameters rmcc RM conformance checker agent.
 * cardinality: 1..1 (effected)
 * 
*/
    public Boolean  cConformsTo(CPrimitiveTuple other, FUNCTION<> rmcc,  ,  ) {
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
 * True if constraints represented by this node contain no further redefinitions with respect to the node other.
 * Typically used to test if an inherited node locally contains any constraints.
 * cardinality: 1..1 (effected)
 * 
*/
    public Boolean  cCongruentTo(CSecondOrder other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** CPrimitiveTuple *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected CPrimitiveTuple() {}

    public CPrimitiveTuple(
            List<cPrimitiveObject> members,
            List<archetypeConstraint> members
        ){
        if ( members == null ) {
            throw new NullPointerException("Property:members has cardinality NonNull, but is null");
        }
        this.members = members;
    }

    private CPrimitiveTuple(Builder builder) {
        this.setMembers( builder.members );
        this.setMembers( builder.members );
    }

    public static class Builder {
        private final List<cPrimitiveObject> members;  //required
        private List<archetypeConstraint> members;

        public Builder (
            List<cPrimitiveObject> members
        ){
            if ( members == null ) {
                throw new NullPointerException("Property:members has cardinality NonNull, but is null");
            }
            this.members = members;
        }

        public Builder setMembers(List<archetypeConstraint> value) {
            this.members = members;
            return this;
        }

        public CPrimitiveTuple build(){
            return new CPrimitiveTuple( this );
        }
    }


    //***** CPrimitiveTuple *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CPrimitiveTuple that = (CPrimitiveTuple) object;
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
            "CPrimitiveTuple {" +
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

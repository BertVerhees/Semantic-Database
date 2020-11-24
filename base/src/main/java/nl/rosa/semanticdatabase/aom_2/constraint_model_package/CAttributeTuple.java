package nl.rosa.semanticdatabase.aom_2.constraint_model_package;

import nl.rosa.semanticdatabase.foundation_types.primitive_types.Boolean;

/**
 * 
 * #Generated: 2020-11-24T17:04:33.085+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Object representing a constraint on an atttribute tuple, i.e.
 * a group of attributes that are constrained together.
 * Typically used for representing co-varying constraints like {units, range} constraints.
 * 
*/
public class CAttributeTuple extends CSecondOrder {

    //***** CAttributeTuple *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Tuple definitions.
 * cardinality: 0..1
 * 
*/
    private List<CPrimitiveTuple> tuples;

/**
 * 
 * List of C_ATTRIBUTEs forming the definition of the tuple.
 * cardinality: 0..1 (redefined)
 * 
*/
    private List<CAttribute> members;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Tuple definitions.
 * cardinality: 0..1
 * 
*/

    public void addToTuple(CPrimitiveTuple value ) {
        if (tuples == null ) {
            tuples = new ArrayList<> ();
        }
        tuples.add( value);
    }

    public void addToTuples(List<CPrimitiveTuple> values ) {
        values.forEach(value -> addTuple(value));
    }

    public void removeFromTuple(CPrimitiveTuple item ) {
        if (tuples != null ) {
            tuples.remove(item);
        }
    }
    public void removeFromTuples( Collection <CPrimitiveTuple> values ) {
        values.forEach(this::removeTuple);
    }
    CPrimitiveTuple getTuples() {
        return this.tuples;
    }
    public CAttributeTuple setTuples(CPrimitiveTuple tuples) {
        this.tuples = tuples;
        return this;
    }
    public List<CPrimitiveTuple> tuples() {
        return Collections.unmodifiableList(this.tuples);
    }

/**
 * 
 * List of C_ATTRIBUTEs forming the definition of the tuple.
 * cardinality: 0..1 (redefined)
 * 
*/

    public void addToMember(CAttribute value ) {
        if (members == null ) {
            members = new ArrayList<> ();
        }
        members.add( value);
    }

    public void addToMembers(List<CAttribute> values ) {
        values.forEach(value -> addMember(value));
    }

    public void removeFromMember(CAttribute item ) {
        if (members != null ) {
            members.remove(item);
        }
    }
    public void removeFromMembers( Collection <CAttribute> values ) {
        values.forEach(this::removeMember);
    }
    CAttribute getMembers() {
        return this.members;
    }
    public CAttributeTuple setMembers(CAttribute members) {
        this.members = members;
        return this;
    }
    public List<CAttribute> members() {
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
    public Boolean  cConformsTo(CAttributeTuple other, FUNCTION<> rmcc,  ,  ) {
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

    //***** CAttributeTuple *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    public CAttributeTuple(
            List<cPrimitiveTuple> tuples,
            List<cAttribute> members,
            List<archetypeConstraint> members
        ){
        this.tuples = tuples;
        this.members = members;
    }

    private CAttributeTuple(Builder builder) {
        this.setTuples( builder.tuples );
        this.setMembers( builder.members );
        this.setMembers( builder.members );
    }

    public static class Builder {
        private List<cPrimitiveTuple> tuples;
        private List<cAttribute> members;
        private List<archetypeConstraint> members;

        public Builder (
        ){
        }

        public Builder setTuples(List<cPrimitiveTuple> value) {
            this.tuples = tuples;
            return this;
        }

        public Builder setMembers(List<cAttribute> value) {
            this.members = members;
            return this;
        }

        public Builder setMembers(List<archetypeConstraint> value) {
            this.members = members;
            return this;
        }

        public CAttributeTuple build(){
            return new CAttributeTuple( this );
        }
    }


    //***** CAttributeTuple *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CAttributeTuple that = (CAttributeTuple) object;
        return
            java.util.Objects.equals(tuples, that.tuples) &&
            java.util.Objects.equals(members, that.members);
        }
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            tuples,
            members
        );
    }

    @Override
    public String toString() {
        return
            "CAttributeTuple {" +
            "tuples='" + tuples + '\''; +
            "members='" + members + '\''; +
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

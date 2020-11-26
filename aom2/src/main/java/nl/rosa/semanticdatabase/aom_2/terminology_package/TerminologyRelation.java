package nl.rosa.semanticdatabase.aom_2.terminology_package;

import java.util.*;

/**
 * 
 * #Generated: 2020-11-25T09:35:00.89+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Class whose instances represent any kind of 1:N relationship between a source term and 1-N target terms.
 * 
*/
public abstract class TerminologyRelation {

    //***** TerminologyRelation *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Code of source term of this relation.
 * cardinality: 1..1
 * 
*/
    private String id;

/**
 * 
 * List of target terms in this relation.
 * cardinality: 1..1
 * 
*/
    private List<String> members = new ArrayList<>();

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Code of source term of this relation.
 * cardinality: 1..1
 * 
*/
    public String getId() {
        return id;
    }
    public void setId(String value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:id failed, it has cardinality NonNull, but is null");
        }
        this.id = id;
    }

/**
 * 
 * List of target terms in this relation.
 * cardinality: 1..1
 * 
*/

    public void addToMember(String value ) {
        members.add( value);
    }

    public void addToMembers(List<String> values ) {
        values.forEach(value -> addToMember(value));
    }

    public void removeFromMember(String item ) {
        if (members != null ) {
            members.remove(item);
        }
    }
    public void removeFromMembers( Collection<String> values ) {
        values.forEach(this::removeFromMember);
    }
    List<String> getMembers() {
        return this.members;
    }
    public TerminologyRelation setMembers(List<String> members) {
        if (members == null ) {
            throw new NullPointerException(" members has cardinality NonNull, but is null");
        }
        this.members = members;
        return this;
    }
    public List<String> members() {
        return Collections.unmodifiableList(this.members);
    }

    //***** TerminologyRelation *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected TerminologyRelation() {}

    protected TerminologyRelation(
            String id,
            List<String> members
        ){
        if ( id == null ) {
            throw new NullPointerException("Property:id has cardinality NonNull, but is null");
        }
        if ( members == null ) {
            throw new NullPointerException("Property:members has cardinality NonNull, but is null");
        }
        this.id = id;
        this.members = members;
    }


    //***** TerminologyRelation *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        TerminologyRelation that = (TerminologyRelation) object;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(members, that.members);
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            id,
            members
        );
    }

    @Override
    public String toString() {
        return
            "TerminologyRelation {" +
            "id='" + id + '\'' +
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

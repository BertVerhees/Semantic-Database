package nl.rosa.semanticdatabase.aom_2.terminology_package;


/**
 * 
 * #Generated: 2020-11-24T17:04:33.085+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Representation of a flat value set within the archetype terminology.
 * 
*/
public class ValueSet extends TerminologyRelation {

    //***** ValueSet *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    public ValueSet(
            String id,
            List<string> members
        ){
        super( 
            id,
            members
        );
    }

    private ValueSet(Builder builder) {
        this.setId( builder.id );
        this.setMembers( builder.members );
    }

    public static class Builder {
        private final String id;  //required
        private final List<string> members;  //required

        public Builder (
            String id,
            List<string> members
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

        public ValueSet build(){
            return new ValueSet( this );
        }
    }


    //***** ValueSet *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ValueSet that = (ValueSet) object;
        return
        }
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
        );
    }

    @Override
    public String toString() {
        return
            "ValueSet {" +
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

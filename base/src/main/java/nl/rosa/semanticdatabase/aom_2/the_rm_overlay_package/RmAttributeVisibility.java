package nl.rosa.semanticdatabase.aom_2.the_rm_overlay_package;

import nl.rosa.semanticdatabase.foundation_types.terminology_package.TerminologyCode;

/**
 * 
 * #Generated: 2020-11-24T17:04:33.085+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Definition of visibility of an RM attribute within a larger archetype structure.
 * 
*/
public class RmAttributeVisibility {

    //***** RmAttributeVisibility *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Visibility setting of a non-archetyped RM attribute (RM attributes that are constrained or within the archetyped structure are visible by default).
 * cardinality: 0..1
 * 
*/
    private VisibilityType visibility;

/**
 * 
 * Optional alias for the attribute referenced by the path.
 * cardinality: 0..1
 * 
*/
    private TerminologyCode alias;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Visibility setting of a non-archetyped RM attribute (RM attributes that are constrained or within the archetyped structure are visible by default).
 * cardinality: 0..1
 * 
*/
    public VisibilityType getVisibility() {
        return visibility;
    }
    public setVisibility(VisibilityType value) {
        this.visibility = visibility;
    }

/**
 * 
 * Optional alias for the attribute referenced by the path.
 * cardinality: 0..1
 * 
*/
    public TerminologyCode getAlias() {
        return alias;
    }
    public setAlias(TerminologyCode value) {
        this.alias = alias;
    }

    //***** RmAttributeVisibility *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    public RmAttributeVisibility(
            VisibilityType visibility,
            TerminologyCode alias
        ){
        this.visibility = visibility;
        this.alias = alias;
    }

    private RmAttributeVisibility(Builder builder) {
        this.setVisibility( builder.visibility );
        this.setAlias( builder.alias );
    }

    public static class Builder {
        private VisibilityType visibility;
        private TerminologyCode alias;

        public Builder (
        ){
        }

        public Builder setVisibility(VisibilityType value) {
            this.visibility = visibility;
            return this;
        }

        public Builder setAlias(TerminologyCode value) {
            this.alias = alias;
            return this;
        }

        public RmAttributeVisibility build(){
            return new RmAttributeVisibility( this );
        }
    }


    //***** RmAttributeVisibility *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        RmAttributeVisibility that = (RmAttributeVisibility) object;
        return
            java.util.Objects.equals(visibility, that.visibility) &&
            java.util.Objects.equals(alias, that.alias);
        }
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            visibility,
            alias
        );
    }

    @Override
    public String toString() {
        return
            "RmAttributeVisibility {" +
            "visibility='" + visibility + '\''; +
            "alias='" + alias + '\''; +
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

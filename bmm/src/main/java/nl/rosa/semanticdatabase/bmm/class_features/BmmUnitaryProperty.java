package nl.rosa.semanticdatabase.bmm.class_features;

import java.util.Objects;
import nl.rosa.semanticdatabase.bmm.types.BmmUnitaryType;

/**
 * 
 * #Generated: 2020-11-25T09:35:00.89+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Meta-type of for properties of unitary type.
 * 
*/
public class BmmUnitaryProperty extends BmmProperty {

    //***** BmmUnitaryProperty *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Declared or inferred static type of the entity.
 * cardinality: 1..1 (redefined)
 * 
*/
    private BmmUnitaryType type;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Declared or inferred static type of the entity.
 * cardinality: 1..1 (redefined)
 * 
*/
    public BmmUnitaryType getType() {
        return type;
    }
    public void setType(BmmUnitaryType value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:type failed, it has cardinality NonNull, but is null");
        }
        this.type = type;
    }

    //***** BmmUnitaryProperty *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected BmmUnitaryProperty() {}

    public BmmUnitaryProperty(
            BmmUnitaryType type,
            BmmType type,
            BmmVisibility visibility,
            List<bmmFeatureExtension> featureExtensions,
            BmmFeatureGroup group,
            BmmClass scope,
            String name,
            Map<string, any> documentation,
            BmmDeclaration scope,
            Map<string, any> extensions
        ){
        super( 
            visibility,
            featureExtensions,
            group,
            scope,
            name,
            documentation,
            scope,
            extensions
        );
        if ( type == null ) {
            throw new NullPointerException("Property:type has cardinality NonNull, but is null");
        }
        this.type = type;
    }

    private BmmUnitaryProperty(Builder builder) {
        this.setType( builder.type );
        this.setType( builder.type );
        this.setVisibility( builder.visibility );
        this.setFeatureExtensions( builder.featureExtensions );
        this.setGroup( builder.group );
        this.setScope( builder.scope );
        this.setName( builder.name );
        this.setDocumentation( builder.documentation );
        this.setScope( builder.scope );
        this.setExtensions( builder.extensions );
    }

    public static class Builder {
        private final BmmUnitaryType type;  //required
        private final BmmType type;  //required
        private BmmVisibility visibility;
        private List<bmmFeatureExtension> featureExtensions;
        private final BmmFeatureGroup group;  //required
        private final BmmClass scope;  //required
        private final String name;  //required
        private Map<string, any> documentation;
        private final BmmDeclaration scope;  //required
        private Map<string, any> extensions;

        public Builder (
            BmmUnitaryType type,
            BmmType type,
            BmmFeatureGroup group,
            BmmClass scope,
            String name,
            BmmDeclaration scope
        ){
            if ( type == null ) {
                throw new NullPointerException("Property:type has cardinality NonNull, but is null");
            }
            if ( type == null ) {
                throw new NullPointerException("Property:type has cardinality NonNull, but is null");
            }
            if ( group == null ) {
                throw new NullPointerException("Property:group has cardinality NonNull, but is null");
            }
            if ( scope == null ) {
                throw new NullPointerException("Property:scope has cardinality NonNull, but is null");
            }
            if ( name == null ) {
                throw new NullPointerException("Property:name has cardinality NonNull, but is null");
            }
            if ( scope == null ) {
                throw new NullPointerException("Property:scope has cardinality NonNull, but is null");
            }
            this.type = type;
            this.type = type;
            this.group = group;
            this.scope = scope;
            this.name = name;
            this.scope = scope;
        }

        public Builder setVisibility(BmmVisibility value) {
            this.visibility = visibility;
            return this;
        }

        public Builder setFeatureExtensions(List<bmmFeatureExtension> value) {
            this.featureExtensions = featureExtensions;
            return this;
        }

        public Builder setDocumentation(Map<string, any> value) {
            this.documentation = documentation;
            return this;
        }

        public Builder setExtensions(Map<string, any> value) {
            this.extensions = extensions;
            return this;
        }

        public BmmUnitaryProperty build(){
            return new BmmUnitaryProperty( this );
        }
    }


    //***** BmmUnitaryProperty *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmUnitaryProperty that = (BmmUnitaryProperty) object;
        return
            java.util.Objects.equals(type, that.type);
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            type
        );
    }

    @java.lang.Override
    public java.lang.String toString() {
        return
            "BmmUnitaryProperty {" +
            "type='" + type + '\'' +
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

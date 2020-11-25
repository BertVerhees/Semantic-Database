package nl.rosa.semanticdatabase.base_types.identification_package;

import java.util.Objects;

/**
 * 
 * #Generated: 2020-11-25T09:35:00.89+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Class describing a reference to another object, which may exist locally or be maintained outside the current namespace, e.g.
 * in another service.
 * Services are usually external, e.g.
 * available in a LAN (including on the same host) or the internet via Corba, SOAP, or some other distributed protocol.
 * However, in small systems they may be part of the same executable as the data containing the Id.
 * 
*/
public class ObjectRef {

    //***** ObjectRef *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Namespace to which this identifier belongs in the local system context (and possibly in any other openEHR compliant environment) e.g.
 * terminology , demographic .
 * These names are not yet standardised.
 * Legal values for namespace are: "local" "unknown" a string matching the standard regex [a-zA-Z][a-zA-Z0-9_.:\/&?=+-]*.
 * Note that the first two are just special values of the regex, and will be matched by it.
 * cardinality: 1..1
 * 
*/
    private String namespace;

/**
 * 
 * Name of the class (concrete or abstract) of object to which this identifier type refers, e.g.
 * PARTY, PERSON, GUIDELINE etc.
 * These class names are from the relevant reference model.
 * The type name ANY can be used to indicate that any type is accepted (e.g.
 * if the type is unknown).
 * cardinality: 1..1
 * 
*/
    private String type;

/**
 * 
 * Globally unique id of an object, regardless of where it is stored.
 * cardinality: 1..1
 * 
*/
    private ObjectId id;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Namespace to which this identifier belongs in the local system context (and possibly in any other openEHR compliant environment) e.g.
 * terminology , demographic .
 * These names are not yet standardised.
 * Legal values for namespace are: "local" "unknown" a string matching the standard regex [a-zA-Z][a-zA-Z0-9_.:\/&?=+-]*.
 * Note that the first two are just special values of the regex, and will be matched by it.
 * cardinality: 1..1
 * 
*/
    public String getNamespace() {
        return namespace;
    }
    public void setNamespace(String value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:namespace failed, it has cardinality NonNull, but is null");
        }
        this.namespace = namespace;
    }

/**
 * 
 * Name of the class (concrete or abstract) of object to which this identifier type refers, e.g.
 * PARTY, PERSON, GUIDELINE etc.
 * These class names are from the relevant reference model.
 * The type name ANY can be used to indicate that any type is accepted (e.g.
 * if the type is unknown).
 * cardinality: 1..1
 * 
*/
    public String getType() {
        return type;
    }
    public void setType(String value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:type failed, it has cardinality NonNull, but is null");
        }
        this.type = type;
    }

/**
 * 
 * Globally unique id of an object, regardless of where it is stored.
 * cardinality: 1..1
 * 
*/
    public ObjectId getId() {
        return id;
    }
    public void setId(ObjectId value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:id failed, it has cardinality NonNull, but is null");
        }
        this.id = id;
    }

    //***** ObjectRef *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected ObjectRef() {}

    public ObjectRef(
            String namespace,
            String type,
            ObjectId id
        ){
        if ( namespace == null ) {
            throw new NullPointerException("Property:namespace has cardinality NonNull, but is null");
        }
        if ( type == null ) {
            throw new NullPointerException("Property:type has cardinality NonNull, but is null");
        }
        if ( id == null ) {
            throw new NullPointerException("Property:id has cardinality NonNull, but is null");
        }
        this.namespace = namespace;
        this.type = type;
        this.id = id;
    }

    private ObjectRef(Builder builder) {
        this.setNamespace( builder.namespace );
        this.setType( builder.type );
        this.setId( builder.id );
    }

    public static class Builder {
        private final String namespace;  //required
        private final String type;  //required
        private final ObjectId id;  //required

        public Builder (
            String namespace,
            String type,
            ObjectId id
        ){
            if ( namespace == null ) {
                throw new NullPointerException("Property:namespace has cardinality NonNull, but is null");
            }
            if ( type == null ) {
                throw new NullPointerException("Property:type has cardinality NonNull, but is null");
            }
            if ( id == null ) {
                throw new NullPointerException("Property:id has cardinality NonNull, but is null");
            }
            this.namespace = namespace;
            this.type = type;
            this.id = id;
        }

        public ObjectRef build(){
            return new ObjectRef( this );
        }
    }


    //***** ObjectRef *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ObjectRef that = (ObjectRef) object;
        return
            Objects.equals(namespace, that.namespace) &&
            Objects.equals(type, that.type) &&
            Objects.equals(id, that.id);
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            namespace,
            type,
            id
        );
    }

    @Override
    public String toString() {
        return
            "ObjectRef {" +
            "namespace='" + namespace + '\'' +
            "type='" + type + '\'' +
            "id='" + id + '\'' +
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

package nl.rosa.semanticdatabase.aom2.constraint_model_package;

import java.util.Objects;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Boolean;

/**
 * 
 * #Generated: 2020-11-24T17:57:46.357+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * A constraint defined by proxy, using a reference to an object constraint defined elsewhere in the same archetype.
 * Note that since this object refers to another node, there are two objects with available occurrences values.
 * The local occurrences value on a COMPLEX_OBJECT_PROXY should always be used; when setting this from a serialised form, if no occurrences is mentioned, the target occurrences should be used (not the standard default of {1..1}); otherwise the locally specified occurrences should be used as normal.
 * When serialising out, if the occurrences is the same as that of the target, it can be left out.
 * 
*/
public class CComplexObjectProxy extends CObject {

    //***** CComplexObjectProxy *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Reference to an object node using archetype path notation.
 * cardinality: 1..1
 * 
*/
    private String targetPath;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Reference to an object node using archetype path notation.
 * cardinality: 1..1
 * 
*/
    public String getTargetPath() {
        return targetPath;
    }
    public void setTargetPath(String value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:targetPath failed, it has cardinality NonNull, but is null");
        }
        this.targetPath = targetPath;
    }

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * True if target occurrences are to be used as the value of occurrences in this object; by the time of runtime use, the target occurrences value has to be set into this object.
 * cardinality: 1..1
 * 
*/
    public Result = (occurrences = Void)  useTargetOccurrences() {
        Result = (occurrences = Void)  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * True if this node occurrences conforms to other.occurrences; other is assumed to be in a flat archetype.
 * If other is a C_COMPLEX_OBJECT, then always True, since if occurrences defined on proxy node, it is an override of the occurrences on the target, and it doesn’t have to conform to anything except the containing attribute’s cardinality.
 * However, if other is also a C_COMPLEX_OBJECT then the override is of another use_node, and normal occurrences apply Parameters other C_OBJECT from a flat parent archetype.
 * cardinality: 1..1 (redefined)
 * 
*/
    public Boolean  occurrencesConformsTo(CObject other) {
        if (other == null ) {
            throw new NullPointerException("Parameter other has cardinality NonNull, but is null.");
        }
        Boolean  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** CComplexObjectProxy *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected CComplexObjectProxy() {}

    public CComplexObjectProxy(
            String targetPath,
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
        if ( targetPath == null ) {
            throw new NullPointerException("Property:targetPath has cardinality NonNull, but is null");
        }
        this.targetPath = targetPath;
    }

    private CComplexObjectProxy(Builder builder) {
        this.setTargetPath( builder.targetPath );
        this.setRmTypeName( builder.rmTypeName );
        this.setOccurrences( builder.occurrences );
        this.setNodeId( builder.nodeId );
        this.setIsDeprecated( builder.isDeprecated );
        this.setSiblingOrder( builder.siblingOrder );
        this.setParent( builder.parent );
        this.setSocParent( builder.socParent );
    }

    public static class Builder {
        private final String targetPath;  //required
        private final String rmTypeName;  //required
        private MultiplicityInterval occurrences;
        private final String nodeId;  //required
        private Boolean isDeprecated;
        private SiblingOrder siblingOrder;
        private ArchetypeConstraint parent;
        private CSecondOrder socParent;

        public Builder (
            String targetPath,
            String rmTypeName,
            String nodeId
        ){
            if ( targetPath == null ) {
                throw new NullPointerException("Property:targetPath has cardinality NonNull, but is null");
            }
            if ( rmTypeName == null ) {
                throw new NullPointerException("Property:rmTypeName has cardinality NonNull, but is null");
            }
            if ( nodeId == null ) {
                throw new NullPointerException("Property:nodeId has cardinality NonNull, but is null");
            }
            this.targetPath = targetPath;
            this.rmTypeName = rmTypeName;
            this.nodeId = nodeId;
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

        public CComplexObjectProxy build(){
            return new CComplexObjectProxy( this );
        }
    }


    //***** CComplexObjectProxy *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        CComplexObjectProxy that = (CComplexObjectProxy) object;
        return
            Objects.equals(targetPath, that.targetPath);
        }
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            targetPath
        );
    }

    @Override
    public String toString() {
        return
            "CComplexObjectProxy {" +
            "targetPath='" + targetPath + '\''; +
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

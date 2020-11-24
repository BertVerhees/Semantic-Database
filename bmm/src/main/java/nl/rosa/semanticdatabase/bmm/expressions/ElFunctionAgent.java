package nl.rosa.semanticdatabase.bmm.expressions;

import nl.rosa.semanticdatabase.bmm.class_features.BmmFunction;

/**
 * 
 * #Generated: 2020-11-24T17:04:33.085+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * An agent whose signature is of a function, i.e.
 * has a result type.
 * 
*/
public class ElFunctionAgent extends ElAgent {

    //***** ElFunctionAgent *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Reference to definition of a routine for which this is a direct call instance, if one exists.
 * cardinality: 0..1 (redefined)
 * 
*/
    private BmmFunction definition;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Reference to definition of a routine for which this is a direct call instance, if one exists.
 * cardinality: 0..1 (redefined)
 * 
*/
    public BmmFunction getDefinition() {
        return definition;
    }
    public setDefinition(BmmFunction value) {
        this.definition = definition;
    }

    //***** ElFunctionAgent *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    public ElFunctionAgent(
            BmmFunction definition,
            String name,
            ElTuple closedArgs,
            List<string> openArgs,
            BmmRoutine definition,
            ElInstanceRef scope
        ){
        super( 
            name,
            closedArgs,
            openArgs,
            scope
        );
        this.definition = definition;
    }

    private ElFunctionAgent(Builder builder) {
        this.setDefinition( builder.definition );
        this.setName( builder.name );
        this.setClosedArgs( builder.closedArgs );
        this.setOpenArgs( builder.openArgs );
        this.setDefinition( builder.definition );
        this.setScope( builder.scope );
    }

    public static class Builder {
        private BmmFunction definition;
        private final String name;  //required
        private ElTuple closedArgs;
        private List<string> openArgs;
        private BmmRoutine definition;
        private ElInstanceRef scope;

        public Builder (
            String name
        ){
            if ( name == null ) {
                throw new NullPointerException("Property:name has cardinality NonNull, but is null");
            }
            this.name = name;
        }

        public Builder setDefinition(BmmFunction value) {
            this.definition = definition;
            return this;
        }

        public Builder setClosedArgs(ElTuple value) {
            this.closedArgs = closedArgs;
            return this;
        }

        public Builder setOpenArgs(List<string> value) {
            this.openArgs = openArgs;
            return this;
        }

        public Builder setDefinition(BmmRoutine value) {
            this.definition = definition;
            return this;
        }

        public Builder setScope(ElInstanceRef value) {
            this.scope = scope;
            return this;
        }

        public ElFunctionAgent build(){
            return new ElFunctionAgent( this );
        }
    }


    //***** ElFunctionAgent *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        ElFunctionAgent that = (ElFunctionAgent) object;
        return
            java.util.Objects.equals(definition, that.definition);
        }
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            definition
        );
    }

    @java.lang.Override
    public java.lang.String toString() {
        return
            "ElFunctionAgent {" +
            "definition='" + definition + '\''; +
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

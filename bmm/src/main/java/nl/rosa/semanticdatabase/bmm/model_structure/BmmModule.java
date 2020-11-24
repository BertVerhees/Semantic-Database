package nl.rosa.semanticdatabase.bmm.model_structure;


/**
 * 
 * #Generated: 2020-11-24T17:04:33.085+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Meta-type defining a generalised module concept.
 * Descendants define actual structure and contents.
 * 
*/
public abstract class BmmModule extends BmmDeclaration {

    //***** BmmModule *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Model within which module is defined.
 * cardinality: 1..1 (redefined)
 * 
*/
    private BmmModel scope;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Model within which module is defined.
 * cardinality: 1..1 (redefined)
 * 
*/
    public BmmModel getScope() {
        return scope;
    }
    public setScope(BmmModel value) {
        if ( value == null ) {
            throw new NullPointerException(" Setting property:scope failed, it has cardinality NonNull, but is null");
        }
        this.scope = scope;
    }

    //***** BmmModule *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/


    protected BmmModule(
            BmmModel scope,
            String name,
            Map<string, any> documentation,
            BmmDeclaration scope,
            Map<string, any> extensions
        ){
        super( 
            name,
            documentation,
            extensions
        );
        if ( scope == null ) {
            throw new NullPointerException("Property:scope has cardinality NonNull, but is null");
        }
        this.scope = scope;
    }


    //***** BmmModule *****

/*=========================================================*/
/* * TOSTRING, EQUALS AND HASHCODE * */
/*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        BmmModule that = (BmmModule) object;
        return
            java.util.Objects.equals(scope, that.scope);
        }
    }

    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            scope
        );
    }

    @java.lang.Override
    public java.lang.String toString() {
        return
            "BmmModule {" +
            "scope='" + scope + '\''; +
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

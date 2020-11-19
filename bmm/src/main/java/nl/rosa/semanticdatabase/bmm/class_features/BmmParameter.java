package nl.rosa.semanticdatabase.bmm.class_features;


/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * A routine parameter variable.
 * 
*/
public class BmmParameter extends BmmVariable {

    //***** BmmParameter *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Optional read/write direction of the parameter.
 * If none-supplied, the parameter is treated as in, i.e.
 * readable.
 * cardinality: 0..1
 * 
*/
    private BmmParameterDirection direction;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Optional read/write direction of the parameter.
 * If none-supplied, the parameter is treated as in, i.e.
 * readable.
 * cardinality: 0..1
 * 
*/
    public BmmParameterDirection getDirection() {
        return direction;
    }
    public BmmParameter setDirection(BmmParameterDirection value) {
        this.direction = direction;
        return this;
    }

    //***** BmmParameter *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public BmmParameter build() {
        return new BmmParameter(
            direction,
            scope,
            type,
            name,
            documentation,
            scope,
            extensions
        );
    }

    public BmmParameter(
            BmmParameterDirection direction,
            BmmRoutine scope,
            BmmType type,
            String name,
            Map<String, Any> documentation,
            BmmDeclaration scope,
            Map<String, Any> extensions
    ){
        if ( scope == null ) {
            throw new NullPointerException("Property:scope has cardinality NonNull, but is null");
        }
        if ( type == null ) {
            throw new NullPointerException("Property:type has cardinality NonNull, but is null");
        }
        if ( name == null ) {
            throw new NullPointerException("Property:name has cardinality NonNull, but is null");
        }
        if ( scope == null ) {
            throw new NullPointerException("Property:scope has cardinality NonNull, but is null");
        }
        this.direction = direction;
        this.scope = scope;
        this.type = type;
        this.name = name;
        this.documentation = documentation;
        this.scope = scope;
        this.extensions = extensions;
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

package nl.rosa.semanticdatabase.bmm.expressions;


/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * A reference that is scoped by a containing entity and requires a context qualifier if it is not the currently scoping entity.
 * 
*/
public abstract class ElScopedRef extends ElInstanceRef {

    //***** ElScopedRef *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Reference to an owning object for this terminal element, if it is not the current scope.
 * cardinality: 0..1
 * 
*/
    private ElInstanceRef scope;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Reference to an owning object for this terminal element, if it is not the current scope.
 * cardinality: 0..1
 * 
*/
    public ElInstanceRef getScope() {
        return scope;
    }
    public ElScopedRef setScope(ElInstanceRef value) {
        this.scope = scope;
        return this;
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

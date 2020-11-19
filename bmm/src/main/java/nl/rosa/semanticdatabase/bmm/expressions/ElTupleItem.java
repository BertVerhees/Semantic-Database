package nl.rosa.semanticdatabase.bmm.expressions;

import nl.rosa.semanticdatabase.foundation_types.primitive_types.String;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * A single tuple item, with an optional name.
 * 
*/
public class ElTupleItem {

    //***** ElTupleItem *****

/*=========================================================*/
/* * FIELDS * */
/*=========================================================*/

/**
 * 
 * Reference to value entity.
 * If Void, this indicates that the item in this position is Void, e.g.
 * within a routine call parameter list.
 * cardinality: 0..1
 * 
*/
    private ElExpression item;

/**
 * 
 * Optional name of tuple item.
 * cardinality: 0..1
 * 
*/
    private String name;

/*=========================================================*/
/* * POJOS * */
/*=========================================================*/

/**
 * 
 * Reference to value entity.
 * If Void, this indicates that the item in this position is Void, e.g.
 * within a routine call parameter list.
 * cardinality: 0..1
 * 
*/
    public ElExpression getItem() {
        return item;
    }
    public ElTupleItem setItem(ElExpression value) {
        this.item = item;
        return this;
    }

/**
 * 
 * Optional name of tuple item.
 * cardinality: 0..1
 * 
*/
    public String getName() {
        return name;
    }
    public ElTupleItem setName(String value) {
        this.name = name;
        return this;
    }

    //***** ElTupleItem *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public ElTupleItem build() {
        return new ElTupleItem(
            item,
            name
        );
    }

    public ElTupleItem(
            ElExpression item,
            String name
    ){
        this.item = item;
        this.name = name;
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

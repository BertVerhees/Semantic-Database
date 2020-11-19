package nl.rosa.semanticdatabase.foundation_types.interval;

import nl.rosa.semanticdatabase..;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Type representing an Interval that happens to be a point value.
 * Provides an efficient representation that is substitutable for Interval<T> where needed.
 * 
*/
public class PointInterval<t> extends Interval {

/*=========================================================*/
/* * CONSTANTS * */
/*=========================================================*/

/**
 * 
 * Lower boundary open (i.e.
 * = -infinity).
 * 
*/
    final Boolean {default lowerUnbounded = false};

/**
 * 
 * Upper boundary open (i.e.
 * = +infinity).
 * 
*/
    final Boolean {default upperUnbounded = false};

/**
 * 
 * Lower boundary value included in range if not lower_unbounded.
 * 
*/
    final Boolean {default lowerIncluded = true};

/**
 * 
 * Upper boundary value included in range if not upper_unbounded.
 * 
*/
    final Boolean {default upperIncluded = true};

    //***** PointInterval<t> *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public PointInterval<t> build() {
        return new PointInterval<t>(
            
        );
    }

    public PointInterval<t>(
            
    ){
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

package nl.rosa.semanticdatabase.base_types.builtins_package;

import nl.rosa.semanticdatabase.foundation_types.primitive_types.Double;
import nl.rosa.semanticdatabase.foundation_types.primitive_types.Numeric;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * A basic statistical evaluator class providing common functions on collections of numbers.
 * 
*/
public class StatisticalEvaluator {

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Sum of a container of values.
 * cardinality: 1..1
 * 
*/
    public Double  sum(Container<Numeric> vals) {
        if (vals == null ) {
            throw new NullPointerException("Parameter vals has cardinality NonNull, but is null.");
        }
        Double  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Mean (average) of a container of values.
 * cardinality: 1..1
 * 
*/
    public Double  mean(Container<Numeric> vals) {
        if (vals == null ) {
            throw new NullPointerException("Parameter vals has cardinality NonNull, but is null.");
        }
        Double  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Mode (most frequent) of a container of values.
 * cardinality: 1..1
 * 
*/
    public Numeric  mode(Container<Numeric> vals) {
        if (vals == null ) {
            throw new NullPointerException("Parameter vals has cardinality NonNull, but is null.");
        }
        Numeric  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Maximum of a container of values.
 * cardinality: 1..1
 * 
*/
    public Numeric  max(Container<Numeric> vals) {
        if (vals == null ) {
            throw new NullPointerException("Parameter vals has cardinality NonNull, but is null.");
        }
        Numeric  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Minimum of a container of values.
 * cardinality: 1..1
 * 
*/
    public Numeric  min(Container<Numeric> vals) {
        if (vals == null ) {
            throw new NullPointerException("Parameter vals has cardinality NonNull, but is null.");
        }
        Numeric  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** StatisticalEvaluator *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public StatisticalEvaluator build() {
        return new StatisticalEvaluator(
            
        );
    }

    public StatisticalEvaluator(
            
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

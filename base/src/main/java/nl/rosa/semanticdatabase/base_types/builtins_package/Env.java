package nl.rosa.semanticdatabase.base_types.builtins_package;

import nl.rosa.semanticdatabase.foundation_types.time_types.Iso8601Date;
import nl.rosa.semanticdatabase.foundation_types.time_types.Iso8601Time;
import nl.rosa.semanticdatabase.foundation_types.time_types.Iso8601DateTime;
import nl.rosa.semanticdatabase.foundation_types.time_types.Iso8601Timezone;

/**
 * 
 * #Generated: 2020-11-19T08:28:08.518+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * 
 * Class representing the real-world environment, providing basic information like current time, date, etc.
 * 
*/
public class Env {

/*=========================================================*/
/* * FUNCTIONS * */
/*=========================================================*/

/**
 * 
 * Return today’s date in the current locale.
 * cardinality: 1..1
 * 
*/
    public Iso8601Date  currentDate() {
        Iso8601Date  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Return current time in the current locale.
 * cardinality: 1..1
 * 
*/
    public Iso8601Time  currentTime() {
        Iso8601Time  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Return current date/time in the current locale.
 * cardinality: 1..1
 * 
*/
    public Iso8601DateTime  currentDateTime() {
        Iso8601DateTime  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

/**
 * 
 * Return the timezone of the current locale.
 * cardinality: 1..1
 * 
*/
    public Iso8601Timezone  timeZone() {
        Iso8601Timezone  result;


        if ( result  == null ) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return  result;
    }

    //***** Env *****

/*=========================================================*/
/* * BUILD PATTERN AND CONSTRUCTOR * */
/*=========================================================*/

    public Env build() {
        return new Env(
            
        );
    }

    public Env(
            
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

package semanticdatabase.base_types.builtins_package;

import java.util.Objects;

import semanticdatabase.foundation_types.time_types.Iso8601Date;
import semanticdatabase.foundation_types.time_types.Iso8601Time;
import semanticdatabase.foundation_types.time_types.Iso8601DateTime;
import semanticdatabase.foundation_types.time_types.Iso8601Timezone;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * Class representing the real-world environment, providing basic information like current time, date, etc.
 */
public class Env {

    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Return today’s date in the current locale.
     * cardinality: 1..1
     */
    public Iso8601Date currentDate() {
        Iso8601Date result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Return current time in the current locale.
     * cardinality: 1..1
     */
    public Iso8601Time currentTime() {
        Iso8601Time result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Return current date/time in the current locale.
     * cardinality: 1..1
     */
    public Iso8601DateTime currentDateTime() {
        Iso8601DateTime result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    /**
     * Return the timezone of the current locale.
     * cardinality: 1..1
     */
    public Iso8601Timezone timeZone() {
        Iso8601Timezone result = null;


        if (result == null) {
            throw new NullPointerException("Return-value has cardinality NonNull, but is null.");
        }
        return result;
    }

    //***** Env *****

    /*=========================================================*/
    /* * BUILD PATTERN AND CONSTRUCTOR * */
    /*=========================================================*/


    protected Env() {
    }

    public Env(

    ) {
    }

    private Env(Builder builder) {
    }

    public static class Builder {

        public Builder(
        ) {
        }

        public Env build() {
            return new Env(this);
        }
    }


    //***** Env *****

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        return true;
    }

    public int hashCode() {
        return Objects.hash(
                super.hashCode()
        );
    }

    @Override
    public String toString() {
        return
                "Env {" +
                        '}';
    }

}

/**
 * ***** BEGIN LICENSE BLOCK *****
 * <p>
 * ISC License
 * <p>
 * Copyright (c) 2020, Bert Verhees
 * <p>
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 * <p>
 * ***** END LICENSE BLOCK *****
 */

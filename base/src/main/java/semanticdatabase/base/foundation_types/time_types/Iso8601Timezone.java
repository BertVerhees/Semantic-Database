package semanticdatabase.base.foundation_types.time_types;

import java.time.ZoneOffset;

/**
 * #Generated: 2020-11-26T17:29:11.503+01:00
 * #Copyright: Bert Verhees
 * #License: See bottom of file
 * <p>
 * ISO8601 timezone string, in format: Z | ±hh[mm] where: hh is "00" - "23" (0-filled to two digits) mm is "00" - "59" (0-filled to two digits) Z is a literal meaning UTC (modern replacement for GMT), i.e.
 * timezone +0000
 */
public class Iso8601Timezone extends Iso8601Type {

    private ZoneOffset zoneOffset;

    public Iso8601Timezone( String value){
        if(value.equals("Z")){
            this.zoneOffset = ZoneOffset.of("+00:00");
        }else if(!value.contains(":")){
            StringBuilder correctedValue = new StringBuilder("");
            if(!value.contains(":")){
                correctedValue.append(value.substring(0, value.length()-2)).append(":").append(value.substring(value.length()-2));
            }else{
                correctedValue.append(value);
            }
            this.zoneOffset = ZoneOffset.of(correctedValue.toString());
        }
    }



    /*=========================================================*/
    /* * FUNCTIONS * */
    /*=========================================================*/

    /**
     * Extract the hour part of timezone, as an Integer in the range 00 - 13.
     * cardinality: 1..1
     */
    public Integer hour() {
        return zoneOffset.getTotalSeconds()/3600;
    }

    /**
     * Extract the hour part of timezone, as an Integer, usually either 0 or 30.
     * cardinality: 1..1
     */
    public Integer minute() {
        return ZoneOffset.of(value).getTotalSeconds()/60;
    }

    /**
     * Direction of timezone expresssed as +1 or -1.
     * cardinality: 1..1
     */
    public Integer sign() {
        if(zoneOffset.getTotalSeconds()<0){
            return -1;
        }else{
            return 1;
        }
    }

    /**
     * Indicates whether minute part known.
     * cardinality: 1..1
     */
    public boolean minuteUnknown() {
        return false;
    }

    /**
     * True if this time zone is partial, i.e.
     * if minutes is missing.
     * cardinality: 1..1 (effected)
     */
    public boolean isPartial() {
        return false;
    }

    /**
     * True if this time-zone uses ‘:’ separators.
     * cardinality: 1..1 (effected)
     */
    public boolean isExtended() {
        return false;
    }

    /**
     * True if timezone is UTC, i.e.
     * +0000.
     * cardinality: 1..1
     */
    public boolean isGmt() {
        return zoneOffset.getTotalSeconds()==0;
    }

    /**
     * Return timezone string.
     * cardinality: 1..1
     */
    public String asString() {
        return zoneOffset.toString();
    }

    /*=========================================================*/
    /* * TOSTRING, EQUALS AND HASHCODE * */
    /*=========================================================*/


    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        return zoneOffset.equals(object);
    }

    public int hashCode() {
        return zoneOffset.hashCode();
    }

    @Override
    public String toString() {
        return
                "Iso8601Timezone {" +
                        zoneOffset.toString() +
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

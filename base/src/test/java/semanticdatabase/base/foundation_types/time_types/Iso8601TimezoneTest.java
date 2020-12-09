package semanticdatabase.base.foundation_types.time_types;

import org.junit.jupiter.api.Test;

/**
 * Default created on 8-12-2020
 */

class Iso8601TimezoneTest {
    @Test
    void constructorTest() {
        Iso8601Timezone itz;
        itz = new Iso8601Timezone("+00:00");
        System.out.println(itz.asString());
        itz = new Iso8601Timezone("00:00");
        System.out.println(itz.asString());
        itz = new Iso8601Timezone("+0000");
        System.out.println(itz.asString());
        itz = new Iso8601Timezone("0000");
        System.out.println(itz.asString());
        itz = new Iso8601Timezone("+01:00");
        System.out.println(itz.asString());
        itz = new Iso8601Timezone("01:00");
        System.out.println(itz.asString());
        itz = new Iso8601Timezone("+0100");
        System.out.println(itz.asString());
        itz = new Iso8601Timezone("0100");
        System.out.println(itz.asString());
        itz = new Iso8601Timezone("-01:00");
        System.out.println(itz.asString());
        itz = new Iso8601Timezone("-0100");
        System.out.println(itz.asString());
    }
}
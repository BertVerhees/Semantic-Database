package nl.rosa.semanticdatabase.base.datavalues.quantity.datetime;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DvTimeTest {

    @Test
    public void testEquals() {

        DvTime dvTimeOne = new DvTime("17:33:16");
        DvTime dvTimeTwo = new DvTime("17:33:16");
        DvTime dvTimeThree = new DvTime("17:33:17");
        DvTime dvTimeFour = new DvTime("17");
        DvTime dvTimeFive = new DvTime("17");
        assertAll(
                () -> assertEquals(dvTimeOne, dvTimeTwo),
                () -> assertNotEquals(dvTimeOne, dvTimeThree),
                () -> assertNotEquals(dvTimeOne, dvTimeFour),

                () -> assertEquals(dvTimeFour, dvTimeFive)
        );
    }
}
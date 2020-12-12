package nl.rosa.semanticdatabase.base.datavalues.quantity.datetime;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DvDurationTest {

    @Test
    public void testEquals() {
        DvDuration dvDurationOne = new DvDuration("P3Y6M4D");
        DvDuration dvDurationTwo = new DvDuration("P3Y6M4D");
        DvDuration dvDurationThree = new DvDuration("P3Y6M5D");
        DvDuration dvDurationFour = new DvDuration("P3Y6M");
        DvDuration dvDurationFive = new DvDuration("P3Y6M");
        assertAll(
                () -> assertEquals(dvDurationOne, dvDurationTwo),
                () -> assertNotEquals(dvDurationOne, dvDurationThree),
                () -> assertNotEquals(dvDurationOne, dvDurationFour),
                () -> assertEquals(dvDurationFour, dvDurationFive)
        );
    }
}
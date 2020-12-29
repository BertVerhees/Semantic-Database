package nl.rosa.semanticdatabase.base.datavalues.quantity.datetime;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DvDateTimeTest {

    private DvDateTime dvDateTimeThre;

    @Test
    public void testEquals() {
        DvDateTime dvDateTimeOne = new DvDateTime("2018-02-01T09:00:22");
        DvDateTime dvDateTimeTwo = new DvDateTime("2018-02-01T09:00:22");
        DvDateTime dvDateTimeThree = new DvDateTime("2018-02-01T09:00:24");
        DvDateTime dvDateTimeFour = new DvDateTime("2018-02-01T09:00");
        DvDateTime dvDateTimeFive = new DvDateTime("2018-02-01T09:00");

        assertAll(
                () -> assertEquals(dvDateTimeOne, dvDateTimeTwo),
                () -> assertNotEquals(dvDateTimeOne, dvDateTimeThree),
                () -> assertNotEquals(dvDateTimeOne, dvDateTimeFour),
                () -> assertNotEquals(dvDateTimeOne, dvDateTimeFive),
                () -> assertEquals(dvDateTimeFour, dvDateTimeFive)
        );

    }

    @Test
    public void testPartialDateTime() {
        assertAll(
                () -> assertEquals("2018-02-01T09:00", new DvDateTime("2018-02-01T09").getValue().toString()),
                () -> assertEquals("2018-02-01T09:00+02:00", new DvDateTime("2018-02-01T09+02:00").getValue().toString()),
                () -> assertEquals("2019-01-28", new DvDateTime("2019-01-28").getValue().toString()),
                () -> assertEquals("2019-01", new DvDateTime("2019-01").getValue().toString()),
                () -> assertEquals("2019", new DvDateTime("2019").getValue().toString())
        );
    }

    @Test
    void add() {
    }

    @Test
    void subtract() {
    }

    @Test
    void diff() {
    }

    @Test
    void lessThan() {
    }

    @Test
    void getMagnitude() {
    }

    @Test
    void setMagnitude() {
    }

    @Test
    void isStrictlyComparableTo() {
    }

    @Test
    void compareTo() {
    }
}
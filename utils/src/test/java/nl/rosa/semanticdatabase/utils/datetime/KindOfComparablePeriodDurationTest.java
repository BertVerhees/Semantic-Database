package nl.rosa.semanticdatabase.utils.datetime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

import static java.time.temporal.ChronoUnit.*;
import static org.junit.jupiter.api.Assertions.*;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.jupiter.api.function.Executable;
import org.junit.runner.RunWith;
import org.threeten.extra.*;

/**
 * Test class.
 */

/**
 * Default created on 30-12-2020
 */

@RunWith(DataProviderRunner.class)
class KindOfComparablePeriodDurationTest {

    private static final Period P1Y2M3D = Period.of(1, 2, 3);
    private static final Duration DUR_5 = Duration.ofSeconds(5);
    private static final Duration DUR_6 = Duration.ofSeconds(6);

    //-----------------------------------------------------------------------
    @Test
    public void test_isSerializable() {
        assertTrue(Serializable.class.isAssignableFrom(KindOfComparablePeriodDuration.class));
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_serialization() throws Exception {
        KindOfComparablePeriodDuration test = KindOfComparablePeriodDuration.of(P1Y2M3D, DUR_5);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(test);
        }
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
            assertEquals(test, ois.readObject());
        }
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_ZERO() {
        assertEquals(KindOfComparablePeriodDuration.ZERO, KindOfComparablePeriodDuration.of(Period.ZERO, Duration.ZERO));
        assertEquals(KindOfComparablePeriodDuration.ZERO, KindOfComparablePeriodDuration.of(Period.ZERO));
        assertEquals(KindOfComparablePeriodDuration.ZERO, KindOfComparablePeriodDuration.of(Duration.ZERO));
        assertEquals(Period.ZERO, KindOfComparablePeriodDuration.ZERO.getPeriod());
        assertEquals(Duration.ZERO, KindOfComparablePeriodDuration.ZERO.getDuration());
        assertEquals(true, KindOfComparablePeriodDuration.ZERO.isZero());
        assertEquals(Arrays.asList(YEARS, MONTHS, DAYS, SECONDS, NANOS), KindOfComparablePeriodDuration.ZERO.getUnits());
        assertEquals(0, KindOfComparablePeriodDuration.ZERO.get(YEARS));
        assertEquals(0, KindOfComparablePeriodDuration.ZERO.get(MONTHS));
        assertEquals(0, KindOfComparablePeriodDuration.ZERO.get(DAYS));
        assertEquals(0, KindOfComparablePeriodDuration.ZERO.get(SECONDS));
        assertEquals(0, KindOfComparablePeriodDuration.ZERO.get(NANOS));
    }

    public void test_ZERO_getEra() {
        Assertions.assertThrows(DateTimeException.class, () -> {
            KindOfComparablePeriodDuration.ZERO.get(ERAS);
        });
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_of_both() {
        KindOfComparablePeriodDuration test = KindOfComparablePeriodDuration.of(P1Y2M3D, Duration.ofSeconds(4));
        assertEquals(P1Y2M3D, test.getPeriod());
        assertEquals(Duration.ofSeconds(4), test.getDuration());
        assertEquals(false, test.isZero());
        assertEquals(1, test.get(YEARS));
        assertEquals(2, test.get(MONTHS));
        assertEquals(3, test.get(DAYS));
        assertEquals(4, test.get(SECONDS));
        assertEquals(0, test.get(NANOS));
    }

    @Test
    public void test_of_period() {
        KindOfComparablePeriodDuration test = KindOfComparablePeriodDuration.of(P1Y2M3D);
        assertEquals(P1Y2M3D, test.getPeriod());
        assertEquals(Duration.ZERO, test.getDuration());
        assertEquals(false, test.isZero());
        assertEquals(1, test.get(YEARS));
        assertEquals(2, test.get(MONTHS));
        assertEquals(3, test.get(DAYS));
        assertEquals(0, test.get(SECONDS));
        assertEquals(0, test.get(NANOS));
    }

    @Test
    public void test_of_duration() {
        KindOfComparablePeriodDuration test = KindOfComparablePeriodDuration.of(Duration.ofSeconds(4));
        assertEquals(Period.ZERO, test.getPeriod());
        assertEquals(Duration.ofSeconds(4), test.getDuration());
        assertEquals(false, test.isZero());
        assertEquals(0, test.get(YEARS));
        assertEquals(0, test.get(MONTHS));
        assertEquals(0, test.get(DAYS));
        assertEquals(4, test.get(SECONDS));
        assertEquals(0, test.get(NANOS));
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_between_dates() {
        KindOfComparablePeriodDuration test = KindOfComparablePeriodDuration.between(LocalDate.of(2012, 6, 20), LocalDate.of(2012, 8, 25));
        assertEquals(Period.between(LocalDate.of(2012, 6, 20), LocalDate.of(2012, 8, 25)), test.getPeriod());
        assertEquals(Duration.ZERO, test.getDuration());
    }

    @Test
    public void test_between_times() {
        KindOfComparablePeriodDuration test = KindOfComparablePeriodDuration.between(LocalTime.of(11, 20), LocalTime.of(12, 25));
        assertEquals(Period.ZERO, test.getPeriod());
        assertEquals(Duration.between(LocalTime.of(11, 20), LocalTime.of(12, 25)), test.getDuration());
    }

    @Test
    public void test_between_mixed1() {
        KindOfComparablePeriodDuration test = KindOfComparablePeriodDuration.between(LocalDate.of(2012, 6, 20), LocalTime.of(11, 25));
        assertEquals(Period.ZERO, test.getPeriod());
        assertEquals(Duration.ofHours(11).plusMinutes(25), test.getDuration());
    }

    @Test
    public void test_between_mixed2() {
        KindOfComparablePeriodDuration test = KindOfComparablePeriodDuration.between(LocalDate.of(2012, 6, 20), LocalDateTime.of(2012, 7, 22, 11, 25));
        assertEquals(Period.of(0, 1, 2), test.getPeriod());
        assertEquals(Duration.ofHours(11).plusMinutes(25), test.getDuration());
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_from() {
        assertEquals(KindOfComparablePeriodDuration.from(KindOfComparablePeriodDuration.of(P1Y2M3D)), KindOfComparablePeriodDuration.from(KindOfComparablePeriodDuration.of(P1Y2M3D)));
        assertEquals(KindOfComparablePeriodDuration.of(Period.ofYears(2)), KindOfComparablePeriodDuration.from(Period.ofYears(2)));
        assertEquals(KindOfComparablePeriodDuration.of(Duration.ofSeconds(2)), KindOfComparablePeriodDuration.from(Duration.ofSeconds(2)));
        assertEquals(KindOfComparablePeriodDuration.of(Period.ofYears(2)), KindOfComparablePeriodDuration.from(Years.of(2)));
        assertEquals(KindOfComparablePeriodDuration.of(Period.ofMonths(2)), KindOfComparablePeriodDuration.from(Months.of(2)));
        assertEquals(KindOfComparablePeriodDuration.of(Period.ofWeeks(2)), KindOfComparablePeriodDuration.from(Weeks.of(2)));
        assertEquals(KindOfComparablePeriodDuration.of(Period.ofDays(2)), KindOfComparablePeriodDuration.from(Days.of(2)));
        assertEquals(KindOfComparablePeriodDuration.of(Duration.ofHours(2)), KindOfComparablePeriodDuration.from(Hours.of(2)));
    }

    //-----------------------------------------------------------------------
    private class DataValid{
        String str;
        Period period;
        Duration duration;

        public DataValid(String str, Period period, Duration duration) {
            this.str = str;
            this.period = period;
            this.duration = duration;
        }
    }
    private DataValid[] dataValid = {
                new DataValid("P1Y2M3W4DT5H6M7S", Period.of(1, 2, 3 * 7 + 4), Duration.ofHours(5).plusMinutes(6).plusSeconds(7)),
                new DataValid("P3Y", Period.ofYears(3), Duration.ZERO),
                new DataValid("P3M", Period.ofMonths(3), Duration.ZERO),
                new DataValid("P3W", Period.ofWeeks(3), Duration.ZERO),
                new DataValid("P3D", Period.ofDays(3), Duration.ZERO),

                new DataValid("PT0S", Period.of(0, 0, 0), Duration.ofSeconds(0)),
                new DataValid("PT1S", Period.of(0, 0, 0), Duration.ofSeconds(1)),
                new DataValid("PT2S", Period.of(0, 0, 0), Duration.ofSeconds(2)),
                new DataValid("PT123456789S", Period.of(0, 0, 0), Duration.ofSeconds(123456789)),
                new DataValid("PT+0S", Period.of(0, 0, 0), Duration.ofSeconds(0)),
                new DataValid("PT+2S", Period.of(0, 0, 0), Duration.ofSeconds(2)),
                new DataValid("PT-0S", Period.of(0, 0, 0), Duration.ofSeconds(0)),
                new DataValid("PT-2S", Period.of(0, 0, 0), Duration.ofSeconds(-2)),

                new DataValid("P+0M", Period.of(0, 0, 0), Duration.ZERO),
                new DataValid("P+2M", Period.of(0, 2, 0), Duration.ZERO),
                new DataValid("P-0M", Period.of(0, 0, 0), Duration.ZERO),
                new DataValid("P-2M", Period.of(0, -2, 0), Duration.ZERO)
        };

    @Test
    public void test_parse_CharSequence_valid() {
        Arrays.stream(dataValid).forEach((dV) ->
                assertEquals(KindOfComparablePeriodDuration.of(dV.period, dV.duration), KindOfComparablePeriodDuration.parse(dV.str))
        );
    }
    
    @Test
    public void test_parse_CharSequence_valid_initialPlus() {
        Arrays.stream(dataValid).forEach((dV) ->
            assertEquals(KindOfComparablePeriodDuration.of(dV.period, dV.duration), KindOfComparablePeriodDuration.parse("+" + dV.str))
        );
    }

    @Test
   public void test_parse_CharSequence_valid_initialMinus() {
        Arrays.stream(dataValid).forEach((dV) ->
            assertEquals(KindOfComparablePeriodDuration.of(dV.period, dV.duration).negated(), KindOfComparablePeriodDuration.parse("-" + dV.str))
        );
    }

    @Test
    public void test_parse_CharSequence_invalid() {
        final String[] testData = {
                "P3Q",
                "P1M2Y",
                "3",
                "-3",
                "3H",
                "-3H",
                "P3",
                "P-3",
                "PH",
                "T",
                "T3H"
        };
        Arrays.stream(testData).forEach(str ->
            Assertions.assertThrows(DateTimeParseException.class,
                     () -> KindOfComparablePeriodDuration.parse(str)
            )
        );
    }

    @Test
    public void test_parse_CharSequence_null() {
        Assertions.assertThrows(NullPointerException.class,
                () -> KindOfComparablePeriodDuration.parse((CharSequence) null)
        );
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_plus_TemporalAmount_PeriodDuration() {
        KindOfComparablePeriodDuration test = KindOfComparablePeriodDuration.of(P1Y2M3D, DUR_5);
        assertEquals(KindOfComparablePeriodDuration.of(Period.of(4, 4, 4), DUR_5), test.plus(Period.of(3, 2, 1)));
        assertEquals(KindOfComparablePeriodDuration.of(P1Y2M3D, Duration.ofSeconds(9)), test.plus(Duration.ofSeconds(4)));
    }

    @Test
    public void test_plus_TemporalAmount_overflowTooBig() {
        Assertions.assertThrows(ArithmeticException.class,
                () -> KindOfComparablePeriodDuration.of(Period.of(Integer.MAX_VALUE - 1, 0, 0)).plus(KindOfComparablePeriodDuration.of(Period.ofYears(2)))
        );
    }

    @Test
    public void test_plus_TemporalAmount_overflowTooSmall() {
        Assertions.assertThrows(ArithmeticException.class,
                () -> KindOfComparablePeriodDuration.of(Period.of(Integer.MIN_VALUE + 1, 0, 0)).plus(KindOfComparablePeriodDuration.of(Period.ofYears(-2)))
        );
    }

    @Test
    public void test_plus_TemporalAmount_null() {
        Assertions.assertThrows(NullPointerException.class,
                () -> P1Y2M3D.plus(null)
        );
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_minus_TemporalAmount_PeriodDuration() {
        KindOfComparablePeriodDuration test = KindOfComparablePeriodDuration.of(P1Y2M3D, DUR_5);
        assertEquals(KindOfComparablePeriodDuration.of(Period.of(0, 1, 2), DUR_5), test.minus(Period.of(1, 1, 1)));
        assertEquals(KindOfComparablePeriodDuration.of(P1Y2M3D, Duration.ofSeconds(1)), test.minus(Duration.ofSeconds(4)));
    }

    @Test
    public void test_minus_TemporalAmount_overflowTooBig() {
        Assertions.assertThrows(ArithmeticException.class,
                () -> KindOfComparablePeriodDuration.of(Period.of(Integer.MAX_VALUE - 1, 0, 0)).minus(KindOfComparablePeriodDuration.of(Period.ofYears(-2)))
        );
    }

    @Test
    public void test_minus_TemporalAmount_overflowTooSmall() {
        Assertions.assertThrows(ArithmeticException.class,
                () -> KindOfComparablePeriodDuration.of(Period.of(Integer.MIN_VALUE + 1, 0, 0)).minus(KindOfComparablePeriodDuration.of(Period.ofYears(2)))
        );
    }

    @Test
    public void test_minus_TemporalAmount_null() {
        Assertions.assertThrows(NullPointerException.class,
                () -> P1Y2M3D.minus(null)
        );
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_multipliedBy() {
        KindOfComparablePeriodDuration test = KindOfComparablePeriodDuration.of(P1Y2M3D, DUR_5);
        assertEquals(KindOfComparablePeriodDuration.ZERO, test.multipliedBy(0));
        assertEquals(test, test.multipliedBy(1));
        assertEquals(KindOfComparablePeriodDuration.of(Period.of(5,  10, 15), Duration.ofSeconds(25)), test.multipliedBy(5));
        assertEquals(KindOfComparablePeriodDuration.of(Period.of(-3,  -6, -9), Duration.ofSeconds(-15)), test.multipliedBy(-3));
    }

    @Test
    public void test_multipliedBy_overflowTooBig() {
        Assertions.assertThrows(ArithmeticException.class,
                () -> KindOfComparablePeriodDuration.of(Period.ofYears(Integer.MAX_VALUE / 2 + 1)).multipliedBy(2)
        );
    }

    @Test
    public void test_multipliedBy_overflowTooSmall() {
        Assertions.assertThrows(ArithmeticException.class,
                () -> KindOfComparablePeriodDuration.of(Period.ofYears(Integer.MIN_VALUE / 2 - 1)).multipliedBy(2)
        );
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_negated() {
        assertEquals(KindOfComparablePeriodDuration.of(P1Y2M3D.negated(), DUR_5.negated()), KindOfComparablePeriodDuration.of(P1Y2M3D, DUR_5).negated());
    }

    @Test
    public void test_negated_overflow() {
        Assertions.assertThrows(ArithmeticException.class,
                () -> KindOfComparablePeriodDuration.of(Duration.ofSeconds(Long.MIN_VALUE)).negated()
        );
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_normalizedYears() {
        assertEquals(KindOfComparablePeriodDuration.of(P1Y2M3D.normalized(), DUR_5), KindOfComparablePeriodDuration.of(P1Y2M3D, DUR_5).normalizedYears());
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_normalizedStandardDays() {
        assertEquals(
                KindOfComparablePeriodDuration.of(P1Y2M3D, Duration.ofHours(5)),
                KindOfComparablePeriodDuration.of(P1Y2M3D, Duration.ofHours(5)).normalizedStandardDays());
        assertEquals(
                KindOfComparablePeriodDuration.of(P1Y2M3D.plusDays(1), Duration.ofHours(1)),
                KindOfComparablePeriodDuration.of(P1Y2M3D, Duration.ofHours(25)).normalizedStandardDays());
        assertEquals(
                KindOfComparablePeriodDuration.of(P1Y2M3D.plusDays(-3), Duration.ofHours(-1)),
                KindOfComparablePeriodDuration.of(P1Y2M3D, Duration.ofHours(-73)).normalizedStandardDays());
    }

    @Test
    public void test_normalizedStandardDaysn_overflow() {
        Assertions.assertThrows(ArithmeticException.class,
                () -> KindOfComparablePeriodDuration.of(Duration.ofSeconds(Long.MIN_VALUE)).normalizedStandardDays()
        );
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_addTo() {
        LocalDateTime base = LocalDateTime.of(2012, 6, 20, 11, 30, 0);
        assertEquals(LocalDateTime.of(2013, 8, 23, 11, 30, 5), KindOfComparablePeriodDuration.of(P1Y2M3D, DUR_5).addTo(base));
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_subtractFrom() {
        LocalDateTime base = LocalDateTime.of(2012, 6, 20, 11, 30, 0);
        assertEquals(LocalDateTime.of(2011, 4, 17, 11, 29, 55), KindOfComparablePeriodDuration.of(P1Y2M3D, DUR_5).subtractFrom(base));
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_equals() {
        KindOfComparablePeriodDuration test5 = KindOfComparablePeriodDuration.of(P1Y2M3D, DUR_5);
        KindOfComparablePeriodDuration test6 = KindOfComparablePeriodDuration.of(P1Y2M3D, DUR_6);
        assertEquals(true, test5.equals(test5));
        assertEquals(false, test5.equals(test6));
        assertEquals(false, test6.equals(test5));
    }

    @Test
    public void test_equals_null() {
        KindOfComparablePeriodDuration test = KindOfComparablePeriodDuration.of(P1Y2M3D, DUR_5);
        assertEquals(false, test.equals(null));
    }

    @Test
    public void test_equals_otherClass() {
        KindOfComparablePeriodDuration test = KindOfComparablePeriodDuration.of(P1Y2M3D, DUR_5);
        assertEquals(false, test.equals(""));
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_hashCode() {
        KindOfComparablePeriodDuration test5 = KindOfComparablePeriodDuration.of(P1Y2M3D, DUR_5);
        KindOfComparablePeriodDuration test6 = KindOfComparablePeriodDuration.of(P1Y2M3D, DUR_6);
        assertEquals(true, test5.hashCode() == test5.hashCode());
        assertEquals(false, test5.hashCode() == test6.hashCode());
    }

    //-----------------------------------------------------------------------
    @Test
    public void test_toString() {
        assertEquals("P1Y2M3DT5S", KindOfComparablePeriodDuration.of(P1Y2M3D, DUR_5).toString());
        assertEquals("P1Y2M3D", KindOfComparablePeriodDuration.of(P1Y2M3D, Duration.ZERO).toString());
        assertEquals("PT5S", KindOfComparablePeriodDuration.of(Period.ZERO, DUR_5).toString());
    }

    @Test
    void of() {
    }

    @Test
    void testOf() {
    }

    @Test
    void testOf1() {
    }

    @Test
    void from() {
    }

    @Test
    void parse() {
    }

    @Test
    void between() {
    }

    @Test
    void withPeriod() {
    }

    @Test
    void withDuration() {
    }

    @Test
    void plus() {
    }

    @Test
    void minus() {
    }

    @Test
    void multipliedBy() {
    }

    @Test
    void negated() {
    }

    @Test
    void normalizedYears() {
    }

    @Test
    void normalizedStandardDays() {
    }

    @Test
    void subtractFrom() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void compareTo() {
    }
}
package nl.rosa.semanticdatabase.base.utils.datetime;

import org.threeten.extra.PeriodDuration;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeParseException;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAmount;

/**
 * ISO date time parsers
 */
public class DateTimeParsers {

    public static LocalDateTime parseDateTimeValue(String text) {
        try {
            return (LocalDateTime)DateTimeFormatters.ISO_8601_DATE_TIME.parseBest(text, OffsetDateTime::from, LocalDateTime::from, LocalDate::from, YearMonth::from, Year::from);
        } catch (DateTimeParseException e) {
            try {
                //some more interesting date_time expression without hyphens...
                return (LocalDateTime)DateTimeFormatters.ISO_8601_DATE_TIME_COMPACT.parseBest(text, OffsetDateTime::from, LocalDateTime::from);
            } catch (DateTimeParseException e2) {
                throw new IllegalArgumentException(e2.getMessage() + ":" + text);
            }
        }
    }

    public static LocalTime parseTimeValue(String text) {
        try {
            return (LocalTime)DateTimeFormatters.ISO_8601_TIME_COMPACT.parseBest(text, OffsetTime::from, LocalTime::from);
        } catch (Exception e0) {
            try {
                return (LocalTime)DateTimeFormatters.ISO_8601_TIME.parseBest(text, OffsetTime::from, LocalTime::from);
            } catch (DateTimeParseException e) {
                try {
                    //Not parseable as a standard public object from datetime. We do not implement our own yet (we could!)
                    //so fallback to the Parsed object. The Parsed object is package-private, so cannot be added as a reference
                    //to the parseBest query, unfortunately.
                    return (LocalTime)DateTimeFormatters.ISO_8601_TIME.parse(text);
                } catch (DateTimeParseException e1) {
                    throw new IllegalArgumentException(e1.getMessage() + ":" + text);
                }
            }
        }
    }

    public static LocalDate parseDateValue(String text) {
        try {
            return (LocalDate) DateTimeFormatters.ISO_8601_DATE_COMPACT.parseBest(text, LocalDate::from, YearMonth::from, Year::from);
        } catch (DateTimeParseException e) {
            try {
                return (LocalDate) DateTimeFormatters.ISO_8601_DATE.parseBest(text, LocalDate::from, YearMonth::from, Year::from);
            } catch (DateTimeParseException e1) {
                throw new IllegalArgumentException(e.getMessage() + ":" + text);
            }
        }
    }

    public static PeriodDuration parseDurationValue(String text) {
        try {
            if (text.startsWith("PT") || text.startsWith("-PT")) {
                return PeriodDuration.from(Duration.parse(text));
            } else if (text.contains("T")) {
                return PeriodDuration.from(Duration.parse(text));
//                return PeriodDuration.parse(text);
            } else {
                return PeriodDuration.from(Period.parse(text));
            }
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(e.getMessage() + ":" + text);
        }
    }
}

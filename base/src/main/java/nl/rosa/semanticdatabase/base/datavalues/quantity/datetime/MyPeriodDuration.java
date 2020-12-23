//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package nl.rosa.semanticdatabase.base.datavalues.quantity.datetime;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.chrono.ChronoPeriod;
import java.time.chrono.IsoChronology;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalUnit;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public final class MyPeriodDuration implements TemporalAmount, Serializable, Comparable<MyPeriodDuration> {
    public static final MyPeriodDuration ZERO;
    private static final long serialVersionUID = 8815521625671589L;
    private static final List<TemporalUnit> SUPPORTED_UNITS;
    private static final long SECONDS_PER_DAY = 86400L;
    private final Period period;
    private final Duration duration;

    public static MyPeriodDuration of(Period period, Duration duration) {
        Objects.requireNonNull(period, "The period must not be null");
        Objects.requireNonNull(duration, "The duration must not be null");
        return new MyPeriodDuration(period, duration);
    }

    public static MyPeriodDuration of(Period period) {
        Objects.requireNonNull(period, "The period must not be null");
        return new MyPeriodDuration(period, Duration.ZERO);
    }

    public static MyPeriodDuration of(Duration duration) {
        Objects.requireNonNull(duration, "The duration must not be null");
        return new MyPeriodDuration(Period.ZERO, duration);
    }

    public static MyPeriodDuration from(TemporalAmount amount) {
        if (amount instanceof MyPeriodDuration) {
            return (MyPeriodDuration)amount;
        } else if (amount instanceof Period) {
            return of((Period)amount);
        } else if (amount instanceof Duration) {
            return of((Duration)amount);
        } else if (amount instanceof ChronoPeriod && !IsoChronology.INSTANCE.equals(((ChronoPeriod)amount).getChronology())) {
            throw new DateTimeException("Period requires ISO chronology: " + amount);
        } else {
            Objects.requireNonNull(amount, "amount");
            int years = 0;
            int months = 0;
            int days = 0;
            Duration duration = Duration.ZERO;
            Iterator var5 = amount.getUnits().iterator();

            while(var5.hasNext()) {
                TemporalUnit unit = (TemporalUnit)var5.next();
                long value = amount.get(unit);
                if (value != 0L) {
                    if (unit.isDurationEstimated()) {
                        if (unit == ChronoUnit.DAYS) {
                            days = Math.addExact(days, Math.toIntExact(value));
                        } else if (unit == ChronoUnit.WEEKS) {
                            days = Math.addExact(days, Math.toIntExact(Math.multiplyExact(value, 7L)));
                        } else if (unit == ChronoUnit.MONTHS) {
                            months = Math.addExact(months, Math.toIntExact(value));
                        } else if (unit == IsoFields.QUARTER_YEARS) {
                            months = Math.addExact(months, Math.toIntExact(Math.multiplyExact(value, 3L)));
                        } else if (unit == ChronoUnit.YEARS) {
                            years = Math.addExact(years, Math.toIntExact(value));
                        } else if (unit == ChronoUnit.DECADES) {
                            years = Math.addExact(years, Math.toIntExact(Math.multiplyExact(value, 10L)));
                        } else if (unit == ChronoUnit.CENTURIES) {
                            years = Math.addExact(years, Math.toIntExact(Math.multiplyExact(value, 100L)));
                        } else {
                            if (unit != ChronoUnit.MILLENNIA) {
                                throw new DateTimeException("Unknown unit: " + unit);
                            }

                            years = Math.addExact(years, Math.toIntExact(Math.multiplyExact(value, 1000L)));
                        }
                    } else {
                        duration = duration.plus(amount.get(unit), unit);
                    }
                }
            }

            return of(Period.of(years, months, days), duration);
        }
    }

    public static MyPeriodDuration parse(CharSequence text) {
        Objects.requireNonNull(text, "text");
        String upper = text.toString().toUpperCase(Locale.ENGLISH);
        String negate = "";
        if (upper.startsWith("+")) {
            upper = upper.substring(1);
        } else if (upper.startsWith("-")) {
            upper = upper.substring(1);
            negate = "-";
        }

        if (upper.startsWith("PT")) {
            return of(Duration.parse(text));
        } else {
            int tpos = upper.indexOf(84);
            if (tpos < 0) {
                return of(Period.parse(text));
            } else {
                Period period = Period.parse(negate + upper.substring(0, tpos));
                Duration duration = Duration.parse(negate + "P" + upper.substring(tpos));
                return of(period, duration);
            }
        }
    }

    public static MyPeriodDuration between(Temporal startInclusive, Temporal endExclusive) {
        LocalDate startDate = (LocalDate)startInclusive.query(TemporalQueries.localDate());
        LocalDate endDate = (LocalDate)endExclusive.query(TemporalQueries.localDate());
        Period period = Period.ZERO;
        if (startDate != null && endDate != null) {
            period = Period.between(startDate, endDate);
        }

        LocalTime startTime = (LocalTime)startInclusive.query(TemporalQueries.localTime());
        LocalTime endTime = (LocalTime)endExclusive.query(TemporalQueries.localTime());
        startTime = startTime != null ? startTime : LocalTime.MIDNIGHT;
        endTime = endTime != null ? endTime : LocalTime.MIDNIGHT;
        Duration duration = Duration.between(startTime, endTime);
        return of(period, duration);
    }

    private MyPeriodDuration(Period period, Duration duration) {
        this.period = period;
        this.duration = duration;
    }

    private Object readResolve() {
        return of(this.period, this.duration);
    }

    public long get(TemporalUnit unit) {
        if (unit instanceof ChronoUnit) {
            switch((ChronoUnit)unit) {
                case YEARS:
                    return (long)this.period.getYears();
                case MONTHS:
                    return (long)this.period.getMonths();
                case DAYS:
                    return (long)this.period.getDays();
                case SECONDS:
                    return this.duration.getSeconds();
                case NANOS:
                    return (long)this.duration.getNano();
            }
        }

        throw new UnsupportedTemporalTypeException("Unsupported unit: " + unit);
    }

    public List<TemporalUnit> getUnits() {
        return SUPPORTED_UNITS;
    }

    public Period getPeriod() {
        return this.period;
    }

    public MyPeriodDuration withPeriod(Period period) {
        return of(period, this.duration);
    }

    public Duration getDuration() {
        return this.duration;
    }

    public MyPeriodDuration withDuration(Duration duration) {
        return of(this.period, duration);
    }

    public boolean isZero() {
        return this.period.isZero() && this.duration.isZero();
    }

    public MyPeriodDuration plus(TemporalAmount amountToAdd) {
        MyPeriodDuration other = from(amountToAdd);
        return of(this.period.plus(other.period), this.duration.plus(other.duration));
    }

    public MyPeriodDuration minus(TemporalAmount amountToAdd) {
        MyPeriodDuration other = from(amountToAdd);
        return of(this.period.minus(other.period), this.duration.minus(other.duration));
    }

    public MyPeriodDuration multipliedBy(int scalar) {
        return scalar == 1 ? this : of(this.period.multipliedBy(scalar), this.duration.multipliedBy((long)scalar));
    }

    public MyPeriodDuration negated() {
        return this.multipliedBy(-1);
    }

    public MyPeriodDuration normalizedYears() {
        return this.withPeriod(this.period.normalized());
    }

    public MyPeriodDuration normalizedStandardDays() {
        long totalSecs = (long)this.period.getDays() * 86400L + this.duration.getSeconds();
        int splitDays = Math.toIntExact(totalSecs / 86400L);
        long splitSecs = totalSecs % 86400L;
        return splitDays == this.period.getDays() && splitSecs == this.duration.getSeconds() ? this : of(this.period.withDays(splitDays), this.duration.withSeconds(splitSecs));
    }

    public Temporal addTo(Temporal temporal) {
        return temporal.plus(this.period).plus(this.duration);
    }

    public Temporal subtractFrom(Temporal temporal) {
        return temporal.minus(this.period).minus(this.duration);
    }

    public boolean equals(Object otherAmount) {
        if (this == otherAmount) {
            return true;
        } else if (!(otherAmount instanceof MyPeriodDuration)) {
            return false;
        } else {
            MyPeriodDuration other = (MyPeriodDuration)otherAmount;
            return this.period.equals(other.period) && this.duration.equals(other.duration);
        }
    }

    public int hashCode() {
        return this.period.hashCode() ^ this.duration.hashCode();
    }

    public String toString() {
        if (this.period.isZero()) {
            return this.duration.toString();
        } else {
            return this.duration.isZero() ? this.period.toString() : this.period.toString() + this.duration.toString().substring(1);
        }
    }

    static {
        ZERO = new MyPeriodDuration(Period.ZERO, Duration.ZERO);
        SUPPORTED_UNITS = Collections.unmodifiableList(Arrays.asList(ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS, ChronoUnit.SECONDS, ChronoUnit.NANOS));
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure
     * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))}
     * for all {@code x} and {@code y}.  (This
     * implies that {@code x.compareTo(y)} must throw an exception iff
     * {@code y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
     * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for
     * all {@code z}.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
     * <i>signum</i> function, which is defined to return one of {@code -1},
     * {@code 0}, or {@code 1} according to whether the value of
     * <i>expression</i> is negative, zero, or positive, respectively.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(MyPeriodDuration o) {
        if(duration.equals(o.duration) && period.equals(o.period)){
            return 0;
        }
        long thisSeconds = period.getDays() * 86400 + duration.getSeconds();
        long otherSeconds = o.period.getDays() * 86400 + o.duration.getSeconds();
        int cmp = Long.compare(thisSeconds, otherSeconds);
        if (cmp != 0) {
            return cmp;
        }
        return duration.getNano() - o.duration.getNano();
    }
}

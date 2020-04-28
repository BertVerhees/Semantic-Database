package nl.rosa.semanticdatabase.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.time.temporal.TemporalAmount;
import java.util.Objects;

@Getter
@Setter
public class Interval<T> {

    /**
     * lower bound.
     */
    @Nullable
    private T lower;
    /**
     * Upper bound.
     */
    @Nullable
    private T upper;
    /**
     * lower boundary open (i.e. = -infinity)
     */
    private boolean lowerUnbounded = false;
    /**
     * upper boundary open (i.e. = +infinity)
     */
    private boolean upperUnbounded = false;
    /**
     * lower boundary value included in range if not lower_unbounded.
     */
    private boolean lowerIncluded = true;
    /**
     * upper boundary value included in range if not upper_unbounded.
     */
    private boolean upperIncluded = true;

    public Interval() {

    }

    public Interval(T value) {
        this(value, value);
    }

    public Interval(T lower, T upper) {
        this(lower, upper, true, true);
    }

    public Interval(T lower, T upper, boolean lowerIncluded, boolean upperIncluded) {
        this.lower = lower;
        this.upper = upper;
        this.lowerIncluded = lowerIncluded;
        this.upperIncluded = upperIncluded;

        if (upper == null) {
            this.upperUnbounded = true;
            this.upperIncluded = false;
        }
        if (lower == null) {
            this.lowerUnbounded = true;
            this.lowerIncluded = false;
        }

    }

    public static <T> Interval<T> lowerUnbounded(T upper, boolean upperIncluded) {
        Interval<T> result = new Interval<>(null, upper, false, upperIncluded);
        result.setLowerUnbounded(true);
        return result;
    }

    public static <T> Interval<T> upperUnbounded(T lower, boolean lowerIncluded) {
        Interval<T> result = new Interval<>(lower, null, lowerIncluded, false);
        result.setUpperUnbounded(true);
        return result;
    }

    public boolean has(T value) {
        if (lowerUnbounded && upperUnbounded) {
            return true;
        }
        //since TemporalAmount does not implement Comparable we have to do some magic here
        Comparable comparableValue;
        Comparable comparableLower;
        Comparable comparableUpper;
        if (value instanceof TemporalAmount && lower instanceof TemporalAmount && upper instanceof TemporalAmount) {
            //TemporalAmount is not comparable, but can always be converted to a duration that is comparable.
            comparableValue = toComparable(value);
            comparableLower = toComparable(lower);
            comparableUpper = toComparable(upper);
        } else if (!(isComparable(lower) && isComparable(upper) && isComparable(value))) {
            throw new UnsupportedOperationException("subclasses of interval not implementing comparable should implement their own has method");
        } else {
            comparableValue = (Comparable) value;
            comparableLower = (Comparable) lower;
            comparableUpper = (Comparable) upper;
        }

        if (value == null) {
            //interval values are not concerned with cardinality, so return true if not set
            return true;
        }

        if (!lowerUnbounded) {
            int comparedWithLower = comparableValue.compareTo(comparableLower);
            if (comparedWithLower < 0 || (!lowerIncluded && comparedWithLower == 0)) {
                return false;
            }
        }

        if (!upperUnbounded) {
            int comparedWithUpper = comparableValue.compareTo(comparableUpper);
            if (comparedWithUpper > 0 || (!upperIncluded && comparedWithUpper == 0)) {
                return false;
            }
        }
        return true;
    }

    private Comparable toComparable(T value) {
        if(value == null) {
            return null;
        }
        if (value instanceof TemporalAmount && !(value instanceof Comparable) && isNonComparableTemporalAmount(value)) {
            //TemporalAmount is not comparable, but can always be converted to a duration that is comparable.
            return IntervalDurationConverter.from((TemporalAmount) value);

        } else if (!isComparable(value)) {
            throw new UnsupportedOperationException("subclasses of interval not implementing comparable should implement their own has method");
        } else {
            return (Comparable) value;
        }
    }

    private boolean isNonComparableTemporalAmount(T value) {
        return value == null || (!(value instanceof Comparable) && value instanceof TemporalAmount);
    }

    private boolean isComparable(T value) {
        return value == null || value instanceof Comparable;
    }

    /**
     * True if there is any overlap between intervals represented by Current and
     * `other'. True if at least one limit of other is strictly inside the limits
     * of this interval.
     *
     * @param other
     * @return
     */
    public Boolean intersects(Interval<T> other) {
        return (lowerUnbounded && other.lowerUnbounded) ||
                (upperUnbounded && other.upperUnbounded) ||
                (compareTo(lower, other.lower) < 0 && compareTo(upper, other.upper) < 0 && compareTo(other.lower, upper) < 0) ||
                (compareTo(other.lower, lower) < 0 && compareTo(other.upper, upper) < 0 && compareTo(lower, other.upper) < 0) ||
                other.contains(this) || this.contains(other);
    }

    /**
     * True if current interval properly contains `other'? True if all points of
     * `other' are inside the current interval.
     *
     * @param other
     * @return
     */
    public Boolean contains(Interval<T> other) {
        boolean otherHasLower = false;
        boolean otherHasUpper = false;
        if (other.lowerUnbounded) {
            otherHasLower = this.lowerUnbounded;
        } else {
            otherHasLower = has(other.lower);
        }
        if (other.upperUnbounded) {
            otherHasUpper = this.upperUnbounded;
        } else {
            otherHasUpper = has(other.upper);
        }
        return otherHasLower && otherHasUpper;
    }

    /**
     * Returns true if both sets subsume each other.
     *
     * @param other
     * @return
     */
    public Boolean setsAreEqual(Interval<T> other) {
        return this.contains(other) && other.contains(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Interval<?> interval = (Interval<?>) o;

        return (lowerUnbounded == interval.lowerUnbounded) &&
                (upperUnbounded == interval.upperUnbounded) &&
                (lowerUnbounded || lowerIncluded == interval.lowerIncluded) &&
                (upperUnbounded || upperIncluded == interval.upperIncluded) &&
                (lowerUnbounded || Objects.equals(lower, interval.lower)) &&
                (upperUnbounded || Objects.equals(upper, interval.upper));
    }

    private int compareTo(T intervalValue, T value) {
        Comparable comparableIntervalValue;
        Comparable comparableValue;
        if (value instanceof TemporalAmount && !(value instanceof Comparable) && isNonComparableTemporalAmount(intervalValue)) {
            //TemporalAmount is not comparable, but can always be converted to a duration that is comparable.
            comparableValue = value == null ? null : IntervalDurationConverter.from((TemporalAmount) value);
            comparableIntervalValue = intervalValue == null ? null : IntervalDurationConverter.from((TemporalAmount) intervalValue);
        } else if (!(isComparable(intervalValue) && isComparable(value))) {
            throw new UnsupportedOperationException("subclasses of interval not implementing comparable should implement their own has method");
        } else {
            comparableValue = (Comparable) value;
            comparableIntervalValue = (Comparable) intervalValue;
        }
        return comparableValue.compareTo(comparableIntervalValue);
    }

}

package nl.rosa.semanticdatabase.referencemodel.model.internal.base;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.time.temporal.TemporalAmount;

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

}

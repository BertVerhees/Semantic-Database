package nl.rosa.semanticdatabase.referencemodel.model.internal.base;

import org.springframework.lang.Nullable;

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

}

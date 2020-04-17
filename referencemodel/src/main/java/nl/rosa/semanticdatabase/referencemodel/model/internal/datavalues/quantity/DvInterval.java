package nl.rosa.semanticdatabase.referencemodel.model.internal.datavalues.quantity;

import nl.rosa.semanticdatabase.referencemodel.model.internal.base.Interval;
import org.springframework.lang.Nullable;

public class DvInterval<Type extends DvOrdered> extends DataValue {

    private final Interval<DvOrdered> interval;

    public DvInterval() {
        interval = new Interval<>();
    }

    public DvInterval(Type lower, Type upper) {
        interval = new Interval<>(lower, upper);
    }

    @Nullable
    public DvOrdered getLower() {
        return interval.getLower();
    }

    public void setLower(DvOrdered lower) {
        interval.setLower(lower);
    }

    @Nullable
    public DvOrdered getUpper() {
        return interval.getUpper();
    }

    public void setUpper(DvOrdered upper) {
        interval.setUpper(upper);
    }

    public boolean isLowerUnbounded() {
        return interval.isLowerUnbounded();
    }

    public void setLowerUnbounded(boolean lowerUnbounded) {
        interval.setLowerUnbounded(lowerUnbounded);
    }

    public boolean isUpperUnbounded() {
        return interval.isUpperUnbounded();
    }

    public void setUpperUnbounded(boolean upperUnbounded) {
        interval.setUpperUnbounded(upperUnbounded);
    }

    public boolean isLowerIncluded() {
        return interval.isLowerIncluded();
    }

    public void setLowerIncluded(boolean lowerIncluded) {
        interval.setLowerIncluded(lowerIncluded);
    }

    public boolean isUpperIncluded() {
        return interval.isUpperIncluded();
    }

    public void setUpperIncluded(boolean upperIncluded) {
        interval.setUpperIncluded(upperIncluded);
    }

    public boolean has(DvOrdered value) {
        return interval.has(value);
    }

    public String toString() {
        return interval.toString();
    }
}

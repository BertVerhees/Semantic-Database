package nl.rosa.semanticdatabase.base.datavalues.quantity;

import nl.rosa.semanticdatabase.base.datatype.CodePhrase;
import nl.rosa.semanticdatabase.base.datavalues.quantity.datetime.DvDuration;

import java.util.List;
import java.util.Objects;

/**
 * Created by pieter.bos on 04/11/15.
 */
public abstract class DvAmount<T extends DvAmount>
        extends DvQuantified<T> {

    /**
     * Accuracy of measurement, expressed either as a half-range percent value (accuracy_is_percent = True)
     * or a half-range quantity. A value of 0 means that accuracy is 100%, i.e. no error.
     *
     * A value of unknown_accuracy_value means that accuracy was not recorded.
     */
    private Double accuracy = null;
    private Boolean accuracyIsPercent = null;

    protected DvAmount(
            List<ReferenceRange<T>> otherReferenceRanges,
            DvInterval<T> normalRange,
            CodePhrase normalStatus,
            Double accuracy,
            Boolean accuracyIsPercent,
            String magnitudeStatus) {
        super(otherReferenceRanges, normalRange, normalStatus, magnitudeStatus);
        this.accuracy = accuracy;
        this.accuracyIsPercent = accuracyIsPercent;
    }

    /**
     * Sum of this quantity and another whose formal type must be the
     * difference type of this quantity.
     *
     * @param s
     * @return product of addition
     */
    public abstract DvQuantified<T> add(DvQuantified<T> s);

    /**
     * Difference of this quantity and another whose formal type must
     * be the difference type of this quantity type.
     *
     * @param s
     * @return product of substration
     */
    public abstract DvQuantified<T> subtract(DvQuantified<T> s);



    public Boolean getAccuracyIsPercent() {
        return accuracyIsPercent;
    }

    public void setAccuracyIsPercent( Boolean accuracyIsPercent) {
        this.accuracyIsPercent = accuracyIsPercent;
    }

    public Double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Double accuracy) {
        this.accuracy = accuracy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DvAmount<?> dvAmount = (DvAmount<?>) o;
        return Objects.equals(accuracy, dvAmount.accuracy) &&
                Objects.equals(accuracyIsPercent, dvAmount.accuracyIsPercent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), accuracy, accuracyIsPercent);
    }
}
